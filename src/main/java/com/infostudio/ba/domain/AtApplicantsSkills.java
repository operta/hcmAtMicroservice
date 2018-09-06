package com.infostudio.ba.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A AtApplicantsSkills.
 */
@Entity
@Table(name = "at_applicants_skills")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AtApplicantsSkills extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "skill")
    private String skill;

    @Column(name = "date_skill")
    private Instant dateSkill;

    @Column(name = "grade")
    private String grade;

    @Column(name = "id_skill")
    private Integer idSkill;

    @Column(name = "id_grade")
    private Integer idGrade;

    @OneToOne
    @JoinColumn(name = "id_applicant")
    private AtApplicants idApplicant;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public AtApplicantsSkills skill(String skill) {
        this.skill = skill;
        return this;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Instant getDateSkill() {
        return dateSkill;
    }

    public AtApplicantsSkills dateSkill(Instant dateSkill) {
        this.dateSkill = dateSkill;
        return this;
    }

    public void setDateSkill(Instant dateSkill) {
        this.dateSkill = dateSkill;
    }

    public String getGrade() {
        return grade;
    }

    public AtApplicantsSkills grade(String grade) {
        this.grade = grade;
        return this;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getIdSkill() {
        return idSkill;
    }

    public AtApplicantsSkills idSkill(Integer idSkill) {
        this.idSkill = idSkill;
        return this;
    }

    public void setIdSkill(Integer idSkill) {
        this.idSkill = idSkill;
    }

    public Integer getIdGrade() {
        return idGrade;
    }

    public AtApplicantsSkills idGrade(Integer idGrade) {
        this.idGrade = idGrade;
        return this;
    }

    public void setIdGrade(Integer idGrade) {
        this.idGrade = idGrade;
    }

    public AtApplicants getIdApplicant() {
        return idApplicant;
    }

    public AtApplicantsSkills idApplicant(AtApplicants atApplicants) {
        this.idApplicant = atApplicants;
        return this;
    }

    public void setIdApplicant(AtApplicants atApplicants) {
        this.idApplicant = atApplicants;
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
        AtApplicantsSkills atApplicantsSkills = (AtApplicantsSkills) o;
        if (atApplicantsSkills.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atApplicantsSkills.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtApplicantsSkills{" +
            "id=" + getId() +
            ", skill='" + getSkill() + "'" +
            ", dateSkill='" + getDateSkill() + "'" +
            ", grade='" + getGrade() + "'" +
            ", idSkill=" + getIdSkill() +
            ", idGrade=" + getIdGrade() +
            "}";
    }
}
