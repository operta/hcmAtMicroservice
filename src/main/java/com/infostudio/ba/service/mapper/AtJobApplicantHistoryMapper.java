package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.AtJobApplicantHistoryDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AtJobApplicantHistory and its DTO AtJobApplicantHistoryDTO.
 */
@Mapper(componentModel = "spring", uses = {AtJobApplicationStatusesMapper.class, AtJobApplicationsMapper.class})
public interface AtJobApplicantHistoryMapper extends EntityMapper<AtJobApplicantHistoryDTO, AtJobApplicantHistory> {

    @Mapping(source = "idStatusFrom.id", target = "idStatusFromId")
    @Mapping(source = "idStatusFrom.name", target = "idStatusFromName")
    @Mapping(source = "idStatusTo.id", target = "idStatusToId")
    @Mapping(source = "idStatusTo.name", target = "idStatusToName")
    @Mapping(source = "idJobApplication.id", target = "idJobApplicationId")
    AtJobApplicantHistoryDTO toDto(AtJobApplicantHistory atJobApplicantHistory);

    @Mapping(source = "idStatusFromId", target = "idStatusFrom")
    @Mapping(source = "idStatusToId", target = "idStatusTo")
    @Mapping(source = "idJobApplicationId", target = "idJobApplication")
    AtJobApplicantHistory toEntity(AtJobApplicantHistoryDTO atJobApplicantHistoryDTO);

    default AtJobApplicantHistory fromId(Long id) {
        if (id == null) {
            return null;
        }
        AtJobApplicantHistory atJobApplicantHistory = new AtJobApplicantHistory();
        atJobApplicantHistory.setId(id);
        return atJobApplicantHistory;
    }
}
