package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.AtJobApplicationsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AtJobApplications and its DTO AtJobApplicationsDTO.
 */
@Mapper(componentModel = "spring", uses = {AtApplicantsMapper.class, AtJobApplicationStatusesMapper.class, AtVacanciesMapper.class})
public interface AtJobApplicationsMapper extends EntityMapper<AtJobApplicationsDTO, AtJobApplications> {

    @Mapping(source = "applicantId.id", target = "applicantIdId")
    @Mapping(source = "applicantId.surname", target = "applicantIdSurname")
    @Mapping(source = "idStatus.id", target = "idStatusId")
    @Mapping(source = "idStatus.name", target = "idStatusName")
    @Mapping(source = "vacancyId.id", target = "vacancyIdId")
    @Mapping(source = "vacancyId.name", target = "vacancyIdName")
    AtJobApplicationsDTO toDto(AtJobApplications atJobApplications);

    @Mapping(source = "applicantIdId", target = "applicantId")
    @Mapping(source = "idStatusId", target = "idStatus")
    @Mapping(source = "vacancyIdId", target = "vacancyId")
    AtJobApplications toEntity(AtJobApplicationsDTO atJobApplicationsDTO);

    default AtJobApplications fromId(Long id) {
        if (id == null) {
            return null;
        }
        AtJobApplications atJobApplications = new AtJobApplications();
        atJobApplications.setId(id);
        return atJobApplications;
    }
}
