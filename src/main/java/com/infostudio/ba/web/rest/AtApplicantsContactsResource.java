package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.AtApplicantsContacts;

import com.infostudio.ba.repository.AtApplicantsContactsRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.AtApplicantsContactsDTO;
import com.infostudio.ba.service.mapper.AtApplicantsContactsMapper;
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
 * REST controller for managing AtApplicantsContacts.
 */
@RestController
@RequestMapping("/api")
public class AtApplicantsContactsResource {

    private final Logger log = LoggerFactory.getLogger(AtApplicantsContactsResource.class);

    private static final String ENTITY_NAME = "atApplicantsContacts";

    private final AtApplicantsContactsRepository atApplicantsContactsRepository;

    private final AtApplicantsContactsMapper atApplicantsContactsMapper;


    public AtApplicantsContactsResource(AtApplicantsContactsRepository atApplicantsContactsRepository, AtApplicantsContactsMapper atApplicantsContactsMapper) {
        this.atApplicantsContactsRepository = atApplicantsContactsRepository;
        this.atApplicantsContactsMapper = atApplicantsContactsMapper;
    }

    /**
     * POST  /at-applicants-contacts : Create a new atApplicantsContacts.
     *
     * @param atApplicantsContactsDTO the atApplicantsContactsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new atApplicantsContactsDTO, or with status 400 (Bad Request) if the atApplicantsContacts has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/at-applicants-contacts")
    @Timed
    public ResponseEntity<AtApplicantsContactsDTO> createAtApplicantsContacts(@Valid @RequestBody AtApplicantsContactsDTO atApplicantsContactsDTO) throws URISyntaxException {
        log.debug("REST request to save AtApplicantsContacts : {}", atApplicantsContactsDTO);
        if (atApplicantsContactsDTO.getId() != null) {
            throw new BadRequestAlertException("A new atApplicantsContacts cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AtApplicantsContacts atApplicantsContacts = atApplicantsContactsMapper.toEntity(atApplicantsContactsDTO);
        atApplicantsContacts = atApplicantsContactsRepository.save(atApplicantsContacts);
        AtApplicantsContactsDTO result = atApplicantsContactsMapper.toDto(atApplicantsContacts);
        return ResponseEntity.created(new URI("/api/at-applicants-contacts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /at-applicants-contacts : Updates an existing atApplicantsContacts.
     *
     * @param atApplicantsContactsDTO the atApplicantsContactsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated atApplicantsContactsDTO,
     * or with status 400 (Bad Request) if the atApplicantsContactsDTO is not valid,
     * or with status 500 (Internal Server Error) if the atApplicantsContactsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/at-applicants-contacts")
    @Timed
    public ResponseEntity<AtApplicantsContactsDTO> updateAtApplicantsContacts(@Valid @RequestBody AtApplicantsContactsDTO atApplicantsContactsDTO) throws URISyntaxException {
        log.debug("REST request to update AtApplicantsContacts : {}", atApplicantsContactsDTO);
        if (atApplicantsContactsDTO.getId() == null) {
            return createAtApplicantsContacts(atApplicantsContactsDTO);
        }
        AtApplicantsContacts atApplicantsContacts = atApplicantsContactsMapper.toEntity(atApplicantsContactsDTO);
        atApplicantsContacts = atApplicantsContactsRepository.save(atApplicantsContacts);
        AtApplicantsContactsDTO result = atApplicantsContactsMapper.toDto(atApplicantsContacts);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, atApplicantsContactsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /at-applicants-contacts : get all the atApplicantsContacts.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of atApplicantsContacts in body
     */
    @GetMapping("/at-applicants-contacts")
    @Timed
    public ResponseEntity<List<AtApplicantsContactsDTO>> getAllAtApplicantsContacts(Pageable pageable) {
        log.debug("REST request to get a page of AtApplicantsContacts");
        Page<AtApplicantsContacts> page = atApplicantsContactsRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/at-applicants-contacts");
        return new ResponseEntity<>(atApplicantsContactsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /at-applicants-contacts/:id : get the "id" atApplicantsContacts.
     *
     * @param id the id of the atApplicantsContactsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the atApplicantsContactsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/at-applicants-contacts/{id}")
    @Timed
    public ResponseEntity<AtApplicantsContactsDTO> getAtApplicantsContacts(@PathVariable Long id) {
        log.debug("REST request to get AtApplicantsContacts : {}", id);
        AtApplicantsContacts atApplicantsContacts = atApplicantsContactsRepository.findById(id);
        AtApplicantsContactsDTO atApplicantsContactsDTO = atApplicantsContactsMapper.toDto(atApplicantsContacts);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atApplicantsContactsDTO));
    }

    @GetMapping("/at-applicants-contacts/applicant/{id}")
    @Timed
    public ResponseEntity<List<AtApplicantsContactsDTO>> getAtApplicantsContactsByAppId(@PathVariable Long id) {
        log.debug("REST request to get AtApplicantsContacts by Applicant Id : {}", id);
        List<AtApplicantsContacts> atApplicantsContacts = atApplicantsContactsRepository.findByIdApllicantId(id);
        List<AtApplicantsContactsDTO> atApplicantsContactsDTO = atApplicantsContactsMapper.toDto(atApplicantsContacts);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atApplicantsContactsDTO));
    }

    /**
     * DELETE  /at-applicants-contacts/:id : delete the "id" atApplicantsContacts.
     *
     * @param id the id of the atApplicantsContactsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/at-applicants-contacts/{id}")
    @Timed
    public ResponseEntity<Void> deleteAtApplicantsContacts(@PathVariable Long id) {
        log.debug("REST request to delete AtApplicantsContacts : {}", id);
        atApplicantsContactsRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }


}
