package com.jsen17.money.domain;

import com.jsen17.money.domain.po.E;
import com.jsen17.money.domain.repository.R;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Husen
 * @since 2022/11/28 20:46
 */
@EnableJpaRepositories(basePackageClasses = R.class)
@EntityScan(basePackageClasses = E.class)
public class DomainAutoConfiguration {
}
