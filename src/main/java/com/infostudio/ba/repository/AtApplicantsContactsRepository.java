package com.infostudio.ba.repository;

import com.infostudio.ba.domain.AtApplicantsContacts;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.util.List;


/**
 * Spring Data JPA repository for the AtApplicantsContacts entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AtApplicantsContactsRepository extends JpaRepository<AtApplicantsContacts, Long> {
    List<AtApplicantsContacts> findByIdApllicantId(Long id);
    AtApplicantsContacts findById(Long id);
}
