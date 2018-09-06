package com.infostudio.ba.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A AtJobApplicationsTests.
 */
@Entity
@Table(name = "at_job_applications_tests")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AtJobApplicationsTests extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "score")
    private Integer score;

    @Column(name = "location_id")
    private Integer locationId;

    @Column(name = "test_date")
    private LocalDate testDate;

    @Column(name = "review")
    private String review;

    @Column(name = "short_description")
    private String shortDescription;

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

    public Integer getScore() {
        return score;
    }

    public AtJobApplicationsTests score(Integer score) {
        this.score = score;
        return this;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public AtJobApplicationsTests locationId(Integer locationId) {
        this.locationId = locationId;
        return this;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public LocalDate getTestDate() {
        return testDate;
    }

    public AtJobApplicationsTests testDate(LocalDate testDate) {
        this.testDate = testDate;
        return this;
    }

    public void setTestDate(LocalDate testDate) {
        this.testDate = testDate;
    }

    public String getReview() {
        return review;
    }

    public AtJobApplicationsTests review(String review) {
        this.review = review;
        return this;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public AtJobApplicationsTests shortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public AtJobApplications getJobApplicationId() {
        return jobApplicationId;
    }

    public AtJobApplicationsTests jobApplicationId(AtJobApplications atJobApplications) {
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
        AtJobApplicationsTests atJobApplicationsTests = (AtJobApplicationsTests) o;
        if (atJobApplicationsTests.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atJobApplicationsTests.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtJobApplicationsTests{" +
            "id=" + getId() +
            ", score=" + getScore() +
            ", jobApplicationId=" + getJobApplicationId() +
            ", locationId=" + getLocationId() +
            ", testDate='" + getTestDate() + "'" +
            ", review='" + getReview() + "'" +
            ", shortDescription='" + getShortDescription() + "'" +
            "}";
    }
}
