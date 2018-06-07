package com.infostudio.ba.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Lob;

/**
 * A DTO for the AtNotificationTemplates entity.
 */
public class AtNotificationTemplatesDTO implements Serializable {

    private Long id;

    @NotNull
    private String code;

    private String subject;

    @Lob
    private String template;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AtNotificationTemplatesDTO atNotificationTemplatesDTO = (AtNotificationTemplatesDTO) o;
        if(atNotificationTemplatesDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atNotificationTemplatesDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtNotificationTemplatesDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", subject='" + getSubject() + "'" +
            ", template='" + getTemplate() + "'" +
            "}";
    }
}
