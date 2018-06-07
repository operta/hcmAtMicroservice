package com.infostudio.ba.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A AtVacancies.
 */
@Entity
@Table(name = "at_vacancies")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "atvacancies")
public class AtVacancies implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "date_from")
    private LocalDate dateFrom;

    @Column(name = "date_to")
    private LocalDate dateTo;

    @Column(name = "status")
    private Integer status;

    @Column(name = "job_role")
    private String jobRole;

    @Column(name = "job_working_time")
    private String jobWorkingTime;

    @Lob
    @Column(name = "skills_requirement")
    private String skillsRequirement;

    @Column(name = "language_requirement")
    private String languageRequirement;

    @Column(name = "education_requirement")
    private String educationRequirement;

    @Lob
    @Column(name = "experience_requirement")
    private String experienceRequirement;

    @Column(name = "id_location")
    private Integer idLocation;

    @Column(name = "id_work_place")
    private Integer idWorkPlace;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public AtVacancies code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public AtVacancies name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public AtVacancies description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public AtVacancies dateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
        return this;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public AtVacancies dateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
        return this;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public Integer getStatus() {
        return status;
    }

    public AtVacancies status(Integer status) {
        this.status = status;
        return this;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getJobRole() {
        return jobRole;
    }

    public AtVacancies jobRole(String jobRole) {
        this.jobRole = jobRole;
        return this;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getJobWorkingTime() {
        return jobWorkingTime;
    }

    public AtVacancies jobWorkingTime(String jobWorkingTime) {
        this.jobWorkingTime = jobWorkingTime;
        return this;
    }

    public void setJobWorkingTime(String jobWorkingTime) {
        this.jobWorkingTime = jobWorkingTime;
    }

    public String getSkillsRequirement() {
        return skillsRequirement;
    }

    public AtVacancies skillsRequirement(String skillsRequirement) {
        this.skillsRequirement = skillsRequirement;
        return this;
    }

    public void setSkillsRequirement(String skillsRequirement) {
        this.skillsRequirement = skillsRequirement;
    }

    public String getLanguageRequirement() {
        return languageRequirement;
    }

    public AtVacancies languageRequirement(String languageRequirement) {
        this.languageRequirement = languageRequirement;
        return this;
    }

    public void setLanguageRequirement(String languageRequirement) {
        this.languageRequirement = languageRequirement;
    }

    public String getEducationRequirement() {
        return educationRequirement;
    }

    public AtVacancies educationRequirement(String educationRequirement) {
        this.educationRequirement = educationRequirement;
        return this;
    }

    public void setEducationRequirement(String educationRequirement) {
        this.educationRequirement = educationRequirement;
    }

    public String getExperienceRequirement() {
        return experienceRequirement;
    }

    public AtVacancies experienceRequirement(String experienceRequirement) {
        this.experienceRequirement = experienceRequirement;
        return this;
    }

    public void setExperienceRequirement(String experienceRequirement) {
        this.experienceRequirement = experienceRequirement;
    }

    public Integer getIdLocation() {
        return idLocation;
    }

    public AtVacancies idLocation(Integer idLocation) {
        this.idLocation = idLocation;
        return this;
    }

    public void setIdLocation(Integer idLocation) {
        this.idLocation = idLocation;
    }

    public Integer getIdWorkPlace() {
        return idWorkPlace;
    }

    public AtVacancies idWorkPlace(Integer idWorkPlace) {
        this.idWorkPlace = idWorkPlace;
        return this;
    }

    public void setIdWorkPlace(Integer idWorkPlace) {
        this.idWorkPlace = idWorkPlace;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AtVacancies atVacancies = (AtVacancies) o;
        if (atVacancies.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atVacancies.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtVacancies{" +
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
