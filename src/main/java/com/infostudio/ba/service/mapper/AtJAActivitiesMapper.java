package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.AtJAActivitiesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AtJAActivities and its DTO AtJAActivitiesDTO.
 */
@Mapper(componentModel = "spring", uses = {AtActivitiesMapper.class, AtJobApplicationsMapper.class, AtActivityStatusesMapper.class})
public interface AtJAActivitiesMapper extends EntityMapper<AtJAActivitiesDTO, AtJAActivities> {

    @Mapping(source = "idActivity.id", target = "idActivityId")
    @Mapping(source = "idActivity.name", target = "idActivityName")
    @Mapping(source = "idJobApplication.id", target = "idJobApplicationId")
    @Mapping(source = "idStatus.id", target = "idStatusId")
    @Mapping(source = "idStatus.name", target = "idStatusName")
    AtJAActivitiesDTO toDto(AtJAActivities atJAActivities);

    @Mapping(source = "idActivityId", target = "idActivity")
    @Mapping(source = "idJobApplicationId", target = "idJobApplication")
    @Mapping(source = "idStatusId", target = "idStatus")
    AtJAActivities toEntity(AtJAActivitiesDTO atJAActivitiesDTO);

    default AtJAActivities fromId(Long id) {
        if (id == null) {
            return null;
        }
        AtJAActivities atJAActivities = new AtJAActivities();
        atJAActivities.setId(id);
        return atJAActivities;
    }
}
