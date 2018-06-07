package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.AtActivityStatusesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AtActivityStatuses and its DTO AtActivityStatusesDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AtActivityStatusesMapper extends EntityMapper<AtActivityStatusesDTO, AtActivityStatuses> {



    default AtActivityStatuses fromId(Long id) {
        if (id == null) {
            return null;
        }
        AtActivityStatuses atActivityStatuses = new AtActivityStatuses();
        atActivityStatuses.setId(id);
        return atActivityStatuses;
    }
}
