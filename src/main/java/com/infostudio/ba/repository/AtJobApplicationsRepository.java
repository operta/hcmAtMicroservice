package com.infostudio.ba.repository;

import com.infostudio.ba.domain.AtJobApplications;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.util.List;


/**
 * Spring Data JPA repository for the AtJobApplications entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AtJobApplicationsRepository extends JpaRepository<AtJobApplications, Long> {
    List<AtJobApplications> findByVacancyIdId(long id);
}
