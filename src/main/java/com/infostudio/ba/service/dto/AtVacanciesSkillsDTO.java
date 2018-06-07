package com.infostudio.ba.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the AtVacanciesSkills entity.
 */
public class AtVacanciesSkillsDTO implements Serializable {

    private Long id;

    @NotNull
    private Integer skillId;

    @NotNull
    private Integer gradeId;

    private Long vacancyIdId;

    private String vacancyIdName;

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

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
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

        AtVacanciesSkillsDTO atVacanciesSkillsDTO = (AtVacanciesSkillsDTO) o;
        if(atVacanciesSkillsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atVacanciesSkillsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtVacanciesSkillsDTO{" +
            "id=" + getId() +
            ", skillId=" + getSkillId() +
            ", gradeId=" + getGradeId() +
            "}";
    }
}
