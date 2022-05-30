package com.jsen17.commons.model;

/**
 * @author HuSen
 * @since 2022/5/30 10:35 AM
 */
public enum SystemError implements Error {
    //
    INTERNAL_SERVER_ERROR(5000, "internal.server.error");

    SystemError(Integer code, String error) {
        this.code = code;
        this.error = error;
    }

    private final Integer code;
    private final String error;

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getError() {
        return this.error;
    }
}
