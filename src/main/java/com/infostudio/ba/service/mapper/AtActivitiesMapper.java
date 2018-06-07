package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.AtActivitiesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AtActivities and its DTO AtActivitiesDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AtActivitiesMapper extends EntityMapper<AtActivitiesDTO, AtActivities> {



    default AtActivities fromId(Long id) {
        if (id == null) {
            return null;
        }
        AtActivities atActivities = new AtActivities();
        atActivities.setId(id);
        return atActivities;
    }
}
