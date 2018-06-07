package com.infostudio.ba.repository.search;

import com.infostudio.ba.domain.AtApplicantsSchools;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the AtApplicantsSchools entity.
 */
public interface AtApplicantsSchoolsSearchRepository extends ElasticsearchRepository<AtApplicantsSchools, Long> {
}
