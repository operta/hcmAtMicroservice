package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.AtVacanciesSkillsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AtVacanciesSkills and its DTO AtVacanciesSkillsDTO.
 */
@Mapper(componentModel = "spring", uses = {AtVacanciesMapper.class})
public interface AtVacanciesSkillsMapper extends EntityMapper<AtVacanciesSkillsDTO, AtVacanciesSkills> {

    @Mapping(source = "vacancyId.id", target = "vacancyIdId")
    @Mapping(source = "vacancyId.name", target = "vacancyIdName")
    AtVacanciesSkillsDTO toDto(AtVacanciesSkills atVacanciesSkills);

    @Mapping(source = "vacancyIdId", target = "vacancyId")
    AtVacanciesSkills toEntity(AtVacanciesSkillsDTO atVacanciesSkillsDTO);

    default AtVacanciesSkills fromId(Long id) {
        if (id == null) {
            return null;
        }
        AtVacanciesSkills atVacanciesSkills = new AtVacanciesSkills();
        atVacanciesSkills.setId(id);
        return atVacanciesSkills;
    }
}
