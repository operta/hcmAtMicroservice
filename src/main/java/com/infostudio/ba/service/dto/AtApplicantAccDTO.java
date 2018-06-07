package com.infostudio.ba.service.dto;


import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the AtApplicantAcc entity.
 */
public class AtApplicantAccDTO implements Serializable {

    private Long id;

    @NotNull
    private String title;

    private String description;

    private String organization;

    private String location;

    private String association;

    private String ongoing;

    private String link;

    private LocalDate dateFrom;

    private LocalDate dateTo;

    private String occupation;

    private String proficiency;

    private String licenceNumber;

    private Long idAccomplishmentTypeId;

    private String idAccomplishmentTypeName;

    private Long idApplicantId;

    private String idApplicantSurname;

    private String createdBy;

    private Instant createdAt;

    private String updatedBy;

    private Instant updatedAt;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAssociation() {
        return association;
    }

    public void setAssociation(String association) {
        this.association = association;
    }

    public String getOngoing() {
        return ongoing;
    }

    public void setOngoing(String ongoing) {
        this.ongoing = ongoing;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public Long getIdAccomplishmentTypeId() {
        return idAccomplishmentTypeId;
    }

    public void setIdAccomplishmentTypeId(Long atAccomplishmentTypesId) {
        this.idAccomplishmentTypeId = atAccomplishmentTypesId;
    }

    public String getIdAccomplishmentTypeName() {
        return idAccomplishmentTypeName;
    }

    public void setIdAccomplishmentTypeName(String atAccomplishmentTypesName) {
        this.idAccomplishmentTypeName = atAccomplishmentTypesName;
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

        AtApplicantAccDTO atApplicantAccDTO = (AtApplicantAccDTO) o;
        if(atApplicantAccDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atApplicantAccDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtApplicantAccDTO{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", organization='" + getOrganization() + "'" +
            ", location='" + getLocation() + "'" +
            ", association='" + getAssociation() + "'" +
            ", ongoing='" + getOngoing() + "'" +
            ", link='" + getLink() + "'" +
            ", dateFrom='" + getDateFrom() + "'" +
            ", dateTo='" + getDateTo() + "'" +
            ", occupation='" + getOccupation() + "'" +
            ", proficiency='" + getProficiency() + "'" +
            ", licenceNumber='" + getLicenceNumber() + "'" +
            "}";
    }
}
