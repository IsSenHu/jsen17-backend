package com.jsen17.jpa.core;

import com.jsen17.commons.func.EmptyConsumer;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.MappedSuperclass;

/**
 * @author HuSen
 * @since 2022/5/27 4:29 PM
 */
@MappedSuperclass
public interface BasePO {

    /**
     * 设置自己的默认值
     */
    void fillingDefaultFieldVal();

    /**
     * 非空的时候执行
     *
     * @param val      值
     * @param consumer 空消费
     */
    default void onNull(Object val, EmptyConsumer consumer) {
        if (val instanceof String && StringUtils.isNotBlank((String) val)) {
            return;
        }
        if (val != null) {
            return;
        }
        consumer.accept();
    }
}
