package com.infostudio.ba.service.dto;


import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import javax.persistence.Lob;

/**
 * A DTO for the AtJAActivities entity.
 */
public class AtJAActivitiesDTO implements Serializable {

    private Long id;

    private Integer grade;

    @Lob
    private String review;

    @NotNull
    private LocalDate dateActivity;

    private Long idActivityId;

    private String idActivityName;

    private Long idJobApplicationId;

    private Long idStatusId;

    private String idStatusName;

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

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public LocalDate getDateActivity() {
        return dateActivity;
    }

    public void setDateActivity(LocalDate dateActivity) {
        this.dateActivity = dateActivity;
    }

    public Long getIdActivityId() {
        return idActivityId;
    }

    public void setIdActivityId(Long atActivitiesId) {
        this.idActivityId = atActivitiesId;
    }

    public String getIdActivityName() {
        return idActivityName;
    }

    public void setIdActivityName(String atActivitiesName) {
        this.idActivityName = atActivitiesName;
    }

    public Long getIdJobApplicationId() {
        return idJobApplicationId;
    }

    public void setIdJobApplicationId(Long atJobApplicationsId) {
        this.idJobApplicationId = atJobApplicationsId;
    }

    public Long getIdStatusId() {
        return idStatusId;
    }

    public void setIdStatusId(Long atActivityStatusesId) {
        this.idStatusId = atActivityStatusesId;
    }

    public String getIdStatusName() {
        return idStatusName;
    }

    public void setIdStatusName(String atActivityStatusesName) {
        this.idStatusName = atActivityStatusesName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AtJAActivitiesDTO atJAActivitiesDTO = (AtJAActivitiesDTO) o;
        if(atJAActivitiesDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atJAActivitiesDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtJAActivitiesDTO{" +
            "id=" + getId() +
            ", grade=" + getGrade() +
            ", review='" + getReview() + "'" +
            ", dateActivity='" + getDateActivity() + "'" +
            "}";
    }
}
