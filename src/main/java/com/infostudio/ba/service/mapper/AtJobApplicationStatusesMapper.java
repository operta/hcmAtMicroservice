package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.AtJobApplicationStatusesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AtJobApplicationStatuses and its DTO AtJobApplicationStatusesDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AtJobApplicationStatusesMapper extends EntityMapper<AtJobApplicationStatusesDTO, AtJobApplicationStatuses> {



    default AtJobApplicationStatuses fromId(Long id) {
        if (id == null) {
            return null;
        }
        AtJobApplicationStatuses atJobApplicationStatuses = new AtJobApplicationStatuses();
        atJobApplicationStatuses.setId(id);
        return atJobApplicationStatuses;
    }
}
