package com.infostudio.ba.repository.search;

import com.infostudio.ba.domain.AtJobApplications;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the AtJobApplications entity.
 */
public interface AtJobApplicationsSearchRepository extends ElasticsearchRepository<AtJobApplications, Long> {
}
