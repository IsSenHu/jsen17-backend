package com.jsen17.webflux.aop;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.lang.NonNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author HuSen
 * @since 2022/5/30 3:33 PM
 */
@Slf4j
public class AccessLogAdvice implements MethodInterceptor {

    public void before(@NonNull Method method, @NonNull Object[] args) {
        log.info("---access:{}, args:{}", method.getName(), Arrays.toString(args));
    }

    @Nullable
    @Override
    public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        Object target = invocation.getThis();
        Object[] args = invocation.getArguments();
        before(method, args);
        return method.invoke(target, args);
    }
}
