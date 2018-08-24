package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.AtNotificationTemplates;
import com.infostudio.ba.service.dto.AtNotificationTemplatesDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-08-24T10:12:57+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class AtNotificationTemplatesMapperImpl implements AtNotificationTemplatesMapper {

    @Override
    public AtNotificationTemplates toEntity(AtNotificationTemplatesDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AtNotificationTemplates atNotificationTemplates = new AtNotificationTemplates();

        atNotificationTemplates.setCreatedBy( dto.getCreatedBy() );
        atNotificationTemplates.setcreatedAt( dto.getCreatedAt() );
        atNotificationTemplates.setupdatedBy( dto.getUpdatedBy() );
        atNotificationTemplates.setupdatedAt( dto.getUpdatedAt() );
        atNotificationTemplates.setId( dto.getId() );
        atNotificationTemplates.setCode( dto.getCode() );
        atNotificationTemplates.setSubject( dto.getSubject() );
        atNotificationTemplates.setTemplate( dto.getTemplate() );

        return atNotificationTemplates;
    }

    @Override
    public AtNotificationTemplatesDTO toDto(AtNotificationTemplates entity) {
        if ( entity == null ) {
            return null;
        }

        AtNotificationTemplatesDTO atNotificationTemplatesDTO = new AtNotificationTemplatesDTO();

        atNotificationTemplatesDTO.setCreatedBy( entity.getCreatedBy() );
        atNotificationTemplatesDTO.setCreatedAt( entity.getcreatedAt() );
        atNotificationTemplatesDTO.setUpdatedBy( entity.getupdatedBy() );
        atNotificationTemplatesDTO.setUpdatedAt( entity.getupdatedAt() );
        atNotificationTemplatesDTO.setId( entity.getId() );
        atNotificationTemplatesDTO.setCode( entity.getCode() );
        atNotificationTemplatesDTO.setSubject( entity.getSubject() );
        atNotificationTemplatesDTO.setTemplate( entity.getTemplate() );

        return atNotificationTemplatesDTO;
    }

    @Override
    public List<AtNotificationTemplates> toEntity(List<AtNotificationTemplatesDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AtNotificationTemplates> list = new ArrayList<AtNotificationTemplates>( dtoList.size() );
        for ( AtNotificationTemplatesDTO atNotificationTemplatesDTO : dtoList ) {
            list.add( toEntity( atNotificationTemplatesDTO ) );
        }

        return list;
    }

    @Override
    public List<AtNotificationTemplatesDTO> toDto(List<AtNotificationTemplates> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AtNotificationTemplatesDTO> list = new ArrayList<AtNotificationTemplatesDTO>( entityList.size() );
        for ( AtNotificationTemplates atNotificationTemplates : entityList ) {
            list.add( toDto( atNotificationTemplates ) );
        }

        return list;
    }
}
