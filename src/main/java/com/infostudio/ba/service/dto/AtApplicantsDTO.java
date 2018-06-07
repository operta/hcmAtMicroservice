package com.infostudio.ba.service.dto;


import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the AtApplicants entity.
 */
public class AtApplicantsDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    private String surname;

    private String middleName;

    private String maidenName;

    private String gender;

    private LocalDate birthdate;

    private String materialStatus;

    private String address;

    private String employed;

    private String description;

    private String employementPosition;

    private String industry;

    private String phoneNumber;

    private String email;

    private String imageLink;

    private Integer idCity;

    private Integer idQualifcation;

    private Integer idEmployee;

    private Integer idUser;

    private String createdBy;

    private Instant createdAt;

    private String updatedBy;

    private Instant updatedAt;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getMaterialStatus() {
        return materialStatus;
    }

    public void setMaterialStatus(String materialStatus) {
        this.materialStatus = materialStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmployed() {
        return employed;
    }

    public void setEmployed(String employed) {
        this.employed = employed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmployementPosition() {
        return employementPosition;
    }

    public void setEmployementPosition(String employementPosition) {
        this.employementPosition = employementPosition;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Integer getIdCity() {
        return idCity;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }

    public Integer getIdQualifcation() {
        return idQualifcation;
    }

    public void setIdQualifcation(Integer idQualifcation) {
        this.idQualifcation = idQualifcation;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AtApplicantsDTO atApplicantsDTO = (AtApplicantsDTO) o;
        if(atApplicantsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atApplicantsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AtApplicantsDTO{" +
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
