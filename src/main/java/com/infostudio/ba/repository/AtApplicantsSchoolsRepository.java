package com.infostudio.ba.repository;

import com.infostudio.ba.domain.AtApplicantsSchools;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the AtApplicantsSchools entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AtApplicantsSchoolsRepository extends JpaRepository<AtApplicantsSchools, Long> {

}