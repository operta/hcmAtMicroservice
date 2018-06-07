package com.infostudio.ba.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.Objects;

/**
 * A AtVacanciesSkills.
 */
@Entity
@Table(name = "at_vacancies_skills")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "atvacanciesskills")
public class AtVacanciesSkills implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "skill_id", nullable = false)
    private Integer skillId;

    @NotNull
    @Column(name = "grade_id", nullable = false)
    private Integer gradeId;

    @OneToOne
    @JoinColumn(name = "vacancy_id")
    private AtVacancies vacancyId;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public AtVacanciesSkills skillId(Integer skillId) {
        this.skillId = skillId;
        return this;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public AtVacanciesSkills gradeId(Integer gradeId) {
        this.gradeId = gradeId;
        return this;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public AtVacancies getVacancyId() {
        return vacancyId;
    }

    public AtVacanciesSkills vacancyId(AtVacancies atVacancies) {
        this.vacancyId = atVacancies;
        return this;
    }

    public void setVacancyId(AtVacancies atVacancies) {
        this.vacancyId = atVacancies;
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
        AtVacanciesSkills atVacanciesSkills = (AtVacanciesSkills) o;
        if (atVacanciesSkills.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atVacanciesSkills.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtVacanciesSkills{" +
            "id=" + getId() +
            ", skillId=" + getSkillId() +
            ", gradeId=" + getGradeId() +
            "}";
    }
}
