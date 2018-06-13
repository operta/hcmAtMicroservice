package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.AtApplicants;

import com.infostudio.ba.repository.AtApplicantsRepository;
import com.infostudio.ba.repository.search.AtApplicantsSearchRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.AtApplicantsDTO;
import com.infostudio.ba.service.mapper.AtApplicantsMapper;
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
 * REST controller for managing AtApplicants.
 */
@RestController
@RequestMapping("/api")
public class AtApplicantsResource {

    private final Logger log = LoggerFactory.getLogger(AtApplicantsResource.class);

    private static final String ENTITY_NAME = "atApplicants";

    private final AtApplicantsRepository atApplicantsRepository;

    private final AtApplicantsMapper atApplicantsMapper;

    private final AtApplicantsSearchRepository atApplicantsSearchRepository;

    public AtApplicantsResource(AtApplicantsRepository atApplicantsRepository, AtApplicantsMapper atApplicantsMapper, AtApplicantsSearchRepository atApplicantsSearchRepository) {
        this.atApplicantsRepository = atApplicantsRepository;
        this.atApplicantsMapper = atApplicantsMapper;
        this.atApplicantsSearchRepository = atApplicantsSearchRepository;
    }

    /**
     * POST  /at-applicants : Create a new atApplicants.
     *
     * @param atApplicantsDTO the atApplicantsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new atApplicantsDTO, or with status 400 (Bad Request) if the atApplicants has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/at-applicants")
    @Timed
    public ResponseEntity<AtApplicantsDTO> createAtApplicants(@Valid @RequestBody AtApplicantsDTO atApplicantsDTO) throws URISyntaxException {
        log.debug("REST request to save AtApplicants : {}", atApplicantsDTO);
        if (atApplicantsDTO.getId() != null) {
            throw new BadRequestAlertException("A new atApplicants cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AtApplicants atApplicants = atApplicantsMapper.toEntity(atApplicantsDTO);
        atApplicants = atApplicantsRepository.save(atApplicants);
        AtApplicantsDTO result = atApplicantsMapper.toDto(atApplicants);
        atApplicantsSearchRepository.save(atApplicants);
        return ResponseEntity.created(new URI("/api/at-applicants/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /at-applicants : Updates an existing atApplicants.
     *
     * @param atApplicantsDTO the atApplicantsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated atApplicantsDTO,
     * or with status 400 (Bad Request) if the atApplicantsDTO is not valid,
     * or with status 500 (Internal Server Error) if the atApplicantsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/at-applicants")
    @Timed
    public ResponseEntity<AtApplicantsDTO> updateAtApplicants(@Valid @RequestBody AtApplicantsDTO atApplicantsDTO) throws URISyntaxException {
        log.debug("REST request to update AtApplicants : {}", atApplicantsDTO);
        if (atApplicantsDTO.getId() == null) {
            return createAtApplicants(atApplicantsDTO);
        }
        AtApplicants atApplicants = atApplicantsMapper.toEntity(atApplicantsDTO);
        atApplicants = atApplicantsRepository.save(atApplicants);
        AtApplicantsDTO result = atApplicantsMapper.toDto(atApplicants);
        atApplicantsSearchRepository.save(atApplicants);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, atApplicantsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /at-applicants : get all the atApplicants.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of atApplicants in body
     */
    @GetMapping("/at-applicants")
    @Timed
    public ResponseEntity<List<AtApplicantsDTO>> getAllAtApplicants(Pageable pageable) {
        log.debug("REST request to get a page of AtApplicants");
        Page<AtApplicants> page = atApplicantsRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/at-applicants");
        return new ResponseEntity<>(atApplicantsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }



    /**
     * GET  /at-applicants/:id : get the "id" atApplicants.
     *
     * @param id the id of the atApplicantsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the atApplicantsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/at-applicants/{id}")
    @Timed
    public ResponseEntity<AtApplicantsDTO> getAtApplicants(@PathVariable Long id) {
        log.debug("REST request to get AtApplicants : {}", id);
        AtApplicants atApplicants = atApplicantsRepository.findOne(id);
        AtApplicantsDTO atApplicantsDTO = atApplicantsMapper.toDto(atApplicants);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atApplicantsDTO));
    }

        /**
     * GET  /at-applicants/:id : get the "id" atApplicants.
     *
     * @param id the id of the atApplicantsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the atApplicantsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/at-applicants/user/{id}")
    @Timed
    public ResponseEntity<AtApplicantsDTO> getApplicantByUserId(@PathVariable Integer id) {
        log.debug("REST request to get AtApplicants by user id: {}", id);
        AtApplicants atApplicants = atApplicantsRepository.findByIdUser(id);
        AtApplicantsDTO atApplicantsDTO = atApplicantsMapper.toDto(atApplicants);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atApplicantsDTO));
    }

    /**
     * DELETE  /at-applicants/:id : delete the "id" atApplicants.
     *
     * @param id the id of the atApplicantsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/at-applicants/{id}")
    @Timed
    public ResponseEntity<Void> deleteAtApplicants(@PathVariable Long id) {
        log.debug("REST request to delete AtApplicants : {}", id);
        atApplicantsRepository.delete(id);
        atApplicantsSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/at-applicants?query=:query : search for the atApplicants corresponding
     * to the query.
     *
     * @param query the query of the atApplicants search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/at-applicants")
    @Timed
    public ResponseEntity<List<AtApplicantsDTO>> searchAtApplicants(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of AtApplicants for query {}", query);
        Page<AtApplicants> page = atApplicantsSearchRepository.search(queryStringQuery(query), pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/at-applicants");
        return new ResponseEntity<>(atApplicantsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

}
