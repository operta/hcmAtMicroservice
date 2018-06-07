package com.infostudio.ba.repository.search;

import com.infostudio.ba.domain.AtActivities;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the AtActivities entity.
 */
public interface AtActivitiesSearchRepository extends ElasticsearchRepository<AtActivities, Long> {
}
