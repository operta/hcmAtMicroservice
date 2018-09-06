package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.AtJobApplicantHistory;
import com.infostudio.ba.domain.AtJobApplicationStatuses;
import com.infostudio.ba.domain.AtJobApplications;
import com.infostudio.ba.service.dto.AtJobApplicantHistoryDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-06T15:49:14+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class AtJobApplicantHistoryMapperImpl implements AtJobApplicantHistoryMapper {

    @Autowired
    private AtJobApplicationStatusesMapper atJobApplicationStatusesMapper;
    @Autowired
    private AtJobApplicationsMapper atJobApplicationsMapper;

    @Override
    public List<AtJobApplicantHistory> toEntity(List<AtJobApplicantHistoryDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AtJobApplicantHistory> list = new ArrayList<AtJobApplicantHistory>( dtoList.size() );
        for ( AtJobApplicantHistoryDTO atJobApplicantHistoryDTO : dtoList ) {
            list.add( toEntity( atJobApplicantHistoryDTO ) );
        }

        return list;
    }

    @Override
    public List<AtJobApplicantHistoryDTO> toDto(List<AtJobApplicantHistory> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AtJobApplicantHistoryDTO> list = new ArrayList<AtJobApplicantHistoryDTO>( entityList.size() );
        for ( AtJobApplicantHistory atJobApplicantHistory : entityList ) {
            list.add( toDto( atJobApplicantHistory ) );
        }

        return list;
    }

    @Override
    public AtJobApplicantHistoryDTO toDto(AtJobApplicantHistory atJobApplicantHistory) {
        if ( atJobApplicantHistory == null ) {
            return null;
        }

        AtJobApplicantHistoryDTO atJobApplicantHistoryDTO = new AtJobApplicantHistoryDTO();

        Long id = atJobApplicantHistoryIdStatusFromId( atJobApplicantHistory );
        if ( id != null ) {
            atJobApplicantHistoryDTO.setIdStatusFromId( id );
        }
        String name = atJobApplicantHistoryIdStatusFromName( atJobApplicantHistory );
        if ( name != null ) {
            atJobApplicantHistoryDTO.setIdStatusFromName( name );
        }
        Long id1 = atJobApplicantHistoryIdJobApplicationId( atJobApplicantHistory );
        if ( id1 != null ) {
            atJobApplicantHistoryDTO.setIdJobApplicationId( id1 );
        }
        String name1 = atJobApplicantHistoryIdStatusToName( atJobApplicantHistory );
        if ( name1 != null ) {
            atJobApplicantHistoryDTO.setIdStatusToName( name1 );
        }
        Long id2 = atJobApplicantHistoryIdStatusToId( atJobApplicantHistory );
        if ( id2 != null ) {
            atJobApplicantHistoryDTO.setIdStatusToId( id2 );
        }
        atJobApplicantHistoryDTO.setCreatedBy( atJobApplicantHistory.getCreatedBy() );
        atJobApplicantHistoryDTO.setCreatedAt( atJobApplicantHistory.getcreatedAt() );
        atJobApplicantHistoryDTO.setUpdatedBy( atJobApplicantHistory.getupdatedBy() );
        atJobApplicantHistoryDTO.setUpdatedAt( atJobApplicantHistory.getupdatedAt() );
        atJobApplicantHistoryDTO.setId( atJobApplicantHistory.getId() );

        return atJobApplicantHistoryDTO;
    }

    @Override
    public AtJobApplicantHistory toEntity(AtJobApplicantHistoryDTO atJobApplicantHistoryDTO) {
        if ( atJobApplicantHistoryDTO == null ) {
            return null;
        }

        AtJobApplicantHistory atJobApplicantHistory = new AtJobApplicantHistory();

        atJobApplicantHistory.setIdStatusFrom( atJobApplicationStatusesMapper.fromId( atJobApplicantHistoryDTO.getIdStatusFromId() ) );
        atJobApplicantHistory.setIdJobApplication( atJobApplicationsMapper.fromId( atJobApplicantHistoryDTO.getIdJobApplicationId() ) );
        atJobApplicantHistory.setIdStatusTo( atJobApplicationStatusesMapper.fromId( atJobApplicantHistoryDTO.getIdStatusToId() ) );
        atJobApplicantHistory.setCreatedBy( atJobApplicantHistoryDTO.getCreatedBy() );
        atJobApplicantHistory.setcreatedAt( atJobApplicantHistoryDTO.getCreatedAt() );
        atJobApplicantHistory.setupdatedBy( atJobApplicantHistoryDTO.getUpdatedBy() );
        atJobApplicantHistory.setupdatedAt( atJobApplicantHistoryDTO.getUpdatedAt() );
        atJobApplicantHistory.setId( atJobApplicantHistoryDTO.getId() );

        return atJobApplicantHistory;
    }

    private Long atJobApplicantHistoryIdStatusFromId(AtJobApplicantHistory atJobApplicantHistory) {
        if ( atJobApplicantHistory == null ) {
            return null;
        }
        AtJobApplicationStatuses idStatusFrom = atJobApplicantHistory.getIdStatusFrom();
        if ( idStatusFrom == null ) {
            return null;
        }
        Long id = idStatusFrom.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String atJobApplicantHistoryIdStatusFromName(AtJobApplicantHistory atJobApplicantHistory) {
        if ( atJobApplicantHistory == null ) {
            return null;
        }
        AtJobApplicationStatuses idStatusFrom = atJobApplicantHistory.getIdStatusFrom();
        if ( idStatusFrom == null ) {
            return null;
        }
        String name = idStatusFrom.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long atJobApplicantHistoryIdJobApplicationId(AtJobApplicantHistory atJobApplicantHistory) {
        if ( atJobApplicantHistory == null ) {
            return null;
        }
        AtJobApplications idJobApplication = atJobApplicantHistory.getIdJobApplication();
        if ( idJobApplication == null ) {
            return null;
        }
        Long id = idJobApplication.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String atJobApplicantHistoryIdStatusToName(AtJobApplicantHistory atJobApplicantHistory) {
        if ( atJobApplicantHistory == null ) {
            return null;
        }
        AtJobApplicationStatuses idStatusTo = atJobApplicantHistory.getIdStatusTo();
        if ( idStatusTo == null ) {
            return null;
        }
        String name = idStatusTo.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long atJobApplicantHistoryIdStatusToId(AtJobApplicantHistory atJobApplicantHistory) {
        if ( atJobApplicantHistory == null ) {
            return null;
        }
        AtJobApplicationStatuses idStatusTo = atJobApplicantHistory.getIdStatusTo();
        if ( idStatusTo == null ) {
            return null;
        }
        Long id = idStatusTo.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
