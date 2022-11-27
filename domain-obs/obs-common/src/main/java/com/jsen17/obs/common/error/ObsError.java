package com.jsen17.obs.common.error;

import com.jsen17.commons.model.Error;

/**
 * @author husen
 * @since 2022/11/27 15:48
 */
public enum ObsError implements Error {
    BUCKET_EXISTS(1, "The bucket has been existed.");

    private final Integer code;

    private final String error;

    ObsError(Integer code, String error) {
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
