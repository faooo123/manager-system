package com.ebay.manager.handler;

import com.ebay.manager.exception.ApplicationErrorCode;
import com.ebay.manager.exception.ApplicationException;
import com.ebay.manager.dto.Response;
import com.ebay.manager.utils.ResponseGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.ServletException;

@RestControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> exceptionHandler(Exception e) {
        log.error("", e);
        return ResponseGenerator.genFailResult(new ApplicationException(ApplicationErrorCode.UNKNOWN_ERROR, e));
    }

    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseEntity<Response> exceptionHandler(HttpMessageConversionException e) {
        log.error("", e);
        return ResponseGenerator.genFailResult(new ApplicationException(ApplicationErrorCode.BAD_PARAMS, e));
    }

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<Response> exceptionHandler(ApplicationException e) {
        return ResponseGenerator.genFailResult(e);
    }
}