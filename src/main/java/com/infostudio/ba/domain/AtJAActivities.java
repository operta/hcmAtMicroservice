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
 * A AtJAActivities.
 */
@Entity
@Table(name = "at_job_applications_activities")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "atjaactivities")
public class AtJAActivities implements Serializable {

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
    @Column(name = "date_activity", nullable = false)
    private LocalDate dateActivity;

    @OneToOne
    @JoinColumn(name = "id_activity")
    private AtActivities idActivity;

    @OneToOne
    @JoinColumn(name = "id_job_application")
    private AtJobApplications idJobApplication;

    @OneToOne
    @JoinColumn(name = "id_status")
    private AtActivityStatuses idStatus;

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

    public AtJAActivities grade(Integer grade) {
        this.grade = grade;
        return this;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getReview() {
        return review;
    }

    public AtJAActivities review(String review) {
        this.review = review;
        return this;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public LocalDate getDateActivity() {
        return dateActivity;
    }

    public AtJAActivities dateActivity(LocalDate dateActivity) {
        this.dateActivity = dateActivity;
        return this;
    }

    public void setDateActivity(LocalDate dateActivity) {
        this.dateActivity = dateActivity;
    }

    public AtActivities getIdActivity() {
        return idActivity;
    }

    public AtJAActivities idActivity(AtActivities atActivities) {
        this.idActivity = atActivities;
        return this;
    }

    public void setIdActivity(AtActivities atActivities) {
        this.idActivity = atActivities;
    }

    public AtJobApplications getIdJobApplication() {
        return idJobApplication;
    }

    public AtJAActivities idJobApplication(AtJobApplications atJobApplications) {
        this.idJobApplication = atJobApplications;
        return this;
    }

    public void setIdJobApplication(AtJobApplications atJobApplications) {
        this.idJobApplication = atJobApplications;
    }

    public AtActivityStatuses getIdStatus() {
        return idStatus;
    }

    public AtJAActivities idStatus(AtActivityStatuses atActivityStatuses) {
        this.idStatus = atActivityStatuses;
        return this;
    }

    public void setIdStatus(AtActivityStatuses atActivityStatuses) {
        this.idStatus = atActivityStatuses;
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
        AtJAActivities atJAActivities = (AtJAActivities) o;
        if (atJAActivities.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atJAActivities.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtJAActivities{" +
            "id=" + getId() +
            ", grade=" + getGrade() +
            ", review='" + getReview() + "'" +
            ", dateActivity='" + getDateActivity() + "'" +
            "}";
    }
}
