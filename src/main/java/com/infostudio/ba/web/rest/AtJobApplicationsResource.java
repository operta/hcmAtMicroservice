package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.AtJobApplications;

import com.infostudio.ba.repository.AtJobApplicationsRepository;
import com.infostudio.ba.repository.search.AtJobApplicationsSearchRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.AtJobApplicationsDTO;
import com.infostudio.ba.service.mapper.AtJobApplicationsMapper;
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
 * REST controller for managing AtJobApplications.
 */
@RestController
@RequestMapping("/api")
public class AtJobApplicationsResource {

    private final Logger log = LoggerFactory.getLogger(AtJobApplicationsResource.class);

    private static final String ENTITY_NAME = "atJobApplications";

    private final AtJobApplicationsRepository atJobApplicationsRepository;

    private final AtJobApplicationsMapper atJobApplicationsMapper;

    private final AtJobApplicationsSearchRepository atJobApplicationsSearchRepository;

    public AtJobApplicationsResource(AtJobApplicationsRepository atJobApplicationsRepository, AtJobApplicationsMapper atJobApplicationsMapper, AtJobApplicationsSearchRepository atJobApplicationsSearchRepository) {
        this.atJobApplicationsRepository = atJobApplicationsRepository;
        this.atJobApplicationsMapper = atJobApplicationsMapper;
        this.atJobApplicationsSearchRepository = atJobApplicationsSearchRepository;
    }

    /**
     * POST  /at-job-applications : Create a new atJobApplications.
     *
     * @param atJobApplicationsDTO the atJobApplicationsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new atJobApplicationsDTO, or with status 400 (Bad Request) if the atJobApplications has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/at-job-applications")
    @Timed
    public ResponseEntity<AtJobApplicationsDTO> createAtJobApplications(@Valid @RequestBody AtJobApplicationsDTO atJobApplicationsDTO) throws URISyntaxException {
        log.debug("REST request to save AtJobApplications : {}", atJobApplicationsDTO);
        if (atJobApplicationsDTO.getId() != null) {
            throw new BadRequestAlertException("A new atJobApplications cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AtJobApplications atJobApplications = atJobApplicationsMapper.toEntity(atJobApplicationsDTO);
        atJobApplications = atJobApplicationsRepository.save(atJobApplications);
        AtJobApplicationsDTO result = atJobApplicationsMapper.toDto(atJobApplications);
        atJobApplicationsSearchRepository.save(atJobApplications);
        return ResponseEntity.created(new URI("/api/at-job-applications/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /at-job-applications : Updates an existing atJobApplications.
     *
     * @param atJobApplicationsDTO the atJobApplicationsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated atJobApplicationsDTO,
     * or with status 400 (Bad Request) if the atJobApplicationsDTO is not valid,
     * or with status 500 (Internal Server Error) if the atJobApplicationsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/at-job-applications")
    @Timed
    public ResponseEntity<AtJobApplicationsDTO> updateAtJobApplications(@Valid @RequestBody AtJobApplicationsDTO atJobApplicationsDTO) throws URISyntaxException {
        log.debug("REST request to update AtJobApplications : {}", atJobApplicationsDTO);
        if (atJobApplicationsDTO.getId() == null) {
            return createAtJobApplications(atJobApplicationsDTO);
        }
        AtJobApplications atJobApplications = atJobApplicationsMapper.toEntity(atJobApplicationsDTO);
        atJobApplications = atJobApplicationsRepository.save(atJobApplications);
        AtJobApplicationsDTO result = atJobApplicationsMapper.toDto(atJobApplications);
        atJobApplicationsSearchRepository.save(atJobApplications);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, atJobApplicationsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /at-job-applications : get all the atJobApplications.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of atJobApplications in body
     */
    @GetMapping("/at-job-applications")
    @Timed
    public ResponseEntity<List<AtJobApplicationsDTO>> getAllAtJobApplications(Pageable pageable) {
        log.debug("REST request to get a page of AtJobApplications");
        Page<AtJobApplications> page = atJobApplicationsRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/at-job-applications");
        return new ResponseEntity<>(atJobApplicationsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /at-job-applications/:id : get the "id" atJobApplications.
     *
     * @param id the id of the atJobApplicationsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the atJobApplicationsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/at-job-applications/{id}")
    @Timed
    public ResponseEntity<AtJobApplicationsDTO> getAtJobApplications(@PathVariable Long id) {
        log.debug("REST request to get AtJobApplications : {}", id);
        AtJobApplications atJobApplications = atJobApplicationsRepository.findOne(id);
        AtJobApplicationsDTO atJobApplicationsDTO = atJobApplicationsMapper.toDto(atJobApplications);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atJobApplicationsDTO));
    }

    /**
     * DELETE  /at-job-applications/:id : delete the "id" atJobApplications.
     *
     * @param id the id of the atJobApplicationsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/at-job-applications/{id}")
    @Timed
    public ResponseEntity<Void> deleteAtJobApplications(@PathVariable Long id) {
        log.debug("REST request to delete AtJobApplications : {}", id);
        atJobApplicationsRepository.delete(id);
        atJobApplicationsSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/at-job-applications?query=:query : search for the atJobApplications corresponding
     * to the query.
     *
     * @param query the query of the atJobApplications search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/at-job-applications")
    @Timed
    public ResponseEntity<List<AtJobApplicationsDTO>> searchAtJobApplications(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of AtJobApplications for query {}", query);
        Page<AtJobApplications> page = atJobApplicationsSearchRepository.search(queryStringQuery(query), pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/at-job-applications");
        return new ResponseEntity<>(atJobApplicationsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

}
