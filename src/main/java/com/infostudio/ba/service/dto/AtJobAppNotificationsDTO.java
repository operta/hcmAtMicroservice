package com.infostudio.ba.service.dto;


import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the AtJobAppNotifications entity.
 */
public class AtJobAppNotificationsDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDate dateSent;

    @NotNull
    private String isActive;

    private Long idJobApplicationId;

    private Long idNotificationId;

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

    public LocalDate getDateSent() {
        return dateSent;
    }

    public void setDateSent(LocalDate dateSent) {
        this.dateSent = dateSent;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Long getIdJobApplicationId() {
        return idJobApplicationId;
    }

    public void setIdJobApplicationId(Long atJobApplicationsId) {
        this.idJobApplicationId = atJobApplicationsId;
    }

    public Long getIdNotificationId() {
        return idNotificationId;
    }

    public void setIdNotificationId(Long atNotificationTemplatesId) {
        this.idNotificationId = atNotificationTemplatesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AtJobAppNotificationsDTO atJobAppNotificationsDTO = (AtJobAppNotificationsDTO) o;
        if(atJobAppNotificationsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atJobAppNotificationsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtJobAppNotificationsDTO{" +
            "id=" + getId() +
            ", dateSent='" + getDateSent() + "'" +
            ", isActive='" + getIsActive() + "'" +
            "}";
    }
}
