package com.infostudio.ba.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;


import java.io.Serializable;
import java.util.Objects;

/**
 * A AtNotificationTemplates.
 */
@Entity
@Table(name = "at_notification_templates")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AtNotificationTemplates extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "subject")
    private String subject;

    @Lob
    @Column(name = "template")
    private String template;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public AtNotificationTemplates code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSubject() {
        return subject;
    }

    public AtNotificationTemplates subject(String subject) {
        this.subject = subject;
        return this;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTemplate() {
        return template;
    }

    public AtNotificationTemplates template(String template) {
        this.template = template;
        return this;
    }

    public void setTemplate(String template) {
        this.template = template;
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
        AtNotificationTemplates atNotificationTemplates = (AtNotificationTemplates) o;
        if (atNotificationTemplates.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atNotificationTemplates.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtNotificationTemplates{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", subject='" + getSubject() + "'" +
            ", template='" + getTemplate() + "'" +
            "}";
    }
}
