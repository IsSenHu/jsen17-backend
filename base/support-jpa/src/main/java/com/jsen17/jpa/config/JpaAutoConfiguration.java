package com.jsen17.jpa.config;

import com.jsen17.jpa.core.EntityAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author HuSen
 * @since 2022/5/27 6:14 PM
 */
@EnableJpaAuditing
public class JpaAutoConfiguration {

    @Bean
    public AuditorAware<Long> auditorAware() {
        return new EntityAuditorAware();
    }
}
