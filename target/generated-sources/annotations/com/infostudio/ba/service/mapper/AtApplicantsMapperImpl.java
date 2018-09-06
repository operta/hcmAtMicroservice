package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.AtApplicants;
import com.infostudio.ba.service.dto.AtApplicantsDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-06T16:15:35+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class AtApplicantsMapperImpl implements AtApplicantsMapper {

    @Override
    public AtApplicants toEntity(AtApplicantsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AtApplicants atApplicants = new AtApplicants();

        atApplicants.setCreatedBy( dto.getCreatedBy() );
        atApplicants.setId( dto.getId() );
        atApplicants.setName( dto.getName() );
        atApplicants.setSurname( dto.getSurname() );
        atApplicants.setMiddleName( dto.getMiddleName() );
        atApplicants.setMaidenName( dto.getMaidenName() );
        atApplicants.setGender( dto.getGender() );
        atApplicants.setBirthdate( dto.getBirthdate() );
        atApplicants.setMaterialStatus( dto.getMaterialStatus() );
        atApplicants.setAddress( dto.getAddress() );
        atApplicants.setEmployed( dto.getEmployed() );
        atApplicants.setDescription( dto.getDescription() );
        atApplicants.setEmployementPosition( dto.getEmployementPosition() );
        atApplicants.setIndustry( dto.getIndustry() );
        atApplicants.setPhoneNumber( dto.getPhoneNumber() );
        atApplicants.setEmail( dto.getEmail() );
        atApplicants.setImageLink( dto.getImageLink() );
        atApplicants.setIdCity( dto.getIdCity() );
        atApplicants.setIdQualifcation( dto.getIdQualifcation() );
        atApplicants.setIdEmployee( dto.getIdEmployee() );
        atApplicants.setIdUser( dto.getIdUser() );

        return atApplicants;
    }

    @Override
    public AtApplicantsDTO toDto(AtApplicants entity) {
        if ( entity == null ) {
            return null;
        }

        AtApplicantsDTO atApplicantsDTO = new AtApplicantsDTO();

        atApplicantsDTO.setCreatedBy( entity.getCreatedBy() );
        atApplicantsDTO.setId( entity.getId() );
        atApplicantsDTO.setName( entity.getName() );
        atApplicantsDTO.setSurname( entity.getSurname() );
        atApplicantsDTO.setMiddleName( entity.getMiddleName() );
        atApplicantsDTO.setMaidenName( entity.getMaidenName() );
        atApplicantsDTO.setGender( entity.getGender() );
        atApplicantsDTO.setBirthdate( entity.getBirthdate() );
        atApplicantsDTO.setMaterialStatus( entity.getMaterialStatus() );
        atApplicantsDTO.setAddress( entity.getAddress() );
        atApplicantsDTO.setEmployed( entity.getEmployed() );
        atApplicantsDTO.setDescription( entity.getDescription() );
        atApplicantsDTO.setEmployementPosition( entity.getEmployementPosition() );
        atApplicantsDTO.setIndustry( entity.getIndustry() );
        atApplicantsDTO.setPhoneNumber( entity.getPhoneNumber() );
        atApplicantsDTO.setEmail( entity.getEmail() );
        atApplicantsDTO.setImageLink( entity.getImageLink() );
        atApplicantsDTO.setIdCity( entity.getIdCity() );
        atApplicantsDTO.setIdQualifcation( entity.getIdQualifcation() );
        atApplicantsDTO.setIdEmployee( entity.getIdEmployee() );
        atApplicantsDTO.setIdUser( entity.getIdUser() );

        return atApplicantsDTO;
    }

    @Override
    public List<AtApplicants> toEntity(List<AtApplicantsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AtApplicants> list = new ArrayList<AtApplicants>( dtoList.size() );
        for ( AtApplicantsDTO atApplicantsDTO : dtoList ) {
            list.add( toEntity( atApplicantsDTO ) );
        }

        return list;
    }

    @Override
    public List<AtApplicantsDTO> toDto(List<AtApplicants> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AtApplicantsDTO> list = new ArrayList<AtApplicantsDTO>( entityList.size() );
        for ( AtApplicants atApplicants : entityList ) {
            list.add( toDto( atApplicants ) );
        }

        return list;
    }
}
