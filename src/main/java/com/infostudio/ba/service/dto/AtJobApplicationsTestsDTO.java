package com.infostudio.ba.service.dto;


import java.time.LocalDate;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the AtJobApplicationsTests entity.
 */
public class AtJobApplicationsTestsDTO implements Serializable {

    private Long id;

    private Integer score;

    private Integer locationId;

    private LocalDate testDate;

    private String review;

    private String shortDescription;

    private Long jobApplicationIdId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public LocalDate getTestDate() {
        return testDate;
    }

    public void setTestDate(LocalDate testDate) {
        this.testDate = testDate;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
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

        AtJobApplicationsTestsDTO atJobApplicationsTestsDTO = (AtJobApplicationsTestsDTO) o;
        if(atJobApplicationsTestsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atJobApplicationsTestsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtJobApplicationsTestsDTO{" +
            "id=" + getId() +
            ", score=" + getScore() +
            ", locationId=" + getLocationId() +
            ", testDate='" + getTestDate() + "'" +
            ", review='" + getReview() + "'" +
            ", shortDescription='" + getShortDescription() + "'" +
            "}";
    }
}
