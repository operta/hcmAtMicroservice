package com.infostudio.ba.repository;

import com.infostudio.ba.domain.AtApplicants;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.time.LocalDate;
import java.util.List;


/**
 * Spring Data JPA repository for the AtApplicants entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AtApplicantsRepository extends JpaRepository<AtApplicants, Long> {
    AtApplicants findByIdUser(Integer id);
}
