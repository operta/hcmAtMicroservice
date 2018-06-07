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
 * A AtJobAppNotifications.
 */
@Entity
@Table(name = "at_job_app_notifications")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "atjobappnotifications")
public class AtJobAppNotifications implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "date_sent", nullable = false)
    private LocalDate dateSent;

    @NotNull
    @Column(name = "is_active", nullable = false)
    private String isActive;

    @OneToOne
    @JoinColumn(name = "id_job_application")
    private AtJobApplications idJobApplication;

    @OneToOne
    @JoinColumn(name = "id_notification")
    private AtNotificationTemplates idNotification;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateSent() {
        return dateSent;
    }

    public AtJobAppNotifications dateSent(LocalDate dateSent) {
        this.dateSent = dateSent;
        return this;
    }

    public void setDateSent(LocalDate dateSent) {
        this.dateSent = dateSent;
    }

    public String getIsActive() {
        return isActive;
    }

    public AtJobAppNotifications isActive(String isActive) {
        this.isActive = isActive;
        return this;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public AtJobApplications getIdJobApplication() {
        return idJobApplication;
    }

    public AtJobAppNotifications idJobApplication(AtJobApplications atJobApplications) {
        this.idJobApplication = atJobApplications;
        return this;
    }

    public void setIdJobApplication(AtJobApplications atJobApplications) {
        this.idJobApplication = atJobApplications;
    }

    public AtNotificationTemplates getIdNotification() {
        return idNotification;
    }

    public AtJobAppNotifications idNotification(AtNotificationTemplates atNotificationTemplates) {
        this.idNotification = atNotificationTemplates;
        return this;
    }

    public void setIdNotification(AtNotificationTemplates atNotificationTemplates) {
        this.idNotification = atNotificationTemplates;
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
        AtJobAppNotifications atJobAppNotifications = (AtJobAppNotifications) o;
        if (atJobAppNotifications.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atJobAppNotifications.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtJobAppNotifications{" +
            "id=" + getId() +
            ", dateSent='" + getDateSent() + "'" +
            ", isActive='" + getIsActive() + "'" +
            "}";
    }
}
