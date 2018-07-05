package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.AtApplicantsDocuments;

import com.infostudio.ba.repository.AtApplicantsDocumentsRepository;
import com.infostudio.ba.repository.search.AtApplicantsDocumentsSearchRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.AtApplicantsDocumentsDTO;
import com.infostudio.ba.service.mapper.AtApplicantsDocumentsMapper;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing AtApplicantsDocuments.
 */
@RestController
@RequestMapping("/api")
public class AtApplicantsDocumentsResource {

    private final Logger log = LoggerFactory.getLogger(AtApplicantsDocumentsResource.class);

    private static final String ENTITY_NAME = "atApplicantsDocuments";

    private final AtApplicantsDocumentsRepository atApplicantsDocumentsRepository;

    private final AtApplicantsDocumentsMapper atApplicantsDocumentsMapper;

    private final AtApplicantsDocumentsSearchRepository atApplicantsDocumentsSearchRepository;

    public AtApplicantsDocumentsResource(AtApplicantsDocumentsRepository atApplicantsDocumentsRepository, AtApplicantsDocumentsMapper atApplicantsDocumentsMapper, AtApplicantsDocumentsSearchRepository atApplicantsDocumentsSearchRepository) {
        this.atApplicantsDocumentsRepository = atApplicantsDocumentsRepository;
        this.atApplicantsDocumentsMapper = atApplicantsDocumentsMapper;
        this.atApplicantsDocumentsSearchRepository = atApplicantsDocumentsSearchRepository;
    }

    /**
     * POST  /at-applicants-documents : Create a new atApplicantsDocuments.
     *
     * @param atApplicantsDocumentsDTO the atApplicantsDocumentsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new atApplicantsDocumentsDTO, or with status 400 (Bad Request) if the atApplicantsDocuments has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/at-applicants-documents")
    @Timed
    public ResponseEntity<AtApplicantsDocumentsDTO> createAtApplicantsDocuments(@Valid @RequestBody AtApplicantsDocumentsDTO atApplicantsDocumentsDTO) throws URISyntaxException {
        log.debug("REST request to save AtApplicantsDocuments : {}", atApplicantsDocumentsDTO);
        if (atApplicantsDocumentsDTO.getId() != null) {
            throw new BadRequestAlertException("A new atApplicantsDocuments cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AtApplicantsDocuments atApplicantsDocuments = atApplicantsDocumentsMapper.toEntity(atApplicantsDocumentsDTO);
        atApplicantsDocuments = atApplicantsDocumentsRepository.save(atApplicantsDocuments);
        AtApplicantsDocumentsDTO result = atApplicantsDocumentsMapper.toDto(atApplicantsDocuments);
        atApplicantsDocumentsSearchRepository.save(atApplicantsDocuments);
        return ResponseEntity.created(new URI("/api/at-applicants-documents/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /at-applicants-documents : Updates an existing atApplicantsDocuments.
     *
     * @param atApplicantsDocumentsDTO the atApplicantsDocumentsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated atApplicantsDocumentsDTO,
     * or with status 400 (Bad Request) if the atApplicantsDocumentsDTO is not valid,
     * or with status 500 (Internal Server Error) if the atApplicantsDocumentsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/at-applicants-documents")
    @Timed
    public ResponseEntity<AtApplicantsDocumentsDTO> updateAtApplicantsDocuments(@Valid @RequestBody AtApplicantsDocumentsDTO atApplicantsDocumentsDTO) throws URISyntaxException {
        log.debug("REST request to update AtApplicantsDocuments : {}", atApplicantsDocumentsDTO);
        if (atApplicantsDocumentsDTO.getId() == null) {
            return createAtApplicantsDocuments(atApplicantsDocumentsDTO);
        }
        AtApplicantsDocuments atApplicantsDocuments = atApplicantsDocumentsMapper.toEntity(atApplicantsDocumentsDTO);
        atApplicantsDocuments = atApplicantsDocumentsRepository.save(atApplicantsDocuments);
        AtApplicantsDocumentsDTO result = atApplicantsDocumentsMapper.toDto(atApplicantsDocuments);
        atApplicantsDocumentsSearchRepository.save(atApplicantsDocuments);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, atApplicantsDocumentsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /at-applicants-documents : get all the atApplicantsDocuments.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of atApplicantsDocuments in body
     */
    @GetMapping("/at-applicants-documents")
    @Timed
    public ResponseEntity<List<AtApplicantsDocumentsDTO>> getAllAtApplicantsDocuments(Pageable pageable) {
        log.debug("REST request to get a page of AtApplicantsDocuments");
        Page<AtApplicantsDocuments> page = atApplicantsDocumentsRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/at-applicants-documents");
        return new ResponseEntity<>(atApplicantsDocumentsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /at-applicants-documents/:id : get the "id" atApplicantsDocuments.
     *
     * @param id the id of the atApplicantsDocumentsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the atApplicantsDocumentsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/at-applicants-documents/{id}")
    @Timed
    public ResponseEntity<AtApplicantsDocumentsDTO> getAtApplicantsDocuments(@PathVariable Long id) {
        log.debug("REST request to get AtApplicantsDocuments : {}", id);
        AtApplicantsDocuments atApplicantsDocuments = atApplicantsDocumentsRepository.findOne(id);
        AtApplicantsDocumentsDTO atApplicantsDocumentsDTO = atApplicantsDocumentsMapper.toDto(atApplicantsDocuments);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atApplicantsDocumentsDTO));
    }

    @GetMapping("/at-applicants-documents/applicant/{id}")
    @Timed
    public ResponseEntity<List<AtApplicantsDocumentsDTO>> getAtApplicantsDocumentsByAppId(@PathVariable Long id) {
        log.debug("REST request to get AtApplicantsDocuments by Applicant Id : {}", id);
        List<AtApplicantsDocuments> atApplicantsDocuments = atApplicantsDocumentsRepository.findByIdApplicantId(id);
        List<AtApplicantsDocumentsDTO> atApplicantsDocumentsDTO = atApplicantsDocumentsMapper.toDto(atApplicantsDocuments);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atApplicantsDocumentsDTO));
    }

    /**
     * DELETE  /at-applicants-documents/:id : delete the "id" atApplicantsDocuments.
     *
     * @param id the id of the atApplicantsDocumentsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/at-applicants-documents/{id}")
    @Timed
    public ResponseEntity<Void> deleteAtApplicantsDocuments(@PathVariable Long id) {
        log.debug("REST request to delete AtApplicantsDocuments : {}", id);
        atApplicantsDocumentsRepository.delete(id);
        atApplicantsDocumentsSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/at-applicants-documents?query=:query : search for the atApplicantsDocuments corresponding
     * to the query.
     *
     * @param query the query of the atApplicantsDocuments search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/at-applicants-documents")
    @Timed
    public ResponseEntity<List<AtApplicantsDocumentsDTO>> searchAtApplicantsDocuments(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of AtApplicantsDocuments for query {}", query);
        Page<AtApplicantsDocuments> page = atApplicantsDocumentsSearchRepository.search(queryStringQuery(query), pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/at-applicants-documents");
        return new ResponseEntity<>(atApplicantsDocumentsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

}
