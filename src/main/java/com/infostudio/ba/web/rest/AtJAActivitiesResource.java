package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.AtJAActivities;

import com.infostudio.ba.repository.AtJAActivitiesRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.AtJAActivitiesDTO;
import com.infostudio.ba.service.mapper.AtJAActivitiesMapper;
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


/**
 * REST controller for managing AtJAActivities.
 */
@RestController
@RequestMapping("/api")
public class AtJAActivitiesResource {

    private final Logger log = LoggerFactory.getLogger(AtJAActivitiesResource.class);

    private static final String ENTITY_NAME = "atJAActivities";

    private final AtJAActivitiesRepository atJAActivitiesRepository;

    private final AtJAActivitiesMapper atJAActivitiesMapper;


    public AtJAActivitiesResource(AtJAActivitiesRepository atJAActivitiesRepository, AtJAActivitiesMapper atJAActivitiesMapper) {
        this.atJAActivitiesRepository = atJAActivitiesRepository;
        this.atJAActivitiesMapper = atJAActivitiesMapper;
    }

    /**
     * POST  /at-ja-activities : Create a new atJAActivities.
     *
     * @param atJAActivitiesDTO the atJAActivitiesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new atJAActivitiesDTO, or with status 400 (Bad Request) if the atJAActivities has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/at-ja-activities")
    @Timed
    public ResponseEntity<AtJAActivitiesDTO> createAtJAActivities(@Valid @RequestBody AtJAActivitiesDTO atJAActivitiesDTO) throws URISyntaxException {
        log.debug("REST request to save AtJAActivities : {}", atJAActivitiesDTO);
        if (atJAActivitiesDTO.getId() != null) {
            throw new BadRequestAlertException("A new atJAActivities cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AtJAActivities atJAActivities = atJAActivitiesMapper.toEntity(atJAActivitiesDTO);
        atJAActivities = atJAActivitiesRepository.save(atJAActivities);
        AtJAActivitiesDTO result = atJAActivitiesMapper.toDto(atJAActivities);
        return ResponseEntity.created(new URI("/api/at-ja-activities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /at-ja-activities : Updates an existing atJAActivities.
     *
     * @param atJAActivitiesDTO the atJAActivitiesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated atJAActivitiesDTO,
     * or with status 400 (Bad Request) if the atJAActivitiesDTO is not valid,
     * or with status 500 (Internal Server Error) if the atJAActivitiesDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/at-ja-activities")
    @Timed
    public ResponseEntity<AtJAActivitiesDTO> updateAtJAActivities(@Valid @RequestBody AtJAActivitiesDTO atJAActivitiesDTO) throws URISyntaxException {
        log.debug("REST request to update AtJAActivities : {}", atJAActivitiesDTO);
        if (atJAActivitiesDTO.getId() == null) {
            return createAtJAActivities(atJAActivitiesDTO);
        }
        AtJAActivities atJAActivities = atJAActivitiesMapper.toEntity(atJAActivitiesDTO);
        atJAActivities = atJAActivitiesRepository.save(atJAActivities);
        AtJAActivitiesDTO result = atJAActivitiesMapper.toDto(atJAActivities);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, atJAActivitiesDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /at-ja-activities : get all the atJAActivities.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of atJAActivities in body
     */
    @GetMapping("/at-ja-activities")
    @Timed
    public ResponseEntity<List<AtJAActivitiesDTO>> getAllAtJAActivities(Pageable pageable) {
        log.debug("REST request to get a page of AtJAActivities");
        Page<AtJAActivities> page = atJAActivitiesRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/at-ja-activities");
        return new ResponseEntity<>(atJAActivitiesMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /at-ja-activities/:id : get the "id" atJAActivities.
     *
     * @param id the id of the atJAActivitiesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the atJAActivitiesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/at-ja-activities/{id}")
    @Timed
    public ResponseEntity<AtJAActivitiesDTO> getAtJAActivities(@PathVariable Long id) {
        log.debug("REST request to get AtJAActivities : {}", id);
        AtJAActivities atJAActivities = atJAActivitiesRepository.findById(id);
        AtJAActivitiesDTO atJAActivitiesDTO = atJAActivitiesMapper.toDto(atJAActivities);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atJAActivitiesDTO));
    }

    /**
     * DELETE  /at-ja-activities/:id : delete the "id" atJAActivities.
     *
     * @param id the id of the atJAActivitiesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/at-ja-activities/{id}")
    @Timed
    public ResponseEntity<Void> deleteAtJAActivities(@PathVariable Long id) {
        log.debug("REST request to delete AtJAActivities : {}", id);
        atJAActivitiesRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }


}
