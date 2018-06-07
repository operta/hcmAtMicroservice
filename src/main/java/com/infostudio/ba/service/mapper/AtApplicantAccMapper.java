package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.AtApplicantAccDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AtApplicantAcc and its DTO AtApplicantAccDTO.
 */
@Mapper(componentModel = "spring", uses = {AtAccomplishmentTypesMapper.class, AtApplicantsMapper.class})
public interface AtApplicantAccMapper extends EntityMapper<AtApplicantAccDTO, AtApplicantAcc> {

    @Mapping(source = "idAccomplishmentType.id", target = "idAccomplishmentTypeId")
    @Mapping(source = "idAccomplishmentType.name", target = "idAccomplishmentTypeName")
    @Mapping(source = "idApplicant.id", target = "idApplicantId")
    @Mapping(source = "idApplicant.surname", target = "idApplicantSurname")
    AtApplicantAccDTO toDto(AtApplicantAcc atApplicantAcc);

    @Mapping(source = "idAccomplishmentTypeId", target = "idAccomplishmentType")
    @Mapping(source = "idApplicantId", target = "idApplicant")
    AtApplicantAcc toEntity(AtApplicantAccDTO atApplicantAccDTO);

    default AtApplicantAcc fromId(Long id) {
        if (id == null) {
            return null;
        }
        AtApplicantAcc atApplicantAcc = new AtApplicantAcc();
        atApplicantAcc.setId(id);
        return atApplicantAcc;
    }
}
