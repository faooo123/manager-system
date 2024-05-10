package com.ebay.manager.utils;


import com.ebay.manager.exception.ApplicationException;
import com.ebay.manager.dto.Response;
import org.springframework.http.ResponseEntity;

/**
 * 相应结果生成
 */
public class ResponseGenerator {

    /**
     * 返回成功
     *
     * @return
     */
    public static ResponseEntity<Response> genSuccessResult() {
        return ResponseEntity.ok(new Response()
                .setCode("200")
                .setMessage("请求成功"));
    }



    /**
     * 返回异常信息
     * @return
     */
    public static ResponseEntity<Response> genFailResult(ApplicationException e) {
        return ExceptionUtil.exceptionResponse(e);
    }

}
