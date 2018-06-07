package com.infostudio.ba.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the AtApplicantsContacts entity.
 */
public class AtApplicantsContactsDTO implements Serializable {

    private Long id;

    @NotNull
    private String contact;

    private String description;

    private Integer idContactType;

    private Long idApllicantId;

    private String idApllicantSurname;

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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIdContactType() {
        return idContactType;
    }

    public void setIdContactType(Integer idContactType) {
        this.idContactType = idContactType;
    }

    public Long getIdApllicantId() {
        return idApllicantId;
    }

    public void setIdApllicantId(Long atApplicantsId) {
        this.idApllicantId = atApplicantsId;
    }

    public String getIdApllicantSurname() {
        return idApllicantSurname;
    }

    public void setIdApllicantSurname(String atApplicantsSurname) {
        this.idApllicantSurname = atApplicantsSurname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AtApplicantsContactsDTO atApplicantsContactsDTO = (AtApplicantsContactsDTO) o;
        if(atApplicantsContactsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atApplicantsContactsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtApplicantsContactsDTO{" +
            "id=" + getId() +
            ", contact='" + getContact() + "'" +
            ", description='" + getDescription() + "'" +
            ", idContactType=" + getIdContactType() +
            "}";
    }
}
