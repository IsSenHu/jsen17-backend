package com.jsen17.obs.common.dto;

import lombok.Data;

/**
 * @author husen
 * @since 2022/11/27 13:48
 */
@Data
public class ObsDTO {

    private String objectKey;

    private String contentType;

    private long size;
}
