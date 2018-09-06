package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.AtAccomplishmentTypes;
import com.infostudio.ba.domain.AtApplicantAcc;
import com.infostudio.ba.domain.AtApplicants;
import com.infostudio.ba.service.dto.AtApplicantAccDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-06T15:12:45+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class AtApplicantAccMapperImpl implements AtApplicantAccMapper {

    @Autowired
    private AtAccomplishmentTypesMapper atAccomplishmentTypesMapper;
    @Autowired
    private AtApplicantsMapper atApplicantsMapper;

    @Override
    public List<AtApplicantAcc> toEntity(List<AtApplicantAccDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AtApplicantAcc> list = new ArrayList<AtApplicantAcc>( dtoList.size() );
        for ( AtApplicantAccDTO atApplicantAccDTO : dtoList ) {
            list.add( toEntity( atApplicantAccDTO ) );
        }

        return list;
    }

    @Override
    public List<AtApplicantAccDTO> toDto(List<AtApplicantAcc> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AtApplicantAccDTO> list = new ArrayList<AtApplicantAccDTO>( entityList.size() );
        for ( AtApplicantAcc atApplicantAcc : entityList ) {
            list.add( toDto( atApplicantAcc ) );
        }

        return list;
    }

    @Override
    public AtApplicantAccDTO toDto(AtApplicantAcc atApplicantAcc) {
        if ( atApplicantAcc == null ) {
            return null;
        }

        AtApplicantAccDTO atApplicantAccDTO = new AtApplicantAccDTO();

        Long id = atApplicantAccIdAccomplishmentTypeId( atApplicantAcc );
        if ( id != null ) {
            atApplicantAccDTO.setIdAccomplishmentTypeId( id );
        }
        String surname = atApplicantAccIdApplicantSurname( atApplicantAcc );
        if ( surname != null ) {
            atApplicantAccDTO.setIdApplicantSurname( surname );
        }
        String name = atApplicantAccIdAccomplishmentTypeName( atApplicantAcc );
        if ( name != null ) {
            atApplicantAccDTO.setIdAccomplishmentTypeName( name );
        }
        Long id1 = atApplicantAccIdApplicantId( atApplicantAcc );
        if ( id1 != null ) {
            atApplicantAccDTO.setIdApplicantId( id1 );
        }
        atApplicantAccDTO.setCreatedBy( atApplicantAcc.getCreatedBy() );
        atApplicantAccDTO.setCreatedAt( atApplicantAcc.getcreatedAt() );
        atApplicantAccDTO.setUpdatedBy( atApplicantAcc.getupdatedBy() );
        atApplicantAccDTO.setUpdatedAt( atApplicantAcc.getupdatedAt() );
        atApplicantAccDTO.setId( atApplicantAcc.getId() );
        atApplicantAccDTO.setTitle( atApplicantAcc.getTitle() );
        atApplicantAccDTO.setDescription( atApplicantAcc.getDescription() );
        atApplicantAccDTO.setOrganization( atApplicantAcc.getOrganization() );
        atApplicantAccDTO.setLocation( atApplicantAcc.getLocation() );
        atApplicantAccDTO.setAssociation( atApplicantAcc.getAssociation() );
        atApplicantAccDTO.setOngoing( atApplicantAcc.getOngoing() );
        atApplicantAccDTO.setLink( atApplicantAcc.getLink() );
        atApplicantAccDTO.setDateFrom( atApplicantAcc.getDateFrom() );
        atApplicantAccDTO.setDateTo( atApplicantAcc.getDateTo() );
        atApplicantAccDTO.setOccupation( atApplicantAcc.getOccupation() );
        atApplicantAccDTO.setProficiency( atApplicantAcc.getProficiency() );
        atApplicantAccDTO.setLicenceNumber( atApplicantAcc.getLicenceNumber() );

        return atApplicantAccDTO;
    }

    @Override
    public AtApplicantAcc toEntity(AtApplicantAccDTO atApplicantAccDTO) {
        if ( atApplicantAccDTO == null ) {
            return null;
        }

        AtApplicantAcc atApplicantAcc = new AtApplicantAcc();

        atApplicantAcc.setIdAccomplishmentType( atAccomplishmentTypesMapper.fromId( atApplicantAccDTO.getIdAccomplishmentTypeId() ) );
        atApplicantAcc.setIdApplicant( atApplicantsMapper.fromId( atApplicantAccDTO.getIdApplicantId() ) );
        atApplicantAcc.setCreatedBy( atApplicantAccDTO.getCreatedBy() );
        atApplicantAcc.setcreatedAt( atApplicantAccDTO.getCreatedAt() );
        atApplicantAcc.setupdatedBy( atApplicantAccDTO.getUpdatedBy() );
        atApplicantAcc.setupdatedAt( atApplicantAccDTO.getUpdatedAt() );
        atApplicantAcc.setId( atApplicantAccDTO.getId() );
        atApplicantAcc.setTitle( atApplicantAccDTO.getTitle() );
        atApplicantAcc.setDescription( atApplicantAccDTO.getDescription() );
        atApplicantAcc.setOrganization( atApplicantAccDTO.getOrganization() );
        atApplicantAcc.setLocation( atApplicantAccDTO.getLocation() );
        atApplicantAcc.setAssociation( atApplicantAccDTO.getAssociation() );
        atApplicantAcc.setOngoing( atApplicantAccDTO.getOngoing() );
        atApplicantAcc.setLink( atApplicantAccDTO.getLink() );
        atApplicantAcc.setDateFrom( atApplicantAccDTO.getDateFrom() );
        atApplicantAcc.setDateTo( atApplicantAccDTO.getDateTo() );
        atApplicantAcc.setOccupation( atApplicantAccDTO.getOccupation() );
        atApplicantAcc.setProficiency( atApplicantAccDTO.getProficiency() );
        atApplicantAcc.setLicenceNumber( atApplicantAccDTO.getLicenceNumber() );

        return atApplicantAcc;
    }

    private Long atApplicantAccIdAccomplishmentTypeId(AtApplicantAcc atApplicantAcc) {
        if ( atApplicantAcc == null ) {
            return null;
        }
        AtAccomplishmentTypes idAccomplishmentType = atApplicantAcc.getIdAccomplishmentType();
        if ( idAccomplishmentType == null ) {
            return null;
        }
        Long id = idAccomplishmentType.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String atApplicantAccIdApplicantSurname(AtApplicantAcc atApplicantAcc) {
        if ( atApplicantAcc == null ) {
            return null;
        }
        AtApplicants idApplicant = atApplicantAcc.getIdApplicant();
        if ( idApplicant == null ) {
            return null;
        }
        String surname = idApplicant.getSurname();
        if ( surname == null ) {
            return null;
        }
        return surname;
    }

    private String atApplicantAccIdAccomplishmentTypeName(AtApplicantAcc atApplicantAcc) {
        if ( atApplicantAcc == null ) {
            return null;
        }
        AtAccomplishmentTypes idAccomplishmentType = atApplicantAcc.getIdAccomplishmentType();
        if ( idAccomplishmentType == null ) {
            return null;
        }
        String name = idAccomplishmentType.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long atApplicantAccIdApplicantId(AtApplicantAcc atApplicantAcc) {
        if ( atApplicantAcc == null ) {
            return null;
        }
        AtApplicants idApplicant = atApplicantAcc.getIdApplicant();
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
