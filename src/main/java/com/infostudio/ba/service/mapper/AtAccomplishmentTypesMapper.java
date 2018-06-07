package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.AtAccomplishmentTypesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AtAccomplishmentTypes and its DTO AtAccomplishmentTypesDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AtAccomplishmentTypesMapper extends EntityMapper<AtAccomplishmentTypesDTO, AtAccomplishmentTypes> {



    default AtAccomplishmentTypes fromId(Long id) {
        if (id == null) {
            return null;
        }
        AtAccomplishmentTypes atAccomplishmentTypes = new AtAccomplishmentTypes();
        atAccomplishmentTypes.setId(id);
        return atAccomplishmentTypes;
    }
}
