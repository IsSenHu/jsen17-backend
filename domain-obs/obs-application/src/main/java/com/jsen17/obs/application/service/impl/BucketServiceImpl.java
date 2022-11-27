package com.jsen17.obs.application.service.impl;

import com.jsen17.commons.model.BusinessException;
import com.jsen17.obs.application.service.BucketService;
import com.jsen17.obs.common.dto.BucketDTO;
import com.jsen17.obs.common.dto.CreateBucketRequest;
import com.jsen17.obs.common.error.ObsError;
import com.jsen17.obs.domain.po.BucketPO;
import com.jsen17.obs.domain.repository.BucketRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * @author husen
 * @since 2022/11/27 15:36
 */
@Service
public class BucketServiceImpl implements BucketService {

    public final BucketRepository bucketRepository;

    public BucketServiceImpl(BucketRepository bucketRepository) {
        this.bucketRepository = bucketRepository;
    }

    @Override
    public Mono<BucketDTO> create(String bucket, CreateBucketRequest request) {
        return bucketRepository.existsById(bucket)
                .flatMap(exists -> judgeThenSave(bucket, exists));
    }

    private Mono<BucketDTO> judgeThenSave(String bucket, Boolean exists) {
        if (exists) {
            return Mono.error(new BusinessException(ObsError.BUCKET_EXISTS));
        }
        BucketPO po = new BucketPO();
        po.setBucket(bucket);
        po.setCreatedTime(LocalDateTime.now());
        return bucketRepository.save(po).map(p -> new BucketDTO());
    }
}
