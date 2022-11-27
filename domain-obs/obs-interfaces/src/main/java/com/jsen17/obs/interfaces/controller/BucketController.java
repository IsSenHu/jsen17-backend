package com.jsen17.obs.interfaces.controller;

import com.jsen17.commons.model.Result;
import com.jsen17.obs.application.service.BucketService;
import com.jsen17.obs.common.dto.BucketDTO;
import com.jsen17.obs.common.dto.CreateBucketRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * @author husen
 * @since 2022/11/27 14:02
 */
@RestController
@RequestMapping("/v1/bucket")
public class BucketController {

    private final BucketService bucketService;

    public BucketController(BucketService bucketService) {
        this.bucketService = bucketService;
    }

    @PostMapping("/{bucket}")
    public Mono<Result<BucketDTO>> create(
            @PathVariable("bucket") String bucket, @RequestBody CreateBucketRequest request) {
        return bucketService.create(bucket, request).map(Result::of);
    }
}
