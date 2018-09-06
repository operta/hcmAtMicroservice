package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.AtJobApplicationStatuses;
import com.infostudio.ba.service.dto.AtJobApplicationStatusesDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-06T15:12:45+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class AtJobApplicationStatusesMapperImpl implements AtJobApplicationStatusesMapper {

    @Override
    public AtJobApplicationStatuses toEntity(AtJobApplicationStatusesDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AtJobApplicationStatuses atJobApplicationStatuses = new AtJobApplicationStatuses();

        atJobApplicationStatuses.setCreatedBy( dto.getCreatedBy() );
        atJobApplicationStatuses.setcreatedAt( dto.getCreatedAt() );
        atJobApplicationStatuses.setupdatedBy( dto.getUpdatedBy() );
        atJobApplicationStatuses.setupdatedAt( dto.getUpdatedAt() );
        atJobApplicationStatuses.setId( dto.getId() );
        atJobApplicationStatuses.setCode( dto.getCode() );
        atJobApplicationStatuses.setName( dto.getName() );
        atJobApplicationStatuses.setDescription( dto.getDescription() );

        return atJobApplicationStatuses;
    }

    @Override
    public AtJobApplicationStatusesDTO toDto(AtJobApplicationStatuses entity) {
        if ( entity == null ) {
            return null;
        }

        AtJobApplicationStatusesDTO atJobApplicationStatusesDTO = new AtJobApplicationStatusesDTO();

        atJobApplicationStatusesDTO.setCreatedBy( entity.getCreatedBy() );
        atJobApplicationStatusesDTO.setCreatedAt( entity.getcreatedAt() );
        atJobApplicationStatusesDTO.setUpdatedBy( entity.getupdatedBy() );
        atJobApplicationStatusesDTO.setUpdatedAt( entity.getupdatedAt() );
        atJobApplicationStatusesDTO.setId( entity.getId() );
        atJobApplicationStatusesDTO.setCode( entity.getCode() );
        atJobApplicationStatusesDTO.setName( entity.getName() );
        atJobApplicationStatusesDTO.setDescription( entity.getDescription() );

        return atJobApplicationStatusesDTO;
    }

    @Override
    public List<AtJobApplicationStatuses> toEntity(List<AtJobApplicationStatusesDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AtJobApplicationStatuses> list = new ArrayList<AtJobApplicationStatuses>( dtoList.size() );
        for ( AtJobApplicationStatusesDTO atJobApplicationStatusesDTO : dtoList ) {
            list.add( toEntity( atJobApplicationStatusesDTO ) );
        }

        return list;
    }

    @Override
    public List<AtJobApplicationStatusesDTO> toDto(List<AtJobApplicationStatuses> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AtJobApplicationStatusesDTO> list = new ArrayList<AtJobApplicationStatusesDTO>( entityList.size() );
        for ( AtJobApplicationStatuses atJobApplicationStatuses : entityList ) {
            list.add( toDto( atJobApplicationStatuses ) );
        }

        return list;
    }
}
