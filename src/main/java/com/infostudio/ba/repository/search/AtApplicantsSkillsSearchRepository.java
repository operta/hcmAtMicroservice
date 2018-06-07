package com.infostudio.ba.repository.search;

import com.infostudio.ba.domain.AtApplicantsSkills;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the AtApplicantsSkills entity.
 */
public interface AtApplicantsSkillsSearchRepository extends ElasticsearchRepository<AtApplicantsSkills, Long> {
}
