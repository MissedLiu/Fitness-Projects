package com.trkj.controller.liucz;

import com.trkj.config.redis.RedisService;
import com.trkj.entity.liucz.Emp;
import com.trkj.entity.liucz.Permission;
import com.trkj.entity.liucz.User;
import com.trkj.entity.liucz.UserInfo;
import com.trkj.service.implLiucz.EmpService;
import com.trkj.utils.JwtUtils;
import com.trkj.utils.MenuTree;
import com.trkj.utils.Result;
import com.trkj.vo.RouterVo;
import com.trkj.vo.TokenVo;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/sysUser")
public class SysUserController {
    @Resource
    private RedisService redisService;
    @Resource
    private JwtUtils jwtUtils;
    @Resource
    private EmpService empService;

    /**
     * 刷新token
     *
     */
    @PostMapping("/refreshToken")
    public Result refreshToken(HttpServletRequest request) {
        //从header中获取前端提交的token
        String token = request.getHeader("token");
        //如果header中没有token，则从参数中获取
        if (ObjectUtils.isEmpty(token)) {
            token = request.getParameter("token");
        }
        //从Spring Security上下文获取用户信息
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        //获取身份信息
        UserDetails details = (UserDetails) authentication.getPrincipal();
        //重新生成token
        String reToken = "";
        //验证原来的token是否合法
        if (jwtUtils.validateToken(token, details)) {
            //生成新的token
            reToken = jwtUtils.refreshToken(token);
        }
        //获取本次token的到期时间，交给前端做判断
        long expireTime = Jwts.parser().setSigningKey(jwtUtils.getSecret())
                .parseClaimsJws(reToken.replace("jwt_", ""))
                .getBody().getExpiration().getTime();
        //清除原来的token信息
        String oldTokenKey = "token_" + token;
        redisService.del(oldTokenKey);
        //存储新的token
        String newTokenKey = "token_" + reToken;
        redisService.set(newTokenKey, reToken, jwtUtils.getExpiration() / 1000);
        //创建TokenVo对象
        TokenVo tokenVo = new TokenVo(expireTime, reToken);
        //返回数据
        return Result.ok(tokenVo).message("token生成成功");
    }

    /**
     * 获取用户信息
     */
    @GetMapping("/getInfo")
    public Result getInfo() {
        //从Spring Security上下文获取用户信息
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        //判断authentication对象是否为空
        if (authentication == null) {
            return Result.error().message("用户信息查询失败");
        }
        //获取用户信息
        User user = (User) authentication.getPrincipal();
        //用户权限集合
        List<Permission> permissionList = user.getPermissionList();
        //获取角色权限编码字段
        Object[] roles =
                permissionList.stream()
                        .filter(Objects::nonNull)
                        .map(Permission::getCode).toArray();
        //根据账户中的员工id获取员工信息
        Emp emp=empService.findEmpByEmpId(user.getEmpId());
        //判断员工信息是否存在
        if(emp==null){
            //返回数据
            return Result.error().message("该账号未分配给员工,请联系部门经理");
        }

        //判断该员工是否分配了权限
        if(roles.length==0){
            //返回数据
            return Result.error().message("该账号未分配相关权限,请联系部门经理");
        }
        //创建用户信息对象
        UserInfo userInfo = new UserInfo(user.getId(),emp.getEmpName(), emp.getAvatar(), null, roles);
        //返回数据
        return Result.ok(userInfo).message("用户信息查询成功");
    }

    /**
     * 获取菜单数据
     */
    @GetMapping("/getMenuList")
    public Result getMenuList() {
        //从Spring Security上下文获取用户信息
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        //获取用户信息
        User user = (User) authentication.getPrincipal();
        //获取相应的权限
        List<Permission> permissionList = user.getPermissionList();
        //筛选目录和菜单
        List<Permission> collect = permissionList.stream()
                .filter(item -> item != null && item.getType() != 2)
                .collect(Collectors.toList());
        //生成路由数据
        List<RouterVo> routerVoList = MenuTree.makeRouter(collect, 0L);

        //返回数据
        return Result.ok(routerVoList).message("菜单数据获取成功");
    }

    /**
     * 用户退出
     */
    @PostMapping("/logout")
    public Result logout(HttpServletRequest request, HttpServletResponse response) {
        //获取token
        String token = request.getParameter("token");
        //如果没有从头部获取token，那么从参数里面获取
        if (ObjectUtils.isEmpty(token)) {
            token = request.getHeader("token");
        }
        //获取用户相关信息
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            //清空用户信息
            new SecurityContextLogoutHandler().logout(request, response,
                    authentication);
            //清空redis里面的token
            String key = "token_" + token;
            redisService.del(key);
            return Result.ok().message("用户退出成功");
        }
        return Result.error().message("用户退出失败");
    }

}
