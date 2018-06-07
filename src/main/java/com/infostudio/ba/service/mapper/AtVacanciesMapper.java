package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.AtVacanciesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AtVacancies and its DTO AtVacanciesDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AtVacanciesMapper extends EntityMapper<AtVacanciesDTO, AtVacancies> {



    default AtVacancies fromId(Long id) {
        if (id == null) {
            return null;
        }
        AtVacancies atVacancies = new AtVacancies();
        atVacancies.setId(id);
        return atVacancies;
    }
}
