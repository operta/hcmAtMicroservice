package com.infostudio.ba.repository;

import com.infostudio.ba.domain.AtJAInt;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the AtJAInt entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AtJAIntRepository extends JpaRepository<AtJAInt, Long> {

}