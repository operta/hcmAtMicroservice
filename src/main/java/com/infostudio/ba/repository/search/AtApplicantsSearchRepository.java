package com.infostudio.ba.repository.search;

import com.infostudio.ba.domain.AtApplicants;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the AtApplicants entity.
 */
public interface AtApplicantsSearchRepository extends ElasticsearchRepository<AtApplicants, Long> {
}
