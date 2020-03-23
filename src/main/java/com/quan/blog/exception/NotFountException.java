package com.quan.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author 张金泉
 * @create 2020-03-19 21:57
 */
//返回状态
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFountException extends RuntimeException {
    public NotFountException() {
    }

    public NotFountException(String message) {
        super(message);
    }

    public NotFountException(String message, Throwable cause) {
        super(message, cause);
    }
}
