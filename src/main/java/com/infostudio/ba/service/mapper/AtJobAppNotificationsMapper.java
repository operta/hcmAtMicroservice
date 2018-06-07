package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.AtJobAppNotificationsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AtJobAppNotifications and its DTO AtJobAppNotificationsDTO.
 */
@Mapper(componentModel = "spring", uses = {AtJobApplicationsMapper.class, AtNotificationTemplatesMapper.class})
public interface AtJobAppNotificationsMapper extends EntityMapper<AtJobAppNotificationsDTO, AtJobAppNotifications> {

    @Mapping(source = "idJobApplication.id", target = "idJobApplicationId")
    @Mapping(source = "idNotification.id", target = "idNotificationId")
    AtJobAppNotificationsDTO toDto(AtJobAppNotifications atJobAppNotifications);

    @Mapping(source = "idJobApplicationId", target = "idJobApplication")
    @Mapping(source = "idNotificationId", target = "idNotification")
    AtJobAppNotifications toEntity(AtJobAppNotificationsDTO atJobAppNotificationsDTO);

    default AtJobAppNotifications fromId(Long id) {
        if (id == null) {
            return null;
        }
        AtJobAppNotifications atJobAppNotifications = new AtJobAppNotifications();
        atJobAppNotifications.setId(id);
        return atJobAppNotifications;
    }
}
