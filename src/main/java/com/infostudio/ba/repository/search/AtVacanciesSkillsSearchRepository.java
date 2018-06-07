package com.infostudio.ba.repository.search;

import com.infostudio.ba.domain.AtVacanciesSkills;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the AtVacanciesSkills entity.
 */
public interface AtVacanciesSkillsSearchRepository extends ElasticsearchRepository<AtVacanciesSkills, Long> {
}
