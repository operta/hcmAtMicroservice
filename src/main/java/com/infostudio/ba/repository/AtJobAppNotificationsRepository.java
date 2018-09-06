package com.infostudio.ba.repository;

import com.infostudio.ba.domain.AtJobAppNotifications;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the AtJobAppNotifications entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AtJobAppNotificationsRepository extends JpaRepository<AtJobAppNotifications, Long> {
    AtJobAppNotifications findById(Long id);
}
