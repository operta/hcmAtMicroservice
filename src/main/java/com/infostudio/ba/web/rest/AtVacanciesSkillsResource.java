package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.AtVacanciesSkills;

import com.infostudio.ba.repository.AtVacanciesSkillsRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.AtVacanciesSkillsDTO;
import com.infostudio.ba.service.mapper.AtVacanciesSkillsMapper;
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
 * REST controller for managing AtVacanciesSkills.
 */
@RestController
@RequestMapping("/api")
public class AtVacanciesSkillsResource {

    private final Logger log = LoggerFactory.getLogger(AtVacanciesSkillsResource.class);

    private static final String ENTITY_NAME = "atVacanciesSkills";

    private final AtVacanciesSkillsRepository atVacanciesSkillsRepository;

    private final AtVacanciesSkillsMapper atVacanciesSkillsMapper;


    public AtVacanciesSkillsResource(AtVacanciesSkillsRepository atVacanciesSkillsRepository, AtVacanciesSkillsMapper atVacanciesSkillsMapper) {
        this.atVacanciesSkillsRepository = atVacanciesSkillsRepository;
        this.atVacanciesSkillsMapper = atVacanciesSkillsMapper;
    }

    /**
     * POST  /at-vacancies-skills : Create a new atVacanciesSkills.
     *
     * @param atVacanciesSkillsDTO the atVacanciesSkillsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new atVacanciesSkillsDTO, or with status 400 (Bad Request) if the atVacanciesSkills has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/at-vacancies-skills")
    @Timed
    public ResponseEntity<AtVacanciesSkillsDTO> createAtVacanciesSkills(@Valid @RequestBody AtVacanciesSkillsDTO atVacanciesSkillsDTO) throws URISyntaxException {
        log.debug("REST request to save AtVacanciesSkills : {}", atVacanciesSkillsDTO);
        if (atVacanciesSkillsDTO.getId() != null) {
            throw new BadRequestAlertException("A new atVacanciesSkills cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AtVacanciesSkills atVacanciesSkills = atVacanciesSkillsMapper.toEntity(atVacanciesSkillsDTO);
        atVacanciesSkills = atVacanciesSkillsRepository.save(atVacanciesSkills);
        AtVacanciesSkillsDTO result = atVacanciesSkillsMapper.toDto(atVacanciesSkills);
        return ResponseEntity.created(new URI("/api/at-vacancies-skills/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /at-vacancies-skills : Updates an existing atVacanciesSkills.
     *
     * @param atVacanciesSkillsDTO the atVacanciesSkillsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated atVacanciesSkillsDTO,
     * or with status 400 (Bad Request) if the atVacanciesSkillsDTO is not valid,
     * or with status 500 (Internal Server Error) if the atVacanciesSkillsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/at-vacancies-skills")
    @Timed
    public ResponseEntity<AtVacanciesSkillsDTO> updateAtVacanciesSkills(@Valid @RequestBody AtVacanciesSkillsDTO atVacanciesSkillsDTO) throws URISyntaxException {
        log.debug("REST request to update AtVacanciesSkills : {}", atVacanciesSkillsDTO);
        if (atVacanciesSkillsDTO.getId() == null) {
            return createAtVacanciesSkills(atVacanciesSkillsDTO);
        }
        AtVacanciesSkills atVacanciesSkills = atVacanciesSkillsMapper.toEntity(atVacanciesSkillsDTO);
        atVacanciesSkills = atVacanciesSkillsRepository.save(atVacanciesSkills);
        AtVacanciesSkillsDTO result = atVacanciesSkillsMapper.toDto(atVacanciesSkills);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, atVacanciesSkillsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /at-vacancies-skills : get all the atVacanciesSkills.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of atVacanciesSkills in body
     */
    @GetMapping("/at-vacancies-skills")
    @Timed
    public ResponseEntity<List<AtVacanciesSkillsDTO>> getAllAtVacanciesSkills(Pageable pageable) {
        log.debug("REST request to get a page of AtVacanciesSkills");
        Page<AtVacanciesSkills> page = atVacanciesSkillsRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/at-vacancies-skills");
        return new ResponseEntity<>(atVacanciesSkillsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /at-vacancies-skills/:id : get the "id" atVacanciesSkills.
     *
     * @param id the id of the atVacanciesSkillsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the atVacanciesSkillsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/at-vacancies-skills/{id}")
    @Timed
    public ResponseEntity<AtVacanciesSkillsDTO> getAtVacanciesSkills(@PathVariable Long id) {
        log.debug("REST request to get AtVacanciesSkills : {}", id);
        AtVacanciesSkills atVacanciesSkills = atVacanciesSkillsRepository.findById(id);
        AtVacanciesSkillsDTO atVacanciesSkillsDTO = atVacanciesSkillsMapper.toDto(atVacanciesSkills);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atVacanciesSkillsDTO));
    }

    /**
     * DELETE  /at-vacancies-skills/:id : delete the "id" atVacanciesSkills.
     *
     * @param id the id of the atVacanciesSkillsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/at-vacancies-skills/{id}")
    @Timed
    public ResponseEntity<Void> deleteAtVacanciesSkills(@PathVariable Long id) {
        log.debug("REST request to delete AtVacanciesSkills : {}", id);
        atVacanciesSkillsRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }


}
