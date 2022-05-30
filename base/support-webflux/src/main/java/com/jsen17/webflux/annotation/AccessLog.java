package com.jsen17.webflux.annotation;

import java.lang.annotation.*;

/**
 * @author HuSen
 * @since 2022/5/30 3:31 PM
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AccessLog {
}
