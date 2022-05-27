package com.jsen17.commons.model;

import lombok.Data;

/**
 * @author HuSen
 * @since 2022/5/27 3:21 PM
 */
@Data
public class Result<T> {

    private Integer code;

    private T data;

    private String msg;

    private Long timestamp;

    public static <T> Result<T> of(T data) {
        Result<T> result = new Result<>();
        result.setCode(0);
        result.setTimestamp(System.currentTimeMillis());
        result.setData(data);
        return result;
    }

    public static <T> Result<T> of(Error error) {
        Result<T> result = new Result<>();
        result.setCode(error.getCode());
        result.setTimestamp(System.currentTimeMillis());
        result.setData(null);
        result.setMsg(error.getError());
        return result;
    }
}
