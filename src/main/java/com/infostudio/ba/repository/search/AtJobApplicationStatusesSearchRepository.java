package com.infostudio.ba.repository.search;

import com.infostudio.ba.domain.AtJobApplicationStatuses;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the AtJobApplicationStatuses entity.
 */
public interface AtJobApplicationStatusesSearchRepository extends ElasticsearchRepository<AtJobApplicationStatuses, Long> {
}
