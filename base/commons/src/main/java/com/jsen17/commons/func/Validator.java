package com.jsen17.commons.func;

import java.util.function.Function;

/**
 * @author HuSen
 * @since 2022/5/27 4:01 PM
 */
@FunctionalInterface
public interface Validator<T> extends Function<T, Boolean> {

    /**
     * 检查参数
     *
     * @param parma 参数
     * @return 是否成功
     */
    default boolean check(T parma) {
        return apply(parma);
    }
}
