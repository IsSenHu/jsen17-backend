package com.jsen17.commons.utils;

import java.util.UUID;

/**
 * @author HuSen
 * @since 2022/5/27 4:21 PM
 */
public class UUIDUtils {

    public static String uid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
