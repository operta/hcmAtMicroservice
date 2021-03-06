package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.AtAccomplishmentTypes;
import com.infostudio.ba.service.dto.AtAccomplishmentTypesDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-06T13:49:09+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class AtAccomplishmentTypesMapperImpl implements AtAccomplishmentTypesMapper {

    @Override
    public AtAccomplishmentTypes toEntity(AtAccomplishmentTypesDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AtAccomplishmentTypes atAccomplishmentTypes = new AtAccomplishmentTypes();

        atAccomplishmentTypes.setCreatedBy( dto.getCreatedBy() );
        atAccomplishmentTypes.setId( dto.getId() );
        atAccomplishmentTypes.setCode( dto.getCode() );
        atAccomplishmentTypes.setName( dto.getName() );
        atAccomplishmentTypes.setDescription( dto.getDescription() );

        return atAccomplishmentTypes;
    }

    @Override
    public AtAccomplishmentTypesDTO toDto(AtAccomplishmentTypes entity) {
        if ( entity == null ) {
            return null;
        }

        AtAccomplishmentTypesDTO atAccomplishmentTypesDTO = new AtAccomplishmentTypesDTO();

        atAccomplishmentTypesDTO.setCreatedBy( entity.getCreatedBy() );
        atAccomplishmentTypesDTO.setId( entity.getId() );
        atAccomplishmentTypesDTO.setCode( entity.getCode() );
        atAccomplishmentTypesDTO.setName( entity.getName() );
        atAccomplishmentTypesDTO.setDescription( entity.getDescription() );

        return atAccomplishmentTypesDTO;
    }

    @Override
    public List<AtAccomplishmentTypes> toEntity(List<AtAccomplishmentTypesDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AtAccomplishmentTypes> list = new ArrayList<AtAccomplishmentTypes>( dtoList.size() );
        for ( AtAccomplishmentTypesDTO atAccomplishmentTypesDTO : dtoList ) {
            list.add( toEntity( atAccomplishmentTypesDTO ) );
        }

        return list;
    }

    @Override
    public List<AtAccomplishmentTypesDTO> toDto(List<AtAccomplishmentTypes> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AtAccomplishmentTypesDTO> list = new ArrayList<AtAccomplishmentTypesDTO>( entityList.size() );
        for ( AtAccomplishmentTypes atAccomplishmentTypes : entityList ) {
            list.add( toDto( atAccomplishmentTypes ) );
        }

        return list;
    }
}
