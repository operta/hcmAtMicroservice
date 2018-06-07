package com.infostudio.ba.repository.search;

import com.infostudio.ba.domain.AtJobApplicantHistory;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the AtJobApplicantHistory entity.
 */
public interface AtJobApplicantHistorySearchRepository extends ElasticsearchRepository<AtJobApplicantHistory, Long> {
}
