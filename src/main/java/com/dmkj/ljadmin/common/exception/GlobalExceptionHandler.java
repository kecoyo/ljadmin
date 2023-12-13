package com.dmkj.ljadmin.common.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.dmkj.ljadmin.common.ResponseResult;
import com.dmkj.ljadmin.common.ResultCode;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

// 全局异常处理
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 处理所有接口数据验证异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        ArrayList<String> errorMsgs = new ArrayList<>();
        for (ObjectError error : allErrors) {
            errorMsgs.add(error.getDefaultMessage());
        }
        return ResponseResult.fail(ResultCode.BAD_REQUEST.getCode(), ResultCode.BAD_REQUEST.getMessage(), errorMsgs);
    }

    // 处理所有接口异常
    @ExceptionHandler(ApiException.class)
    public ResponseResult<Object> handleApiException(ApiException e) {
        return ResponseResult.fail(e.getCode(), e.getMessage());
    }

    // 处理所有接口异常
    @ExceptionHandler(BadRequestException.class)
    public ResponseResult<Object> handleApiException(BadRequestException e) {
        return ResponseResult.fail(e.getStatus(), e.getMessage());
    }

    // 类型转换异常
    // @ExceptionHandler(InvalidFormatException.class)
    // public ResponseResult<Object>
    // handleInvalidFormatException(InvalidFormatException e) {
    // return ResponseResult.fail(ResultCode.BAD_REQUEST);
    // }

    // 参数解析异常
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseResult<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return ResponseResult.fail(ResultCode.BAD_REQUEST.getCode(), ResultCode.BAD_REQUEST.getMessage(),
                e.getMessage());
    }

    // 403 接口无权限异常
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseResult<Object> handleAccessDeniedException(AccessDeniedException e) {
        return ResponseResult.fail(ResultCode.FORBIDDEN);
    }

    // 404 接口不存在异常
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseResult<Object> handleNotFoundException(NoResourceFoundException e) {
        return ResponseResult.fail(ResultCode.NOT_FOUND);
    }

    // 处理所有未知异常
    @ExceptionHandler(Exception.class)
    public ResponseResult<Object> handleException(Exception e) {
        return ResponseResult.fail(ResultCode.ERROR.getCode(), ResultCode.ERROR.getMessage(),
                e.getMessage());
    }
}
