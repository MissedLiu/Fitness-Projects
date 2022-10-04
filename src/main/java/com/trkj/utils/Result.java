package com.trkj.utils;

import com.trkj.config.exception.CustomError;

import lombok.Data;

/**
 * 全局统一返回结果类
 */
@Data
public class Result<T> {
    private Boolean success;//是否成功
    private Integer code;//状态码
    private String message;//返回消息
    private T data;//返回数据

    /**
     * 私有化构造方法，禁止在其它类创建对象
     */
    private Result() {
    }

    /**
     * 成功执行，不返回数据
     *
     * @return
     */
    public static <T> Result<T> ok() {
       Result<T> result = new Result<T>();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS);
        result.setMessage("执行成功");
        return result;
    }

    /**
     * 成功执行，并返回数据
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> ok(T data) {
      Result<T> result = new Result<T>();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS);
        result.setMessage("执行成功");
        result.setData(data);
        return result;
    }

    /**
     * 失败
     *
     * @return
     */
    public static <T> Result<T> error() {
       Result<T> result = new Result<T>();
        result.setSuccess(false);
        result.setCode(ResultCode.ERROR);
        result.setMessage("执行失败");
        return result;
    }

    /**
     * 设置是否成功
     *
     * @param success
     * @return
     */
    public Result<T> success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    /**
     * 设置状态码
     *
     * @param code
     * @return
     */
    public Result<T> code(Integer code) {
        this.setCode(code);
        return this;
    }

    /**
     * 设置返回消息
     *
     * @param message
     * @return
     */
    public Result<T> message(String message) {
        this.setMessage(message);
        return this;
    }

    /**
     * 是否存在
     *
     * @return
     */
    public static <T> Result<T> exist() {
        Result<T> result = new Result<T>();
        result.setSuccess(false);//存在该数据
        result.setCode(ResultCode.SUCCESS);//执行成功但是存在该数据
        result.setMessage("该数据存在");
        return result;
    }

    /**
     * 请求出现异常时的响应数据封装
     * @param e:异常
     * @return AjaxResponse 封闭后的响应对象
     */
    public static Result error(CustomError e) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(e.getCode());
        result.setMessage(e.getMessage());
        return result;
    }

    /**
     * 请求出现异常时的响应数据封装
     * @param e:异常
     * @return AjaxResponse 封闭后的响应对象
     */
    public static Result error(CustomError e, Object data) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(e.getCode());
        result.setMessage(e.getMessage());
        result.setData(data);
        return result;
    }

    /**
     * @Description //请求错误的响 返回响应消息
     * @Param msg
     * @return com.trkj.vo.AjaxResponse
     **/
    public static Result error(String msg) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(200);
        result.setMessage(msg);
        result.setData(null);
        return result;
    }
}