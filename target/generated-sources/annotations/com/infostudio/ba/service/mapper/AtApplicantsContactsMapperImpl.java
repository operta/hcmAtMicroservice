package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.AtApplicants;
import com.infostudio.ba.domain.AtApplicantsContacts;
import com.infostudio.ba.service.dto.AtApplicantsContactsDTO;
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
public class AtApplicantsContactsMapperImpl implements AtApplicantsContactsMapper {

    @Autowired
    private AtApplicantsMapper atApplicantsMapper;

    @Override
    public List<AtApplicantsContacts> toEntity(List<AtApplicantsContactsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AtApplicantsContacts> list = new ArrayList<AtApplicantsContacts>( dtoList.size() );
        for ( AtApplicantsContactsDTO atApplicantsContactsDTO : dtoList ) {
            list.add( toEntity( atApplicantsContactsDTO ) );
        }

        return list;
    }

    @Override
    public List<AtApplicantsContactsDTO> toDto(List<AtApplicantsContacts> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AtApplicantsContactsDTO> list = new ArrayList<AtApplicantsContactsDTO>( entityList.size() );
        for ( AtApplicantsContacts atApplicantsContacts : entityList ) {
            list.add( toDto( atApplicantsContacts ) );
        }

        return list;
    }

    @Override
    public AtApplicantsContactsDTO toDto(AtApplicantsContacts atApplicantsContacts) {
        if ( atApplicantsContacts == null ) {
            return null;
        }

        AtApplicantsContactsDTO atApplicantsContactsDTO = new AtApplicantsContactsDTO();

        String surname = atApplicantsContactsIdApllicantSurname( atApplicantsContacts );
        if ( surname != null ) {
            atApplicantsContactsDTO.setIdApllicantSurname( surname );
        }
        Long id = atApplicantsContactsIdApllicantId( atApplicantsContacts );
        if ( id != null ) {
            atApplicantsContactsDTO.setIdApllicantId( id );
        }
        atApplicantsContactsDTO.setCreatedBy( atApplicantsContacts.getCreatedBy() );
        atApplicantsContactsDTO.setCreatedAt( atApplicantsContacts.getcreatedAt() );
        atApplicantsContactsDTO.setUpdatedBy( atApplicantsContacts.getupdatedBy() );
        atApplicantsContactsDTO.setUpdatedAt( atApplicantsContacts.getupdatedAt() );
        atApplicantsContactsDTO.setId( atApplicantsContacts.getId() );
        atApplicantsContactsDTO.setContact( atApplicantsContacts.getContact() );
        atApplicantsContactsDTO.setDescription( atApplicantsContacts.getDescription() );
        atApplicantsContactsDTO.setIdContactType( atApplicantsContacts.getIdContactType() );

        return atApplicantsContactsDTO;
    }

    @Override
    public AtApplicantsContacts toEntity(AtApplicantsContactsDTO atApplicantsContactsDTO) {
        if ( atApplicantsContactsDTO == null ) {
            return null;
        }

        AtApplicantsContacts atApplicantsContacts = new AtApplicantsContacts();

        atApplicantsContacts.setIdApllicant( atApplicantsMapper.fromId( atApplicantsContactsDTO.getIdApllicantId() ) );
        atApplicantsContacts.setCreatedBy( atApplicantsContactsDTO.getCreatedBy() );
        atApplicantsContacts.setcreatedAt( atApplicantsContactsDTO.getCreatedAt() );
        atApplicantsContacts.setupdatedBy( atApplicantsContactsDTO.getUpdatedBy() );
        atApplicantsContacts.setupdatedAt( atApplicantsContactsDTO.getUpdatedAt() );
        atApplicantsContacts.setId( atApplicantsContactsDTO.getId() );
        atApplicantsContacts.setContact( atApplicantsContactsDTO.getContact() );
        atApplicantsContacts.setDescription( atApplicantsContactsDTO.getDescription() );
        atApplicantsContacts.setIdContactType( atApplicantsContactsDTO.getIdContactType() );

        return atApplicantsContacts;
    }

    private String atApplicantsContactsIdApllicantSurname(AtApplicantsContacts atApplicantsContacts) {
        if ( atApplicantsContacts == null ) {
            return null;
        }
        AtApplicants idApllicant = atApplicantsContacts.getIdApllicant();
        if ( idApllicant == null ) {
            return null;
        }
        String surname = idApllicant.getSurname();
        if ( surname == null ) {
            return null;
        }
        return surname;
    }

    private Long atApplicantsContactsIdApllicantId(AtApplicantsContacts atApplicantsContacts) {
        if ( atApplicantsContacts == null ) {
            return null;
        }
        AtApplicants idApllicant = atApplicantsContacts.getIdApllicant();
        if ( idApllicant == null ) {
            return null;
        }
        Long id = idApllicant.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
