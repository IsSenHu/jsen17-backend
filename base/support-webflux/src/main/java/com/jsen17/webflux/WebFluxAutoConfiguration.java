package com.jsen17.webflux;

import com.jsen17.commons.model.*;
import com.jsen17.commons.model.Error;
import com.jsen17.webflux.utils.ContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

/**
 * @author HuSen
 * @since 2022/5/30 8:53 AM
 */
@Configuration(proxyBeanMethods = false)
public class WebFluxAutoConfiguration {

    @Bean
    public ContextUtils contextUtils() {
        return new ContextUtils();
    }

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

            // 业务异常
            if (e instanceof BusinessException) {
                Error error = ((BusinessException) e).getError();
                return Result.of(error);
            }

            // 参数异常
            if (e instanceof ParamException) {
                Map<String, String> errors = ((ParamException) e).getErrors();
                Result<Object> result = Result.of(errors);
                result.setCode(4000);
                result.setMsg(e.getMessage());
                return result;
            }

            // 否则服务器内部错误
            return Result.of(SystemError.INTERNAL_SERVER_ERROR);
        }
    }
}
