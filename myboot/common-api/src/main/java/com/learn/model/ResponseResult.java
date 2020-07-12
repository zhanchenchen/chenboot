package com.learn.model;

import com.learn.enumeration.StatusCode;
import lombok.Data;

import java.util.Date;

/**
 * @Description 此类用于封装具体响应数据
 * @Auth Chen
 * @Date 2019-9-6
 * @Email zccdamon@163.com
 */
@Data
public class ResponseResult {
    private long timestamp;     //时间戳
    private int status;         //响应状态码
    private boolean flag;       //标志字段（成功或失败）
    private String message;     //响应消息
    private Object data;        //响应数据

    /**
     * 无参构造方法
     */
    public ResponseResult() {
        this.timestamp = new Date().getTime();
    }

    /**
     * 双参构造方法
     *
     * @param statusCode 状态码（枚举类）
     * @param message    响应消息
     */
    public ResponseResult(StatusCode statusCode, String message, boolean flag) {
        this();
        this.status = statusCode.getCode();
        this.message = message;
        this.flag = flag;
    }

    /**
     * 双参构造方法
     *
     * @param statusCode 状态码（自定义）
     * @param message    响应消息
     */
    public ResponseResult(int statusCode, String message, boolean flag) {
        this();
        this.status = statusCode;
        this.message = message;
        this.flag = flag;
    }

    /**
     * 全参构造方法
     *
     * @param statusCode 状态码（枚举类）
     * @param message    响应消息
     * @param data       响应数据
     */
    public ResponseResult(StatusCode statusCode, String message, Object data, boolean flag) {
        this(statusCode, message, flag);
        this.data = data;
    }

    /**
     * 全参构造方法
     *
     * @param statusCode 状态码（自定义）
     * @param message    响应消息
     * @param data       响应数据
     */
    public ResponseResult(int statusCode, String message, Object data, boolean flag) {
        this(statusCode, message, flag);
        this.data = data;
    }

    //————————————————成功的响应————————————————

    /**
     * 成功响应 1
     * 默认使用 200 状态码
     *
     * @return 响应实体
     */
    public static ResponseResult success() {
        StatusCode ok = StatusCode.OK;
        return new ResponseResult(ok, ok.getDescription(), null, true);
    }

    /**
     * 成功响应 2
     * 默认使用 200 状态码
     *
     * @param message 响应消息
     * @return 响应实体
     */
    public static ResponseResult success(String message) {
        StatusCode ok = StatusCode.OK;
        return new ResponseResult(ok, message, null, true);
    }

    /**
     * 成功响应 3
     * 默认使用 200 状态码
     *
     * @param data 响应数据
     * @return 响应实体
     */
    public static ResponseResult success(Object data) {
        StatusCode ok = StatusCode.OK;
        return new ResponseResult(ok, ok.getDescription(), data, true);
    }

    /**
     * 成功响应 4
     * 默认使用 200 状态码
     *
     * @param message 响应消息
     * @param data    响应数据
     * @return 响应实体
     */
    public static ResponseResult success(String message, Object data) {
        StatusCode ok = StatusCode.OK;
        return new ResponseResult(ok, message, data, true);
    }

    /**
     * 成功响应 5
     *
     * @param statusCode 状态码（枚举类）
     * @param data       响应数据
     * @return 响应实体
     */
    public static ResponseResult success(StatusCode statusCode, Object data) {
        return new ResponseResult(statusCode, statusCode.getDescription(), data, true);
    }

    /**
     * 成功响应 6
     *
     * @param statusCode 状态码（枚举类）
     * @param message    响应消息
     * @param data       响应数据
     * @return 响应实体
     */
    public static ResponseResult success(StatusCode statusCode, String message, Object data) {
        return new ResponseResult(statusCode, message, data, true);
    }

    /**
     * 成功响应 7
     *
     * @param statusCode 状态码（自定义）
     * @param message    响应消息
     * @param data       响应数据
     * @return 响应实体
     */
    public static ResponseResult success(int statusCode, String message, Object data) {
        return new ResponseResult(statusCode, message, data, true);
    }

    //————————————————错误的响应————————————————

    /**
     * 错误响应 1
     * 默认使用 500 状态码
     *
     * @return 响应实体
     */
    public static ResponseResult error() {
        StatusCode internalServerError = StatusCode.INTERNAL_SERVER_ERROR;
        return new ResponseResult(internalServerError, internalServerError.getDescription(), null, false);
    }

    /**
     * 错误响应 2
     * 默认使用 500 状态码
     *
     * @param message 响应消息
     * @return 响应实体
     */
    public static ResponseResult error(String message) {
        StatusCode internalServerError = StatusCode.INTERNAL_SERVER_ERROR;
        return new ResponseResult(internalServerError, message, null, false);
    }

    /**
     * 错误响应 3
     * 默认使用 500 状态码
     *
     * @param data 响应数据
     * @return 响应实体
     */
    public static ResponseResult error(Object data) {
        StatusCode internalServerError = StatusCode.INTERNAL_SERVER_ERROR;
        return new ResponseResult(internalServerError, internalServerError.getDescription(), data, false);
    }

    /**
     * 错误响应 4
     * 默认使用 500 状态码
     *
     * @param message 响应消息
     * @param data    响应数据
     * @return 响应实体
     */
    public static ResponseResult error(String message, Object data) {
        StatusCode internalServerError = StatusCode.INTERNAL_SERVER_ERROR;
        return new ResponseResult(internalServerError, message, data, false);
    }

    /**
     * 错误响应 5
     *
     * @param statusCode 状态码（枚举类）
     * @param data       响应数据
     * @return 响应实体
     */
    public static ResponseResult error(StatusCode statusCode, Object data) {
        return new ResponseResult(statusCode, statusCode.getDescription(), data, false);
    }

    /**
     * 错误响应 6
     *
     * @param statusCode 状态码（枚举类）
     * @param message    响应消息
     * @param data       响应数据
     * @return 响应实体
     */
    public static ResponseResult error(StatusCode statusCode, String message, Object data) {
        return new ResponseResult(statusCode, message, data, false);
    }

    /**
     * 错误响应 7
     *
     * @param statusCode 状态码（自定义）
     * @param message    响应消息
     * @param data       响应数据
     * @return 响应实体
     */
    public static ResponseResult error(int statusCode, String message, Object data) {
        return new ResponseResult(statusCode, message, data, false);
    }

}
