package com.jsen17.webflux.aop;

import com.jsen17.webflux.annotation.AccessLog;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author HuSen
 * @since 2022/5/30 3:33 PM
 */
@Slf4j
public class AccessLogAdvice implements MethodInterceptor {

    private final ConcurrentMap<Integer, AccessLog> accessLogConcurrentMap = new ConcurrentHashMap<>();

    public void before(AccessLog accessLog, Object target, @NonNull Method method, @NonNull Object[] args) {
        if (StringUtils.isBlank(accessLog.name())) {
            log.info("---access target:{}, method:{}, args:{}", target != null ? target.getClass().getSimpleName() : null, method.getName(), Arrays.toString(args));
        } else {
            log.info("---access {}, args:{}", accessLog.name(), Arrays.toString(args));
        }
    }

    @Nullable
    @Override
    public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {
        AccessLog accessLog = accessLogConcurrentMap.computeIfAbsent(invocation.getStaticPart().hashCode(),
                c -> invocation.getStaticPart().getAnnotation(AccessLog.class));
        Method method = invocation.getMethod();
        Object[] args = invocation.getArguments();
        before(accessLog, invocation.getThis(), method, args);
        return invocation.proceed();
    }
}
