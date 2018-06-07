package com.infostudio.ba.service.dto;


import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the AtJobApplicantHistory entity.
 */
public class AtJobApplicantHistoryDTO implements Serializable {

    private Long id;

    private Long idStatusFromId;

    private String idStatusFromName;

    private Long idStatusToId;

    private String idStatusToName;

    private Long idJobApplicationId;

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

    public Long getIdStatusFromId() {
        return idStatusFromId;
    }

    public void setIdStatusFromId(Long atJobApplicationStatusesId) {
        this.idStatusFromId = atJobApplicationStatusesId;
    }

    public String getIdStatusFromName() {
        return idStatusFromName;
    }

    public void setIdStatusFromName(String atJobApplicationStatusesName) {
        this.idStatusFromName = atJobApplicationStatusesName;
    }

    public Long getIdStatusToId() {
        return idStatusToId;
    }

    public void setIdStatusToId(Long atJobApplicationStatusesId) {
        this.idStatusToId = atJobApplicationStatusesId;
    }

    public String getIdStatusToName() {
        return idStatusToName;
    }

    public void setIdStatusToName(String atJobApplicationStatusesName) {
        this.idStatusToName = atJobApplicationStatusesName;
    }

    public Long getIdJobApplicationId() {
        return idJobApplicationId;
    }

    public void setIdJobApplicationId(Long atJobApplicationsId) {
        this.idJobApplicationId = atJobApplicationsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AtJobApplicantHistoryDTO atJobApplicantHistoryDTO = (AtJobApplicantHistoryDTO) o;
        if(atJobApplicantHistoryDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atJobApplicantHistoryDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtJobApplicantHistoryDTO{" +
            "id=" + getId() +
            "}";
    }
}
