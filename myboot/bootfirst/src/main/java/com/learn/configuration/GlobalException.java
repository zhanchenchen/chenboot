package com.learn.configuration;

import com.learn.model.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 全局异常捕捉
 */
@RestControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handle(Exception exception, HttpServletRequest request, HttpServletResponse response) {
        log.error("=========================异常开始打印=========================>>");
        log.error("URL: {}", request.getRequestURL());
        log.error("Class: {}", exception.getClass());
        log.error("message: {}", exception.getMessage());
        log.error("localizedMessage: {}", exception.getLocalizedMessage());
        StackTraceElement[] stackTrace = exception.getStackTrace();
        for (int i = 0; i < stackTrace.length; i++) {
            log.error("ClassName:{},MethodName:{},LineNumber:{}", stackTrace[i].getClassName(), stackTrace[i].getMethodName(), stackTrace[i].getLineNumber());
        }
        log.error("<<=========================异常打印结束=========================");
        //捕捉验证失败异常Validated
        if (exception instanceof ConstraintViolationException) {
            ConstraintViolationException cve = (ConstraintViolationException) exception;
            Set<ConstraintViolation<?>> constraintViolations = cve.getConstraintViolations();
            String errorMessages = constraintViolations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining(","));
            return ResponseResult.error(errorMessages);
        }

        //捕捉验证失败异常Valid
        if (exception instanceof BindException) {
            BindException bindException = (BindException) exception;
            String errorMessages = bindException.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining(","));
            return ResponseResult.error(errorMessages);
        }
        //文件上传过大异常捕捉
        if (exception instanceof MaxUploadSizeExceededException) {
            MaxUploadSizeExceededException maxUploadSizeExceededException= (MaxUploadSizeExceededException) exception;
            return ResponseResult.error(maxUploadSizeExceededException.getMostSpecificCause().getMessage());
        }
        return ResponseResult.error("Internal Server Error！");
    }
}
