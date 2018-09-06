package com.infostudio.ba.repository;

import com.infostudio.ba.domain.AtApplicantAcc;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.util.List;


/**
 * Spring Data JPA repository for the AtApplicantAcc entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AtApplicantAccRepository extends JpaRepository<AtApplicantAcc, Long> {
    List<AtApplicantAcc> findByIdApplicantId(Long id);
    AtApplicantAcc findById(Long id);
}
