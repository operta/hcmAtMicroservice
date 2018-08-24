package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.AtApplicants;
import com.infostudio.ba.domain.AtApplicantsSkills;
import com.infostudio.ba.service.dto.AtApplicantsSkillsDTO;
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
public class AtApplicantsSkillsMapperImpl implements AtApplicantsSkillsMapper {

    @Autowired
    private AtApplicantsMapper atApplicantsMapper;

    @Override
    public List<AtApplicantsSkills> toEntity(List<AtApplicantsSkillsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AtApplicantsSkills> list = new ArrayList<AtApplicantsSkills>( dtoList.size() );
        for ( AtApplicantsSkillsDTO atApplicantsSkillsDTO : dtoList ) {
            list.add( toEntity( atApplicantsSkillsDTO ) );
        }

        return list;
    }

    @Override
    public List<AtApplicantsSkillsDTO> toDto(List<AtApplicantsSkills> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AtApplicantsSkillsDTO> list = new ArrayList<AtApplicantsSkillsDTO>( entityList.size() );
        for ( AtApplicantsSkills atApplicantsSkills : entityList ) {
            list.add( toDto( atApplicantsSkills ) );
        }

        return list;
    }

    @Override
    public AtApplicantsSkillsDTO toDto(AtApplicantsSkills atApplicantsSkills) {
        if ( atApplicantsSkills == null ) {
            return null;
        }

        AtApplicantsSkillsDTO atApplicantsSkillsDTO = new AtApplicantsSkillsDTO();

        String surname = atApplicantsSkillsIdApplicantSurname( atApplicantsSkills );
        if ( surname != null ) {
            atApplicantsSkillsDTO.setIdApplicantSurname( surname );
        }
        Long id = atApplicantsSkillsIdApplicantId( atApplicantsSkills );
        if ( id != null ) {
            atApplicantsSkillsDTO.setIdApplicantId( id );
        }
        atApplicantsSkillsDTO.setCreatedBy( atApplicantsSkills.getCreatedBy() );
        atApplicantsSkillsDTO.setCreatedAt( atApplicantsSkills.getcreatedAt() );
        atApplicantsSkillsDTO.setUpdatedBy( atApplicantsSkills.getupdatedBy() );
        atApplicantsSkillsDTO.setUpdatedAt( atApplicantsSkills.getupdatedAt() );
        atApplicantsSkillsDTO.setId( atApplicantsSkills.getId() );
        atApplicantsSkillsDTO.setSkill( atApplicantsSkills.getSkill() );
        atApplicantsSkillsDTO.setDateSkill( atApplicantsSkills.getDateSkill() );
        atApplicantsSkillsDTO.setGrade( atApplicantsSkills.getGrade() );
        atApplicantsSkillsDTO.setIdSkill( atApplicantsSkills.getIdSkill() );
        atApplicantsSkillsDTO.setIdGrade( atApplicantsSkills.getIdGrade() );

        return atApplicantsSkillsDTO;
    }

    @Override
    public AtApplicantsSkills toEntity(AtApplicantsSkillsDTO atApplicantsSkillsDTO) {
        if ( atApplicantsSkillsDTO == null ) {
            return null;
        }

        AtApplicantsSkills atApplicantsSkills = new AtApplicantsSkills();

        atApplicantsSkills.setIdApplicant( atApplicantsMapper.fromId( atApplicantsSkillsDTO.getIdApplicantId() ) );
        atApplicantsSkills.setCreatedBy( atApplicantsSkillsDTO.getCreatedBy() );
        atApplicantsSkills.setcreatedAt( atApplicantsSkillsDTO.getCreatedAt() );
        atApplicantsSkills.setupdatedBy( atApplicantsSkillsDTO.getUpdatedBy() );
        atApplicantsSkills.setupdatedAt( atApplicantsSkillsDTO.getUpdatedAt() );
        atApplicantsSkills.setId( atApplicantsSkillsDTO.getId() );
        atApplicantsSkills.setSkill( atApplicantsSkillsDTO.getSkill() );
        atApplicantsSkills.setDateSkill( atApplicantsSkillsDTO.getDateSkill() );
        atApplicantsSkills.setGrade( atApplicantsSkillsDTO.getGrade() );
        atApplicantsSkills.setIdSkill( atApplicantsSkillsDTO.getIdSkill() );
        atApplicantsSkills.setIdGrade( atApplicantsSkillsDTO.getIdGrade() );

        return atApplicantsSkills;
    }

    private String atApplicantsSkillsIdApplicantSurname(AtApplicantsSkills atApplicantsSkills) {
        if ( atApplicantsSkills == null ) {
            return null;
        }
        AtApplicants idApplicant = atApplicantsSkills.getIdApplicant();
        if ( idApplicant == null ) {
            return null;
        }
        String surname = idApplicant.getSurname();
        if ( surname == null ) {
            return null;
        }
        return surname;
    }

    private Long atApplicantsSkillsIdApplicantId(AtApplicantsSkills atApplicantsSkills) {
        if ( atApplicantsSkills == null ) {
            return null;
        }
        AtApplicants idApplicant = atApplicantsSkills.getIdApplicant();
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
