package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.AtJAInt;

import com.infostudio.ba.repository.AtJAIntRepository;
import com.infostudio.ba.repository.search.AtJAIntSearchRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.AtJAIntDTO;
import com.infostudio.ba.service.mapper.AtJAIntMapper;
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
 * REST controller for managing AtJAInt.
 */
@RestController
@RequestMapping("/api")
public class AtJAIntResource {

    private final Logger log = LoggerFactory.getLogger(AtJAIntResource.class);

    private static final String ENTITY_NAME = "atJAInt";

    private final AtJAIntRepository atJAIntRepository;

    private final AtJAIntMapper atJAIntMapper;

    private final AtJAIntSearchRepository atJAIntSearchRepository;

    public AtJAIntResource(AtJAIntRepository atJAIntRepository, AtJAIntMapper atJAIntMapper, AtJAIntSearchRepository atJAIntSearchRepository) {
        this.atJAIntRepository = atJAIntRepository;
        this.atJAIntMapper = atJAIntMapper;
        this.atJAIntSearchRepository = atJAIntSearchRepository;
    }

    /**
     * POST  /at-ja-ints : Create a new atJAInt.
     *
     * @param atJAIntDTO the atJAIntDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new atJAIntDTO, or with status 400 (Bad Request) if the atJAInt has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/at-ja-ints")
    @Timed
    public ResponseEntity<AtJAIntDTO> createAtJAInt(@RequestBody AtJAIntDTO atJAIntDTO) throws URISyntaxException {
        log.debug("REST request to save AtJAInt : {}", atJAIntDTO);
        if (atJAIntDTO.getId() != null) {
            throw new BadRequestAlertException("A new atJAInt cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AtJAInt atJAInt = atJAIntMapper.toEntity(atJAIntDTO);
        atJAInt = atJAIntRepository.save(atJAInt);
        AtJAIntDTO result = atJAIntMapper.toDto(atJAInt);
        atJAIntSearchRepository.save(atJAInt);
        return ResponseEntity.created(new URI("/api/at-ja-ints/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /at-ja-ints : Updates an existing atJAInt.
     *
     * @param atJAIntDTO the atJAIntDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated atJAIntDTO,
     * or with status 400 (Bad Request) if the atJAIntDTO is not valid,
     * or with status 500 (Internal Server Error) if the atJAIntDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/at-ja-ints")
    @Timed
    public ResponseEntity<AtJAIntDTO> updateAtJAInt(@RequestBody AtJAIntDTO atJAIntDTO) throws URISyntaxException {
        log.debug("REST request to update AtJAInt : {}", atJAIntDTO);
        if (atJAIntDTO.getId() == null) {
            return createAtJAInt(atJAIntDTO);
        }
        AtJAInt atJAInt = atJAIntMapper.toEntity(atJAIntDTO);
        atJAInt = atJAIntRepository.save(atJAInt);
        AtJAIntDTO result = atJAIntMapper.toDto(atJAInt);
        atJAIntSearchRepository.save(atJAInt);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, atJAIntDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /at-ja-ints : get all the atJAInts.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of atJAInts in body
     */
    @GetMapping("/at-ja-ints")
    @Timed
    public ResponseEntity<List<AtJAIntDTO>> getAllAtJAInts(Pageable pageable) {
        log.debug("REST request to get a page of AtJAInts");
        Page<AtJAInt> page = atJAIntRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/at-ja-ints");
        return new ResponseEntity<>(atJAIntMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /at-ja-ints/:id : get the "id" atJAInt.
     *
     * @param id the id of the atJAIntDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the atJAIntDTO, or with status 404 (Not Found)
     */
    @GetMapping("/at-ja-ints/{id}")
    @Timed
    public ResponseEntity<AtJAIntDTO> getAtJAInt(@PathVariable Long id) {
        log.debug("REST request to get AtJAInt : {}", id);
        AtJAInt atJAInt = atJAIntRepository.findOne(id);
        AtJAIntDTO atJAIntDTO = atJAIntMapper.toDto(atJAInt);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atJAIntDTO));
    }

    @GetMapping("/at-ja-ints/job-application/{id}")
    @Timed
    public ResponseEntity<List<AtJAIntDTO>> getAtJAIntByJobAppId(@PathVariable Long id) {
        log.debug("REST request to get AtJAInt by JobApplication Id : {}", id);
        List<AtJAInt> atJAInt = atJAIntRepository.findByJobApplicationIdId(id);
        List<AtJAIntDTO> atJAIntDTO = atJAIntMapper.toDto(atJAInt);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atJAIntDTO));
    }

    /**
     * DELETE  /at-ja-ints/:id : delete the "id" atJAInt.
     *
     * @param id the id of the atJAIntDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/at-ja-ints/{id}")
    @Timed
    public ResponseEntity<Void> deleteAtJAInt(@PathVariable Long id) {
        log.debug("REST request to delete AtJAInt : {}", id);
        atJAIntRepository.delete(id);
        atJAIntSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/at-ja-ints?query=:query : search for the atJAInt corresponding
     * to the query.
     *
     * @param query the query of the atJAInt search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/at-ja-ints")
    @Timed
    public ResponseEntity<List<AtJAIntDTO>> searchAtJAInts(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of AtJAInts for query {}", query);
        Page<AtJAInt> page = atJAIntSearchRepository.search(queryStringQuery(query), pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/at-ja-ints");
        return new ResponseEntity<>(atJAIntMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

}
