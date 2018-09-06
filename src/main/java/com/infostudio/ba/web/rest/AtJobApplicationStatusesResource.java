package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.AtJobApplicationStatuses;
import com.infostudio.ba.repository.AtJobApplicationStatusesRepository;
import com.infostudio.ba.service.dto.AtJobApplicationStatusesDTO;
import com.infostudio.ba.service.mapper.AtJobApplicationStatusesMapper;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
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

/**
 * REST controller for managing AtJobApplicationStatuses.
 */
@RestController
@RequestMapping("/api")
public class AtJobApplicationStatusesResource {

    private final Logger log = LoggerFactory.getLogger(AtJobApplicationStatusesResource.class);

    private static final String ENTITY_NAME = "atJobApplicationStatuses";

    private final AtJobApplicationStatusesRepository atJobApplicationStatusesRepository;

    private final AtJobApplicationStatusesMapper atJobApplicationStatusesMapper;


    public AtJobApplicationStatusesResource(AtJobApplicationStatusesRepository atJobApplicationStatusesRepository, AtJobApplicationStatusesMapper atJobApplicationStatusesMapper) {
        this.atJobApplicationStatusesRepository = atJobApplicationStatusesRepository;
        this.atJobApplicationStatusesMapper = atJobApplicationStatusesMapper;
    }

    /**
     * POST  /at-job-application-statuses : Create a new atJobApplicationStatuses.
     *
     * @param atJobApplicationStatusesDTO the atJobApplicationStatusesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new atJobApplicationStatusesDTO, or with status 400 (Bad Request) if the atJobApplicationStatuses has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/at-job-application-statuses")
    @Timed
    public ResponseEntity<AtJobApplicationStatusesDTO> createAtJobApplicationStatuses(@Valid @RequestBody AtJobApplicationStatusesDTO atJobApplicationStatusesDTO) throws URISyntaxException {
        log.debug("REST request to save AtJobApplicationStatuses : {}", atJobApplicationStatusesDTO);
        if (atJobApplicationStatusesDTO.getId() != null) {
            throw new BadRequestAlertException("A new atJobApplicationStatuses cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AtJobApplicationStatuses atJobApplicationStatuses = atJobApplicationStatusesMapper.toEntity(atJobApplicationStatusesDTO);
        atJobApplicationStatuses = atJobApplicationStatusesRepository.save(atJobApplicationStatuses);
        AtJobApplicationStatusesDTO result = atJobApplicationStatusesMapper.toDto(atJobApplicationStatuses);
        return ResponseEntity.created(new URI("/api/at-job-application-statuses/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /at-job-application-statuses : Updates an existing atJobApplicationStatuses.
     *
     * @param atJobApplicationStatusesDTO the atJobApplicationStatusesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated atJobApplicationStatusesDTO,
     * or with status 400 (Bad Request) if the atJobApplicationStatusesDTO is not valid,
     * or with status 500 (Internal Server Error) if the atJobApplicationStatusesDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/at-job-application-statuses")
    @Timed
    public ResponseEntity<AtJobApplicationStatusesDTO> updateAtJobApplicationStatuses(@Valid @RequestBody AtJobApplicationStatusesDTO atJobApplicationStatusesDTO) throws URISyntaxException {
        log.debug("REST request to update AtJobApplicationStatuses : {}", atJobApplicationStatusesDTO);
        if (atJobApplicationStatusesDTO.getId() == null) {
            return createAtJobApplicationStatuses(atJobApplicationStatusesDTO);
        }
        AtJobApplicationStatuses oldAtJobApplicationStatuses = atJobApplicationStatusesRepository.findOne(atJobApplicationStatusesDTO.getId());
        AtJobApplicationStatuses atJobApplicationStatuses = atJobApplicationStatusesMapper.toEntity(atJobApplicationStatusesDTO);



        atJobApplicationStatuses = atJobApplicationStatusesRepository.save(atJobApplicationStatuses);
        AtJobApplicationStatusesDTO result = atJobApplicationStatusesMapper.toDto(atJobApplicationStatuses);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, atJobApplicationStatusesDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /at-job-application-statuses : get all the atJobApplicationStatuses.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of atJobApplicationStatuses in body
     */
    @GetMapping("/at-job-application-statuses")
    @Timed
    public ResponseEntity<List<AtJobApplicationStatusesDTO>> getAllAtJobApplicationStatuses(Pageable pageable) {
        log.debug("REST request to get a page of AtJobApplicationStatuses");
        Page<AtJobApplicationStatuses> page = atJobApplicationStatusesRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/at-job-application-statuses");
        return new ResponseEntity<>(atJobApplicationStatusesMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /at-job-application-statuses/:id : get the "id" atJobApplicationStatuses.
     *
     * @param id the id of the atJobApplicationStatusesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the atJobApplicationStatusesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/at-job-application-statuses/{id}")
    @Timed
    public ResponseEntity<AtJobApplicationStatusesDTO> getAtJobApplicationStatuses(@PathVariable Long id) {
        log.debug("REST request to get AtJobApplicationStatuses : {}", id);
        AtJobApplicationStatuses atJobApplicationStatuses = atJobApplicationStatusesRepository.findOne(id);
        AtJobApplicationStatusesDTO atJobApplicationStatusesDTO = atJobApplicationStatusesMapper.toDto(atJobApplicationStatuses);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atJobApplicationStatusesDTO));
    }

    /**
     * DELETE  /at-job-application-statuses/:id : delete the "id" atJobApplicationStatuses.
     *
     * @param id the id of the atJobApplicationStatusesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/at-job-application-statuses/{id}")
    @Timed
    public ResponseEntity<Void> deleteAtJobApplicationStatuses(@PathVariable Long id) {
        log.debug("REST request to delete AtJobApplicationStatuses : {}", id);
        atJobApplicationStatusesRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }


}
