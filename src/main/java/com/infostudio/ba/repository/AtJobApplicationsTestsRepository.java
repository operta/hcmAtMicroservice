package com.infostudio.ba.repository;

import com.infostudio.ba.domain.AtJobApplicationsTests;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the AtJobApplicationsTests entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AtJobApplicationsTestsRepository extends JpaRepository<AtJobApplicationsTests, Long> {

}
