package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.AtNotificationTemplates;
import com.infostudio.ba.repository.AtNotificationTemplatesRepository;
import com.infostudio.ba.service.dto.AtNotificationTemplatesDTO;
import com.infostudio.ba.service.mapper.AtNotificationTemplatesMapper;
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
 * REST controller for managing AtNotificationTemplates.
 */
@RestController
@RequestMapping("/api")
public class AtNotificationTemplatesResource {

    private final Logger log = LoggerFactory.getLogger(AtNotificationTemplatesResource.class);

    private static final String ENTITY_NAME = "atNotificationTemplates";

    private final AtNotificationTemplatesRepository atNotificationTemplatesRepository;

    private final AtNotificationTemplatesMapper atNotificationTemplatesMapper;


    public AtNotificationTemplatesResource(AtNotificationTemplatesRepository atNotificationTemplatesRepository, AtNotificationTemplatesMapper atNotificationTemplatesMapper) {
        this.atNotificationTemplatesRepository = atNotificationTemplatesRepository;
        this.atNotificationTemplatesMapper = atNotificationTemplatesMapper;
    }

    /**
     * POST  /at-notification-templates : Create a new atNotificationTemplates.
     *
     * @param atNotificationTemplatesDTO the atNotificationTemplatesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new atNotificationTemplatesDTO, or with status 400 (Bad Request) if the atNotificationTemplates has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/at-notification-templates")
    @Timed
    public ResponseEntity<AtNotificationTemplatesDTO> createAtNotificationTemplates(@Valid @RequestBody AtNotificationTemplatesDTO atNotificationTemplatesDTO) throws URISyntaxException {
        log.debug("REST request to save AtNotificationTemplates : {}", atNotificationTemplatesDTO);
        if (atNotificationTemplatesDTO.getId() != null) {
            throw new BadRequestAlertException("A new atNotificationTemplates cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AtNotificationTemplates atNotificationTemplates = atNotificationTemplatesMapper.toEntity(atNotificationTemplatesDTO);
        atNotificationTemplates = atNotificationTemplatesRepository.save(atNotificationTemplates);
        AtNotificationTemplatesDTO result = atNotificationTemplatesMapper.toDto(atNotificationTemplates);
        return ResponseEntity.created(new URI("/api/at-notification-templates/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /at-notification-templates : Updates an existing atNotificationTemplates.
     *
     * @param atNotificationTemplatesDTO the atNotificationTemplatesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated atNotificationTemplatesDTO,
     * or with status 400 (Bad Request) if the atNotificationTemplatesDTO is not valid,
     * or with status 500 (Internal Server Error) if the atNotificationTemplatesDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/at-notification-templates")
    @Timed
    public ResponseEntity<AtNotificationTemplatesDTO> updateAtNotificationTemplates(@Valid @RequestBody AtNotificationTemplatesDTO atNotificationTemplatesDTO) throws URISyntaxException {
        log.debug("REST request to update AtNotificationTemplates : {}", atNotificationTemplatesDTO);
        if (atNotificationTemplatesDTO.getId() == null) {
            return createAtNotificationTemplates(atNotificationTemplatesDTO);
        }
        AtNotificationTemplates atNotificationTemplates = atNotificationTemplatesMapper.toEntity(atNotificationTemplatesDTO);
        atNotificationTemplates = atNotificationTemplatesRepository.save(atNotificationTemplates);
        AtNotificationTemplatesDTO result = atNotificationTemplatesMapper.toDto(atNotificationTemplates);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, atNotificationTemplatesDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /at-notification-templates : get all the atNotificationTemplates.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of atNotificationTemplates in body
     */
    @GetMapping("/at-notification-templates")
    @Timed
    public ResponseEntity<List<AtNotificationTemplatesDTO>> getAllAtNotificationTemplates(Pageable pageable) {
        log.debug("REST request to get a page of AtNotificationTemplates");
        Page<AtNotificationTemplates> page = atNotificationTemplatesRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/at-notification-templates");
        return new ResponseEntity<>(atNotificationTemplatesMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /at-notification-templates/:id : get the "id" atNotificationTemplates.
     *
     * @param id the id of the atNotificationTemplatesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the atNotificationTemplatesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/at-notification-templates/{id}")
    @Timed
    public ResponseEntity<AtNotificationTemplatesDTO> getAtNotificationTemplates(@PathVariable Long id) {
        log.debug("REST request to get AtNotificationTemplates : {}", id);
        AtNotificationTemplates atNotificationTemplates = atNotificationTemplatesRepository.findOne(id);
        AtNotificationTemplatesDTO atNotificationTemplatesDTO = atNotificationTemplatesMapper.toDto(atNotificationTemplates);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atNotificationTemplatesDTO));
    }

    /**
     * DELETE  /at-notification-templates/:id : delete the "id" atNotificationTemplates.
     *
     * @param id the id of the atNotificationTemplatesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/at-notification-templates/{id}")
    @Timed
    public ResponseEntity<Void> deleteAtNotificationTemplates(@PathVariable Long id) {
        log.debug("REST request to delete AtNotificationTemplates : {}", id);
        atNotificationTemplatesRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }


}
