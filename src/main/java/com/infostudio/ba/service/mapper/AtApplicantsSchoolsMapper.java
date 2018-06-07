package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.AtApplicantsSchoolsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AtApplicantsSchools and its DTO AtApplicantsSchoolsDTO.
 */
@Mapper(componentModel = "spring", uses = {AtApplicantsMapper.class})
public interface AtApplicantsSchoolsMapper extends EntityMapper<AtApplicantsSchoolsDTO, AtApplicantsSchools> {

    @Mapping(source = "idApplicant.id", target = "idApplicantId")
    @Mapping(source = "idApplicant.surname", target = "idApplicantSurname")
    AtApplicantsSchoolsDTO toDto(AtApplicantsSchools atApplicantsSchools);

    @Mapping(source = "idApplicantId", target = "idApplicant")
    AtApplicantsSchools toEntity(AtApplicantsSchoolsDTO atApplicantsSchoolsDTO);

    default AtApplicantsSchools fromId(Long id) {
        if (id == null) {
            return null;
        }
        AtApplicantsSchools atApplicantsSchools = new AtApplicantsSchools();
        atApplicantsSchools.setId(id);
        return atApplicantsSchools;
    }
}
