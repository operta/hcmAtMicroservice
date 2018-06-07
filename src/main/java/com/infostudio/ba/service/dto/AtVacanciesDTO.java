package com.infostudio.ba.service.dto;


import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Lob;

/**
 * A DTO for the AtVacancies entity.
 */
public class AtVacanciesDTO implements Serializable {

    private Long id;

    @NotNull
    private String code;

    @NotNull
    private String name;

    @Lob
    private String description;

    private LocalDate dateFrom;

    private LocalDate dateTo;

    private Integer status;

    private String jobRole;

    private String jobWorkingTime;

    @Lob
    private String skillsRequirement;

    private String languageRequirement;

    private String educationRequirement;

    @Lob
    private String experienceRequirement;

    private Integer idLocation;

    private Integer idWorkPlace;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getJobWorkingTime() {
        return jobWorkingTime;
    }

    public void setJobWorkingTime(String jobWorkingTime) {
        this.jobWorkingTime = jobWorkingTime;
    }

    public String getSkillsRequirement() {
        return skillsRequirement;
    }

    public void setSkillsRequirement(String skillsRequirement) {
        this.skillsRequirement = skillsRequirement;
    }

    public String getLanguageRequirement() {
        return languageRequirement;
    }

    public void setLanguageRequirement(String languageRequirement) {
        this.languageRequirement = languageRequirement;
    }

    public String getEducationRequirement() {
        return educationRequirement;
    }

    public void setEducationRequirement(String educationRequirement) {
        this.educationRequirement = educationRequirement;
    }

    public String getExperienceRequirement() {
        return experienceRequirement;
    }

    public void setExperienceRequirement(String experienceRequirement) {
        this.experienceRequirement = experienceRequirement;
    }

    public Integer getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Integer idLocation) {
        this.idLocation = idLocation;
    }

    public Integer getIdWorkPlace() {
        return idWorkPlace;
    }

    public void setIdWorkPlace(Integer idWorkPlace) {
        this.idWorkPlace = idWorkPlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AtVacanciesDTO atVacanciesDTO = (AtVacanciesDTO) o;
        if(atVacanciesDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atVacanciesDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtVacanciesDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", dateFrom='" + getDateFrom() + "'" +
            ", dateTo='" + getDateTo() + "'" +
            ", status=" + getStatus() +
            ", jobRole='" + getJobRole() + "'" +
            ", jobWorkingTime='" + getJobWorkingTime() + "'" +
            ", skillsRequirement='" + getSkillsRequirement() + "'" +
            ", languageRequirement='" + getLanguageRequirement() + "'" +
            ", educationRequirement='" + getEducationRequirement() + "'" +
            ", experienceRequirement='" + getExperienceRequirement() + "'" +
            ", idLocation=" + getIdLocation() +
            ", idWorkPlace=" + getIdWorkPlace() +
            "}";
    }
}
