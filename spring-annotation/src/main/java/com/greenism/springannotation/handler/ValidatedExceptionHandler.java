package com.greenism.springannotation.handler;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@ResponseBody
public class ValidatedExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> errorHandle(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code",-1);
        map.put("msg",e.getMessage());
        return map;
    }

    @ExceptionHandler(value=MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,Object> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        Map<String,Object> map = new HashMap<>();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
           map.put("field",error.getField());
           map.put("message",error.getDefaultMessage());
        }
        return map;
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,Object> handleConstraintViolationException(ConstraintViolationException e) {
        Map<String,Object> map = new HashMap<>();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            map.put("field",violation.getPropertyPath().toString());
            map.put("message",violation.getMessage());
        }
        return map;
    }
}
