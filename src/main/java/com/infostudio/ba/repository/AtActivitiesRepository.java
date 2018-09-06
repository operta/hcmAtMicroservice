package com.infostudio.ba.repository;

import com.infostudio.ba.domain.AtActivities;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the AtActivities entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AtActivitiesRepository extends JpaRepository<AtActivities, Long> {
    AtActivities findById(Long id);
}
