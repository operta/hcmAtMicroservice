package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.AtActivityStatuses;

import com.infostudio.ba.repository.AtActivityStatusesRepository;
import com.infostudio.ba.repository.search.AtActivityStatusesSearchRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.AtActivityStatusesDTO;
import com.infostudio.ba.service.mapper.AtActivityStatusesMapper;
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
 * REST controller for managing AtActivityStatuses.
 */
@RestController
@RequestMapping("/api")
public class AtActivityStatusesResource {

    private final Logger log = LoggerFactory.getLogger(AtActivityStatusesResource.class);

    private static final String ENTITY_NAME = "atActivityStatuses";

    private final AtActivityStatusesRepository atActivityStatusesRepository;

    private final AtActivityStatusesMapper atActivityStatusesMapper;

    private final AtActivityStatusesSearchRepository atActivityStatusesSearchRepository;

    public AtActivityStatusesResource(AtActivityStatusesRepository atActivityStatusesRepository, AtActivityStatusesMapper atActivityStatusesMapper, AtActivityStatusesSearchRepository atActivityStatusesSearchRepository) {
        this.atActivityStatusesRepository = atActivityStatusesRepository;
        this.atActivityStatusesMapper = atActivityStatusesMapper;
        this.atActivityStatusesSearchRepository = atActivityStatusesSearchRepository;
    }

    /**
     * POST  /at-activity-statuses : Create a new atActivityStatuses.
     *
     * @param atActivityStatusesDTO the atActivityStatusesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new atActivityStatusesDTO, or with status 400 (Bad Request) if the atActivityStatuses has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/at-activity-statuses")
    @Timed
    public ResponseEntity<AtActivityStatusesDTO> createAtActivityStatuses(@Valid @RequestBody AtActivityStatusesDTO atActivityStatusesDTO) throws URISyntaxException {
        log.debug("REST request to save AtActivityStatuses : {}", atActivityStatusesDTO);
        if (atActivityStatusesDTO.getId() != null) {
            throw new BadRequestAlertException("A new atActivityStatuses cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AtActivityStatuses atActivityStatuses = atActivityStatusesMapper.toEntity(atActivityStatusesDTO);
        atActivityStatuses = atActivityStatusesRepository.save(atActivityStatuses);
        AtActivityStatusesDTO result = atActivityStatusesMapper.toDto(atActivityStatuses);
        atActivityStatusesSearchRepository.save(atActivityStatuses);
        return ResponseEntity.created(new URI("/api/at-activity-statuses/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /at-activity-statuses : Updates an existing atActivityStatuses.
     *
     * @param atActivityStatusesDTO the atActivityStatusesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated atActivityStatusesDTO,
     * or with status 400 (Bad Request) if the atActivityStatusesDTO is not valid,
     * or with status 500 (Internal Server Error) if the atActivityStatusesDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/at-activity-statuses")
    @Timed
    public ResponseEntity<AtActivityStatusesDTO> updateAtActivityStatuses(@Valid @RequestBody AtActivityStatusesDTO atActivityStatusesDTO) throws URISyntaxException {
        log.debug("REST request to update AtActivityStatuses : {}", atActivityStatusesDTO);
        if (atActivityStatusesDTO.getId() == null) {
            return createAtActivityStatuses(atActivityStatusesDTO);
        }
        AtActivityStatuses atActivityStatuses = atActivityStatusesMapper.toEntity(atActivityStatusesDTO);
        atActivityStatuses = atActivityStatusesRepository.save(atActivityStatuses);
        AtActivityStatusesDTO result = atActivityStatusesMapper.toDto(atActivityStatuses);
        atActivityStatusesSearchRepository.save(atActivityStatuses);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, atActivityStatusesDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /at-activity-statuses : get all the atActivityStatuses.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of atActivityStatuses in body
     */
    @GetMapping("/at-activity-statuses")
    @Timed
    public ResponseEntity<List<AtActivityStatusesDTO>> getAllAtActivityStatuses(Pageable pageable) {
        log.debug("REST request to get a page of AtActivityStatuses");
        Page<AtActivityStatuses> page = atActivityStatusesRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/at-activity-statuses");
        return new ResponseEntity<>(atActivityStatusesMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /at-activity-statuses/:id : get the "id" atActivityStatuses.
     *
     * @param id the id of the atActivityStatusesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the atActivityStatusesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/at-activity-statuses/{id}")
    @Timed
    public ResponseEntity<AtActivityStatusesDTO> getAtActivityStatuses(@PathVariable Long id) {
        log.debug("REST request to get AtActivityStatuses : {}", id);
        AtActivityStatuses atActivityStatuses = atActivityStatusesRepository.findOne(id);
        AtActivityStatusesDTO atActivityStatusesDTO = atActivityStatusesMapper.toDto(atActivityStatuses);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atActivityStatusesDTO));
    }

    /**
     * DELETE  /at-activity-statuses/:id : delete the "id" atActivityStatuses.
     *
     * @param id the id of the atActivityStatusesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/at-activity-statuses/{id}")
    @Timed
    public ResponseEntity<Void> deleteAtActivityStatuses(@PathVariable Long id) {
        log.debug("REST request to delete AtActivityStatuses : {}", id);
        atActivityStatusesRepository.delete(id);
        atActivityStatusesSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/at-activity-statuses?query=:query : search for the atActivityStatuses corresponding
     * to the query.
     *
     * @param query the query of the atActivityStatuses search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/at-activity-statuses")
    @Timed
    public ResponseEntity<List<AtActivityStatusesDTO>> searchAtActivityStatuses(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of AtActivityStatuses for query {}", query);
        Page<AtActivityStatuses> page = atActivityStatusesSearchRepository.search(queryStringQuery(query), pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/at-activity-statuses");
        return new ResponseEntity<>(atActivityStatusesMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

}
