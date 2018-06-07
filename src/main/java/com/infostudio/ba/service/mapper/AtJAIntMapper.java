package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.AtJAIntDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AtJAInt and its DTO AtJAIntDTO.
 */
@Mapper(componentModel = "spring", uses = {AtJobApplicationsMapper.class})
public interface AtJAIntMapper extends EntityMapper<AtJAIntDTO, AtJAInt> {

    @Mapping(source = "jobApplicationId.id", target = "jobApplicationIdId")
    AtJAIntDTO toDto(AtJAInt atJAInt);

    @Mapping(source = "jobApplicationIdId", target = "jobApplicationId")
    AtJAInt toEntity(AtJAIntDTO atJAIntDTO);

    default AtJAInt fromId(Long id) {
        if (id == null) {
            return null;
        }
        AtJAInt atJAInt = new AtJAInt();
        atJAInt.setId(id);
        return atJAInt;
    }
}
