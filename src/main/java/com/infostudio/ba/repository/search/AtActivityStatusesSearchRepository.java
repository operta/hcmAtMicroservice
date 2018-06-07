package com.infostudio.ba.repository.search;

import com.infostudio.ba.domain.AtActivityStatuses;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the AtActivityStatuses entity.
 */
public interface AtActivityStatusesSearchRepository extends ElasticsearchRepository<AtActivityStatuses, Long> {
}
