package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.AtJobAppNotifications;
import com.infostudio.ba.repository.AtJobAppNotificationsRepository;
import com.infostudio.ba.service.dto.AtJobAppNotificationsDTO;
import com.infostudio.ba.service.mapper.AtJobAppNotificationsMapper;
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
 * REST controller for managing AtJobAppNotifications.
 */
@RestController
@RequestMapping("/api")
public class AtJobAppNotificationsResource {

    private final Logger log = LoggerFactory.getLogger(AtJobAppNotificationsResource.class);

    private static final String ENTITY_NAME = "atJobAppNotifications";

    private final AtJobAppNotificationsRepository atJobAppNotificationsRepository;

    private final AtJobAppNotificationsMapper atJobAppNotificationsMapper;


    public AtJobAppNotificationsResource(AtJobAppNotificationsRepository atJobAppNotificationsRepository, AtJobAppNotificationsMapper atJobAppNotificationsMapper) {
        this.atJobAppNotificationsRepository = atJobAppNotificationsRepository;
        this.atJobAppNotificationsMapper = atJobAppNotificationsMapper;
    }

    /**
     * POST  /at-job-app-notifications : Create a new atJobAppNotifications.
     *
     * @param atJobAppNotificationsDTO the atJobAppNotificationsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new atJobAppNotificationsDTO, or with status 400 (Bad Request) if the atJobAppNotifications has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/at-job-app-notifications")
    @Timed
    public ResponseEntity<AtJobAppNotificationsDTO> createAtJobAppNotifications(@Valid @RequestBody AtJobAppNotificationsDTO atJobAppNotificationsDTO) throws URISyntaxException {
        log.debug("REST request to save AtJobAppNotifications : {}", atJobAppNotificationsDTO);
        if (atJobAppNotificationsDTO.getId() != null) {
            throw new BadRequestAlertException("A new atJobAppNotifications cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AtJobAppNotifications atJobAppNotifications = atJobAppNotificationsMapper.toEntity(atJobAppNotificationsDTO);
        atJobAppNotifications = atJobAppNotificationsRepository.save(atJobAppNotifications);
        AtJobAppNotificationsDTO result = atJobAppNotificationsMapper.toDto(atJobAppNotifications);
        return ResponseEntity.created(new URI("/api/at-job-app-notifications/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /at-job-app-notifications : Updates an existing atJobAppNotifications.
     *
     * @param atJobAppNotificationsDTO the atJobAppNotificationsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated atJobAppNotificationsDTO,
     * or with status 400 (Bad Request) if the atJobAppNotificationsDTO is not valid,
     * or with status 500 (Internal Server Error) if the atJobAppNotificationsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/at-job-app-notifications")
    @Timed
    public ResponseEntity<AtJobAppNotificationsDTO> updateAtJobAppNotifications(@Valid @RequestBody AtJobAppNotificationsDTO atJobAppNotificationsDTO) throws URISyntaxException {
        log.debug("REST request to update AtJobAppNotifications : {}", atJobAppNotificationsDTO);
        if (atJobAppNotificationsDTO.getId() == null) {
            return createAtJobAppNotifications(atJobAppNotificationsDTO);
        }
        AtJobAppNotifications atJobAppNotifications = atJobAppNotificationsMapper.toEntity(atJobAppNotificationsDTO);
        atJobAppNotifications = atJobAppNotificationsRepository.save(atJobAppNotifications);
        AtJobAppNotificationsDTO result = atJobAppNotificationsMapper.toDto(atJobAppNotifications);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, atJobAppNotificationsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /at-job-app-notifications : get all the atJobAppNotifications.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of atJobAppNotifications in body
     */
    @GetMapping("/at-job-app-notifications")
    @Timed
    public ResponseEntity<List<AtJobAppNotificationsDTO>> getAllAtJobAppNotifications(Pageable pageable) {
        log.debug("REST request to get a page of AtJobAppNotifications");
        Page<AtJobAppNotifications> page = atJobAppNotificationsRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/at-job-app-notifications");
        return new ResponseEntity<>(atJobAppNotificationsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /at-job-app-notifications/:id : get the "id" atJobAppNotifications.
     *
     * @param id the id of the atJobAppNotificationsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the atJobAppNotificationsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/at-job-app-notifications/{id}")
    @Timed
    public ResponseEntity<AtJobAppNotificationsDTO> getAtJobAppNotifications(@PathVariable Long id) {
        log.debug("REST request to get AtJobAppNotifications : {}", id);
        AtJobAppNotifications atJobAppNotifications = atJobAppNotificationsRepository.findOne(id);
        AtJobAppNotificationsDTO atJobAppNotificationsDTO = atJobAppNotificationsMapper.toDto(atJobAppNotifications);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atJobAppNotificationsDTO));
    }

    /**
     * DELETE  /at-job-app-notifications/:id : delete the "id" atJobAppNotifications.
     *
     * @param id the id of the atJobAppNotificationsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/at-job-app-notifications/{id}")
    @Timed
    public ResponseEntity<Void> deleteAtJobAppNotifications(@PathVariable Long id) {
        log.debug("REST request to delete AtJobAppNotifications : {}", id);
        atJobAppNotificationsRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
