package com.infostudio.ba.service.dto;


import java.time.Instant;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the AtApplicantsSkills entity.
 */
public class AtApplicantsSkillsDTO implements Serializable {

    private Long id;

    private String skill;

    private Instant dateSkill;

    private String grade;

    private Integer idSkill;

    private Integer idGrade;

    private Long idApplicantId;

    private String idApplicantSurname;

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

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Instant getDateSkill() {
        return dateSkill;
    }

    public void setDateSkill(Instant dateSkill) {
        this.dateSkill = dateSkill;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(Integer idSkill) {
        this.idSkill = idSkill;
    }

    public Integer getIdGrade() {
        return idGrade;
    }

    public void setIdGrade(Integer idGrade) {
        this.idGrade = idGrade;
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

        AtApplicantsSkillsDTO atApplicantsSkillsDTO = (AtApplicantsSkillsDTO) o;
        if(atApplicantsSkillsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atApplicantsSkillsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtApplicantsSkillsDTO{" +
            "id=" + getId() +
            ", skill='" + getSkill() + "'" +
            ", dateSkill='" + getDateSkill() + "'" +
            ", grade='" + getGrade() + "'" +
            ", idSkill=" + getIdSkill() +
            ", idGrade=" + getIdGrade() +
            "}";
    }
}
