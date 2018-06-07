package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.AtJobApplicationsTests;

import com.infostudio.ba.repository.AtJobApplicationsTestsRepository;
import com.infostudio.ba.repository.search.AtJobApplicationsTestsSearchRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.AtJobApplicationsTestsDTO;
import com.infostudio.ba.service.mapper.AtJobApplicationsTestsMapper;
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
 * REST controller for managing AtJobApplicationsTests.
 */
@RestController
@RequestMapping("/api")
public class AtJobApplicationsTestsResource {

    private final Logger log = LoggerFactory.getLogger(AtJobApplicationsTestsResource.class);

    private static final String ENTITY_NAME = "atJobApplicationsTests";

    private final AtJobApplicationsTestsRepository atJobApplicationsTestsRepository;

    private final AtJobApplicationsTestsMapper atJobApplicationsTestsMapper;

    private final AtJobApplicationsTestsSearchRepository atJobApplicationsTestsSearchRepository;

    public AtJobApplicationsTestsResource(AtJobApplicationsTestsRepository atJobApplicationsTestsRepository, AtJobApplicationsTestsMapper atJobApplicationsTestsMapper, AtJobApplicationsTestsSearchRepository atJobApplicationsTestsSearchRepository) {
        this.atJobApplicationsTestsRepository = atJobApplicationsTestsRepository;
        this.atJobApplicationsTestsMapper = atJobApplicationsTestsMapper;
        this.atJobApplicationsTestsSearchRepository = atJobApplicationsTestsSearchRepository;
    }

    /**
     * POST  /at-job-applications-tests : Create a new atJobApplicationsTests.
     *
     * @param atJobApplicationsTestsDTO the atJobApplicationsTestsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new atJobApplicationsTestsDTO, or with status 400 (Bad Request) if the atJobApplicationsTests has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/at-job-applications-tests")
    @Timed
    public ResponseEntity<AtJobApplicationsTestsDTO> createAtJobApplicationsTests(@RequestBody AtJobApplicationsTestsDTO atJobApplicationsTestsDTO) throws URISyntaxException {
        log.debug("REST request to save AtJobApplicationsTests : {}", atJobApplicationsTestsDTO);
        if (atJobApplicationsTestsDTO.getId() != null) {
            throw new BadRequestAlertException("A new atJobApplicationsTests cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AtJobApplicationsTests atJobApplicationsTests = atJobApplicationsTestsMapper.toEntity(atJobApplicationsTestsDTO);
        atJobApplicationsTests = atJobApplicationsTestsRepository.save(atJobApplicationsTests);
        AtJobApplicationsTestsDTO result = atJobApplicationsTestsMapper.toDto(atJobApplicationsTests);
        atJobApplicationsTestsSearchRepository.save(atJobApplicationsTests);
        return ResponseEntity.created(new URI("/api/at-job-applications-tests/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /at-job-applications-tests : Updates an existing atJobApplicationsTests.
     *
     * @param atJobApplicationsTestsDTO the atJobApplicationsTestsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated atJobApplicationsTestsDTO,
     * or with status 400 (Bad Request) if the atJobApplicationsTestsDTO is not valid,
     * or with status 500 (Internal Server Error) if the atJobApplicationsTestsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/at-job-applications-tests")
    @Timed
    public ResponseEntity<AtJobApplicationsTestsDTO> updateAtJobApplicationsTests(@RequestBody AtJobApplicationsTestsDTO atJobApplicationsTestsDTO) throws URISyntaxException {
        log.debug("REST request to update AtJobApplicationsTests : {}", atJobApplicationsTestsDTO);
        if (atJobApplicationsTestsDTO.getId() == null) {
            return createAtJobApplicationsTests(atJobApplicationsTestsDTO);
        }
        AtJobApplicationsTests atJobApplicationsTests = atJobApplicationsTestsMapper.toEntity(atJobApplicationsTestsDTO);
        atJobApplicationsTests = atJobApplicationsTestsRepository.save(atJobApplicationsTests);
        AtJobApplicationsTestsDTO result = atJobApplicationsTestsMapper.toDto(atJobApplicationsTests);
        atJobApplicationsTestsSearchRepository.save(atJobApplicationsTests);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, atJobApplicationsTestsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /at-job-applications-tests : get all the atJobApplicationsTests.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of atJobApplicationsTests in body
     */
    @GetMapping("/at-job-applications-tests")
    @Timed
    public ResponseEntity<List<AtJobApplicationsTestsDTO>> getAllAtJobApplicationsTests(Pageable pageable) {
        log.debug("REST request to get a page of AtJobApplicationsTests");
        Page<AtJobApplicationsTests> page = atJobApplicationsTestsRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/at-job-applications-tests");
        return new ResponseEntity<>(atJobApplicationsTestsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /at-job-applications-tests/:id : get the "id" atJobApplicationsTests.
     *
     * @param id the id of the atJobApplicationsTestsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the atJobApplicationsTestsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/at-job-applications-tests/{id}")
    @Timed
    public ResponseEntity<AtJobApplicationsTestsDTO> getAtJobApplicationsTests(@PathVariable Long id) {
        log.debug("REST request to get AtJobApplicationsTests : {}", id);
        AtJobApplicationsTests atJobApplicationsTests = atJobApplicationsTestsRepository.findOne(id);
        AtJobApplicationsTestsDTO atJobApplicationsTestsDTO = atJobApplicationsTestsMapper.toDto(atJobApplicationsTests);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atJobApplicationsTestsDTO));
    }

    /**
     * DELETE  /at-job-applications-tests/:id : delete the "id" atJobApplicationsTests.
     *
     * @param id the id of the atJobApplicationsTestsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/at-job-applications-tests/{id}")
    @Timed
    public ResponseEntity<Void> deleteAtJobApplicationsTests(@PathVariable Long id) {
        log.debug("REST request to delete AtJobApplicationsTests : {}", id);
        atJobApplicationsTestsRepository.delete(id);
        atJobApplicationsTestsSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/at-job-applications-tests?query=:query : search for the atJobApplicationsTests corresponding
     * to the query.
     *
     * @param query the query of the atJobApplicationsTests search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/at-job-applications-tests")
    @Timed
    public ResponseEntity<List<AtJobApplicationsTestsDTO>> searchAtJobApplicationsTests(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of AtJobApplicationsTests for query {}", query);
        Page<AtJobApplicationsTests> page = atJobApplicationsTestsSearchRepository.search(queryStringQuery(query), pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/at-job-applications-tests");
        return new ResponseEntity<>(atJobApplicationsTestsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

}
