package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.AtNotificationTemplatesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AtNotificationTemplates and its DTO AtNotificationTemplatesDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AtNotificationTemplatesMapper extends EntityMapper<AtNotificationTemplatesDTO, AtNotificationTemplates> {



    default AtNotificationTemplates fromId(Long id) {
        if (id == null) {
            return null;
        }
        AtNotificationTemplates atNotificationTemplates = new AtNotificationTemplates();
        atNotificationTemplates.setId(id);
        return atNotificationTemplates;
    }
}
