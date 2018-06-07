package com.infostudio.ba.repository;

import com.infostudio.ba.domain.AtVacancies;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the AtVacancies entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AtVacanciesRepository extends JpaRepository<AtVacancies, Long> {

}
