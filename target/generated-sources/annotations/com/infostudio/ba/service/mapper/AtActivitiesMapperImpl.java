package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.AtActivities;
import com.infostudio.ba.service.dto.AtActivitiesDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-08-24T09:35:30+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class AtActivitiesMapperImpl implements AtActivitiesMapper {

    @Override
    public AtActivities toEntity(AtActivitiesDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AtActivities atActivities = new AtActivities();

        atActivities.setCreatedBy( dto.getCreatedBy() );
        atActivities.setcreatedAt( dto.getCreatedAt() );
        atActivities.setupdatedBy( dto.getUpdatedBy() );
        atActivities.setupdatedAt( dto.getUpdatedAt() );
        atActivities.setId( dto.getId() );
        atActivities.setCode( dto.getCode() );
        atActivities.setName( dto.getName() );
        atActivities.setDescription( dto.getDescription() );

        return atActivities;
    }

    @Override
    public AtActivitiesDTO toDto(AtActivities entity) {
        if ( entity == null ) {
            return null;
        }

        AtActivitiesDTO atActivitiesDTO = new AtActivitiesDTO();

        atActivitiesDTO.setCreatedBy( entity.getCreatedBy() );
        atActivitiesDTO.setCreatedAt( entity.getcreatedAt() );
        atActivitiesDTO.setUpdatedBy( entity.getupdatedBy() );
        atActivitiesDTO.setUpdatedAt( entity.getupdatedAt() );
        atActivitiesDTO.setId( entity.getId() );
        atActivitiesDTO.setCode( entity.getCode() );
        atActivitiesDTO.setName( entity.getName() );
        atActivitiesDTO.setDescription( entity.getDescription() );

        return atActivitiesDTO;
    }

    @Override
    public List<AtActivities> toEntity(List<AtActivitiesDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AtActivities> list = new ArrayList<AtActivities>( dtoList.size() );
        for ( AtActivitiesDTO atActivitiesDTO : dtoList ) {
            list.add( toEntity( atActivitiesDTO ) );
        }

        return list;
    }

    @Override
    public List<AtActivitiesDTO> toDto(List<AtActivities> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AtActivitiesDTO> list = new ArrayList<AtActivitiesDTO>( entityList.size() );
        for ( AtActivities atActivities : entityList ) {
            list.add( toDto( atActivities ) );
        }

        return list;
    }
}
