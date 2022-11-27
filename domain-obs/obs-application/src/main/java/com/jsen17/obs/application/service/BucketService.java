package com.jsen17.obs.application.service;

import com.jsen17.obs.common.dto.BucketDTO;
import com.jsen17.obs.common.dto.CreateBucketRequest;
import reactor.core.publisher.Mono;

/**
 * @author husen
 * @since 2022/11/27 15:36
 */
public interface BucketService {

    Mono<BucketDTO> create(String bucket, CreateBucketRequest request);
}
