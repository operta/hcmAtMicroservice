package com.infostudio.ba.repository;

import com.infostudio.ba.domain.AtVacancies;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.time.LocalDate;
import java.util.List;


/**
 * Spring Data JPA repository for the AtVacancies entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AtVacanciesRepository extends JpaRepository<AtVacancies, Long> {
    List<AtVacancies> findByDateFromGreaterThanEqual(LocalDate fromDate);
    List<AtVacancies> findByDateToLessThanEqual(LocalDate toDate);
    List<AtVacancies> findByNameContainingIgnoreCase(String name);
    List<AtVacancies> findByStatus(Integer id);
    List<AtVacancies> findByIdLocation(Integer id);

    AtVacancies findById(Long id);
}
