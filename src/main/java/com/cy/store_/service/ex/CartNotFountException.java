package com.cy.store_.service.ex;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/15/16:33
 */
public class CartNotFountException extends ServiceException{
    public CartNotFountException() {
        super();
    }

    public CartNotFountException(String message) {
        super(message);
    }

    public CartNotFountException(String message, Throwable cause) {
        super(message, cause);
    }

    public CartNotFountException(Throwable cause) {
        super(cause);
    }

    protected CartNotFountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
