package com.infostudio.ba.service.dto;


import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the AtVacanciesStatuses entity.
 */
public class AtVacanciesStatusesDTO implements Serializable {

    private Long id;

    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AtVacanciesStatusesDTO atVacanciesStatusesDTO = (AtVacanciesStatusesDTO) o;
        if(atVacanciesStatusesDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atVacanciesStatusesDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtVacanciesStatusesDTO{" +
            "id=" + getId() +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
