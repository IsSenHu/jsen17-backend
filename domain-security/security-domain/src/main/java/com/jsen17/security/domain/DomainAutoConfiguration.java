package com.jsen17.security.domain;

import com.jsen17.security.domain.po.Eeeeee;
import com.jsen17.security.domain.repository.Rrrrrr;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author HuSen
 * @since 2022/5/27 11:18 AM
 */
@ComponentScan
@EnableJpaRepositories(basePackageClasses = Rrrrrr.class)
@EntityScan(basePackageClasses = Eeeeee.class)
public class DomainAutoConfiguration {
}
