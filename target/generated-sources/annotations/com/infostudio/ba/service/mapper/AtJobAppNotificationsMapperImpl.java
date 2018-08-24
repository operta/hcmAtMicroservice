package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.AtJobAppNotifications;
import com.infostudio.ba.domain.AtJobApplications;
import com.infostudio.ba.domain.AtNotificationTemplates;
import com.infostudio.ba.service.dto.AtJobAppNotificationsDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-08-24T10:12:57+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class AtJobAppNotificationsMapperImpl implements AtJobAppNotificationsMapper {

    @Autowired
    private AtJobApplicationsMapper atJobApplicationsMapper;
    @Autowired
    private AtNotificationTemplatesMapper atNotificationTemplatesMapper;

    @Override
    public List<AtJobAppNotifications> toEntity(List<AtJobAppNotificationsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AtJobAppNotifications> list = new ArrayList<AtJobAppNotifications>( dtoList.size() );
        for ( AtJobAppNotificationsDTO atJobAppNotificationsDTO : dtoList ) {
            list.add( toEntity( atJobAppNotificationsDTO ) );
        }

        return list;
    }

    @Override
    public List<AtJobAppNotificationsDTO> toDto(List<AtJobAppNotifications> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AtJobAppNotificationsDTO> list = new ArrayList<AtJobAppNotificationsDTO>( entityList.size() );
        for ( AtJobAppNotifications atJobAppNotifications : entityList ) {
            list.add( toDto( atJobAppNotifications ) );
        }

        return list;
    }

    @Override
    public AtJobAppNotificationsDTO toDto(AtJobAppNotifications atJobAppNotifications) {
        if ( atJobAppNotifications == null ) {
            return null;
        }

        AtJobAppNotificationsDTO atJobAppNotificationsDTO = new AtJobAppNotificationsDTO();

        Long id = atJobAppNotificationsIdJobApplicationId( atJobAppNotifications );
        if ( id != null ) {
            atJobAppNotificationsDTO.setIdJobApplicationId( id );
        }
        Long id1 = atJobAppNotificationsIdNotificationId( atJobAppNotifications );
        if ( id1 != null ) {
            atJobAppNotificationsDTO.setIdNotificationId( id1 );
        }
        atJobAppNotificationsDTO.setCreatedBy( atJobAppNotifications.getCreatedBy() );
        atJobAppNotificationsDTO.setCreatedAt( atJobAppNotifications.getcreatedAt() );
        atJobAppNotificationsDTO.setUpdatedBy( atJobAppNotifications.getupdatedBy() );
        atJobAppNotificationsDTO.setUpdatedAt( atJobAppNotifications.getupdatedAt() );
        atJobAppNotificationsDTO.setId( atJobAppNotifications.getId() );
        atJobAppNotificationsDTO.setDateSent( atJobAppNotifications.getDateSent() );
        atJobAppNotificationsDTO.setIsActive( atJobAppNotifications.getIsActive() );

        return atJobAppNotificationsDTO;
    }

    @Override
    public AtJobAppNotifications toEntity(AtJobAppNotificationsDTO atJobAppNotificationsDTO) {
        if ( atJobAppNotificationsDTO == null ) {
            return null;
        }

        AtJobAppNotifications atJobAppNotifications = new AtJobAppNotifications();

        atJobAppNotifications.setIdJobApplication( atJobApplicationsMapper.fromId( atJobAppNotificationsDTO.getIdJobApplicationId() ) );
        atJobAppNotifications.setIdNotification( atNotificationTemplatesMapper.fromId( atJobAppNotificationsDTO.getIdNotificationId() ) );
        atJobAppNotifications.setCreatedBy( atJobAppNotificationsDTO.getCreatedBy() );
        atJobAppNotifications.setcreatedAt( atJobAppNotificationsDTO.getCreatedAt() );
        atJobAppNotifications.setupdatedBy( atJobAppNotificationsDTO.getUpdatedBy() );
        atJobAppNotifications.setupdatedAt( atJobAppNotificationsDTO.getUpdatedAt() );
        atJobAppNotifications.setId( atJobAppNotificationsDTO.getId() );
        atJobAppNotifications.setDateSent( atJobAppNotificationsDTO.getDateSent() );
        atJobAppNotifications.setIsActive( atJobAppNotificationsDTO.getIsActive() );

        return atJobAppNotifications;
    }

    private Long atJobAppNotificationsIdJobApplicationId(AtJobAppNotifications atJobAppNotifications) {
        if ( atJobAppNotifications == null ) {
            return null;
        }
        AtJobApplications idJobApplication = atJobAppNotifications.getIdJobApplication();
        if ( idJobApplication == null ) {
            return null;
        }
        Long id = idJobApplication.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long atJobAppNotificationsIdNotificationId(AtJobAppNotifications atJobAppNotifications) {
        if ( atJobAppNotifications == null ) {
            return null;
        }
        AtNotificationTemplates idNotification = atJobAppNotifications.getIdNotification();
        if ( idNotification == null ) {
            return null;
        }
        Long id = idNotification.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
