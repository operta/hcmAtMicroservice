package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.AtActivities;
import com.infostudio.ba.domain.AtActivityStatuses;
import com.infostudio.ba.domain.AtJAActivities;
import com.infostudio.ba.domain.AtJobApplications;
import com.infostudio.ba.service.dto.AtJAActivitiesDTO;
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
public class AtJAActivitiesMapperImpl implements AtJAActivitiesMapper {

    @Autowired
    private AtActivitiesMapper atActivitiesMapper;
    @Autowired
    private AtJobApplicationsMapper atJobApplicationsMapper;
    @Autowired
    private AtActivityStatusesMapper atActivityStatusesMapper;

    @Override
    public List<AtJAActivities> toEntity(List<AtJAActivitiesDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AtJAActivities> list = new ArrayList<AtJAActivities>( dtoList.size() );
        for ( AtJAActivitiesDTO atJAActivitiesDTO : dtoList ) {
            list.add( toEntity( atJAActivitiesDTO ) );
        }

        return list;
    }

    @Override
    public List<AtJAActivitiesDTO> toDto(List<AtJAActivities> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AtJAActivitiesDTO> list = new ArrayList<AtJAActivitiesDTO>( entityList.size() );
        for ( AtJAActivities atJAActivities : entityList ) {
            list.add( toDto( atJAActivities ) );
        }

        return list;
    }

    @Override
    public AtJAActivitiesDTO toDto(AtJAActivities atJAActivities) {
        if ( atJAActivities == null ) {
            return null;
        }

        AtJAActivitiesDTO atJAActivitiesDTO = new AtJAActivitiesDTO();

        String name = atJAActivitiesIdActivityName( atJAActivities );
        if ( name != null ) {
            atJAActivitiesDTO.setIdActivityName( name );
        }
        String name1 = atJAActivitiesIdStatusName( atJAActivities );
        if ( name1 != null ) {
            atJAActivitiesDTO.setIdStatusName( name1 );
        }
        Long id = atJAActivitiesIdActivityId( atJAActivities );
        if ( id != null ) {
            atJAActivitiesDTO.setIdActivityId( id );
        }
        Long id1 = atJAActivitiesIdJobApplicationId( atJAActivities );
        if ( id1 != null ) {
            atJAActivitiesDTO.setIdJobApplicationId( id1 );
        }
        Long id2 = atJAActivitiesIdStatusId( atJAActivities );
        if ( id2 != null ) {
            atJAActivitiesDTO.setIdStatusId( id2 );
        }
        atJAActivitiesDTO.setCreatedBy( atJAActivities.getCreatedBy() );
        atJAActivitiesDTO.setCreatedAt( atJAActivities.getcreatedAt() );
        atJAActivitiesDTO.setUpdatedBy( atJAActivities.getupdatedBy() );
        atJAActivitiesDTO.setUpdatedAt( atJAActivities.getupdatedAt() );
        atJAActivitiesDTO.setId( atJAActivities.getId() );
        atJAActivitiesDTO.setGrade( atJAActivities.getGrade() );
        atJAActivitiesDTO.setReview( atJAActivities.getReview() );
        atJAActivitiesDTO.setDateActivity( atJAActivities.getDateActivity() );

        return atJAActivitiesDTO;
    }

    @Override
    public AtJAActivities toEntity(AtJAActivitiesDTO atJAActivitiesDTO) {
        if ( atJAActivitiesDTO == null ) {
            return null;
        }

        AtJAActivities atJAActivities = new AtJAActivities();

        atJAActivities.setIdStatus( atActivityStatusesMapper.fromId( atJAActivitiesDTO.getIdStatusId() ) );
        atJAActivities.setIdJobApplication( atJobApplicationsMapper.fromId( atJAActivitiesDTO.getIdJobApplicationId() ) );
        atJAActivities.setIdActivity( atActivitiesMapper.fromId( atJAActivitiesDTO.getIdActivityId() ) );
        atJAActivities.setCreatedBy( atJAActivitiesDTO.getCreatedBy() );
        atJAActivities.setcreatedAt( atJAActivitiesDTO.getCreatedAt() );
        atJAActivities.setupdatedBy( atJAActivitiesDTO.getUpdatedBy() );
        atJAActivities.setupdatedAt( atJAActivitiesDTO.getUpdatedAt() );
        atJAActivities.setId( atJAActivitiesDTO.getId() );
        atJAActivities.setGrade( atJAActivitiesDTO.getGrade() );
        atJAActivities.setReview( atJAActivitiesDTO.getReview() );
        atJAActivities.setDateActivity( atJAActivitiesDTO.getDateActivity() );

        return atJAActivities;
    }

    private String atJAActivitiesIdActivityName(AtJAActivities atJAActivities) {
        if ( atJAActivities == null ) {
            return null;
        }
        AtActivities idActivity = atJAActivities.getIdActivity();
        if ( idActivity == null ) {
            return null;
        }
        String name = idActivity.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String atJAActivitiesIdStatusName(AtJAActivities atJAActivities) {
        if ( atJAActivities == null ) {
            return null;
        }
        AtActivityStatuses idStatus = atJAActivities.getIdStatus();
        if ( idStatus == null ) {
            return null;
        }
        String name = idStatus.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long atJAActivitiesIdActivityId(AtJAActivities atJAActivities) {
        if ( atJAActivities == null ) {
            return null;
        }
        AtActivities idActivity = atJAActivities.getIdActivity();
        if ( idActivity == null ) {
            return null;
        }
        Long id = idActivity.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long atJAActivitiesIdJobApplicationId(AtJAActivities atJAActivities) {
        if ( atJAActivities == null ) {
            return null;
        }
        AtJobApplications idJobApplication = atJAActivities.getIdJobApplication();
        if ( idJobApplication == null ) {
            return null;
        }
        Long id = idJobApplication.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long atJAActivitiesIdStatusId(AtJAActivities atJAActivities) {
        if ( atJAActivities == null ) {
            return null;
        }
        AtActivityStatuses idStatus = atJAActivities.getIdStatus();
        if ( idStatus == null ) {
            return null;
        }
        Long id = idStatus.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
