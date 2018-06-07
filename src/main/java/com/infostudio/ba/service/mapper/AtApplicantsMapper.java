package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.AtApplicantsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AtApplicants and its DTO AtApplicantsDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AtApplicantsMapper extends EntityMapper<AtApplicantsDTO, AtApplicants> {



    default AtApplicants fromId(Long id) {
        if (id == null) {
            return null;
        }
        AtApplicants atApplicants = new AtApplicants();
        atApplicants.setId(id);
        return atApplicants;
    }
}
