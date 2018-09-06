package com.infostudio.ba.repository;

import com.infostudio.ba.domain.AtNotificationTemplates;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the AtNotificationTemplates entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AtNotificationTemplatesRepository extends JpaRepository<AtNotificationTemplates, Long> {
    AtNotificationTemplates findById(Long id);
}
