package com.jsen17.obs.domain.po;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Husen
 * @since 2022/11/26 22:23
 */
@Data
@Document("obs")
public class ObsPO {

    @Id
    private String objectKey;

    private String contentType;

    private long size;
}
