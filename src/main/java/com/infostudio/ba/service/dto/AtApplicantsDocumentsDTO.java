package com.infostudio.ba.service.dto;


import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the AtApplicantsDocuments entity.
 */
public class AtApplicantsDocumentsDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    private String description;

    private LocalDate dateCreated;

    private LocalDate validFrom;

    private LocalDate validTo;

    private Integer idDocumentLink;

    private Integer idDocumentType;

    private Long idApplicantId;

    private String idApplicantSurname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }

    public Integer getIdDocumentLink() {
        return idDocumentLink;
    }

    public void setIdDocumentLink(Integer idDocumentLink) {
        this.idDocumentLink = idDocumentLink;
    }

    public Integer getIdDocumentType() {
        return idDocumentType;
    }

    public void setIdDocumentType(Integer idDocumentType) {
        this.idDocumentType = idDocumentType;
    }

    public Long getIdApplicantId() {
        return idApplicantId;
    }

    public void setIdApplicantId(Long atApplicantsId) {
        this.idApplicantId = atApplicantsId;
    }

    public String getIdApplicantSurname() {
        return idApplicantSurname;
    }

    public void setIdApplicantSurname(String atApplicantsSurname) {
        this.idApplicantSurname = atApplicantsSurname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AtApplicantsDocumentsDTO atApplicantsDocumentsDTO = (AtApplicantsDocumentsDTO) o;
        if(atApplicantsDocumentsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atApplicantsDocumentsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtApplicantsDocumentsDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", dateCreated='" + getDateCreated() + "'" +
            ", validFrom='" + getValidFrom() + "'" +
            ", validTo='" + getValidTo() + "'" +
            ", idDocumentLink=" + getIdDocumentLink() +
            ", idDocumentType=" + getIdDocumentType() +
            "}";
    }
}
