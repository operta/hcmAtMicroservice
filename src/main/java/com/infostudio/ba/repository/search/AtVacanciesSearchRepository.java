package com.infostudio.ba.repository.search;

import com.infostudio.ba.domain.AtVacancies;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the AtVacancies entity.
 */
public interface AtVacanciesSearchRepository extends ElasticsearchRepository<AtVacancies, Long> {
}
