package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.AtApplicantsDocumentsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AtApplicantsDocuments and its DTO AtApplicantsDocumentsDTO.
 */
@Mapper(componentModel = "spring", uses = {AtApplicantsMapper.class})
public interface AtApplicantsDocumentsMapper extends EntityMapper<AtApplicantsDocumentsDTO, AtApplicantsDocuments> {

    @Mapping(source = "idApplicant.id", target = "idApplicantId")
    @Mapping(source = "idApplicant.surname", target = "idApplicantSurname")
    AtApplicantsDocumentsDTO toDto(AtApplicantsDocuments atApplicantsDocuments);

    @Mapping(source = "idApplicantId", target = "idApplicant")
    AtApplicantsDocuments toEntity(AtApplicantsDocumentsDTO atApplicantsDocumentsDTO);

    default AtApplicantsDocuments fromId(Long id) {
        if (id == null) {
            return null;
        }
        AtApplicantsDocuments atApplicantsDocuments = new AtApplicantsDocuments();
        atApplicantsDocuments.setId(id);
        return atApplicantsDocuments;
    }
}
