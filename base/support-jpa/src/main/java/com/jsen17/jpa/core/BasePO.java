package com.jsen17.jpa.core;

import com.jsen17.commons.func.EmptyConsumer;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * @author HuSen
 * @since 2022/5/27 4:29 PM
 */
@Setter
@Getter
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BasePO {

    /**
     * 创建时间
     */
    @CreatedDate
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 最近修改时间
     */
    @LastModifiedDate
    @Column(name = "last_modified_time")
    private LocalDateTime lastModifiedTime;

    /**
     * 被谁创建
     */
    @CreatedBy
    @Column(name = "create_user_id")
    private Long createBy;

    /**
     * 最近一次被谁修改
     */
    @LastModifiedBy
    @Column(name = "last_modified_by")
    private Long lastModifiedBy;

    /**
     * 设置自己的默认值
     */
    public abstract void fillingDefaultFieldVal();

    /**
     * 非空的时候执行
     *
     * @param val      值
     * @param consumer 空消费
     */
    protected void onNull(Object val, EmptyConsumer consumer) {
        if (val instanceof String && StringUtils.isNotBlank((String) val)) {
            return;
        }
        if (val != null) {
            return;
        }
        consumer.accept();
    }
}
