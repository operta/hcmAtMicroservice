package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.AtApplicants;
import com.infostudio.ba.domain.AtVacancies;

import com.infostudio.ba.repository.AtVacanciesRepository;
import com.infostudio.ba.service.dto.AtApplicantsDTO;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.AtVacanciesDTO;
import com.infostudio.ba.service.mapper.AtVacanciesMapper;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


/**
 * REST controller for managing AtVacancies.
 */
@RestController
@RequestMapping("/api")
public class AtVacanciesResource {

    private final Logger log = LoggerFactory.getLogger(AtVacanciesResource.class);

    private static final String ENTITY_NAME = "atVacancies";

    private final AtVacanciesRepository atVacanciesRepository;

    private final AtVacanciesMapper atVacanciesMapper;


    public AtVacanciesResource(AtVacanciesRepository atVacanciesRepository, AtVacanciesMapper atVacanciesMapper) {
        this.atVacanciesRepository = atVacanciesRepository;
        this.atVacanciesMapper = atVacanciesMapper;
    }

    /**
     * POST  /at-vacancies : Create a new atVacancies.
     *
     * @param atVacanciesDTO the atVacanciesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new atVacanciesDTO, or with status 400 (Bad Request) if the atVacancies has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/at-vacancies")
    @Timed
    public ResponseEntity<AtVacanciesDTO> createAtVacancies(@Valid @RequestBody AtVacanciesDTO atVacanciesDTO) throws URISyntaxException {
        log.debug("REST request to save AtVacancies : {}", atVacanciesDTO);
        if (atVacanciesDTO.getId() != null) {
            throw new BadRequestAlertException("A new atVacancies cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AtVacancies atVacancies = atVacanciesMapper.toEntity(atVacanciesDTO);
        atVacancies = atVacanciesRepository.save(atVacancies);
        AtVacanciesDTO result = atVacanciesMapper.toDto(atVacancies);
        return ResponseEntity.created(new URI("/api/at-vacancies/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /at-vacancies : Updates an existing atVacancies.
     *
     * @param atVacanciesDTO the atVacanciesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated atVacanciesDTO,
     * or with status 400 (Bad Request) if the atVacanciesDTO is not valid,
     * or with status 500 (Internal Server Error) if the atVacanciesDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/at-vacancies")
    @Timed
    public ResponseEntity<AtVacanciesDTO> updateAtVacancies(@Valid @RequestBody AtVacanciesDTO atVacanciesDTO) throws URISyntaxException {
        log.debug("REST request to update AtVacancies : {}", atVacanciesDTO);
        if (atVacanciesDTO.getId() == null) {
            return createAtVacancies(atVacanciesDTO);
        }
        AtVacancies atVacancies = atVacanciesMapper.toEntity(atVacanciesDTO);
        atVacancies = atVacanciesRepository.save(atVacancies);
        AtVacanciesDTO result = atVacanciesMapper.toDto(atVacancies);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, atVacanciesDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /at-vacancies : get all the atVacancies.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of atVacancies in body
     */
    @GetMapping("/at-vacancies")
    @Timed
    public ResponseEntity<List<AtVacanciesDTO>> getAllAtVacancies(
        Pageable pageable,
        @RequestParam(value = "fromDate", required = false) LocalDate fromDate,
        @RequestParam(value = "toDate", required = false) LocalDate toDate,
        @RequestParam(value = "name", required = false) String name,
        @RequestParam(value = "statusId", required = false) Integer statusId,
        @RequestParam(value = "regionId", required = false) Integer regionId
        ) {
        System.out.println("HERE ________________----!!!!!!");
        System.out.println(name);
        log.debug("REST request to get a page of AtVacancies");
        Set<Integer> vacancyIds = new HashSet<Integer>(Arrays.asList(extractIds(atVacanciesRepository.findAll())));

        if(fromDate != null) {
            List<AtVacancies> list  = atVacanciesRepository.findByDateFromGreaterThanEqual(fromDate);
            Set<Integer> s = new HashSet<Integer>(Arrays.asList(extractIds(list)));
            vacancyIds.retainAll(s);
        }
        if(toDate != null) {
            List<AtVacancies> list = atVacanciesRepository.findByDateToLessThanEqual(toDate);
            Set<Integer> s = new HashSet<Integer>(Arrays.asList(extractIds(list)));
            vacancyIds.retainAll(s);
        }
        if(name != null) {
            List<AtVacancies> list = atVacanciesRepository.findByNameContainingIgnoreCase(name);
            Set<Integer> s = new HashSet<Integer>(Arrays.asList(extractIds(list)));
            vacancyIds.retainAll(s);
        }
        if(statusId != null) {
            List<AtVacancies> list = atVacanciesRepository.findByStatus(statusId);
            Set<Integer> s = new HashSet<Integer>(Arrays.asList(extractIds(list)));
            vacancyIds.retainAll(s);
        }
        if(regionId != null) {
            List<AtVacancies> list = atVacanciesRepository.findByIdLocation(regionId);
            Set<Integer> s = new HashSet<Integer>(Arrays.asList(extractIds(list)));
            vacancyIds.retainAll(s);
        }

        Integer[] result = vacancyIds.toArray(new Integer[vacancyIds.size()]);


        List<AtVacancies> vacancies = new ArrayList<AtVacancies>();
        for(int i = 0; i < result.length; i++) {
            AtVacancies item = atVacanciesRepository.findById(result[i].longValue());
            vacancies.add(item);
        }

        Page<AtVacancies> page = new PageImpl<AtVacancies>(vacancies, pageable, vacancies.size());
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/at-vacancies");
        return new ResponseEntity<>(atVacanciesMapper.toDto(page.getContent()), headers, HttpStatus.OK);

    }

    public static Integer[] extractIds(List<AtVacancies> array) {
        if(array.size() == 0) {
            return new Integer[0];
        }
        Integer[] result = new Integer[array.size()];
        for(int i = 0; i < array.size(); i++) {
            result[i] = (array.get(i).getId().intValue());
        }
        return result;
    }



    /**
     * GET  /at-vacancies/:id : get the "id" atVacancies.
     *
     * @param id the id of the atVacanciesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the atVacanciesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/at-vacancies/{id}")
    @Timed
    public ResponseEntity<AtVacanciesDTO> getAtVacancies(@PathVariable Long id) {
        log.debug("REST request to get AtVacancies : {}", id);
        AtVacancies atVacancies = atVacanciesRepository.findById(id);
        AtVacanciesDTO atVacanciesDTO = atVacanciesMapper.toDto(atVacancies);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(atVacanciesDTO));
    }

    /**
     * DELETE  /at-vacancies/:id : delete the "id" atVacancies.
     *
     * @param id the id of the atVacanciesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/at-vacancies/{id}")
    @Timed
    public ResponseEntity<Void> deleteAtVacancies(@PathVariable Long id) {
        log.debug("REST request to delete AtVacancies : {}", id);
        atVacanciesRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }


}
