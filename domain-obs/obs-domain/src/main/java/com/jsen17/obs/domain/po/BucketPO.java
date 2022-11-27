package com.jsen17.obs.domain.po;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author husen
 * @since 2022/11/27 15:35
 */
@Data
@Document("bucket")
public class BucketPO {

    @Id
    private String bucket;

    private LocalDateTime createdTime;
}
