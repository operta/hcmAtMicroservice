package com.infostudio.ba.service.dto;


import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import javax.persistence.Lob;

/**
 * A DTO for the AtJobApplications entity.
 */
public class AtJobApplicationsDTO implements Serializable {

    private Long id;

    private Integer grade;

    @Lob
    private String review;

    @NotNull
    private LocalDate dateApplied;

    private Integer interviewGrade;

    private Integer testGrade;

    private Long applicantIdId;

    private String applicantIdSurname;

    private Long idStatusId;

    private String idStatusName;

    private Long vacancyIdId;

    private String vacancyIdName;

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

    public LocalDate getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(LocalDate dateApplied) {
        this.dateApplied = dateApplied;
    }

    public Integer getInterviewGrade() {
        return interviewGrade;
    }

    public void setInterviewGrade(Integer interviewGrade) {
        this.interviewGrade = interviewGrade;
    }

    public Integer getTestGrade() {
        return testGrade;
    }

    public void setTestGrade(Integer testGrade) {
        this.testGrade = testGrade;
    }

    public Long getApplicantIdId() {
        return applicantIdId;
    }

    public void setApplicantIdId(Long atApplicantsId) {
        this.applicantIdId = atApplicantsId;
    }

    public String getApplicantIdSurname() {
        return applicantIdSurname;
    }

    public void setApplicantIdSurname(String atApplicantsSurname) {
        this.applicantIdSurname = atApplicantsSurname;
    }

    public Long getIdStatusId() {
        return idStatusId;
    }

    public void setIdStatusId(Long atJobApplicationStatusesId) {
        this.idStatusId = atJobApplicationStatusesId;
    }

    public String getIdStatusName() {
        return idStatusName;
    }

    public void setIdStatusName(String atJobApplicationStatusesName) {
        this.idStatusName = atJobApplicationStatusesName;
    }

    public Long getVacancyIdId() {
        return vacancyIdId;
    }

    public void setVacancyIdId(Long atVacanciesId) {
        this.vacancyIdId = atVacanciesId;
    }

    public String getVacancyIdName() {
        return vacancyIdName;
    }

    public void setVacancyIdName(String atVacanciesName) {
        this.vacancyIdName = atVacanciesName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AtJobApplicationsDTO atJobApplicationsDTO = (AtJobApplicationsDTO) o;
        if(atJobApplicationsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atJobApplicationsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtJobApplicationsDTO{" +
            "id=" + getId() +
            ", grade=" + getGrade() +
            ", review='" + getReview() + "'" +
            ", dateApplied='" + getDateApplied() + "'" +
            ", interviewGrade=" + getInterviewGrade() +
            ", testGrade=" + getTestGrade() +
            "}";
    }
}
