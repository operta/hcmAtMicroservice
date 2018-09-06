package com.infostudio.ba.repository;

import java.util.List;

import com.infostudio.ba.domain.AtJobApplicantHistory;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the AtJobApplicantHistory entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AtJobApplicantHistoryRepository extends JpaRepository<AtJobApplicantHistory, Long> {
    List<AtJobApplicantHistory> findByIdJobApplicationId(Long id);
    AtJobApplicantHistory findById(Long id);
}
