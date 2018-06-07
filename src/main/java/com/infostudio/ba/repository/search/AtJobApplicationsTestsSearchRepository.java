package com.infostudio.ba.repository.search;

import com.infostudio.ba.domain.AtJobApplicationsTests;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the AtJobApplicationsTests entity.
 */
public interface AtJobApplicationsTestsSearchRepository extends ElasticsearchRepository<AtJobApplicationsTests, Long> {
}
