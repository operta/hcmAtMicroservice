package com.infostudio.ba.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A AtApplicantsSchools.
 */
@Entity
@Table(name = "at_applicants_schools")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AtApplicantsSchools extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "school")
    private String school;

    @Column(name = "date_from")
    private LocalDate dateFrom;

    @Column(name = "date_to")
    private LocalDate dateTo;

    @Column(name = "major")
    private String major;

    @Column(name = "degree")
    private String degree;

    @Column(name = "grade")
    private Integer grade;

    @Column(name = "description")
    private String description;

    @Column(name = "link")
    private String link;

    @Column(name = "id_qualification")
    private Integer idQualifcation;

    @Column(name = "id_school")
    private Integer idSchool;

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

    public String getSchool() {
        return school;
    }

    public AtApplicantsSchools school(String school) {
        this.school = school;
        return this;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public AtApplicantsSchools dateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
        return this;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public AtApplicantsSchools dateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
        return this;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public String getMajor() {
        return major;
    }

    public AtApplicantsSchools major(String major) {
        this.major = major;
        return this;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDegree() {
        return degree;
    }

    public AtApplicantsSchools degree(String degree) {
        this.degree = degree;
        return this;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Integer getGrade() {
        return grade;
    }

    public AtApplicantsSchools grade(Integer grade) {
        this.grade = grade;
        return this;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getDescription() {
        return description;
    }

    public AtApplicantsSchools description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public AtApplicantsSchools link(String link) {
        this.link = link;
        return this;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getIdQualifcation() {
        return idQualifcation;
    }

    public AtApplicantsSchools idQualifcation(Integer idQualifcation) {
        this.idQualifcation = idQualifcation;
        return this;
    }

    public void setIdQualifcation(Integer idQualifcation) {
        this.idQualifcation = idQualifcation;
    }

    public Integer getIdSchool() {
        return idSchool;
    }

    public AtApplicantsSchools idSchool(Integer idSchool) {
        this.idSchool = idSchool;
        return this;
    }

    public void setIdSchool(Integer idSchool) {
        this.idSchool = idSchool;
    }

    public AtApplicants getIdApplicant() {
        return idApplicant;
    }

    public AtApplicantsSchools idApplicant(AtApplicants atApplicants) {
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
        AtApplicantsSchools atApplicantsSchools = (AtApplicantsSchools) o;
        if (atApplicantsSchools.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atApplicantsSchools.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtApplicantsSchools{" +
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
