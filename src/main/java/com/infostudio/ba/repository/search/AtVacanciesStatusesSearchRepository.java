package com.infostudio.ba.repository.search;

import com.infostudio.ba.domain.AtVacanciesStatuses;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the AtVacanciesStatuses entity.
 */
public interface AtVacanciesStatusesSearchRepository extends ElasticsearchRepository<AtVacanciesStatuses, Long> {
}
