package com.infostudio.ba.repository.search;

import com.infostudio.ba.domain.AtJAActivities;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the AtJAActivities entity.
 */
public interface AtJAActivitiesSearchRepository extends ElasticsearchRepository<AtJAActivities, Long> {
}
