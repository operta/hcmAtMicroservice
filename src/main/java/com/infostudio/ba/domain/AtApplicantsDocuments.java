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
 * A AtApplicantsDocuments.
 */
@Entity
@Table(name = "aad")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "at_applicants_documents")
public class AtApplicantsDocuments implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "date_created")
    private LocalDate dateCreated;

    @Column(name = "valid_from")
    private LocalDate validFrom;

    @Column(name = "valid_to")
    private LocalDate validTo;

    @Column(name = "id_document_link")
    private Integer idDocumentLink;

    @Column(name = "id_document_type")
    private Integer idDocumentType;

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

    public String getName() {
        return name;
    }

    public AtApplicantsDocuments name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public AtApplicantsDocuments description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public AtApplicantsDocuments dateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public AtApplicantsDocuments validFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
        return this;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public AtApplicantsDocuments validTo(LocalDate validTo) {
        this.validTo = validTo;
        return this;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }

    public Integer getIdDocumentLink() {
        return idDocumentLink;
    }

    public AtApplicantsDocuments idDocumentLink(Integer idDocumentLink) {
        this.idDocumentLink = idDocumentLink;
        return this;
    }

    public void setIdDocumentLink(Integer idDocumentLink) {
        this.idDocumentLink = idDocumentLink;
    }

    public Integer getIdDocumentType() {
        return idDocumentType;
    }

    public AtApplicantsDocuments idDocumentType(Integer idDocumentType) {
        this.idDocumentType = idDocumentType;
        return this;
    }

    public void setIdDocumentType(Integer idDocumentType) {
        this.idDocumentType = idDocumentType;
    }

    public AtApplicants getIdApplicant() {
        return idApplicant;
    }

    public AtApplicantsDocuments idApplicant(AtApplicants atApplicants) {
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
        AtApplicantsDocuments atApplicantsDocuments = (AtApplicantsDocuments) o;
        if (atApplicantsDocuments.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atApplicantsDocuments.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtApplicantsDocuments{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", dateCreated='" + getDateCreated() + "'" +
            ", validFrom='" + getValidFrom() + "'" +
            ", validTo='" + getValidTo() + "'" +
            ", idDocumentLink=" + getIdDocumentLink() +
            ", idDocumentType=" + getIdDocumentType() +
            "}";
    }
}
