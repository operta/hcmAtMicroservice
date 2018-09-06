package com.infostudio.ba.repository;

import com.infostudio.ba.domain.AtJAActivities;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the AtJAActivities entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AtJAActivitiesRepository extends JpaRepository<AtJAActivities, Long> {
    AtJAActivities findById(Long id);
}
