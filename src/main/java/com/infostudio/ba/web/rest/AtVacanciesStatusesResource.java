package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.AtVacanciesStatuses;

import com.infostudio.ba.repository.AtVacanciesStatusesRepository;
import com.infostudio.ba.repository.search.AtVacanciesStatusesSearchRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.AtVacanciesStatusesDTO;
import com.infostudio.ba.service.mapper.AtVacanciesStatusesMapper;
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
 * REST controller for managing AtVacanciesStatuses.
 */
@RestController
@RequestMapping("/api")
public class AtVacanciesStatusesResource {

    private final Logger log = LoggerFactory.getLogger(AtVacanciesStatusesResource.class);

    private static final String ENTITY_NAME = "atVacanciesStatuses";

    private final AtVacanciesStatusesRepository atVacanciesStatusesRepository;

    private final AtVacanciesStatusesMapper atVacanciesStatusesMapper;

    private final AtVacanciesStatusesSearchRepository atVacanciesStatusesSearchRepository;

    public AtVacanciesStatusesResource(AtVacanciesStatusesRepository atVacanciesStatusesRepository, AtVacanciesStatusesMapper atVacanciesStatusesMapper, AtVacanciesStatusesSearchRepository atVacanciesStatusesSearchRepository) {
        this.atVacanciesStatusesRepository = atVacanciesStatusesRepository;
        this.atVacanciesStatusesMapper = atVacanciesStatusesMapper;
        this.atVacanciesStatusesSearchRepository = atVacanciesStatusesSearchRepository;
    }

    /**
     * POST  /at-vacancies-statuses : Create a new atVacanciesStatuses.
     *
     * @param atVacanciesStatusesDTO the atVacanciesStatusesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new atVacanciesStatusesDTO, or with status 400 (Bad Request) if the atVacanciesStatuses has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/at-vacancies-statuses")
    @Timed
    public ResponseEntity<AtVacanciesStatusesDTO> createAtVacanciesStatuses(@RequestBody AtVacanciesStatusesDTO atVacanciesStatusesDTO) throws URISyntaxException {
        log.debug("REST request to save AtVacanciesStatuses : {}", atVacanciesStatusesDTO);
        if (atVacanciesStatusesDTO.getId() != null) {
            throw new BadRequestAlertException("A new atVacanciesStatuses cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AtVacanciesStatuses atVacanciesStatuses = atVacanciesStatusesMapper.toEntity(atVacanciesStatusesDTO);
        atVacanciesStatuses = atVacanciesStatusesRepository.save(atVacanciesStatuses);
        AtVacanciesStatusesDTO result = atVacanciesStatusesMapper.toDto(atVacanciesStatuses);
        atVacanciesStatusesSearchRepository.save(atVacanciesStatuses);
        return ResponseEntity.created(new URI("/api/at-vacancies-statuses/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /at-vacancies-statuses : Updates an existing atVacanciesStatuses.
     *
     * @param atVacanciesStatusesDTO the atVacanciesStatusesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated atVacanciesStatusesDTO,
     * or with status 400 (Bad Request) if the atVacanciesStatusesDTO is not valid,
     * or with status 500 (Internal Server Error) if the atVacanciesStatusesDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/at-vacancies-statuses")
    @Timed
    public ResponseEntity<AtVacanciesStatusesDTO> updateAtVacanciesStatuses(@RequestBody AtVacanciesStatusesDTO atVacanciesStatusesDTO) throws URISyntaxException {
        log.debug("REST request to update AtVacanciesStatuses : {}", atVacanciesStatusesDTO);
        if (atVacanciesStatusesDTO.getId() == null) {
            return createAtVacanciesStatuses(atVacanciesStatusesDTO);
        }
        AtVacanciesStatuses atVacanciesStatuses = atVacanciesStatusesMapper.toEntity(atVacanciesStatusesDTO);
        atVacanciesStatuses = atVacanciesStatusesRepository.save(atVacanciesStatuses);
        AtVacanciesStatusesDTO result = atVacanciesStatusesMapper.toDto(atVacanciesStatuses);
        atVacanciesStatusesSearchRepository.save(atVacanciesStatuses);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, atVacanciesStatusesDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /at-vacancies-statuses : get all the atVacanciesStatuses.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of atVacanciesStatuses in body
     */
    @GetMapping("/at-vacancies-statuses")
    @Timed
    public ResponseEntity<List<AtVacanciesStatusesDTO>> getAllAtVacanciesStatuses(Pageable pageable) {
        log.debug("REST request to get a page of AtVacanciesStatuses");
        Page<AtVacanciesStatuses> page = atVacanciesStatusesRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/at-vacancies-statuses");
        return new ResponseEntity<>(atVacanciesStatusesMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /at-vacancies-statuses/:id : get the "id" atVacanciesStatuses.
     *
     * @param id the id of the atVacanciesStatusesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the atVacanciesStatusesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/at-vacancies-statuses/{id}")
    @Timed
    public ResponseEntity<AtVacanciesStatusesDTO> getAtVacanciesStatuses(@PathVariable Long id) {
        log.debug("REST request to get AtVacanciesStatuses : {}", id);
        AtVacanciesStatuses atVacanciesStatuses = atVacanciesStatusesRepository.findOne(id);
        AtVacanciesStatusesDTO atVacanciesStatusesDTO = atVacanciesStatusesMapper.toDto(atVacanciesStatuses);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atVacanciesStatusesDTO));
    }

    /**
     * DELETE  /at-vacancies-statuses/:id : delete the "id" atVacanciesStatuses.
     *
     * @param id the id of the atVacanciesStatusesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/at-vacancies-statuses/{id}")
    @Timed
    public ResponseEntity<Void> deleteAtVacanciesStatuses(@PathVariable Long id) {
        log.debug("REST request to delete AtVacanciesStatuses : {}", id);
        atVacanciesStatusesRepository.delete(id);
        atVacanciesStatusesSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/at-vacancies-statuses?query=:query : search for the atVacanciesStatuses corresponding
     * to the query.
     *
     * @param query the query of the atVacanciesStatuses search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/at-vacancies-statuses")
    @Timed
    public ResponseEntity<List<AtVacanciesStatusesDTO>> searchAtVacanciesStatuses(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of AtVacanciesStatuses for query {}", query);
        Page<AtVacanciesStatuses> page = atVacanciesStatusesSearchRepository.search(queryStringQuery(query), pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/at-vacancies-statuses");
        return new ResponseEntity<>(atVacanciesStatusesMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

}
