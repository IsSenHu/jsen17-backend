package com.jsen17.obs.domain.repository;

import com.jsen17.obs.domain.po.ObsPO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @author Husen
 * @since 2022/11/26 22:25
 */
public interface ObsRepository extends ReactiveMongoRepository<ObsPO, String> {
}
