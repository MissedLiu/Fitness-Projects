package com.trkj.config.exception;


import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.trkj.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.NestedRuntimeException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
  //  @ResponseBody
    public Result defaultServiceErrorHandler(HttpServletRequest request, Exception e){
        System.out.println("--------------------------------------------------1");
        log.info("GlobalExceptionHandler开始输出异常信息>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>：");
        e.printStackTrace();
        log.info("GlobalExceptionHandler输出异常信息完毕>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>！");
        if(e instanceof NoHandlerFoundException){
            log.info("没有找到匹配的资源");
            return Result.error(e.getMessage());
        }
        if(e instanceof NullPointerException){
            log.info("对象为空");
            return Result.error("对象为空");
        }
        if(e instanceof IndexOutOfBoundsException){
            log.info("下标越界");
            return Result.error("下标越界");
        }
        if(e instanceof NumberFormatException){
            log.info("不能转换成数值");
            return Result.error("不能转换成数值");
        }
        if(e instanceof ClassCastException){
            log.info("类型无法转换");
            return Result.error("类型无法转换");
        }

        return Result.error(e.getMessage());

    }
    @ExceptionHandler({NestedRuntimeException.class})
    @ResponseBody
    public Result defaultSystemErrorHandler(HttpServletRequest request, Exception e){
        System.out.println("--------------------------------------------------2");
        log.info("GlobalExceptionHandler开始输出异常信息>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>：");
        e.printStackTrace();
        log.info("GlobalExceptionHandler输出异常信息完毕>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>！");
        if(e instanceof MethodArgumentTypeMismatchException){
            log.info("参数类型不匹配");
            return Result.error("参数类型不匹配");
        }
        if(e instanceof InvalidFormatException){
            log.info("JSON数据反序列化失败");
            return Result.error(e.getMessage());
        }
        if(e instanceof HttpMessageNotReadableException){
            log.info("参数JSON序列化失败");
            return Result.error(e.getMessage());
        }
        if(e instanceof MaxUploadSizeExceededException){
            log.info("上传文件超出指定大小");
            return Result.error(
                    "总文件不能超过10M，单个文件不能超过5M！");
        }
        return Result.error(e.getMessage());
    }

    // 处理的异常类型
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Result handleValidException(MethodArgumentNotValidException e) {
        log.info("GlobalExceptionHandler开始输出异常信息>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>：");
        e.printStackTrace();
        log.info("GlobalExceptionHandler输出异常信息完毕>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>！");
        log.error("数据校验出现问题{},异常类型：{}",e.getMessage(),e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        Map<String,String> errorMap = new HashMap<>();
        StringBuilder msg = new StringBuilder();
        bindingResult.getFieldErrors().forEach(fieldError -> {
            errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
            msg.append(fieldError.getDefaultMessage());
            msg.append(",");
        });
        log.debug("数据校验异常信息{}",errorMap);
        //参数校验异常
        return Result.error(msg.toString());
    }
}