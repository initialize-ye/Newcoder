package com.newcoder.subject.common.enums;

import lombok.Getter;

/**
 * 统一返回状态码
 *
 * @author chenye
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(200, "成功"),
    FAIL(500, "系统异常"),

    PARAM_ERROR(400, "参数错误"),
    NOT_LOGIN(401, "未登录"),
    NO_AUTH(403, "没有权限"),
    NOT_FOUND(404, "资源不存在");

    private final int code;
    private final String message;

    ResultCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResultCodeEnum getByCode(int code) {
        for (ResultCodeEnum e : values()) {
            if (e.code == code) {
                return e;
            }
        }
        return null;
    }
}