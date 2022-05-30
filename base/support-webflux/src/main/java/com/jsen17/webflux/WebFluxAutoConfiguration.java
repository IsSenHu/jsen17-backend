package com.jsen17.webflux;

import com.jsen17.commons.model.Error;
import com.jsen17.commons.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author HuSen
 * @since 2022/5/30 8:53 AM
 */
@Configuration(proxyBeanMethods = false)
public class WebFluxAutoConfiguration {

    @Slf4j
    @Configuration
    @RestControllerAdvice
    public static class RestAdvice implements InitializingBean {

        @Override
        public void afterPropertiesSet() {
            log.info("RestAdvice init");
        }

        @ExceptionHandler
        public Result<Object> globalExceptionHandler(Exception e) {
            log.error("error.", e);
            return Result.of(new Error() {
                @Override
                public Integer getCode() {
                    return 50001;
                }

                @Override
                public String getError() {
                    return "业务异常";
                }
            });
        }
    }
}
