package com.cy.store_.service.ex;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/10/23:00
 */
public class DeleteException extends ServiceException{
    public DeleteException() {
    }

    public DeleteException(String message) {
        super(message);
    }

    public DeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteException(Throwable cause) {
        super(cause);
    }

    public DeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
