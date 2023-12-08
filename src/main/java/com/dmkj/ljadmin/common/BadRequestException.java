package com.dmkj.ljadmin.common;

import org.springframework.http.HttpStatus;

import lombok.Getter;

/**
 * 统一异常处理
 */
@Getter
public class BadRequestException extends RuntimeException {

    private Integer status = HttpStatus.BAD_REQUEST.value();

    public BadRequestException(String msg) {
        super(msg);
    }

    public BadRequestException(HttpStatus status, String msg) {
        super(msg);
        this.status = status.value();
    }
}
