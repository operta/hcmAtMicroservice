package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.AtApplicantsSkills;

import com.infostudio.ba.repository.AtApplicantsSkillsRepository;
import com.infostudio.ba.repository.search.AtApplicantsSkillsSearchRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.AtApplicantsSkillsDTO;
import com.infostudio.ba.service.mapper.AtApplicantsSkillsMapper;
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

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing AtApplicantsSkills.
 */
@RestController
@RequestMapping("/api")
public class AtApplicantsSkillsResource {

    private final Logger log = LoggerFactory.getLogger(AtApplicantsSkillsResource.class);

    private static final String ENTITY_NAME = "atApplicantsSkills";

    private final AtApplicantsSkillsRepository atApplicantsSkillsRepository;

    private final AtApplicantsSkillsMapper atApplicantsSkillsMapper;

    private final AtApplicantsSkillsSearchRepository atApplicantsSkillsSearchRepository;

    public AtApplicantsSkillsResource(AtApplicantsSkillsRepository atApplicantsSkillsRepository, AtApplicantsSkillsMapper atApplicantsSkillsMapper, AtApplicantsSkillsSearchRepository atApplicantsSkillsSearchRepository) {
        this.atApplicantsSkillsRepository = atApplicantsSkillsRepository;
        this.atApplicantsSkillsMapper = atApplicantsSkillsMapper;
        this.atApplicantsSkillsSearchRepository = atApplicantsSkillsSearchRepository;
    }

    /**
     * POST  /at-applicants-skills : Create a new atApplicantsSkills.
     *
     * @param atApplicantsSkillsDTO the atApplicantsSkillsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new atApplicantsSkillsDTO, or with status 400 (Bad Request) if the atApplicantsSkills has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/at-applicants-skills")
    @Timed
    public ResponseEntity<AtApplicantsSkillsDTO> createAtApplicantsSkills(@RequestBody AtApplicantsSkillsDTO atApplicantsSkillsDTO) throws URISyntaxException {
        log.debug("REST request to save AtApplicantsSkills : {}", atApplicantsSkillsDTO);
        if (atApplicantsSkillsDTO.getId() != null) {
            throw new BadRequestAlertException("A new atApplicantsSkills cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AtApplicantsSkills atApplicantsSkills = atApplicantsSkillsMapper.toEntity(atApplicantsSkillsDTO);
        atApplicantsSkills = atApplicantsSkillsRepository.save(atApplicantsSkills);
        AtApplicantsSkillsDTO result = atApplicantsSkillsMapper.toDto(atApplicantsSkills);
        atApplicantsSkillsSearchRepository.save(atApplicantsSkills);
        return ResponseEntity.created(new URI("/api/at-applicants-skills/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /at-applicants-skills : Updates an existing atApplicantsSkills.
     *
     * @param atApplicantsSkillsDTO the atApplicantsSkillsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated atApplicantsSkillsDTO,
     * or with status 400 (Bad Request) if the atApplicantsSkillsDTO is not valid,
     * or with status 500 (Internal Server Error) if the atApplicantsSkillsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/at-applicants-skills")
    @Timed
    public ResponseEntity<AtApplicantsSkillsDTO> updateAtApplicantsSkills(@RequestBody AtApplicantsSkillsDTO atApplicantsSkillsDTO) throws URISyntaxException {
        log.debug("REST request to update AtApplicantsSkills : {}", atApplicantsSkillsDTO);
        if (atApplicantsSkillsDTO.getId() == null) {
            return createAtApplicantsSkills(atApplicantsSkillsDTO);
        }
        AtApplicantsSkills atApplicantsSkills = atApplicantsSkillsMapper.toEntity(atApplicantsSkillsDTO);
        atApplicantsSkills = atApplicantsSkillsRepository.save(atApplicantsSkills);
        AtApplicantsSkillsDTO result = atApplicantsSkillsMapper.toDto(atApplicantsSkills);
        atApplicantsSkillsSearchRepository.save(atApplicantsSkills);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, atApplicantsSkillsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /at-applicants-skills : get all the atApplicantsSkills.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of atApplicantsSkills in body
     */
    @GetMapping("/at-applicants-skills")
    @Timed
    public ResponseEntity<List<AtApplicantsSkillsDTO>> getAllAtApplicantsSkills(Pageable pageable) {
        log.debug("REST request to get a page of AtApplicantsSkills");
        Page<AtApplicantsSkills> page = atApplicantsSkillsRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/at-applicants-skills");
        return new ResponseEntity<>(atApplicantsSkillsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /at-applicants-skills/:id : get the "id" atApplicantsSkills.
     *
     * @param id the id of the atApplicantsSkillsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the atApplicantsSkillsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/at-applicants-skills/{id}")
    @Timed
    public ResponseEntity<AtApplicantsSkillsDTO> getAtApplicantsSkills(@PathVariable Long id) {
        log.debug("REST request to get AtApplicantsSkills : {}", id);
        AtApplicantsSkills atApplicantsSkills = atApplicantsSkillsRepository.findOne(id);
        AtApplicantsSkillsDTO atApplicantsSkillsDTO = atApplicantsSkillsMapper.toDto(atApplicantsSkills);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atApplicantsSkillsDTO));
    }

    @GetMapping("/at-applicants-skills/applicant/{id}")
    @Timed
    public ResponseEntity<List<AtApplicantsSkillsDTO>> getAtApplicantsSkillsByAppId(@PathVariable Long id) {
        log.debug("REST request to get AtApplicantsSkills by Applicant Id : {}", id);
        List<AtApplicantsSkills> atApplicantsSkills = atApplicantsSkillsRepository.findByIdApplicantId(id);
        List<AtApplicantsSkillsDTO> atApplicantsSkillsDTO = atApplicantsSkillsMapper.toDto(atApplicantsSkills);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atApplicantsSkillsDTO));
    }

    /**
     * DELETE  /at-applicants-skills/:id : delete the "id" atApplicantsSkills.
     *
     * @param id the id of the atApplicantsSkillsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/at-applicants-skills/{id}")
    @Timed
    public ResponseEntity<Void> deleteAtApplicantsSkills(@PathVariable Long id) {
        log.debug("REST request to delete AtApplicantsSkills : {}", id);
        atApplicantsSkillsRepository.delete(id);
        atApplicantsSkillsSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/at-applicants-skills?query=:query : search for the atApplicantsSkills corresponding
     * to the query.
     *
     * @param query the query of the atApplicantsSkills search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/at-applicants-skills")
    @Timed
    public ResponseEntity<List<AtApplicantsSkillsDTO>> searchAtApplicantsSkills(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of AtApplicantsSkills for query {}", query);
        Page<AtApplicantsSkills> page = atApplicantsSkillsSearchRepository.search(queryStringQuery(query), pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/at-applicants-skills");
        return new ResponseEntity<>(atApplicantsSkillsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

}
