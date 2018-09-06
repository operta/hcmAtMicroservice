package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.AtActivities;

import com.infostudio.ba.repository.AtActivitiesRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.AtActivitiesDTO;
import com.infostudio.ba.service.mapper.AtActivitiesMapper;
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
 * REST controller for managing AtActivities.
 */
@RestController
@RequestMapping("/api")
public class AtActivitiesResource {

    private final Logger log = LoggerFactory.getLogger(AtActivitiesResource.class);

    private static final String ENTITY_NAME = "atActivities";

    private final AtActivitiesRepository atActivitiesRepository;

    private final AtActivitiesMapper atActivitiesMapper;


    public AtActivitiesResource(AtActivitiesRepository atActivitiesRepository, AtActivitiesMapper atActivitiesMapper) {
        this.atActivitiesRepository = atActivitiesRepository;
        this.atActivitiesMapper = atActivitiesMapper;
    }

    /**
     * POST  /at-activities : Create a new atActivities.
     *
     * @param atActivitiesDTO the atActivitiesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new atActivitiesDTO, or with status 400 (Bad Request) if the atActivities has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/at-activities")
    @Timed
    public ResponseEntity<AtActivitiesDTO> createAtActivities(@Valid @RequestBody AtActivitiesDTO atActivitiesDTO) throws URISyntaxException {
        log.debug("REST request to save AtActivities : {}", atActivitiesDTO);
        if (atActivitiesDTO.getId() != null) {
            throw new BadRequestAlertException("A new atActivities cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AtActivities atActivities = atActivitiesMapper.toEntity(atActivitiesDTO);
        atActivities = atActivitiesRepository.save(atActivities);
        AtActivitiesDTO result = atActivitiesMapper.toDto(atActivities);

        return ResponseEntity.created(new URI("/api/at-activities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /at-activities : Updates an existing atActivities.
     *
     * @param atActivitiesDTO the atActivitiesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated atActivitiesDTO,
     * or with status 400 (Bad Request) if the atActivitiesDTO is not valid,
     * or with status 500 (Internal Server Error) if the atActivitiesDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/at-activities")
    @Timed
    public ResponseEntity<AtActivitiesDTO> updateAtActivities(@Valid @RequestBody AtActivitiesDTO atActivitiesDTO) throws URISyntaxException {
        log.debug("REST request to update AtActivities : {}", atActivitiesDTO);
        if (atActivitiesDTO.getId() == null) {
            return createAtActivities(atActivitiesDTO);
        }
        AtActivities atActivities = atActivitiesMapper.toEntity(atActivitiesDTO);
        atActivities = atActivitiesRepository.save(atActivities);
        AtActivitiesDTO result = atActivitiesMapper.toDto(atActivities);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, atActivitiesDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /at-activities : get all the atActivities.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of atActivities in body
     */
    @GetMapping("/at-activities")
    @Timed
    public ResponseEntity<List<AtActivitiesDTO>> getAllAtActivities(Pageable pageable) {
        log.debug("REST request to get a page of AtActivities");
        Page<AtActivities> page = atActivitiesRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/at-activities");
        return new ResponseEntity<>(atActivitiesMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /at-activities/:id : get the "id" atActivities.
     *
     * @param id the id of the atActivitiesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the atActivitiesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/at-activities/{id}")
    @Timed
    public ResponseEntity<AtActivitiesDTO> getAtActivities(@PathVariable Long id) {
        log.debug("REST request to get AtActivities : {}", id);
        AtActivities atActivities = atActivitiesRepository.findById(id);
        AtActivitiesDTO atActivitiesDTO = atActivitiesMapper.toDto(atActivities);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atActivitiesDTO));
    }

    /**
     * DELETE  /at-activities/:id : delete the "id" atActivities.
     *
     * @param id the id of the atActivitiesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/at-activities/{id}")
    @Timed
    public ResponseEntity<Void> deleteAtActivities(@PathVariable Long id) {
        log.debug("REST request to delete AtActivities : {}", id);
        atActivitiesRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
