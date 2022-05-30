package com.jsen17.webflux;

import com.jsen17.webflux.aop.LogAnnotationAdvisor;
import org.springframework.aop.framework.autoproxy.AbstractBeanFactoryAwareAdvisingPostProcessor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

/**
 * @author HuSen
 * @since 2022/5/30 3:14 PM
 */
@Configuration
public class AccessLogAnnoBeanPostProcessor extends AbstractBeanFactoryAwareAdvisingPostProcessor {

    @Override
    public void setBeanFactory(@NonNull BeanFactory beanFactory) {
        super.setBeanFactory(beanFactory);
        this.advisor = new LogAnnotationAdvisor();
    }
}
