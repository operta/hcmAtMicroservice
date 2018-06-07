package com.infostudio.ba.repository.search;

import com.infostudio.ba.domain.AtApplicantsDocuments;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the AtApplicantsDocuments entity.
 */
public interface AtApplicantsDocumentsSearchRepository extends ElasticsearchRepository<AtApplicantsDocuments, Long> {
}
