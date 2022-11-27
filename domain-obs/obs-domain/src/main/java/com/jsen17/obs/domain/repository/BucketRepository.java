package com.jsen17.obs.domain.repository;

import com.jsen17.obs.domain.po.BucketPO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @author husen
 * @since 2022/11/27 15:36
 */
public interface BucketRepository extends ReactiveMongoRepository<BucketPO, String> {
}
