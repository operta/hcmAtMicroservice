package com.infostudio.ba.repository;

import com.infostudio.ba.domain.AtApplicantsSkills;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the AtApplicantsSkills entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AtApplicantsSkillsRepository extends JpaRepository<AtApplicantsSkills, Long> {

}
