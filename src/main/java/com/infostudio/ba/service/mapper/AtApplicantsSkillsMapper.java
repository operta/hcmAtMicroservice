package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.AtApplicantsSkillsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AtApplicantsSkills and its DTO AtApplicantsSkillsDTO.
 */
@Mapper(componentModel = "spring", uses = {AtApplicantsMapper.class})
public interface AtApplicantsSkillsMapper extends EntityMapper<AtApplicantsSkillsDTO, AtApplicantsSkills> {

    @Mapping(source = "idApplicant.id", target = "idApplicantId")
    @Mapping(source = "idApplicant.surname", target = "idApplicantSurname")
    AtApplicantsSkillsDTO toDto(AtApplicantsSkills atApplicantsSkills);

    @Mapping(source = "idApplicantId", target = "idApplicant")
    AtApplicantsSkills toEntity(AtApplicantsSkillsDTO atApplicantsSkillsDTO);

    default AtApplicantsSkills fromId(Long id) {
        if (id == null) {
            return null;
        }
        AtApplicantsSkills atApplicantsSkills = new AtApplicantsSkills();
        atApplicantsSkills.setId(id);
        return atApplicantsSkills;
    }
}
