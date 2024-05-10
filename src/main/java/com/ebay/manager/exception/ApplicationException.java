package com.ebay.manager.exception;

import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {

    private ApplicationErrorCode code;

    /**
     * <p>原始错误信息, 日志中追踪堆栈信息</p>
     */
    private Throwable originThrowable;


    /**
     * <p>一般为无法辨别的系统异常</p>
     * @param code
     * @param originThrowable
     */
    public ApplicationException(ApplicationErrorCode code,Throwable originThrowable) {
        this.code = code;
        this.originThrowable = originThrowable;
    }

    public ApplicationException(ApplicationErrorCode code) {
        this.code = code;
    }

    /**
     * 代码中 catch exception 需要获取详细的 message
     * @return
     */
    @Override
    public String getMessage() {
        if(originThrowable != null){
            return originThrowable.getMessage();
        }
        return this.code.getMsg();
    }
}
