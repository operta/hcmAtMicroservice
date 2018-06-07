package com.infostudio.ba.repository.search;

import com.infostudio.ba.domain.AtApplicantsContacts;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the AtApplicantsContacts entity.
 */
public interface AtApplicantsContactsSearchRepository extends ElasticsearchRepository<AtApplicantsContacts, Long> {
}
