package com.jsen17.commons.constants;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author HuSen
 * @since 2022/5/27 4:24 PM
 */
public class Constants {

    public static final String TODO = "todo";
    public static final LocalDateTime SYSTEM_END_TIME = LocalDateTime.of(LocalDate.of(9999, 12, 31), LocalTime.MIN);

    public static class Default {
        public static final String PASSWORD = "jsen17jsen17";
    }

    public static class Time {
        public static final String TIMEZONE_8 = "GMT+8";

        public static final String F1 = "yyyy-MM-dd HH:mm:ss";
    }
}
