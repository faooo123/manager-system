package com.ebay.manager.exception;

import com.ebay.manager.enums.Constants;
import lombok.Getter;
import org.slf4j.event.Level;

@Getter
public enum ApplicationErrorCode {
    UNKNOWN_ERROR("99999","系统异常，请查看日志详情", Constants.INTERNAL_SERVER_ERROR),
    BAD_PARAMS("00001","参数错误", Constants.BAD_REQUEST_STATUS),
    AUTH_ERROR("00002","访问鉴权失败，请检查凭证",Constants.FORBIDDEN_STATUS),
    JSON_ERROR("00003", "JSON 错误",Constants.BAD_REQUEST_STATUS),
    ;

    /**
     * 自定义错误码
     */
    private String errorCode;
    /**
     * 错误状态码对应 HTTP Code
     */
    private Integer httpCode;
    /**
     * 错误信息
     */
    private String msg;

    ApplicationErrorCode(String errorCode, String msg, Integer httpCode) {
        this.errorCode = errorCode;
        this.msg = msg;
        this.httpCode = httpCode;
    }
}
