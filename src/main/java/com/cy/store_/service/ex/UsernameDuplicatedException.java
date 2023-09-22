package com.cy.store_.service.ex;

/**
 * @Description: 用户名被占用异常
 * @Auther: hanshihao
 * @Date: 2023/09/10/00:05
 */
public class UsernameDuplicatedException extends ServiceException{
    public UsernameDuplicatedException() {
    }

    public UsernameDuplicatedException(String message) {
        super(message);
    }

    public UsernameDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameDuplicatedException(Throwable cause) {
        super(cause);
    }

    public UsernameDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
