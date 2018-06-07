package com.infostudio.ba.service.dto;


import java.time.LocalDate;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import javax.persistence.Lob;

/**
 * A DTO for the AtJAInt entity.
 */
public class AtJAIntDTO implements Serializable {

    private Long id;

    private Integer grade;

    @Lob
    private String description;

    private Integer locationId;

    private LocalDate interviewDate;

    private Long jobApplicationIdId;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public LocalDate getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(LocalDate interviewDate) {
        this.interviewDate = interviewDate;
    }

    public Long getJobApplicationIdId() {
        return jobApplicationIdId;
    }

    public void setJobApplicationIdId(Long atJobApplicationsId) {
        this.jobApplicationIdId = atJobApplicationsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AtJAIntDTO atJAIntDTO = (AtJAIntDTO) o;
        if(atJAIntDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atJAIntDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtJAIntDTO{" +
            "id=" + getId() +
            ", grade=" + getGrade() +
            ", description='" + getDescription() + "'" +
            ", locationId=" + getLocationId() +
            ", interviewDate='" + getInterviewDate() + "'" +
            "}";
    }
}
