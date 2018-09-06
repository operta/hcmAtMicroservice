package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.AtApplicants;
import com.infostudio.ba.domain.AtApplicantsSchools;
import com.infostudio.ba.service.dto.AtApplicantsSchoolsDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-06T13:49:09+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class AtApplicantsSchoolsMapperImpl implements AtApplicantsSchoolsMapper {

    @Autowired
    private AtApplicantsMapper atApplicantsMapper;

    @Override
    public List<AtApplicantsSchools> toEntity(List<AtApplicantsSchoolsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AtApplicantsSchools> list = new ArrayList<AtApplicantsSchools>( dtoList.size() );
        for ( AtApplicantsSchoolsDTO atApplicantsSchoolsDTO : dtoList ) {
            list.add( toEntity( atApplicantsSchoolsDTO ) );
        }

        return list;
    }

    @Override
    public List<AtApplicantsSchoolsDTO> toDto(List<AtApplicantsSchools> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AtApplicantsSchoolsDTO> list = new ArrayList<AtApplicantsSchoolsDTO>( entityList.size() );
        for ( AtApplicantsSchools atApplicantsSchools : entityList ) {
            list.add( toDto( atApplicantsSchools ) );
        }

        return list;
    }

    @Override
    public AtApplicantsSchoolsDTO toDto(AtApplicantsSchools atApplicantsSchools) {
        if ( atApplicantsSchools == null ) {
            return null;
        }

        AtApplicantsSchoolsDTO atApplicantsSchoolsDTO = new AtApplicantsSchoolsDTO();

        String surname = atApplicantsSchoolsIdApplicantSurname( atApplicantsSchools );
        if ( surname != null ) {
            atApplicantsSchoolsDTO.setIdApplicantSurname( surname );
        }
        Long id = atApplicantsSchoolsIdApplicantId( atApplicantsSchools );
        if ( id != null ) {
            atApplicantsSchoolsDTO.setIdApplicantId( id );
        }
        atApplicantsSchoolsDTO.setCreatedBy( atApplicantsSchools.getCreatedBy() );
        atApplicantsSchoolsDTO.setId( atApplicantsSchools.getId() );
        atApplicantsSchoolsDTO.setSchool( atApplicantsSchools.getSchool() );
        atApplicantsSchoolsDTO.setDateFrom( atApplicantsSchools.getDateFrom() );
        atApplicantsSchoolsDTO.setDateTo( atApplicantsSchools.getDateTo() );
        atApplicantsSchoolsDTO.setMajor( atApplicantsSchools.getMajor() );
        atApplicantsSchoolsDTO.setDegree( atApplicantsSchools.getDegree() );
        atApplicantsSchoolsDTO.setGrade( atApplicantsSchools.getGrade() );
        atApplicantsSchoolsDTO.setDescription( atApplicantsSchools.getDescription() );
        atApplicantsSchoolsDTO.setLink( atApplicantsSchools.getLink() );
        atApplicantsSchoolsDTO.setIdQualifcation( atApplicantsSchools.getIdQualifcation() );
        atApplicantsSchoolsDTO.setIdSchool( atApplicantsSchools.getIdSchool() );

        return atApplicantsSchoolsDTO;
    }

    @Override
    public AtApplicantsSchools toEntity(AtApplicantsSchoolsDTO atApplicantsSchoolsDTO) {
        if ( atApplicantsSchoolsDTO == null ) {
            return null;
        }

        AtApplicantsSchools atApplicantsSchools = new AtApplicantsSchools();

        atApplicantsSchools.setIdApplicant( atApplicantsMapper.fromId( atApplicantsSchoolsDTO.getIdApplicantId() ) );
        atApplicantsSchools.setCreatedBy( atApplicantsSchoolsDTO.getCreatedBy() );
        atApplicantsSchools.setId( atApplicantsSchoolsDTO.getId() );
        atApplicantsSchools.setSchool( atApplicantsSchoolsDTO.getSchool() );
        atApplicantsSchools.setDateFrom( atApplicantsSchoolsDTO.getDateFrom() );
        atApplicantsSchools.setDateTo( atApplicantsSchoolsDTO.getDateTo() );
        atApplicantsSchools.setMajor( atApplicantsSchoolsDTO.getMajor() );
        atApplicantsSchools.setDegree( atApplicantsSchoolsDTO.getDegree() );
        atApplicantsSchools.setGrade( atApplicantsSchoolsDTO.getGrade() );
        atApplicantsSchools.setDescription( atApplicantsSchoolsDTO.getDescription() );
        atApplicantsSchools.setLink( atApplicantsSchoolsDTO.getLink() );
        atApplicantsSchools.setIdQualifcation( atApplicantsSchoolsDTO.getIdQualifcation() );
        atApplicantsSchools.setIdSchool( atApplicantsSchoolsDTO.getIdSchool() );

        return atApplicantsSchools;
    }

    private String atApplicantsSchoolsIdApplicantSurname(AtApplicantsSchools atApplicantsSchools) {
        if ( atApplicantsSchools == null ) {
            return null;
        }
        AtApplicants idApplicant = atApplicantsSchools.getIdApplicant();
        if ( idApplicant == null ) {
            return null;
        }
        String surname = idApplicant.getSurname();
        if ( surname == null ) {
            return null;
        }
        return surname;
    }

    private Long atApplicantsSchoolsIdApplicantId(AtApplicantsSchools atApplicantsSchools) {
        if ( atApplicantsSchools == null ) {
            return null;
        }
        AtApplicants idApplicant = atApplicantsSchools.getIdApplicant();
        if ( idApplicant == null ) {
            return null;
        }
        Long id = idApplicant.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
