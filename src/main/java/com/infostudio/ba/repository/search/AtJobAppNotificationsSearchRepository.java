package com.infostudio.ba.repository.search;

import com.infostudio.ba.domain.AtJobAppNotifications;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the AtJobAppNotifications entity.
 */
public interface AtJobAppNotificationsSearchRepository extends ElasticsearchRepository<AtJobAppNotifications, Long> {
}
