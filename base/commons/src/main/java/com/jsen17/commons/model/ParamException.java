package com.jsen17.commons.model;

import java.util.Map;

/**
 * 参数异常
 *
 * @author HuSen
 * @since 2022/5/30 9:01 AM
 */
public class ParamException extends RuntimeException {

    private final Map<String, String> errors;

    public ParamException(Map<String, String> errors) {
        super("param.error", null, false, false);
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
