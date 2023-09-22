package com.cy.store_.controller.ex;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/09/19/23:14
 */
public class FileTypeException extends FileUploadException{
    public FileTypeException() {
        super();
    }

    public FileTypeException(String message) {
        super(message);
    }

    public FileTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileTypeException(Throwable cause) {
        super(cause);
    }

    protected FileTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
