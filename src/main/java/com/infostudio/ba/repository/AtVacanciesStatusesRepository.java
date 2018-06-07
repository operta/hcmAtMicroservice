package com.infostudio.ba.repository;

import com.infostudio.ba.domain.AtVacanciesStatuses;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the AtVacanciesStatuses entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AtVacanciesStatusesRepository extends JpaRepository<AtVacanciesStatuses, Long> {

}
