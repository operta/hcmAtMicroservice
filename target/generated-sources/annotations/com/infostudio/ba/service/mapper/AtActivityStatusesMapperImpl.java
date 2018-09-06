package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.AtActivityStatuses;
import com.infostudio.ba.service.dto.AtActivityStatusesDTO;
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
public class AtActivityStatusesMapperImpl implements AtActivityStatusesMapper {

    @Override
    public AtActivityStatuses toEntity(AtActivityStatusesDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AtActivityStatuses atActivityStatuses = new AtActivityStatuses();

        atActivityStatuses.setCreatedBy( dto.getCreatedBy() );
        atActivityStatuses.setcreatedAt( dto.getCreatedAt() );
        atActivityStatuses.setupdatedBy( dto.getUpdatedBy() );
        atActivityStatuses.setupdatedAt( dto.getUpdatedAt() );
        atActivityStatuses.setId( dto.getId() );
        atActivityStatuses.setCode( dto.getCode() );
        atActivityStatuses.setName( dto.getName() );
        atActivityStatuses.setDescription( dto.getDescription() );

        return atActivityStatuses;
    }

    @Override
    public AtActivityStatusesDTO toDto(AtActivityStatuses entity) {
        if ( entity == null ) {
            return null;
        }

        AtActivityStatusesDTO atActivityStatusesDTO = new AtActivityStatusesDTO();

        atActivityStatusesDTO.setCreatedBy( entity.getCreatedBy() );
        atActivityStatusesDTO.setCreatedAt( entity.getcreatedAt() );
        atActivityStatusesDTO.setUpdatedBy( entity.getupdatedBy() );
        atActivityStatusesDTO.setUpdatedAt( entity.getupdatedAt() );
        atActivityStatusesDTO.setId( entity.getId() );
        atActivityStatusesDTO.setCode( entity.getCode() );
        atActivityStatusesDTO.setName( entity.getName() );
        atActivityStatusesDTO.setDescription( entity.getDescription() );

        return atActivityStatusesDTO;
    }

    @Override
    public List<AtActivityStatuses> toEntity(List<AtActivityStatusesDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AtActivityStatuses> list = new ArrayList<AtActivityStatuses>( dtoList.size() );
        for ( AtActivityStatusesDTO atActivityStatusesDTO : dtoList ) {
            list.add( toEntity( atActivityStatusesDTO ) );
        }

        return list;
    }

    @Override
    public List<AtActivityStatusesDTO> toDto(List<AtActivityStatuses> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AtActivityStatusesDTO> list = new ArrayList<AtActivityStatusesDTO>( entityList.size() );
        for ( AtActivityStatuses atActivityStatuses : entityList ) {
            list.add( toDto( atActivityStatuses ) );
        }

        return list;
    }
}
