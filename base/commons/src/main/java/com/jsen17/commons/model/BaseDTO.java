package com.jsen17.commons.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsen17.commons.constants.Constants;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author HuSen
 * @since 2022/5/27 6:19 PM
 */
@Getter
@Setter
@ToString
public class BaseDTO implements Serializable {

    /**
     * 创建时间
     */
    @JsonFormat(pattern = Constants.Time.F1, timezone = Constants.Time.TIMEZONE_8)
    private LocalDateTime createTime;

    /**
     * 最近修改时间
     */
    @JsonFormat(pattern = Constants.Time.F1, timezone = Constants.Time.TIMEZONE_8)
    private LocalDateTime lastModifiedTime;

    /**
     * 被谁创建
     */
    private Long createBy;

    /**
     * 最近一次被谁修改
     */
    private Long lastModifiedBy;
}
