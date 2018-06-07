package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.AtApplicantsContactsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AtApplicantsContacts and its DTO AtApplicantsContactsDTO.
 */
@Mapper(componentModel = "spring", uses = {AtApplicantsMapper.class})
public interface AtApplicantsContactsMapper extends EntityMapper<AtApplicantsContactsDTO, AtApplicantsContacts> {

    @Mapping(source = "idApllicant.id", target = "idApllicantId")
    @Mapping(source = "idApllicant.surname", target = "idApllicantSurname")
    AtApplicantsContactsDTO toDto(AtApplicantsContacts atApplicantsContacts);

    @Mapping(source = "idApllicantId", target = "idApllicant")
    AtApplicantsContacts toEntity(AtApplicantsContactsDTO atApplicantsContactsDTO);

    default AtApplicantsContacts fromId(Long id) {
        if (id == null) {
            return null;
        }
        AtApplicantsContacts atApplicantsContacts = new AtApplicantsContacts();
        atApplicantsContacts.setId(id);
        return atApplicantsContacts;
    }
}
