package com.infostudio.ba.repository;

import com.infostudio.ba.domain.AtActivityStatuses;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the AtActivityStatuses entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AtActivityStatusesRepository extends JpaRepository<AtActivityStatuses, Long> {

}
