package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.AtApplicantsSchools;

import com.infostudio.ba.repository.AtApplicantsSchoolsRepository;
import com.infostudio.ba.repository.search.AtApplicantsSchoolsSearchRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.AtApplicantsSchoolsDTO;
import com.infostudio.ba.service.mapper.AtApplicantsSchoolsMapper;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing AtApplicantsSchools.
 */
@RestController
@RequestMapping("/api")
public class AtApplicantsSchoolsResource {

    private final Logger log = LoggerFactory.getLogger(AtApplicantsSchoolsResource.class);

    private static final String ENTITY_NAME = "atApplicantsSchools";

    private final AtApplicantsSchoolsRepository atApplicantsSchoolsRepository;

    private final AtApplicantsSchoolsMapper atApplicantsSchoolsMapper;

    private final AtApplicantsSchoolsSearchRepository atApplicantsSchoolsSearchRepository;

    public AtApplicantsSchoolsResource(AtApplicantsSchoolsRepository atApplicantsSchoolsRepository, AtApplicantsSchoolsMapper atApplicantsSchoolsMapper, AtApplicantsSchoolsSearchRepository atApplicantsSchoolsSearchRepository) {
        this.atApplicantsSchoolsRepository = atApplicantsSchoolsRepository;
        this.atApplicantsSchoolsMapper = atApplicantsSchoolsMapper;
        this.atApplicantsSchoolsSearchRepository = atApplicantsSchoolsSearchRepository;
    }

    /**
     * POST  /at-applicants-schools : Create a new atApplicantsSchools.
     *
     * @param atApplicantsSchoolsDTO the atApplicantsSchoolsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new atApplicantsSchoolsDTO, or with status 400 (Bad Request) if the atApplicantsSchools has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/at-applicants-schools")
    @Timed
    public ResponseEntity<AtApplicantsSchoolsDTO> createAtApplicantsSchools(@RequestBody AtApplicantsSchoolsDTO atApplicantsSchoolsDTO) throws URISyntaxException {
        log.debug("REST request to save AtApplicantsSchools : {}", atApplicantsSchoolsDTO);
        if (atApplicantsSchoolsDTO.getId() != null) {
            throw new BadRequestAlertException("A new atApplicantsSchools cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AtApplicantsSchools atApplicantsSchools = atApplicantsSchoolsMapper.toEntity(atApplicantsSchoolsDTO);
        atApplicantsSchools = atApplicantsSchoolsRepository.save(atApplicantsSchools);
        AtApplicantsSchoolsDTO result = atApplicantsSchoolsMapper.toDto(atApplicantsSchools);
        atApplicantsSchoolsSearchRepository.save(atApplicantsSchools);
        return ResponseEntity.created(new URI("/api/at-applicants-schools/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /at-applicants-schools : Updates an existing atApplicantsSchools.
     *
     * @param atApplicantsSchoolsDTO the atApplicantsSchoolsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated atApplicantsSchoolsDTO,
     * or with status 400 (Bad Request) if the atApplicantsSchoolsDTO is not valid,
     * or with status 500 (Internal Server Error) if the atApplicantsSchoolsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/at-applicants-schools")
    @Timed
    public ResponseEntity<AtApplicantsSchoolsDTO> updateAtApplicantsSchools(@RequestBody AtApplicantsSchoolsDTO atApplicantsSchoolsDTO) throws URISyntaxException {
        log.debug("REST request to update AtApplicantsSchools : {}", atApplicantsSchoolsDTO);
        if (atApplicantsSchoolsDTO.getId() == null) {
            return createAtApplicantsSchools(atApplicantsSchoolsDTO);
        }
        AtApplicantsSchools atApplicantsSchools = atApplicantsSchoolsMapper.toEntity(atApplicantsSchoolsDTO);
        atApplicantsSchools = atApplicantsSchoolsRepository.save(atApplicantsSchools);
        AtApplicantsSchoolsDTO result = atApplicantsSchoolsMapper.toDto(atApplicantsSchools);
        atApplicantsSchoolsSearchRepository.save(atApplicantsSchools);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, atApplicantsSchoolsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /at-applicants-schools : get all the atApplicantsSchools.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of atApplicantsSchools in body
     */
    @GetMapping("/at-applicants-schools")
    @Timed
    public ResponseEntity<List<AtApplicantsSchoolsDTO>> getAllAtApplicantsSchools(Pageable pageable) {
        log.debug("REST request to get a page of AtApplicantsSchools");
        Page<AtApplicantsSchools> page = atApplicantsSchoolsRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/at-applicants-schools");
        return new ResponseEntity<>(atApplicantsSchoolsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /at-applicants-schools/:id : get the "id" atApplicantsSchools.
     *
     * @param id the id of the atApplicantsSchoolsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the atApplicantsSchoolsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/at-applicants-schools/{id}")
    @Timed
    public ResponseEntity<AtApplicantsSchoolsDTO> getAtApplicantsSchools(@PathVariable Long id) {
        log.debug("REST request to get AtApplicantsSchools : {}", id);
        AtApplicantsSchools atApplicantsSchools = atApplicantsSchoolsRepository.findOne(id);
        AtApplicantsSchoolsDTO atApplicantsSchoolsDTO = atApplicantsSchoolsMapper.toDto(atApplicantsSchools);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atApplicantsSchoolsDTO));
    }

    /**
     * DELETE  /at-applicants-schools/:id : delete the "id" atApplicantsSchools.
     *
     * @param id the id of the atApplicantsSchoolsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/at-applicants-schools/{id}")
    @Timed
    public ResponseEntity<Void> deleteAtApplicantsSchools(@PathVariable Long id) {
        log.debug("REST request to delete AtApplicantsSchools : {}", id);
        atApplicantsSchoolsRepository.delete(id);
        atApplicantsSchoolsSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/at-applicants-schools?query=:query : search for the atApplicantsSchools corresponding
     * to the query.
     *
     * @param query the query of the atApplicantsSchools search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/at-applicants-schools")
    @Timed
    public ResponseEntity<List<AtApplicantsSchoolsDTO>> searchAtApplicantsSchools(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of AtApplicantsSchools for query {}", query);
        Page<AtApplicantsSchools> page = atApplicantsSchoolsSearchRepository.search(queryStringQuery(query), pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/at-applicants-schools");
        return new ResponseEntity<>(atApplicantsSchoolsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

}