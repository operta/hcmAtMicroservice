package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.AtApplicants;
import com.infostudio.ba.domain.AtApplicantsDocuments;
import com.infostudio.ba.service.dto.AtApplicantsDocumentsDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-06T13:49:08+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class AtApplicantsDocumentsMapperImpl implements AtApplicantsDocumentsMapper {

    @Autowired
    private AtApplicantsMapper atApplicantsMapper;

    @Override
    public List<AtApplicantsDocuments> toEntity(List<AtApplicantsDocumentsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AtApplicantsDocuments> list = new ArrayList<AtApplicantsDocuments>( dtoList.size() );
        for ( AtApplicantsDocumentsDTO atApplicantsDocumentsDTO : dtoList ) {
            list.add( toEntity( atApplicantsDocumentsDTO ) );
        }

        return list;
    }

    @Override
    public List<AtApplicantsDocumentsDTO> toDto(List<AtApplicantsDocuments> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AtApplicantsDocumentsDTO> list = new ArrayList<AtApplicantsDocumentsDTO>( entityList.size() );
        for ( AtApplicantsDocuments atApplicantsDocuments : entityList ) {
            list.add( toDto( atApplicantsDocuments ) );
        }

        return list;
    }

    @Override
    public AtApplicantsDocumentsDTO toDto(AtApplicantsDocuments atApplicantsDocuments) {
        if ( atApplicantsDocuments == null ) {
            return null;
        }

        AtApplicantsDocumentsDTO atApplicantsDocumentsDTO = new AtApplicantsDocumentsDTO();

        String surname = atApplicantsDocumentsIdApplicantSurname( atApplicantsDocuments );
        if ( surname != null ) {
            atApplicantsDocumentsDTO.setIdApplicantSurname( surname );
        }
        Long id = atApplicantsDocumentsIdApplicantId( atApplicantsDocuments );
        if ( id != null ) {
            atApplicantsDocumentsDTO.setIdApplicantId( id );
        }
        atApplicantsDocumentsDTO.setCreatedBy( atApplicantsDocuments.getCreatedBy() );
        atApplicantsDocumentsDTO.setId( atApplicantsDocuments.getId() );
        atApplicantsDocumentsDTO.setName( atApplicantsDocuments.getName() );
        atApplicantsDocumentsDTO.setDescription( atApplicantsDocuments.getDescription() );
        atApplicantsDocumentsDTO.setDateCreated( atApplicantsDocuments.getDateCreated() );
        atApplicantsDocumentsDTO.setValidFrom( atApplicantsDocuments.getValidFrom() );
        atApplicantsDocumentsDTO.setValidTo( atApplicantsDocuments.getValidTo() );
        atApplicantsDocumentsDTO.setIdDocumentLink( atApplicantsDocuments.getIdDocumentLink() );
        atApplicantsDocumentsDTO.setIdDocumentType( atApplicantsDocuments.getIdDocumentType() );

        return atApplicantsDocumentsDTO;
    }

    @Override
    public AtApplicantsDocuments toEntity(AtApplicantsDocumentsDTO atApplicantsDocumentsDTO) {
        if ( atApplicantsDocumentsDTO == null ) {
            return null;
        }

        AtApplicantsDocuments atApplicantsDocuments = new AtApplicantsDocuments();

        atApplicantsDocuments.setIdApplicant( atApplicantsMapper.fromId( atApplicantsDocumentsDTO.getIdApplicantId() ) );
        atApplicantsDocuments.setCreatedBy( atApplicantsDocumentsDTO.getCreatedBy() );
        atApplicantsDocuments.setId( atApplicantsDocumentsDTO.getId() );
        atApplicantsDocuments.setName( atApplicantsDocumentsDTO.getName() );
        atApplicantsDocuments.setDescription( atApplicantsDocumentsDTO.getDescription() );
        atApplicantsDocuments.setDateCreated( atApplicantsDocumentsDTO.getDateCreated() );
        atApplicantsDocuments.setValidFrom( atApplicantsDocumentsDTO.getValidFrom() );
        atApplicantsDocuments.setValidTo( atApplicantsDocumentsDTO.getValidTo() );
        atApplicantsDocuments.setIdDocumentLink( atApplicantsDocumentsDTO.getIdDocumentLink() );
        atApplicantsDocuments.setIdDocumentType( atApplicantsDocumentsDTO.getIdDocumentType() );

        return atApplicantsDocuments;
    }

    private String atApplicantsDocumentsIdApplicantSurname(AtApplicantsDocuments atApplicantsDocuments) {
        if ( atApplicantsDocuments == null ) {
            return null;
        }
        AtApplicants idApplicant = atApplicantsDocuments.getIdApplicant();
        if ( idApplicant == null ) {
            return null;
        }
        String surname = idApplicant.getSurname();
        if ( surname == null ) {
            return null;
        }
        return surname;
    }

    private Long atApplicantsDocumentsIdApplicantId(AtApplicantsDocuments atApplicantsDocuments) {
        if ( atApplicantsDocuments == null ) {
            return null;
        }
        AtApplicants idApplicant = atApplicantsDocuments.getIdApplicant();
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
