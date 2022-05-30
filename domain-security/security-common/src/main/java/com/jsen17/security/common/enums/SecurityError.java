package com.jsen17.security.common.enums;

import com.jsen17.commons.model.Error;

/**
 * @author HuSen
 * @since 2022/5/30 9:15 AM
 */
public enum SecurityError implements Error {
    ;

    private final Integer code;
    private final String error;

    SecurityError(Integer code, String error) {
        this.code = code;
        this.error = error;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getError() {
        return this.error;
    }
}
