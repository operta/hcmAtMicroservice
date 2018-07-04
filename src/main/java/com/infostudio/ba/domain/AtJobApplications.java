package com.infostudio.ba.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A AtJobApplications.
 */
@Entity
@Table(name = "at_job_applications")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "atjobapplications")
public class AtJobApplications extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "grade")
    private Integer grade;

    @Lob
    @Column(name = "review")
    private String review;

    @NotNull
    @Column(name = "date_applied", nullable = false)
    private LocalDate dateApplied;

    @Column(name = "interview_grade")
    private Integer interviewGrade;

    @Column(name = "test_grade")
    private Integer testGrade;

    @OneToOne
    @JoinColumn(name = "applicantid")
    @NotFound(action = NotFoundAction.IGNORE)
    private AtApplicants applicantId;

    @OneToOne
    @JoinColumn(name = "id_status")
    private AtJobApplicationStatuses idStatus;

    @OneToOne
    @JoinColumn(name = "vacancyid")
    private AtVacancies vacancyId;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGrade() {
        return grade;
    }

    public AtJobApplications grade(Integer grade) {
        this.grade = grade;
        return this;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getReview() {
        return review;
    }

    public AtJobApplications review(String review) {
        this.review = review;
        return this;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public LocalDate getDateApplied() {
        return dateApplied;
    }

    public AtJobApplications dateApplied(LocalDate dateApplied) {
        this.dateApplied = dateApplied;
        return this;
    }

    public void setDateApplied(LocalDate dateApplied) {
        this.dateApplied = dateApplied;
    }

    public Integer getInterviewGrade() {
        return interviewGrade;
    }

    public AtJobApplications interviewGrade(Integer interviewGrade) {
        this.interviewGrade = interviewGrade;
        return this;
    }

    public void setInterviewGrade(Integer interviewGrade) {
        this.interviewGrade = interviewGrade;
    }

    public Integer getTestGrade() {
        return testGrade;
    }

    public AtJobApplications testGrade(Integer testGrade) {
        this.testGrade = testGrade;
        return this;
    }

    public void setTestGrade(Integer testGrade) {
        this.testGrade = testGrade;
    }

    public AtApplicants getApplicantId() {
        return applicantId;
    }

    public AtJobApplications applicantId(AtApplicants atApplicants) {
        this.applicantId = atApplicants;
        return this;
    }

    public void setApplicantId(AtApplicants atApplicants) {
        this.applicantId = atApplicants;
    }

    public AtJobApplicationStatuses getIdStatus() {
        return idStatus;
    }

    public AtJobApplications idStatus(AtJobApplicationStatuses atJobApplicationStatuses) {
        this.idStatus = atJobApplicationStatuses;
        return this;
    }

    public void setIdStatus(AtJobApplicationStatuses atJobApplicationStatuses) {
        this.idStatus = atJobApplicationStatuses;
    }

    public AtVacancies getVacancyId() {
        return vacancyId;
    }

    public AtJobApplications vacancyId(AtVacancies atVacancies) {
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
        AtJobApplications atJobApplications = (AtJobApplications) o;
        if (atJobApplications.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atJobApplications.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtJobApplications{" +
            "id=" + getId() +
            ", grade=" + getGrade() +
            ", review='" + getReview() + "'" +
            ", dateApplied='" + getDateApplied() + "'" +
            ", interviewGrade=" + getInterviewGrade() +
            ", testGrade=" + getTestGrade() +
            "}";
    }
}
