package com.trkj.config.security.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.trkj.config.redis.RedisService;
import com.trkj.entity.User;
import com.trkj.utils.JwtUtils;
import com.trkj.utils.LoginResult;
import com.trkj.utils.ResultCode;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/*
 * 登录成功处理器类
 * */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Resource
    private JwtUtils jwtUtils;
    @Resource
    private RedisService redisService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //设置客户端的响应的内容类型
        response.setContentType("application/json;charset=UTF-8");
        //获取当登录用户信息
        User user = (User) authentication.getPrincipal();
        //生成token
        String token = jwtUtils.generateToken(user);
        //设置token的签名密钥及过期时间
        long expireTime = Jwts.parser()
                .setSigningKey(jwtUtils.getSecret())//设置签名密钥
                .parseClaimsJws(token.replace("jwt_", " "))//将生成的jwt_,转换成空字符串
                .getBody().getExpiration().getTime();//设置过期时间
        //创建LoginResult登录结果对象
        LoginResult loginResult = new LoginResult(user.getId(), ResultCode.SUCCESS, token, expireTime);
        //消除循环引用
        String result = JSON.toJSONString(loginResult, SerializerFeature.DisableCircularReferenceDetect);
        //获取输出流
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(result.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
        //将token信息保存到redis中
        String tokenKey = "token_" + token;
        redisService.set(tokenKey, token, jwtUtils.getExpiration() / 1000);
    }
}
