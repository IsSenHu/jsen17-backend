package com.jsen17.webflux.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;

/**
 * @author HuSen
 * @since 2022/5/30 9:19 AM
 */
public class ContextUtils implements ApplicationContextAware {

    private ApplicationContext context;

    private static final ContextUtils INSTANCE = new ContextUtils();

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        INSTANCE.context = applicationContext;
    }

    public static <T> T getBean(Class<T> tClass) {
        return INSTANCE.context.getBean(tClass);
    }

    public static <T> T getBean(String name, Class<T> tClass) {
        return INSTANCE.context.getBean(name, tClass);
    }

    public static ApplicationContext getContext() {
        return INSTANCE.context;
    }
}
