package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.AtVacancies;
import com.infostudio.ba.service.dto.AtVacanciesDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-08-24T09:35:31+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class AtVacanciesMapperImpl implements AtVacanciesMapper {

    @Override
    public AtVacancies toEntity(AtVacanciesDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AtVacancies atVacancies = new AtVacancies();

        atVacancies.setCreatedBy( dto.getCreatedBy() );
        atVacancies.setcreatedAt( dto.getCreatedAt() );
        atVacancies.setupdatedBy( dto.getUpdatedBy() );
        atVacancies.setupdatedAt( dto.getUpdatedAt() );
        atVacancies.setId( dto.getId() );
        atVacancies.setCode( dto.getCode() );
        atVacancies.setName( dto.getName() );
        atVacancies.setDescription( dto.getDescription() );
        atVacancies.setDateFrom( dto.getDateFrom() );
        atVacancies.setDateTo( dto.getDateTo() );
        atVacancies.setStatus( dto.getStatus() );
        atVacancies.setJobRole( dto.getJobRole() );
        atVacancies.setJobWorkingTime( dto.getJobWorkingTime() );
        atVacancies.setSkillsRequirement( dto.getSkillsRequirement() );
        atVacancies.setLanguageRequirement( dto.getLanguageRequirement() );
        atVacancies.setEducationRequirement( dto.getEducationRequirement() );
        atVacancies.setExperienceRequirement( dto.getExperienceRequirement() );
        atVacancies.setIdLocation( dto.getIdLocation() );
        atVacancies.setIdWorkPlace( dto.getIdWorkPlace() );

        return atVacancies;
    }

    @Override
    public AtVacanciesDTO toDto(AtVacancies entity) {
        if ( entity == null ) {
            return null;
        }

        AtVacanciesDTO atVacanciesDTO = new AtVacanciesDTO();

        atVacanciesDTO.setCreatedBy( entity.getCreatedBy() );
        atVacanciesDTO.setCreatedAt( entity.getcreatedAt() );
        atVacanciesDTO.setUpdatedBy( entity.getupdatedBy() );
        atVacanciesDTO.setUpdatedAt( entity.getupdatedAt() );
        atVacanciesDTO.setId( entity.getId() );
        atVacanciesDTO.setCode( entity.getCode() );
        atVacanciesDTO.setName( entity.getName() );
        atVacanciesDTO.setDescription( entity.getDescription() );
        atVacanciesDTO.setDateFrom( entity.getDateFrom() );
        atVacanciesDTO.setDateTo( entity.getDateTo() );
        atVacanciesDTO.setStatus( entity.getStatus() );
        atVacanciesDTO.setJobRole( entity.getJobRole() );
        atVacanciesDTO.setJobWorkingTime( entity.getJobWorkingTime() );
        atVacanciesDTO.setSkillsRequirement( entity.getSkillsRequirement() );
        atVacanciesDTO.setLanguageRequirement( entity.getLanguageRequirement() );
        atVacanciesDTO.setEducationRequirement( entity.getEducationRequirement() );
        atVacanciesDTO.setExperienceRequirement( entity.getExperienceRequirement() );
        atVacanciesDTO.setIdLocation( entity.getIdLocation() );
        atVacanciesDTO.setIdWorkPlace( entity.getIdWorkPlace() );

        return atVacanciesDTO;
    }

    @Override
    public List<AtVacancies> toEntity(List<AtVacanciesDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AtVacancies> list = new ArrayList<AtVacancies>( dtoList.size() );
        for ( AtVacanciesDTO atVacanciesDTO : dtoList ) {
            list.add( toEntity( atVacanciesDTO ) );
        }

        return list;
    }

    @Override
    public List<AtVacanciesDTO> toDto(List<AtVacancies> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AtVacanciesDTO> list = new ArrayList<AtVacanciesDTO>( entityList.size() );
        for ( AtVacancies atVacancies : entityList ) {
            list.add( toDto( atVacancies ) );
        }

        return list;
    }
}
