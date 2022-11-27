package com.jsen17.obs.interfaces.controller;

import com.jsen17.obs.domain.po.ObsPO;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * @author husen
 * @since 2022/11/27 13:45
 */
@RestController
@RequestMapping("/v1/obs")
public class ObsController {

    @PostMapping("/{objectKey}")
    public Mono<ObsPO> upload(
            @PathVariable("objectKey") String objectKey, @RequestPart("file") FilePart file) {
        return Mono.empty();
    }
}
