package com.infostudio.ba.repository;

import com.infostudio.ba.domain.AtApplicantsExperience;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the AtApplicantsExperience entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AtApplicantsExperienceRepository extends JpaRepository<AtApplicantsExperience, Long> {

}
