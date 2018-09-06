package com.infostudio.ba.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A AtApplicantsExperience.
 */
@Entity
@Table(name = "at_applicant_experiences")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AtApplicantsExperience implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "company")
    private String company;

    @Column(name = "position")
    private String position;

    @Column(name = "location")
    private String location;

    @Column(name = "date_from")
    private LocalDate dateFrom;

    @Column(name = "date_to")
    private LocalDate dateTo;

    @Column(name = "ongoing")
    private String ongoing;

    @OneToOne
    @JoinColumn(name ="id_applicant")
    private AtApplicants atApplicants;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public AtApplicantsExperience company(String company) {
        this.company = company;
        return this;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public AtApplicantsExperience position(String position) {
        this.position = position;
        return this;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public AtApplicantsExperience location(String location) {
        this.location = location;
        return this;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public AtApplicantsExperience dateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
        return this;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public AtApplicantsExperience dateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
        return this;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public String getOngoing() {
        return ongoing;
    }

    public AtApplicantsExperience ongoing(String ongoing) {
        this.ongoing = ongoing;
        return this;
    }

    public void setOngoing(String ongoing) {
        this.ongoing = ongoing;
    }

    public AtApplicants getAtApplicants() {
        return atApplicants;
    }

    public AtApplicantsExperience atApplicants(AtApplicants atApplicants) {
        this.atApplicants = atApplicants;
        return this;
    }

    public void setAtApplicants(AtApplicants atApplicants) {
        this.atApplicants = atApplicants;
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
        AtApplicantsExperience atApplicantsExperience = (AtApplicantsExperience) o;
        if (atApplicantsExperience.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atApplicantsExperience.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtApplicantsExperience{" +
            "id=" + getId() +
            ", company='" + getCompany() + "'" +
            ", position='" + getPosition() + "'" +
            ", location='" + getLocation() + "'" +
            ", dateFrom='" + getDateFrom() + "'" +
            ", dateTo='" + getDateTo() + "'" +
            ", ongoing='" + getOngoing() + "'" +
            "}";
    }
}
