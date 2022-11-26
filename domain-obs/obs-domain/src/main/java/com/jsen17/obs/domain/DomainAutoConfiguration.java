package com.jsen17.obs.domain;

import com.jsen17.obs.domain.repository.R;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author Husen
 * @since 2022/11/26 22:22
 */
@EnableMongoRepositories(basePackageClasses = R.class)
public class DomainAutoConfiguration {
}
