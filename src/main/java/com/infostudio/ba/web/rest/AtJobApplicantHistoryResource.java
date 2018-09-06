package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.AtJobApplicantHistory;

import com.infostudio.ba.repository.AtJobApplicantHistoryRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.AtJobApplicantHistoryDTO;
import com.infostudio.ba.service.mapper.AtJobApplicantHistoryMapper;
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


/**
 * REST controller for managing AtJobApplicantHistory.
 */
@RestController
@RequestMapping("/api")
public class AtJobApplicantHistoryResource {

    private final Logger log = LoggerFactory.getLogger(AtJobApplicantHistoryResource.class);

    private static final String ENTITY_NAME = "atJobApplicantHistory";

    private final AtJobApplicantHistoryRepository atJobApplicantHistoryRepository;

    private final AtJobApplicantHistoryMapper atJobApplicantHistoryMapper;


    public AtJobApplicantHistoryResource(AtJobApplicantHistoryRepository atJobApplicantHistoryRepository, AtJobApplicantHistoryMapper atJobApplicantHistoryMapper) {
        this.atJobApplicantHistoryRepository = atJobApplicantHistoryRepository;
        this.atJobApplicantHistoryMapper = atJobApplicantHistoryMapper;
    }

    /**
     * POST  /at-job-applicant-histories : Create a new atJobApplicantHistory.
     *
     * @param atJobApplicantHistoryDTO the atJobApplicantHistoryDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new atJobApplicantHistoryDTO, or with status 400 (Bad Request) if the atJobApplicantHistory has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/at-job-applicant-histories")
    @Timed
    public ResponseEntity<AtJobApplicantHistoryDTO> createAtJobApplicantHistory(@RequestBody AtJobApplicantHistoryDTO atJobApplicantHistoryDTO) throws URISyntaxException {
        log.debug("REST request to save AtJobApplicantHistory : {}", atJobApplicantHistoryDTO);
        if (atJobApplicantHistoryDTO.getId() != null) {
            throw new BadRequestAlertException("A new atJobApplicantHistory cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AtJobApplicantHistory atJobApplicantHistory = atJobApplicantHistoryMapper.toEntity(atJobApplicantHistoryDTO);
        atJobApplicantHistory = atJobApplicantHistoryRepository.save(atJobApplicantHistory);
        AtJobApplicantHistoryDTO result = atJobApplicantHistoryMapper.toDto(atJobApplicantHistory);
        return ResponseEntity.created(new URI("/api/at-job-applicant-histories/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /at-job-applicant-histories : Updates an existing atJobApplicantHistory.
     *
     * @param atJobApplicantHistoryDTO the atJobApplicantHistoryDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated atJobApplicantHistoryDTO,
     * or with status 400 (Bad Request) if the atJobApplicantHistoryDTO is not valid,
     * or with status 500 (Internal Server Error) if the atJobApplicantHistoryDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/at-job-applicant-histories")
    @Timed
    public ResponseEntity<AtJobApplicantHistoryDTO> updateAtJobApplicantHistory(@RequestBody AtJobApplicantHistoryDTO atJobApplicantHistoryDTO) throws URISyntaxException {
        log.debug("REST request to update AtJobApplicantHistory : {}", atJobApplicantHistoryDTO);
        if (atJobApplicantHistoryDTO.getId() == null) {
            return createAtJobApplicantHistory(atJobApplicantHistoryDTO);
        }
        AtJobApplicantHistory atJobApplicantHistory = atJobApplicantHistoryMapper.toEntity(atJobApplicantHistoryDTO);
        atJobApplicantHistory = atJobApplicantHistoryRepository.save(atJobApplicantHistory);
        AtJobApplicantHistoryDTO result = atJobApplicantHistoryMapper.toDto(atJobApplicantHistory);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, atJobApplicantHistoryDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /at-job-applicant-histories : get all the atJobApplicantHistories.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of atJobApplicantHistories in body
     */
    @GetMapping("/at-job-applicant-histories")
    @Timed
    public ResponseEntity<List<AtJobApplicantHistoryDTO>> getAllAtJobApplicantHistories(Pageable pageable) {
        log.debug("REST request to get a page of AtJobApplicantHistories");
        Page<AtJobApplicantHistory> page = atJobApplicantHistoryRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/at-job-applicant-histories");
        return new ResponseEntity<>(atJobApplicantHistoryMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /at-job-applicant-histories/:id : get the "id" atJobApplicantHistory.
     *
     * @param id the id of the atJobApplicantHistoryDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the atJobApplicantHistoryDTO, or with status 404 (Not Found)
     */
    @GetMapping("/at-job-applicant-histories/{id}")
    @Timed
    public ResponseEntity<AtJobApplicantHistoryDTO> getAtJobApplicantHistory(@PathVariable Long id) {
        log.debug("REST request to get AtJobApplicantHistory : {}", id);
        AtJobApplicantHistory atJobApplicantHistory = atJobApplicantHistoryRepository.findById(id);
        AtJobApplicantHistoryDTO atJobApplicantHistoryDTO = atJobApplicantHistoryMapper.toDto(atJobApplicantHistory);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atJobApplicantHistoryDTO));
    }

    @GetMapping("/at-job-applicant-histories/job-application/{id}")
    @Timed
    public ResponseEntity<List<AtJobApplicantHistoryDTO>> getAtJobApplicantHistoryByJobAppId(@PathVariable Long id) {
        log.debug("REST request to get AtJobApplicantHistoryDTO by JobApplication Id : {}", id);
        List<AtJobApplicantHistory> items = atJobApplicantHistoryRepository.findByIdJobApplicationId(id);
        List<AtJobApplicantHistoryDTO> itemsDTO = atJobApplicantHistoryMapper.toDto(items);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(itemsDTO));
    }

    /**
     * DELETE  /at-job-applicant-histories/:id : delete the "id" atJobApplicantHistory.
     *
     * @param id the id of the atJobApplicantHistoryDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/at-job-applicant-histories/{id}")
    @Timed
    public ResponseEntity<Void> deleteAtJobApplicantHistory(@PathVariable Long id) {
        log.debug("REST request to delete AtJobApplicantHistory : {}", id);
        atJobApplicantHistoryRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }


}
