package com.infostudio.ba.repository.search;

import com.infostudio.ba.domain.AtNotificationTemplates;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the AtNotificationTemplates entity.
 */
public interface AtNotificationTemplatesSearchRepository extends ElasticsearchRepository<AtNotificationTemplates, Long> {
}
