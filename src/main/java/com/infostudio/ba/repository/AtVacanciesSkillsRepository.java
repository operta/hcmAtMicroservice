package com.infostudio.ba.repository;

import com.infostudio.ba.domain.AtVacanciesSkills;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the AtVacanciesSkills entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AtVacanciesSkillsRepository extends JpaRepository<AtVacanciesSkills, Long> {
    AtVacanciesSkills findById(Long id);
}
