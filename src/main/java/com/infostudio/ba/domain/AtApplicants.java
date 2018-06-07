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
 * A AtApplicants.
 */
@Entity
@Table(name = "at_applicants")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "atapplicants")
public class AtApplicants extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "maiden_name")
    private String maidenName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "marital_status")
    private String materialStatus;

    @Column(name = "address")
    private String address;

    @Column(name = "employed")
    private String employed;

    @Column(name = "description")
    private String description;

    @Column(name = "employment_position")
    private String employementPosition;

    @Column(name = "industry")
    private String industry;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "image_link")
    private String imageLink;

    @Column(name = "id_city")
    private Integer idCity;

    @Column(name = "id_qualification")
    private Integer idQualifcation;

    @Column(name = "id_employee")
    private Integer idEmployee;

    @Column(name = "id_user")
    private Integer idUser;

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

    public AtApplicants name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public AtApplicants surname(String surname) {
        this.surname = surname;
        return this;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public AtApplicants middleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public AtApplicants maidenName(String maidenName) {
        this.maidenName = maidenName;
        return this;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public String getGender() {
        return gender;
    }

    public AtApplicants gender(String gender) {
        this.gender = gender;
        return this;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public AtApplicants birthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getMaterialStatus() {
        return materialStatus;
    }

    public AtApplicants materialStatus(String materialStatus) {
        this.materialStatus = materialStatus;
        return this;
    }

    public void setMaterialStatus(String materialStatus) {
        this.materialStatus = materialStatus;
    }

    public String getAddress() {
        return address;
    }

    public AtApplicants address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmployed() {
        return employed;
    }

    public AtApplicants employed(String employed) {
        this.employed = employed;
        return this;
    }

    public void setEmployed(String employed) {
        this.employed = employed;
    }

    public String getDescription() {
        return description;
    }

    public AtApplicants description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmployementPosition() {
        return employementPosition;
    }

    public AtApplicants employementPosition(String employementPosition) {
        this.employementPosition = employementPosition;
        return this;
    }

    public void setEmployementPosition(String employementPosition) {
        this.employementPosition = employementPosition;
    }

    public String getIndustry() {
        return industry;
    }

    public AtApplicants industry(String industry) {
        this.industry = industry;
        return this;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public AtApplicants phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public AtApplicants email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageLink() {
        return imageLink;
    }

    public AtApplicants imageLink(String imageLink) {
        this.imageLink = imageLink;
        return this;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Integer getIdCity() {
        return idCity;
    }

    public AtApplicants idCity(Integer idCity) {
        this.idCity = idCity;
        return this;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }

    public Integer getIdQualifcation() {
        return idQualifcation;
    }

    public AtApplicants idQualifcation(Integer idQualifcation) {
        this.idQualifcation = idQualifcation;
        return this;
    }

    public void setIdQualifcation(Integer idQualifcation) {
        this.idQualifcation = idQualifcation;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public AtApplicants idEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
        return this;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public AtApplicants idUser(Integer idUser) {
        this.idUser = idUser;
        return this;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
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
        AtApplicants atApplicants = (AtApplicants) o;
        if (atApplicants.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atApplicants.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtApplicants{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", surname='" + getSurname() + "'" +
            ", middleName='" + getMiddleName() + "'" +
            ", maidenName='" + getMaidenName() + "'" +
            ", gender='" + getGender() + "'" +
            ", birthdate='" + getBirthdate() + "'" +
            ", materialStatus='" + getMaterialStatus() + "'" +
            ", address='" + getAddress() + "'" +
            ", employed='" + getEmployed() + "'" +
            ", description='" + getDescription() + "'" +
            ", employementPosition='" + getEmployementPosition() + "'" +
            ", industry='" + getIndustry() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", email='" + getEmail() + "'" +
            ", imageLink='" + getImageLink() + "'" +
            ", idCity=" + getIdCity() +
            ", idQualifcation=" + getIdQualifcation() +
            ", idEmployee=" + getIdEmployee() +
            ", idUser=" + getIdUser() +
            "}";
    }
}
