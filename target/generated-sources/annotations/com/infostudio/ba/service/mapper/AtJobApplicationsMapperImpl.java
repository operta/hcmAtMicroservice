package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.AtApplicants;
import com.infostudio.ba.domain.AtJobApplicationStatuses;
import com.infostudio.ba.domain.AtJobApplications;
import com.infostudio.ba.domain.AtVacancies;
import com.infostudio.ba.service.dto.AtJobApplicationsDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-08-24T09:35:30+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class AtJobApplicationsMapperImpl implements AtJobApplicationsMapper {

    @Autowired
    private AtApplicantsMapper atApplicantsMapper;
    @Autowired
    private AtJobApplicationStatusesMapper atJobApplicationStatusesMapper;
    @Autowired
    private AtVacanciesMapper atVacanciesMapper;

    @Override
    public List<AtJobApplications> toEntity(List<AtJobApplicationsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AtJobApplications> list = new ArrayList<AtJobApplications>( dtoList.size() );
        for ( AtJobApplicationsDTO atJobApplicationsDTO : dtoList ) {
            list.add( toEntity( atJobApplicationsDTO ) );
        }

        return list;
    }

    @Override
    public List<AtJobApplicationsDTO> toDto(List<AtJobApplications> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AtJobApplicationsDTO> list = new ArrayList<AtJobApplicationsDTO>( entityList.size() );
        for ( AtJobApplications atJobApplications : entityList ) {
            list.add( toDto( atJobApplications ) );
        }

        return list;
    }

    @Override
    public AtJobApplicationsDTO toDto(AtJobApplications atJobApplications) {
        if ( atJobApplications == null ) {
            return null;
        }

        AtJobApplicationsDTO atJobApplicationsDTO = new AtJobApplicationsDTO();

        String name = atJobApplicationsIdStatusName( atJobApplications );
        if ( name != null ) {
            atJobApplicationsDTO.setIdStatusName( name );
        }
        Long id = atJobApplicationsVacancyIdId( atJobApplications );
        if ( id != null ) {
            atJobApplicationsDTO.setVacancyIdId( id );
        }
        Long id1 = atJobApplicationsIdStatusId( atJobApplications );
        if ( id1 != null ) {
            atJobApplicationsDTO.setIdStatusId( id1 );
        }
        String surname = atJobApplicationsApplicantIdSurname( atJobApplications );
        if ( surname != null ) {
            atJobApplicationsDTO.setApplicantIdSurname( surname );
        }
        Long id2 = atJobApplicationsApplicantIdId( atJobApplications );
        if ( id2 != null ) {
            atJobApplicationsDTO.setApplicantIdId( id2 );
        }
        String name1 = atJobApplicationsVacancyIdName( atJobApplications );
        if ( name1 != null ) {
            atJobApplicationsDTO.setVacancyIdName( name1 );
        }
        atJobApplicationsDTO.setCreatedBy( atJobApplications.getCreatedBy() );
        atJobApplicationsDTO.setCreatedAt( atJobApplications.getcreatedAt() );
        atJobApplicationsDTO.setUpdatedBy( atJobApplications.getupdatedBy() );
        atJobApplicationsDTO.setUpdatedAt( atJobApplications.getupdatedAt() );
        atJobApplicationsDTO.setId( atJobApplications.getId() );
        atJobApplicationsDTO.setGrade( atJobApplications.getGrade() );
        atJobApplicationsDTO.setReview( atJobApplications.getReview() );
        atJobApplicationsDTO.setDateApplied( atJobApplications.getDateApplied() );
        atJobApplicationsDTO.setInterviewGrade( atJobApplications.getInterviewGrade() );
        atJobApplicationsDTO.setTestGrade( atJobApplications.getTestGrade() );

        return atJobApplicationsDTO;
    }

    @Override
    public AtJobApplications toEntity(AtJobApplicationsDTO atJobApplicationsDTO) {
        if ( atJobApplicationsDTO == null ) {
            return null;
        }

        AtJobApplications atJobApplications = new AtJobApplications();

        atJobApplications.setIdStatus( atJobApplicationStatusesMapper.fromId( atJobApplicationsDTO.getIdStatusId() ) );
        atJobApplications.setApplicantId( atApplicantsMapper.fromId( atJobApplicationsDTO.getApplicantIdId() ) );
        atJobApplications.setVacancyId( atVacanciesMapper.fromId( atJobApplicationsDTO.getVacancyIdId() ) );
        atJobApplications.setCreatedBy( atJobApplicationsDTO.getCreatedBy() );
        atJobApplications.setcreatedAt( atJobApplicationsDTO.getCreatedAt() );
        atJobApplications.setupdatedBy( atJobApplicationsDTO.getUpdatedBy() );
        atJobApplications.setupdatedAt( atJobApplicationsDTO.getUpdatedAt() );
        atJobApplications.setId( atJobApplicationsDTO.getId() );
        atJobApplications.setGrade( atJobApplicationsDTO.getGrade() );
        atJobApplications.setReview( atJobApplicationsDTO.getReview() );
        atJobApplications.setDateApplied( atJobApplicationsDTO.getDateApplied() );
        atJobApplications.setInterviewGrade( atJobApplicationsDTO.getInterviewGrade() );
        atJobApplications.setTestGrade( atJobApplicationsDTO.getTestGrade() );

        return atJobApplications;
    }

    private String atJobApplicationsIdStatusName(AtJobApplications atJobApplications) {
        if ( atJobApplications == null ) {
            return null;
        }
        AtJobApplicationStatuses idStatus = atJobApplications.getIdStatus();
        if ( idStatus == null ) {
            return null;
        }
        String name = idStatus.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long atJobApplicationsVacancyIdId(AtJobApplications atJobApplications) {
        if ( atJobApplications == null ) {
            return null;
        }
        AtVacancies vacancyId = atJobApplications.getVacancyId();
        if ( vacancyId == null ) {
            return null;
        }
        Long id = vacancyId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long atJobApplicationsIdStatusId(AtJobApplications atJobApplications) {
        if ( atJobApplications == null ) {
            return null;
        }
        AtJobApplicationStatuses idStatus = atJobApplications.getIdStatus();
        if ( idStatus == null ) {
            return null;
        }
        Long id = idStatus.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String atJobApplicationsApplicantIdSurname(AtJobApplications atJobApplications) {
        if ( atJobApplications == null ) {
            return null;
        }
        AtApplicants applicantId = atJobApplications.getApplicantId();
        if ( applicantId == null ) {
            return null;
        }
        String surname = applicantId.getSurname();
        if ( surname == null ) {
            return null;
        }
        return surname;
    }

    private Long atJobApplicationsApplicantIdId(AtJobApplications atJobApplications) {
        if ( atJobApplications == null ) {
            return null;
        }
        AtApplicants applicantId = atJobApplications.getApplicantId();
        if ( applicantId == null ) {
            return null;
        }
        Long id = applicantId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String atJobApplicationsVacancyIdName(AtJobApplications atJobApplications) {
        if ( atJobApplications == null ) {
            return null;
        }
        AtVacancies vacancyId = atJobApplications.getVacancyId();
        if ( vacancyId == null ) {
            return null;
        }
        String name = vacancyId.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
