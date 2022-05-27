package com.jsen17.commons.model;

/**
 * @author HuSen
 * @since 2022/5/27 3:22 PM
 */
public interface Error {

    /**
     * 返回错误码
     *
     * @return 错误码
     */
    Integer getCode();

    /**
     * 返回错误的描述
     *
     * @return 错误的描述
     */
    String getError();
}
