package com.cy.store_.service.ex;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/09/11/22:36
 */
public class UpdateException extends ServiceException{
    public UpdateException() {
        super();
    }

    public UpdateException(String message) {
        super(message);
    }

    public UpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateException(Throwable cause) {
        super(cause);
    }

    protected UpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
