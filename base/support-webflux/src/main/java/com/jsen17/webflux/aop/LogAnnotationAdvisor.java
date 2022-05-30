package com.jsen17.webflux.aop;

import com.jsen17.webflux.annotation.AccessLog;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.lang.NonNull;

/**
 * @author HuSen
 * @since 2022/5/30 3:28 PM
 */
public class LogAnnotationAdvisor extends AbstractPointcutAdvisor {

    private final Pointcut pointcut;
    private final Advice advice;

    public LogAnnotationAdvisor() {
        this.advice = buildAdvice();
        this.pointcut = buildPointcut();
    }

    private Pointcut buildPointcut() {
        return AnnotationMatchingPointcut.forMethodAnnotation(AccessLog.class);
    }

    private Advice buildAdvice() {
        return new AccessLogAdvice();
    }

    @Override
    @NonNull
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    @Override
    @NonNull
    public Advice getAdvice() {
        return this.advice;
    }
}
