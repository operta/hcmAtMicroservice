package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.AtVacanciesStatusesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AtVacanciesStatuses and its DTO AtVacanciesStatusesDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AtVacanciesStatusesMapper extends EntityMapper<AtVacanciesStatusesDTO, AtVacanciesStatuses> {



    default AtVacanciesStatuses fromId(Long id) {
        if (id == null) {
            return null;
        }
        AtVacanciesStatuses atVacanciesStatuses = new AtVacanciesStatuses();
        atVacanciesStatuses.setId(id);
        return atVacanciesStatuses;
    }
}
