package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.AtVacanciesStatuses;
import com.infostudio.ba.service.dto.AtVacanciesStatusesDTO;
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
public class AtVacanciesStatusesMapperImpl implements AtVacanciesStatusesMapper {

    @Override
    public AtVacanciesStatuses toEntity(AtVacanciesStatusesDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AtVacanciesStatuses atVacanciesStatuses = new AtVacanciesStatuses();

        atVacanciesStatuses.setCreatedBy( dto.getCreatedBy() );
        atVacanciesStatuses.setcreatedAt( dto.getCreatedAt() );
        atVacanciesStatuses.setupdatedBy( dto.getUpdatedBy() );
        atVacanciesStatuses.setupdatedAt( dto.getUpdatedAt() );
        atVacanciesStatuses.setId( dto.getId() );
        atVacanciesStatuses.setStatus( dto.getStatus() );

        return atVacanciesStatuses;
    }

    @Override
    public AtVacanciesStatusesDTO toDto(AtVacanciesStatuses entity) {
        if ( entity == null ) {
            return null;
        }

        AtVacanciesStatusesDTO atVacanciesStatusesDTO = new AtVacanciesStatusesDTO();

        atVacanciesStatusesDTO.setCreatedBy( entity.getCreatedBy() );
        atVacanciesStatusesDTO.setCreatedAt( entity.getcreatedAt() );
        atVacanciesStatusesDTO.setUpdatedBy( entity.getupdatedBy() );
        atVacanciesStatusesDTO.setUpdatedAt( entity.getupdatedAt() );
        atVacanciesStatusesDTO.setId( entity.getId() );
        atVacanciesStatusesDTO.setStatus( entity.getStatus() );

        return atVacanciesStatusesDTO;
    }

    @Override
    public List<AtVacanciesStatuses> toEntity(List<AtVacanciesStatusesDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AtVacanciesStatuses> list = new ArrayList<AtVacanciesStatuses>( dtoList.size() );
        for ( AtVacanciesStatusesDTO atVacanciesStatusesDTO : dtoList ) {
            list.add( toEntity( atVacanciesStatusesDTO ) );
        }

        return list;
    }

    @Override
    public List<AtVacanciesStatusesDTO> toDto(List<AtVacanciesStatuses> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AtVacanciesStatusesDTO> list = new ArrayList<AtVacanciesStatusesDTO>( entityList.size() );
        for ( AtVacanciesStatuses atVacanciesStatuses : entityList ) {
            list.add( toDto( atVacanciesStatuses ) );
        }

        return list;
    }
}
