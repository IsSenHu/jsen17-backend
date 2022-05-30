package com.jsen17.commons.utils;

import com.jsen17.commons.model.BusinessException;
import com.jsen17.commons.model.Error;
import org.apache.commons.lang3.StringUtils;

/**
 * 断言工具类，抛出业务异常
 *
 * @author HuSen
 * @since 2022/5/30 9:11 AM
 */
public class AssertUtils {

    public static void notNull(Object obj, Error error) {
        if (obj == null) {
            throw new BusinessException(error);
        }
    }

    public static void isNull(Object obj, Error error) {
        if (obj != null) {
            throw new BusinessException(error);
        }
    }

    public static void isTrue(boolean condition, Error error) {
        if (!condition) {
            throw new BusinessException(error);
        }
    }

    public static void notBlank(String str, Error error) {
        if (StringUtils.isBlank(str)) {
            throw new BusinessException(error);
        }
    }
}
