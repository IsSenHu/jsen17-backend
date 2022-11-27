package com.jsen17.obs.application.converter;

import com.jsen17.obs.common.dto.BucketDTO;
import com.jsen17.obs.domain.po.BucketPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author husen
 * @since 2022/11/27 15:52
 */
@Mapper
public interface BucketConverter {

    BucketConverter INSTANCE = Mappers.getMapper(BucketConverter.class);

    BucketDTO poToDto(BucketPO po);
}
