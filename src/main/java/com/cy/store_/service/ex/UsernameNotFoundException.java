package com.cy.store_.service.ex;

/**
 * @Description: 用户名不存在异常
 * @Auther: hanshihao
 * @Date: 2023/09/10/20:59
 */
public class UsernameNotFoundException extends ServiceException{
    public UsernameNotFoundException() {
    }

    public UsernameNotFoundException(String message) {
        super(message);
    }

    public UsernameNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameNotFoundException(Throwable cause) {
        super(cause);
    }

    public UsernameNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
