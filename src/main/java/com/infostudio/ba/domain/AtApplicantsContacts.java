package com.infostudio.ba.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.Objects;

/**
 * A AtApplicantsContacts.
 */
@Entity
@Table(name = "at_applicants_contacts")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "atapplicantscontacts")
public class AtApplicantsContacts implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "contact", nullable = false)
    private String contact;

    @Column(name = "description")
    private String description;

    @Column(name = "id_contact_type")
    private Integer idContactType;

    @OneToOne
    @JoinColumn(name = "id_applicant")
    private AtApplicants idApllicant;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public AtApplicantsContacts contact(String contact) {
        this.contact = contact;
        return this;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDescription() {
        return description;
    }

    public AtApplicantsContacts description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIdContactType() {
        return idContactType;
    }

    public AtApplicantsContacts idContactType(Integer idContactType) {
        this.idContactType = idContactType;
        return this;
    }

    public void setIdContactType(Integer idContactType) {
        this.idContactType = idContactType;
    }

    public AtApplicants getIdApllicant() {
        return idApllicant;
    }

    public AtApplicantsContacts idApllicant(AtApplicants atApplicants) {
        this.idApllicant = atApplicants;
        return this;
    }

    public void setIdApllicant(AtApplicants atApplicants) {
        this.idApllicant = atApplicants;
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
        AtApplicantsContacts atApplicantsContacts = (AtApplicantsContacts) o;
        if (atApplicantsContacts.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atApplicantsContacts.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtApplicantsContacts{" +
            "id=" + getId() +
            ", contact='" + getContact() + "'" +
            ", description='" + getDescription() + "'" +
            ", idContactType=" + getIdContactType() +
            "}";
    }
}
