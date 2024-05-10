package com.ebay.manager.utils;

import com.ebay.manager.exception.ApplicationException;
import com.ebay.manager.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public class ExceptionUtil {
    public static ResponseEntity<Response> exceptionResponse(ApplicationException e) {
        return exceptionResponse(null, e);
    }

    public static ResponseEntity<Response> exceptionResponse(HttpServletRequest request, ApplicationException e) {
        Response response = new Response();
        response.setMessage(e.getMessage());
        response.setCode(e.getCode().getErrorCode());
        return new ResponseEntity<>(response, HttpStatus.valueOf(e.getCode().getHttpCode()));
    }
}