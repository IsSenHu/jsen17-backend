package com.jsen17.obs.application.converter;

import com.jsen17.obs.common.dto.ObsDTO;
import com.jsen17.obs.domain.po.ObsPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author husen
 * @since 2022/11/27 13:54
 */
@Mapper
public interface ObsConverter {

    ObsConverter INSTANCE = Mappers.getMapper(ObsConverter.class);

    ObsDTO poToDto(ObsPO po);
}
