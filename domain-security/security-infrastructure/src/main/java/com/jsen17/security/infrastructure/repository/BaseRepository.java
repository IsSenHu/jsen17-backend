package com.jsen17.security.infrastructure.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author HuSen
 * @since 2022/5/27 1:14 PM
 */
@NoRepositoryBean
public interface BaseRepository<T, ID> extends R2dbcRepository<T, ID> {

}
