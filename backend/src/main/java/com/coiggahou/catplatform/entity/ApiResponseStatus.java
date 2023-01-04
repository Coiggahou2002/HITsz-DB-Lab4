package com.coiggahou.catplatform.entity;


/**
 * 返回状态枚举
 * @author coiggahou
 */
public enum ApiResponseStatus {

    SUCCESS(10000, "success"),

    RESOURCE_NOT_FOUND(10002, "资源未找到"),

    SERVER_ERROR(10005, "服务端发生未知错误"),

    REQUEST_NOT_FOUND(10006, "请求不存在"),

    VALIDATION_ERROR(30001, "参数校验异常"),

    REQUEST_PARAM_ERROR(30002, "请求参数异常"),

    REGISTER_FAILED(20007, "注册失败"),

    AUTHENTICATION_ERROR(10001, "认证异常"),

    USER_NOT_EXIST(20001, "用户不存在"),

    USERNAME_OR_PASSWORD_ERROR(20002, "用户名或密码错误");

    /**
     * 状态码
     */
    private int code;

    /**
     * 状态描述信息
     */
    private String msg;

    ApiResponseStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}