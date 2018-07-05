package com.infostudio.ba.repository.search;

import com.infostudio.ba.domain.AtApplicantsExperience;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the AtApplicantsExperience entity.
 */
public interface AtApplicantsExperienceSearchRepository extends ElasticsearchRepository<AtApplicantsExperience, Long> {
}
