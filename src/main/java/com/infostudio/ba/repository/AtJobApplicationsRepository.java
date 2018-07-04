package com.infostudio.ba.repository;

import com.infostudio.ba.domain.AtJobApplications;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.util.List;


/**
 * Spring Data JPA repository for the AtJobApplications entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AtJobApplicationsRepository extends JpaRepository<AtJobApplications, Long> {
    List<AtJobApplications> findByVacancyIdId(long id);


    @Query("SELECT COUNT(at.id) FROM AtJobApplications at WHERE at.applicantId.id=:atId AND at.vacancyId.id=:vId")
    Integer findIfExistsByApplicantAndVacancy(@Param("atId") Long appId, @Param("vId") Long vacId);

}
