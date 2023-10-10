package com.cy.store_.service.ex;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/09/23:08
 */
public class AddressNotFoundException extends ServiceException{

    public AddressNotFoundException() {
    }

    public AddressNotFoundException(String message) {
        super(message);
    }

    public AddressNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressNotFoundException(Throwable cause) {
        super(cause);
    }

    public AddressNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
