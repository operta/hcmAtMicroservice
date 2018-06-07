package com.infostudio.ba.repository.search;

import com.infostudio.ba.domain.AtJAInt;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the AtJAInt entity.
 */
public interface AtJAIntSearchRepository extends ElasticsearchRepository<AtJAInt, Long> {
}
