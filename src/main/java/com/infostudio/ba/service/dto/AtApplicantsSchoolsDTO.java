package com.infostudio.ba.service.dto;


import java.time.LocalDate;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the AtApplicantsSchools entity.
 */
public class AtApplicantsSchoolsDTO implements Serializable {

    private Long id;

    private String school;

    private LocalDate dateFrom;

    private LocalDate dateTo;

    private String major;

    private String degree;

    private Integer grade;

    private String description;

    private String link;

    private Integer idQualifcation;

    private Integer idSchool;

    private Long idApplicantId;

    private String idApplicantSurname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getIdQualifcation() {
        return idQualifcation;
    }

    public void setIdQualifcation(Integer idQualifcation) {
        this.idQualifcation = idQualifcation;
    }

    public Integer getIdSchool() {
        return idSchool;
    }

    public void setIdSchool(Integer idSchool) {
        this.idSchool = idSchool;
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

        AtApplicantsSchoolsDTO atApplicantsSchoolsDTO = (AtApplicantsSchoolsDTO) o;
        if(atApplicantsSchoolsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atApplicantsSchoolsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtApplicantsSchoolsDTO{" +
            "id=" + getId() +
            ", school='" + getSchool() + "'" +
            ", dateFrom='" + getDateFrom() + "'" +
            ", dateTo='" + getDateTo() + "'" +
            ", major='" + getMajor() + "'" +
            ", degree='" + getDegree() + "'" +
            ", grade=" + getGrade() +
            ", description='" + getDescription() + "'" +
            ", link='" + getLink() + "'" +
            ", idQualifcation=" + getIdQualifcation() +
            ", idSchool=" + getIdSchool() +
            "}";
    }
}
