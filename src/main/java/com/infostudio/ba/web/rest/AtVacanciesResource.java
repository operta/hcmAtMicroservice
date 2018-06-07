package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.AtVacancies;

import com.infostudio.ba.repository.AtVacanciesRepository;
import com.infostudio.ba.repository.search.AtVacanciesSearchRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.AtVacanciesDTO;
import com.infostudio.ba.service.mapper.AtVacanciesMapper;
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
 * REST controller for managing AtVacancies.
 */
@RestController
@RequestMapping("/api")
public class AtVacanciesResource {

    private final Logger log = LoggerFactory.getLogger(AtVacanciesResource.class);

    private static final String ENTITY_NAME = "atVacancies";

    private final AtVacanciesRepository atVacanciesRepository;

    private final AtVacanciesMapper atVacanciesMapper;

    private final AtVacanciesSearchRepository atVacanciesSearchRepository;

    public AtVacanciesResource(AtVacanciesRepository atVacanciesRepository, AtVacanciesMapper atVacanciesMapper, AtVacanciesSearchRepository atVacanciesSearchRepository) {
        this.atVacanciesRepository = atVacanciesRepository;
        this.atVacanciesMapper = atVacanciesMapper;
        this.atVacanciesSearchRepository = atVacanciesSearchRepository;
    }

    /**
     * POST  /at-vacancies : Create a new atVacancies.
     *
     * @param atVacanciesDTO the atVacanciesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new atVacanciesDTO, or with status 400 (Bad Request) if the atVacancies has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/at-vacancies")
    @Timed
    public ResponseEntity<AtVacanciesDTO> createAtVacancies(@Valid @RequestBody AtVacanciesDTO atVacanciesDTO) throws URISyntaxException {
        log.debug("REST request to save AtVacancies : {}", atVacanciesDTO);
        if (atVacanciesDTO.getId() != null) {
            throw new BadRequestAlertException("A new atVacancies cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AtVacancies atVacancies = atVacanciesMapper.toEntity(atVacanciesDTO);
        atVacancies = atVacanciesRepository.save(atVacancies);
        AtVacanciesDTO result = atVacanciesMapper.toDto(atVacancies);
        atVacanciesSearchRepository.save(atVacancies);
        return ResponseEntity.created(new URI("/api/at-vacancies/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /at-vacancies : Updates an existing atVacancies.
     *
     * @param atVacanciesDTO the atVacanciesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated atVacanciesDTO,
     * or with status 400 (Bad Request) if the atVacanciesDTO is not valid,
     * or with status 500 (Internal Server Error) if the atVacanciesDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/at-vacancies")
    @Timed
    public ResponseEntity<AtVacanciesDTO> updateAtVacancies(@Valid @RequestBody AtVacanciesDTO atVacanciesDTO) throws URISyntaxException {
        log.debug("REST request to update AtVacancies : {}", atVacanciesDTO);
        if (atVacanciesDTO.getId() == null) {
            return createAtVacancies(atVacanciesDTO);
        }
        AtVacancies atVacancies = atVacanciesMapper.toEntity(atVacanciesDTO);
        atVacancies = atVacanciesRepository.save(atVacancies);
        AtVacanciesDTO result = atVacanciesMapper.toDto(atVacancies);
        atVacanciesSearchRepository.save(atVacancies);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, atVacanciesDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /at-vacancies : get all the atVacancies.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of atVacancies in body
     */
    @GetMapping("/at-vacancies")
    @Timed
    public ResponseEntity<List<AtVacanciesDTO>> getAllAtVacancies(Pageable pageable) {
        log.debug("REST request to get a page of AtVacancies");
        Page<AtVacancies> page = atVacanciesRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/at-vacancies");
        return new ResponseEntity<>(atVacanciesMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /at-vacancies/:id : get the "id" atVacancies.
     *
     * @param id the id of the atVacanciesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the atVacanciesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/at-vacancies/{id}")
    @Timed
    public ResponseEntity<AtVacanciesDTO> getAtVacancies(@PathVariable Long id) {
        log.debug("REST request to get AtVacancies : {}", id);
        AtVacancies atVacancies = atVacanciesRepository.findOne(id);
        AtVacanciesDTO atVacanciesDTO = atVacanciesMapper.toDto(atVacancies);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atVacanciesDTO));
    }

    /**
     * DELETE  /at-vacancies/:id : delete the "id" atVacancies.
     *
     * @param id the id of the atVacanciesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/at-vacancies/{id}")
    @Timed
    public ResponseEntity<Void> deleteAtVacancies(@PathVariable Long id) {
        log.debug("REST request to delete AtVacancies : {}", id);
        atVacanciesRepository.delete(id);
        atVacanciesSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/at-vacancies?query=:query : search for the atVacancies corresponding
     * to the query.
     *
     * @param query the query of the atVacancies search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/at-vacancies")
    @Timed
    public ResponseEntity<List<AtVacanciesDTO>> searchAtVacancies(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of AtVacancies for query {}", query);
        Page<AtVacancies> page = atVacanciesSearchRepository.search(queryStringQuery(query), pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/at-vacancies");
        return new ResponseEntity<>(atVacanciesMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

}
