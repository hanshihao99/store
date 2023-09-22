package com.cy.store_.service.ex;

/**
 * @Description: 密码不匹配的异常
 * @Auther: hanshihao
 * @Date: 2023/09/10/20:59
 */
public class PasswordNotMatchException extends ServiceException{
    public PasswordNotMatchException() {
    }

    public PasswordNotMatchException(String message) {
        super(message);
    }

    public PasswordNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNotMatchException(Throwable cause) {
        super(cause);
    }

    public PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
