package com.jsen17.obs.common.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author husen
 * @since 2022/11/27 15:41
 */
@Data
public class BucketDTO {

    private String bucket;

    private LocalDateTime createdTime;
}
