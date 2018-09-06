package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.AtApplicantsExperience;
import com.infostudio.ba.repository.AtApplicantsExperienceRepository;
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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

/**
 * REST controller for managing AtApplicantsExperience.
 */
@RestController
@RequestMapping("/api")
public class AtApplicantsExperienceResource {

    private final Logger log = LoggerFactory.getLogger(AtApplicantsExperienceResource.class);

    private static final String ENTITY_NAME = "atApplicantsExperience";

    private final AtApplicantsExperienceRepository atApplicantsExperienceRepository;


    public AtApplicantsExperienceResource(AtApplicantsExperienceRepository atApplicantsExperienceRepository) {
        this.atApplicantsExperienceRepository = atApplicantsExperienceRepository;
    }

    /**
     * POST  /at-applicants-experiences : Create a new atApplicantsExperience.
     *
     * @param atApplicantsExperience the atApplicantsExperience to create
     * @return the ResponseEntity with status 201 (Created) and with body the new atApplicantsExperience, or with status 400 (Bad Request) if the atApplicantsExperience has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/at-applicants-experiences")
    @Timed
    public ResponseEntity<AtApplicantsExperience> createAtApplicantsExperience(@RequestBody AtApplicantsExperience atApplicantsExperience) throws URISyntaxException {
        log.debug("REST request to save AtApplicantsExperience : {}", atApplicantsExperience);
        if (atApplicantsExperience.getId() != null) {
            throw new BadRequestAlertException("A new atApplicantsExperience cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AtApplicantsExperience result = atApplicantsExperienceRepository.save(atApplicantsExperience);
        return ResponseEntity.created(new URI("/api/at-applicants-experiences/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /at-applicants-experiences : Updates an existing atApplicantsExperience.
     *
     * @param atApplicantsExperience the atApplicantsExperience to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated atApplicantsExperience,
     * or with status 400 (Bad Request) if the atApplicantsExperience is not valid,
     * or with status 500 (Internal Server Error) if the atApplicantsExperience couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/at-applicants-experiences")
    @Timed
    public ResponseEntity<AtApplicantsExperience> updateAtApplicantsExperience(@RequestBody AtApplicantsExperience atApplicantsExperience) throws URISyntaxException {
        log.debug("REST request to update AtApplicantsExperience : {}", atApplicantsExperience);
        if (atApplicantsExperience.getId() == null) {
            return createAtApplicantsExperience(atApplicantsExperience);
        }
        AtApplicantsExperience result = atApplicantsExperienceRepository.save(atApplicantsExperience);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, atApplicantsExperience.getId().toString()))
            .body(result);
    }

    /**
     * GET  /at-applicants-experiences : get all the atApplicantsExperiences.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of atApplicantsExperiences in body
     */
    @GetMapping("/at-applicants-experiences")
    @Timed
    public ResponseEntity<List<AtApplicantsExperience>> getAllAtApplicantsExperiences(Pageable pageable) {
        log.debug("REST request to get a page of AtApplicantsExperiences");
        Page<AtApplicantsExperience> page = atApplicantsExperienceRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/at-applicants-experiences");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /at-applicants-experiences/:id : get the "id" atApplicantsExperience.
     *
     * @param id the id of the atApplicantsExperience to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the atApplicantsExperience, or with status 404 (Not Found)
     */
    @GetMapping("/at-applicants-experiences/{id}")
    @Timed
    public ResponseEntity<AtApplicantsExperience> getAtApplicantsExperience(@PathVariable Long id) {
        log.debug("REST request to get AtApplicantsExperience : {}", id);
        AtApplicantsExperience atApplicantsExperience = atApplicantsExperienceRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atApplicantsExperience));
    }

    @GetMapping("/at-applicants-experiences/applicant/{id}")
    @Timed
    public ResponseEntity<List<AtApplicantsExperience>> getAtApplicantsExperienceByAppId(@PathVariable Long id) {
        log.debug("REST request to get AtApplicantsExperience by Applicant Id : {}", id);
        List<AtApplicantsExperience> atApplicantsExperience = atApplicantsExperienceRepository.findByAtApplicantsId(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atApplicantsExperience));
    }

    /**
     * DELETE  /at-applicants-experiences/:id : delete the "id" atApplicantsExperience.
     *
     * @param id the id of the atApplicantsExperience to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/at-applicants-experiences/{id}")
    @Timed
    public ResponseEntity<Void> deleteAtApplicantsExperience(@PathVariable Long id) {
        log.debug("REST request to delete AtApplicantsExperience : {}", id);
        atApplicantsExperienceRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }



}
