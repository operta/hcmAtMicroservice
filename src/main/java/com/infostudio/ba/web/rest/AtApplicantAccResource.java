package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.AtApplicantAcc;
import com.infostudio.ba.repository.AtApplicantAccRepository;
import com.infostudio.ba.service.dto.AtApplicantAccDTO;
import com.infostudio.ba.service.mapper.AtApplicantAccMapper;
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
 * REST controller for managing AtApplicantAcc.
 */
@RestController
@RequestMapping("/api")
public class AtApplicantAccResource {

    private final Logger log = LoggerFactory.getLogger(AtApplicantAccResource.class);

    private static final String ENTITY_NAME = "atApplicantAcc";

    private final AtApplicantAccRepository atApplicantAccRepository;

    private final AtApplicantAccMapper atApplicantAccMapper;


    public AtApplicantAccResource(AtApplicantAccRepository atApplicantAccRepository, AtApplicantAccMapper atApplicantAccMapper) {
        this.atApplicantAccRepository = atApplicantAccRepository;
        this.atApplicantAccMapper = atApplicantAccMapper;
    }

    /**
     * POST  /at-applicant-accs : Create a new atApplicantAcc.
     *
     * @param atApplicantAccDTO the atApplicantAccDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new atApplicantAccDTO, or with status 400 (Bad Request) if the atApplicantAcc has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/at-applicant-accs")
    @Timed
    public ResponseEntity<AtApplicantAccDTO> createAtApplicantAcc(@Valid @RequestBody AtApplicantAccDTO atApplicantAccDTO) throws URISyntaxException {
        log.debug("REST request to save AtApplicantAcc : {}", atApplicantAccDTO);
        if (atApplicantAccDTO.getId() != null) {
            throw new BadRequestAlertException("A new atApplicantAcc cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AtApplicantAcc atApplicantAcc = atApplicantAccMapper.toEntity(atApplicantAccDTO);
        atApplicantAcc = atApplicantAccRepository.save(atApplicantAcc);
        AtApplicantAccDTO result = atApplicantAccMapper.toDto(atApplicantAcc);
        return ResponseEntity.created(new URI("/api/at-applicant-accs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /at-applicant-accs : Updates an existing atApplicantAcc.
     *
     * @param atApplicantAccDTO the atApplicantAccDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated atApplicantAccDTO,
     * or with status 400 (Bad Request) if the atApplicantAccDTO is not valid,
     * or with status 500 (Internal Server Error) if the atApplicantAccDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/at-applicant-accs")
    @Timed
    public ResponseEntity<AtApplicantAccDTO> updateAtApplicantAcc(@Valid @RequestBody AtApplicantAccDTO atApplicantAccDTO) throws URISyntaxException {
        log.debug("REST request to update AtApplicantAcc : {}", atApplicantAccDTO);
        if (atApplicantAccDTO.getId() == null) {
            return createAtApplicantAcc(atApplicantAccDTO);
        }
        AtApplicantAcc atApplicantAcc = atApplicantAccMapper.toEntity(atApplicantAccDTO);
        atApplicantAcc = atApplicantAccRepository.save(atApplicantAcc);
        AtApplicantAccDTO result = atApplicantAccMapper.toDto(atApplicantAcc);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, atApplicantAccDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /at-applicant-accs : get all the atApplicantAccs.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of atApplicantAccs in body
     */
    @GetMapping("/at-applicant-accs")
    @Timed
    public ResponseEntity<List<AtApplicantAccDTO>> getAllAtApplicantAccs(Pageable pageable) {
        log.debug("REST request to get a page of AtApplicantAccs");
        Page<AtApplicantAcc> page = atApplicantAccRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/at-applicant-accs");
        return new ResponseEntity<>(atApplicantAccMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /at-applicant-accs/:id : get the "id" atApplicantAcc.
     *
     * @param id the id of the atApplicantAccDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the atApplicantAccDTO, or with status 404 (Not Found)
     */
    @GetMapping("/at-applicant-accs/{id}")
    @Timed
    public ResponseEntity<AtApplicantAccDTO> getAtApplicantAcc(@PathVariable Long id) {
        log.debug("REST request to get AtApplicantAcc : {}", id);
        AtApplicantAcc atApplicantAcc = atApplicantAccRepository.findOne(id);
        AtApplicantAccDTO atApplicantAccDTO = atApplicantAccMapper.toDto(atApplicantAcc);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atApplicantAccDTO));
    }

    @GetMapping("/at-applicant-accs/applicant/{id}")
    @Timed
    public ResponseEntity<List<AtApplicantAccDTO>> getAtApplicantAccByAppId(@PathVariable Long id) {
        log.debug("REST request to get AtApplicantAcc by Applicant Id : {}", id);
        List<AtApplicantAcc> atApplicantAcc = atApplicantAccRepository.findByIdApplicantId(id);
        List<AtApplicantAccDTO> atApplicantAccDTO = atApplicantAccMapper.toDto(atApplicantAcc);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atApplicantAccDTO));
    }

    /**
     * DELETE  /at-applicant-accs/:id : delete the "id" atApplicantAcc.
     *
     * @param id the id of the atApplicantAccDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/at-applicant-accs/{id}")
    @Timed
    public ResponseEntity<Void> deleteAtApplicantAcc(@PathVariable Long id) {
        log.debug("REST request to delete AtApplicantAcc : {}", id);
        atApplicantAccRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }


}
