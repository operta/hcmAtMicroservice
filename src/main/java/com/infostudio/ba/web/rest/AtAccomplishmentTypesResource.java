package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.AtAccomplishmentTypes;

import com.infostudio.ba.repository.AtAccomplishmentTypesRepository;
import com.infostudio.ba.repository.search.AtAccomplishmentTypesSearchRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.AtAccomplishmentTypesDTO;
import com.infostudio.ba.service.mapper.AtAccomplishmentTypesMapper;
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
 * REST controller for managing AtAccomplishmentTypes.
 */
@RestController
@RequestMapping("/api")
public class AtAccomplishmentTypesResource {

    private final Logger log = LoggerFactory.getLogger(AtAccomplishmentTypesResource.class);

    private static final String ENTITY_NAME = "atAccomplishmentTypes";

    private final AtAccomplishmentTypesRepository atAccomplishmentTypesRepository;

    private final AtAccomplishmentTypesMapper atAccomplishmentTypesMapper;

    private final AtAccomplishmentTypesSearchRepository atAccomplishmentTypesSearchRepository;

    public AtAccomplishmentTypesResource(AtAccomplishmentTypesRepository atAccomplishmentTypesRepository, AtAccomplishmentTypesMapper atAccomplishmentTypesMapper, AtAccomplishmentTypesSearchRepository atAccomplishmentTypesSearchRepository) {
        this.atAccomplishmentTypesRepository = atAccomplishmentTypesRepository;
        this.atAccomplishmentTypesMapper = atAccomplishmentTypesMapper;
        this.atAccomplishmentTypesSearchRepository = atAccomplishmentTypesSearchRepository;
    }

    /**
     * POST  /at-accomplishment-types : Create a new atAccomplishmentTypes.
     *
     * @param atAccomplishmentTypesDTO the atAccomplishmentTypesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new atAccomplishmentTypesDTO, or with status 400 (Bad Request) if the atAccomplishmentTypes has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/at-accomplishment-types")
    @Timed
    public ResponseEntity<AtAccomplishmentTypesDTO> createAtAccomplishmentTypes(@Valid @RequestBody AtAccomplishmentTypesDTO atAccomplishmentTypesDTO) throws URISyntaxException {
        log.debug("REST request to save AtAccomplishmentTypes : {}", atAccomplishmentTypesDTO);
        if (atAccomplishmentTypesDTO.getId() != null) {
            throw new BadRequestAlertException("A new atAccomplishmentTypes cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AtAccomplishmentTypes atAccomplishmentTypes = atAccomplishmentTypesMapper.toEntity(atAccomplishmentTypesDTO);
        atAccomplishmentTypes = atAccomplishmentTypesRepository.save(atAccomplishmentTypes);
        AtAccomplishmentTypesDTO result = atAccomplishmentTypesMapper.toDto(atAccomplishmentTypes);
        atAccomplishmentTypesSearchRepository.save(atAccomplishmentTypes);
        return ResponseEntity.created(new URI("/api/at-accomplishment-types/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /at-accomplishment-types : Updates an existing atAccomplishmentTypes.
     *
     * @param atAccomplishmentTypesDTO the atAccomplishmentTypesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated atAccomplishmentTypesDTO,
     * or with status 400 (Bad Request) if the atAccomplishmentTypesDTO is not valid,
     * or with status 500 (Internal Server Error) if the atAccomplishmentTypesDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/at-accomplishment-types")
    @Timed
    public ResponseEntity<AtAccomplishmentTypesDTO> updateAtAccomplishmentTypes(@Valid @RequestBody AtAccomplishmentTypesDTO atAccomplishmentTypesDTO) throws URISyntaxException {
        log.debug("REST request to update AtAccomplishmentTypes : {}", atAccomplishmentTypesDTO);
        if (atAccomplishmentTypesDTO.getId() == null) {
            return createAtAccomplishmentTypes(atAccomplishmentTypesDTO);
        }
        AtAccomplishmentTypes atAccomplishmentTypes = atAccomplishmentTypesMapper.toEntity(atAccomplishmentTypesDTO);
        atAccomplishmentTypes = atAccomplishmentTypesRepository.save(atAccomplishmentTypes);
        AtAccomplishmentTypesDTO result = atAccomplishmentTypesMapper.toDto(atAccomplishmentTypes);
        atAccomplishmentTypesSearchRepository.save(atAccomplishmentTypes);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, atAccomplishmentTypesDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /at-accomplishment-types : get all the atAccomplishmentTypes.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of atAccomplishmentTypes in body
     */
    @GetMapping("/at-accomplishment-types")
    @Timed
    public ResponseEntity<List<AtAccomplishmentTypesDTO>> getAllAtAccomplishmentTypes(Pageable pageable) {
        log.debug("REST request to get a page of AtAccomplishmentTypes");
        Page<AtAccomplishmentTypes> page = atAccomplishmentTypesRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/at-accomplishment-types");
        return new ResponseEntity<>(atAccomplishmentTypesMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /at-accomplishment-types/:id : get the "id" atAccomplishmentTypes.
     *
     * @param id the id of the atAccomplishmentTypesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the atAccomplishmentTypesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/at-accomplishment-types/{id}")
    @Timed
    public ResponseEntity<AtAccomplishmentTypesDTO> getAtAccomplishmentTypes(@PathVariable Long id) {
        log.debug("REST request to get AtAccomplishmentTypes : {}", id);
        AtAccomplishmentTypes atAccomplishmentTypes = atAccomplishmentTypesRepository.findOne(id);
        AtAccomplishmentTypesDTO atAccomplishmentTypesDTO = atAccomplishmentTypesMapper.toDto(atAccomplishmentTypes);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atAccomplishmentTypesDTO));
    }

    /**
     * DELETE  /at-accomplishment-types/:id : delete the "id" atAccomplishmentTypes.
     *
     * @param id the id of the atAccomplishmentTypesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/at-accomplishment-types/{id}")
    @Timed
    public ResponseEntity<Void> deleteAtAccomplishmentTypes(@PathVariable Long id) {
        log.debug("REST request to delete AtAccomplishmentTypes : {}", id);
        atAccomplishmentTypesRepository.delete(id);
        atAccomplishmentTypesSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/at-accomplishment-types?query=:query : search for the atAccomplishmentTypes corresponding
     * to the query.
     *
     * @param query the query of the atAccomplishmentTypes search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/at-accomplishment-types")
    @Timed
    public ResponseEntity<List<AtAccomplishmentTypesDTO>> searchAtAccomplishmentTypes(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of AtAccomplishmentTypes for query {}", query);
        Page<AtAccomplishmentTypes> page = atAccomplishmentTypesSearchRepository.search(queryStringQuery(query), pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/at-accomplishment-types");
        return new ResponseEntity<>(atAccomplishmentTypesMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

}
