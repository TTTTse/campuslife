package com.graduationproject.campuslifecommon.constant;

import lombok.Getter;
import lombok.Setter;

public enum ResultCode {
    NORMAL(20000L, "正常响应"),
    AUTH_FAIL(20001L, "账号或密码错误"),
    STAT_FAIL(20001L,"数据库数据异常"),
    SYSTEM_ERROR(20002L, "系统异常");

    @Setter
    @Getter
    private Long code;

    @Setter
    @Getter
    private String message;

    ResultCode(Long code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }
}
