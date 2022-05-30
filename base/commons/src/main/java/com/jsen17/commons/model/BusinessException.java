package com.jsen17.commons.model;

/**
 * 业务异常
 *
 * @author HuSen
 * @since 2022/5/30 9:03 AM
 */
public class BusinessException extends RuntimeException {

    private final Error error;

    public BusinessException(Error error) {
        super(error.getError());
        this.error = error;
    }

    public Error getError() {
        return error;
    }
}
