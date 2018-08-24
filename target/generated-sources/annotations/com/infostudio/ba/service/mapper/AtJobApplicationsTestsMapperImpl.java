package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.AtJobApplications;
import com.infostudio.ba.domain.AtJobApplicationsTests;
import com.infostudio.ba.service.dto.AtJobApplicationsTestsDTO;
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
public class AtJobApplicationsTestsMapperImpl implements AtJobApplicationsTestsMapper {

    @Autowired
    private AtJobApplicationsMapper atJobApplicationsMapper;

    @Override
    public List<AtJobApplicationsTests> toEntity(List<AtJobApplicationsTestsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AtJobApplicationsTests> list = new ArrayList<AtJobApplicationsTests>( dtoList.size() );
        for ( AtJobApplicationsTestsDTO atJobApplicationsTestsDTO : dtoList ) {
            list.add( toEntity( atJobApplicationsTestsDTO ) );
        }

        return list;
    }

    @Override
    public List<AtJobApplicationsTestsDTO> toDto(List<AtJobApplicationsTests> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AtJobApplicationsTestsDTO> list = new ArrayList<AtJobApplicationsTestsDTO>( entityList.size() );
        for ( AtJobApplicationsTests atJobApplicationsTests : entityList ) {
            list.add( toDto( atJobApplicationsTests ) );
        }

        return list;
    }

    @Override
    public AtJobApplicationsTestsDTO toDto(AtJobApplicationsTests atJobApplicationsTests) {
        if ( atJobApplicationsTests == null ) {
            return null;
        }

        AtJobApplicationsTestsDTO atJobApplicationsTestsDTO = new AtJobApplicationsTestsDTO();

        Long id = atJobApplicationsTestsJobApplicationIdId( atJobApplicationsTests );
        if ( id != null ) {
            atJobApplicationsTestsDTO.setJobApplicationIdId( id );
        }
        atJobApplicationsTestsDTO.setCreatedBy( atJobApplicationsTests.getCreatedBy() );
        atJobApplicationsTestsDTO.setCreatedAt( atJobApplicationsTests.getcreatedAt() );
        atJobApplicationsTestsDTO.setUpdatedBy( atJobApplicationsTests.getupdatedBy() );
        atJobApplicationsTestsDTO.setUpdatedAt( atJobApplicationsTests.getupdatedAt() );
        atJobApplicationsTestsDTO.setId( atJobApplicationsTests.getId() );
        atJobApplicationsTestsDTO.setScore( atJobApplicationsTests.getScore() );
        atJobApplicationsTestsDTO.setLocationId( atJobApplicationsTests.getLocationId() );
        atJobApplicationsTestsDTO.setTestDate( atJobApplicationsTests.getTestDate() );
        atJobApplicationsTestsDTO.setReview( atJobApplicationsTests.getReview() );
        atJobApplicationsTestsDTO.setShortDescription( atJobApplicationsTests.getShortDescription() );

        return atJobApplicationsTestsDTO;
    }

    @Override
    public AtJobApplicationsTests toEntity(AtJobApplicationsTestsDTO atJobApplicationsTestsDTO) {
        if ( atJobApplicationsTestsDTO == null ) {
            return null;
        }

        AtJobApplicationsTests atJobApplicationsTests = new AtJobApplicationsTests();

        atJobApplicationsTests.setJobApplicationId( atJobApplicationsMapper.fromId( atJobApplicationsTestsDTO.getJobApplicationIdId() ) );
        atJobApplicationsTests.setCreatedBy( atJobApplicationsTestsDTO.getCreatedBy() );
        atJobApplicationsTests.setcreatedAt( atJobApplicationsTestsDTO.getCreatedAt() );
        atJobApplicationsTests.setupdatedBy( atJobApplicationsTestsDTO.getUpdatedBy() );
        atJobApplicationsTests.setupdatedAt( atJobApplicationsTestsDTO.getUpdatedAt() );
        atJobApplicationsTests.setId( atJobApplicationsTestsDTO.getId() );
        atJobApplicationsTests.setScore( atJobApplicationsTestsDTO.getScore() );
        atJobApplicationsTests.setLocationId( atJobApplicationsTestsDTO.getLocationId() );
        atJobApplicationsTests.setTestDate( atJobApplicationsTestsDTO.getTestDate() );
        atJobApplicationsTests.setReview( atJobApplicationsTestsDTO.getReview() );
        atJobApplicationsTests.setShortDescription( atJobApplicationsTestsDTO.getShortDescription() );

        return atJobApplicationsTests;
    }

    private Long atJobApplicationsTestsJobApplicationIdId(AtJobApplicationsTests atJobApplicationsTests) {
        if ( atJobApplicationsTests == null ) {
            return null;
        }
        AtJobApplications jobApplicationId = atJobApplicationsTests.getJobApplicationId();
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
