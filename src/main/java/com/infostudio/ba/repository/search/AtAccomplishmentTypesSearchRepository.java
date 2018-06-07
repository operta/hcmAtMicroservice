package com.infostudio.ba.repository.search;

import com.infostudio.ba.domain.AtAccomplishmentTypes;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the AtAccomplishmentTypes entity.
 */
public interface AtAccomplishmentTypesSearchRepository extends ElasticsearchRepository<AtAccomplishmentTypes, Long> {
}
