package com.infostudio.ba.repository;

import com.infostudio.ba.domain.AtJobApplicationStatuses;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the AtJobApplicationStatuses entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AtJobApplicationStatusesRepository extends JpaRepository<AtJobApplicationStatuses, Long> {
    AtJobApplicationStatuses findByName(String name);
}
