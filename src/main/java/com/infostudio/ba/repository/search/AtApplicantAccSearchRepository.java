package com.infostudio.ba.repository.search;

import com.infostudio.ba.domain.AtApplicantAcc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the AtApplicantAcc entity.
 */
public interface AtApplicantAccSearchRepository extends ElasticsearchRepository<AtApplicantAcc, Long> {
}
