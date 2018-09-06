package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.AtVacancies;
import com.infostudio.ba.domain.AtVacanciesSkills;
import com.infostudio.ba.service.dto.AtVacanciesSkillsDTO;
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
public class AtVacanciesSkillsMapperImpl implements AtVacanciesSkillsMapper {

    @Autowired
    private AtVacanciesMapper atVacanciesMapper;

    @Override
    public List<AtVacanciesSkills> toEntity(List<AtVacanciesSkillsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AtVacanciesSkills> list = new ArrayList<AtVacanciesSkills>( dtoList.size() );
        for ( AtVacanciesSkillsDTO atVacanciesSkillsDTO : dtoList ) {
            list.add( toEntity( atVacanciesSkillsDTO ) );
        }

        return list;
    }

    @Override
    public List<AtVacanciesSkillsDTO> toDto(List<AtVacanciesSkills> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AtVacanciesSkillsDTO> list = new ArrayList<AtVacanciesSkillsDTO>( entityList.size() );
        for ( AtVacanciesSkills atVacanciesSkills : entityList ) {
            list.add( toDto( atVacanciesSkills ) );
        }

        return list;
    }

    @Override
    public AtVacanciesSkillsDTO toDto(AtVacanciesSkills atVacanciesSkills) {
        if ( atVacanciesSkills == null ) {
            return null;
        }

        AtVacanciesSkillsDTO atVacanciesSkillsDTO = new AtVacanciesSkillsDTO();

        Long id = atVacanciesSkillsVacancyIdId( atVacanciesSkills );
        if ( id != null ) {
            atVacanciesSkillsDTO.setVacancyIdId( id );
        }
        String name = atVacanciesSkillsVacancyIdName( atVacanciesSkills );
        if ( name != null ) {
            atVacanciesSkillsDTO.setVacancyIdName( name );
        }
        atVacanciesSkillsDTO.setCreatedBy( atVacanciesSkills.getCreatedBy() );
        atVacanciesSkillsDTO.setId( atVacanciesSkills.getId() );
        atVacanciesSkillsDTO.setSkillId( atVacanciesSkills.getSkillId() );
        atVacanciesSkillsDTO.setGradeId( atVacanciesSkills.getGradeId() );

        return atVacanciesSkillsDTO;
    }

    @Override
    public AtVacanciesSkills toEntity(AtVacanciesSkillsDTO atVacanciesSkillsDTO) {
        if ( atVacanciesSkillsDTO == null ) {
            return null;
        }

        AtVacanciesSkills atVacanciesSkills = new AtVacanciesSkills();

        atVacanciesSkills.setVacancyId( atVacanciesMapper.fromId( atVacanciesSkillsDTO.getVacancyIdId() ) );
        atVacanciesSkills.setCreatedBy( atVacanciesSkillsDTO.getCreatedBy() );
        atVacanciesSkills.setId( atVacanciesSkillsDTO.getId() );
        atVacanciesSkills.setSkillId( atVacanciesSkillsDTO.getSkillId() );
        atVacanciesSkills.setGradeId( atVacanciesSkillsDTO.getGradeId() );

        return atVacanciesSkills;
    }

    private Long atVacanciesSkillsVacancyIdId(AtVacanciesSkills atVacanciesSkills) {
        if ( atVacanciesSkills == null ) {
            return null;
        }
        AtVacancies vacancyId = atVacanciesSkills.getVacancyId();
        if ( vacancyId == null ) {
            return null;
        }
        Long id = vacancyId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String atVacanciesSkillsVacancyIdName(AtVacanciesSkills atVacanciesSkills) {
        if ( atVacanciesSkills == null ) {
            return null;
        }
        AtVacancies vacancyId = atVacanciesSkills.getVacancyId();
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
