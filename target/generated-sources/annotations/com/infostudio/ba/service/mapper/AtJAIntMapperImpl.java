package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.AtJAInt;
import com.infostudio.ba.domain.AtJobApplications;
import com.infostudio.ba.service.dto.AtJAIntDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-08-24T09:35:31+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class AtJAIntMapperImpl implements AtJAIntMapper {

    @Autowired
    private AtJobApplicationsMapper atJobApplicationsMapper;

    @Override
    public List<AtJAInt> toEntity(List<AtJAIntDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AtJAInt> list = new ArrayList<AtJAInt>( dtoList.size() );
        for ( AtJAIntDTO atJAIntDTO : dtoList ) {
            list.add( toEntity( atJAIntDTO ) );
        }

        return list;
    }

    @Override
    public List<AtJAIntDTO> toDto(List<AtJAInt> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AtJAIntDTO> list = new ArrayList<AtJAIntDTO>( entityList.size() );
        for ( AtJAInt atJAInt : entityList ) {
            list.add( toDto( atJAInt ) );
        }

        return list;
    }

    @Override
    public AtJAIntDTO toDto(AtJAInt atJAInt) {
        if ( atJAInt == null ) {
            return null;
        }

        AtJAIntDTO atJAIntDTO = new AtJAIntDTO();

        Long id = atJAIntJobApplicationIdId( atJAInt );
        if ( id != null ) {
            atJAIntDTO.setJobApplicationIdId( id );
        }
        atJAIntDTO.setCreatedBy( atJAInt.getCreatedBy() );
        atJAIntDTO.setCreatedAt( atJAInt.getcreatedAt() );
        atJAIntDTO.setUpdatedBy( atJAInt.getupdatedBy() );
        atJAIntDTO.setUpdatedAt( atJAInt.getupdatedAt() );
        atJAIntDTO.setId( atJAInt.getId() );
        atJAIntDTO.setGrade( atJAInt.getGrade() );
        atJAIntDTO.setDescription( atJAInt.getDescription() );
        atJAIntDTO.setLocationId( atJAInt.getLocationId() );
        atJAIntDTO.setInterviewDate( atJAInt.getInterviewDate() );

        return atJAIntDTO;
    }

    @Override
    public AtJAInt toEntity(AtJAIntDTO atJAIntDTO) {
        if ( atJAIntDTO == null ) {
            return null;
        }

        AtJAInt atJAInt = new AtJAInt();

        atJAInt.setJobApplicationId( atJobApplicationsMapper.fromId( atJAIntDTO.getJobApplicationIdId() ) );
        atJAInt.setCreatedBy( atJAIntDTO.getCreatedBy() );
        atJAInt.setcreatedAt( atJAIntDTO.getCreatedAt() );
        atJAInt.setupdatedBy( atJAIntDTO.getUpdatedBy() );
        atJAInt.setupdatedAt( atJAIntDTO.getUpdatedAt() );
        atJAInt.setId( atJAIntDTO.getId() );
        atJAInt.setGrade( atJAIntDTO.getGrade() );
        atJAInt.setDescription( atJAIntDTO.getDescription() );
        atJAInt.setLocationId( atJAIntDTO.getLocationId() );
        atJAInt.setInterviewDate( atJAIntDTO.getInterviewDate() );

        return atJAInt;
    }

    private Long atJAIntJobApplicationIdId(AtJAInt atJAInt) {
        if ( atJAInt == null ) {
            return null;
        }
        AtJobApplications jobApplicationId = atJAInt.getJobApplicationId();
        if ( jobApplicationId == null ) {
            return null;
        }
        Long id = jobApplicationId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
