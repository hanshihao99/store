package com.cy.store_.controller.ex;

import java.io.File;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/09/19/23:14
 */
public class FileIOException extends FileUploadException {
    public FileIOException() {
        super();
    }

    public FileIOException(String message) {
        super(message);
    }

    public FileIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileIOException(Throwable cause) {
        super(cause);
    }

    protected FileIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
