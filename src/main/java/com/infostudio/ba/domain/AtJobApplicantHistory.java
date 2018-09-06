package com.infostudio.ba.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A AtJobApplicantHistory.
 */
@Entity
@Table(name = "at_job_application_history")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AtJobApplicantHistory extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_status_from")
    private AtJobApplicationStatuses idStatusFrom;

    @OneToOne
    @JoinColumn(name = "id_status_to")
    private AtJobApplicationStatuses idStatusTo;

    @OneToOne
    @JoinColumn(name = "id_job_application")
    private AtJobApplications idJobApplication;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AtJobApplicationStatuses getIdStatusFrom() {
        return idStatusFrom;
    }

    public AtJobApplicantHistory idStatusFrom(AtJobApplicationStatuses atJobApplicationStatuses) {
        this.idStatusFrom = atJobApplicationStatuses;
        return this;
    }

    public void setIdStatusFrom(AtJobApplicationStatuses atJobApplicationStatuses) {
        this.idStatusFrom = atJobApplicationStatuses;
    }

    public AtJobApplicationStatuses getIdStatusTo() {
        return idStatusTo;
    }

    public AtJobApplicantHistory idStatusTo(AtJobApplicationStatuses atJobApplicationStatuses) {
        this.idStatusTo = atJobApplicationStatuses;
        return this;
    }

    public void setIdStatusTo(AtJobApplicationStatuses atJobApplicationStatuses) {
        this.idStatusTo = atJobApplicationStatuses;
    }

    public AtJobApplications getIdJobApplication() {
        return idJobApplication;
    }

    public AtJobApplicantHistory idJobApplication(AtJobApplications atJobApplications) {
        this.idJobApplication = atJobApplications;
        return this;
    }

    public void setIdJobApplication(AtJobApplications atJobApplications) {
        this.idJobApplication = atJobApplications;
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
        AtJobApplicantHistory atJobApplicantHistory = (AtJobApplicantHistory) o;
        if (atJobApplicantHistory.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atJobApplicantHistory.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtJobApplicantHistory{" +
            "id=" + getId() +
            "}";
    }
}
