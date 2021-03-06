package com.infostudio.ba.repository;

import com.infostudio.ba.domain.AtApplicantsDocuments;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.util.List;


/**
 * Spring Data JPA repository for the AtApplicantsDocuments entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AtApplicantsDocumentsRepository extends JpaRepository<AtApplicantsDocuments, Long> {
    List<AtApplicantsDocuments> findByIdApplicantId(Long id);
    AtApplicantsDocuments findById(Long id);
}
