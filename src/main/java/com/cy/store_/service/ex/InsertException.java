package com.cy.store_.service.ex;

/**
 * @Description: 插入时异常
 * @Auther: hanshihao
 * @Date: 2023/09/10/00:07
 */
public class InsertException extends RuntimeException{
    public InsertException() {
        super();
    }

    public InsertException(String message) {
        super(message);
    }

    public InsertException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertException(Throwable cause) {
        super(cause);
    }

    protected InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
