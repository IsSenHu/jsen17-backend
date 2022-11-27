package com.jsen17.obs.domain;

import com.jsen17.obs.domain.repository.R;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * @author Husen
 * @since 2022/11/26 22:22
 */
@EnableReactiveMongoRepositories(basePackageClasses = R.class)
public class DomainAutoConfiguration {
}
