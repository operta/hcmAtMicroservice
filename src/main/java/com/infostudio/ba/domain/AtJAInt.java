package com.infostudio.ba.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A AtJAInt.
 */
@Entity
@Table(name = "at_job_applications_interviews")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "atjaint")
public class AtJAInt extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "grade")
    private Integer grade;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "location_id")
    private Integer locationId;

    @Column(name = "interview_date")
    private LocalDate interviewDate;

    @OneToOne
    @JoinColumn(name = "job_application_id")
    private AtJobApplications jobApplicationId;

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

    public AtJAInt grade(Integer grade) {
        this.grade = grade;
        return this;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getDescription() {
        return description;
    }

    public AtJAInt description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public AtJAInt locationId(Integer locationId) {
        this.locationId = locationId;
        return this;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public LocalDate getInterviewDate() {
        return interviewDate;
    }

    public AtJAInt interviewDate(LocalDate interviewDate) {
        this.interviewDate = interviewDate;
        return this;
    }

    public void setInterviewDate(LocalDate interviewDate) {
        this.interviewDate = interviewDate;
    }

    public AtJobApplications getJobApplicationId() {
        return jobApplicationId;
    }

    public AtJAInt jobApplicationId(AtJobApplications atJobApplications) {
        this.jobApplicationId = atJobApplications;
        return this;
    }

    public void setJobApplicationId(AtJobApplications atJobApplications) {
        this.jobApplicationId = atJobApplications;
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
        AtJAInt atJAInt = (AtJAInt) o;
        if (atJAInt.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atJAInt.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtJAInt{" +
            "id=" + getId() +
            ", grade=" + getGrade() +
            ", description='" + getDescription() + "'" +
            ", locationId=" + getLocationId() +
            ", interviewDate='" + getInterviewDate() + "'" +
            "}";
    }
}
