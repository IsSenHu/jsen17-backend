package com.jsen17.webflux.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 参数验证器
 * 通知/拦截器
 * 主要是进行参数校验
 *
 * @author HuSen
 * @since 2022/5/30 2:53 PM
 */
public class ParamValidatorAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) {
        System.out.println(target + "." + method.getName() + ":" + Arrays.toString(args));
    }
}
