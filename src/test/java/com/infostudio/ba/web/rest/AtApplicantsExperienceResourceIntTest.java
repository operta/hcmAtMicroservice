package com.infostudio.ba.web.rest;

import com.infostudio.ba.HcmAtMicroserviceApp;

import com.infostudio.ba.domain.AtApplicantsExperience;
import com.infostudio.ba.repository.AtApplicantsExperienceRepository;
import com.infostudio.ba.repository.search.AtApplicantsExperienceSearchRepository;
import com.infostudio.ba.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static com.infostudio.ba.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the AtApplicantsExperienceResource REST controller.
 *
 * @see AtApplicantsExperienceResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HcmAtMicroserviceApp.class)
public class AtApplicantsExperienceResourceIntTest {

    private static final String DEFAULT_COMPANY = "AAAAAAAAAA";
    private static final String UPDATED_COMPANY = "BBBBBBBBBB";

    private static final String DEFAULT_POSITION = "AAAAAAAAAA";
    private static final String UPDATED_POSITION = "BBBBBBBBBB";

    private static final String DEFAULT_LOCATION = "AAAAAAAAAA";
    private static final String UPDATED_LOCATION = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATE_FROM = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_FROM = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_TO = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_TO = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_ONGOING = "AAAAAAAAAA";
    private static final String UPDATED_ONGOING = "BBBBBBBBBB";

    @Autowired
    private AtApplicantsExperienceRepository atApplicantsExperienceRepository;

    @Autowired
    private AtApplicantsExperienceSearchRepository atApplicantsExperienceSearchRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restAtApplicantsExperienceMockMvc;

    private AtApplicantsExperience atApplicantsExperience;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final AtApplicantsExperienceResource atApplicantsExperienceResource = new AtApplicantsExperienceResource(atApplicantsExperienceRepository, atApplicantsExperienceSearchRepository);
        this.restAtApplicantsExperienceMockMvc = MockMvcBuilders.standaloneSetup(atApplicantsExperienceResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AtApplicantsExperience createEntity(EntityManager em) {
        AtApplicantsExperience atApplicantsExperience = new AtApplicantsExperience()
            .company(DEFAULT_COMPANY)
            .position(DEFAULT_POSITION)
            .location(DEFAULT_LOCATION)
            .dateFrom(DEFAULT_DATE_FROM)
            .dateTo(DEFAULT_DATE_TO)
            .ongoing(DEFAULT_ONGOING);
        return atApplicantsExperience;
    }

    @Before
    public void initTest() {
        atApplicantsExperienceSearchRepository.deleteAll();
        atApplicantsExperience = createEntity(em);
    }

    @Test
    @Transactional
    public void createAtApplicantsExperience() throws Exception {
        int databaseSizeBeforeCreate = atApplicantsExperienceRepository.findAll().size();

        // Create the AtApplicantsExperience
        restAtApplicantsExperienceMockMvc.perform(post("/api/at-applicants-experiences")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(atApplicantsExperience)))
            .andExpect(status().isCreated());

        // Validate the AtApplicantsExperience in the database
        List<AtApplicantsExperience> atApplicantsExperienceList = atApplicantsExperienceRepository.findAll();
        assertThat(atApplicantsExperienceList).hasSize(databaseSizeBeforeCreate + 1);
        AtApplicantsExperience testAtApplicantsExperience = atApplicantsExperienceList.get(atApplicantsExperienceList.size() - 1);
        assertThat(testAtApplicantsExperience.getCompany()).isEqualTo(DEFAULT_COMPANY);
        assertThat(testAtApplicantsExperience.getPosition()).isEqualTo(DEFAULT_POSITION);
        assertThat(testAtApplicantsExperience.getLocation()).isEqualTo(DEFAULT_LOCATION);
        assertThat(testAtApplicantsExperience.getDateFrom()).isEqualTo(DEFAULT_DATE_FROM);
        assertThat(testAtApplicantsExperience.getDateTo()).isEqualTo(DEFAULT_DATE_TO);
        assertThat(testAtApplicantsExperience.getOngoing()).isEqualTo(DEFAULT_ONGOING);

        // Validate the AtApplicantsExperience in Elasticsearch
        AtApplicantsExperience atApplicantsExperienceEs = atApplicantsExperienceSearchRepository.findOne(testAtApplicantsExperience.getId());
        assertThat(atApplicantsExperienceEs).isEqualToIgnoringGivenFields(testAtApplicantsExperience);
    }

    @Test
    @Transactional
    public void createAtApplicantsExperienceWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = atApplicantsExperienceRepository.findAll().size();

        // Create the AtApplicantsExperience with an existing ID
        atApplicantsExperience.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAtApplicantsExperienceMockMvc.perform(post("/api/at-applicants-experiences")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(atApplicantsExperience)))
            .andExpect(status().isBadRequest());

        // Validate the AtApplicantsExperience in the database
        List<AtApplicantsExperience> atApplicantsExperienceList = atApplicantsExperienceRepository.findAll();
        assertThat(atApplicantsExperienceList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllAtApplicantsExperiences() throws Exception {
        // Initialize the database
        atApplicantsExperienceRepository.saveAndFlush(atApplicantsExperience);

        // Get all the atApplicantsExperienceList
        restAtApplicantsExperienceMockMvc.perform(get("/api/at-applicants-experiences?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(atApplicantsExperience.getId().intValue())))
            .andExpect(jsonPath("$.[*].company").value(hasItem(DEFAULT_COMPANY.toString())))
            .andExpect(jsonPath("$.[*].position").value(hasItem(DEFAULT_POSITION.toString())))
            .andExpect(jsonPath("$.[*].location").value(hasItem(DEFAULT_LOCATION.toString())))
            .andExpect(jsonPath("$.[*].dateFrom").value(hasItem(DEFAULT_DATE_FROM.toString())))
            .andExpect(jsonPath("$.[*].dateTo").value(hasItem(DEFAULT_DATE_TO.toString())))
            .andExpect(jsonPath("$.[*].ongoing").value(hasItem(DEFAULT_ONGOING.toString())));
    }

    @Test
    @Transactional
    public void getAtApplicantsExperience() throws Exception {
        // Initialize the database
        atApplicantsExperienceRepository.saveAndFlush(atApplicantsExperience);

        // Get the atApplicantsExperience
        restAtApplicantsExperienceMockMvc.perform(get("/api/at-applicants-experiences/{id}", atApplicantsExperience.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(atApplicantsExperience.getId().intValue()))
            .andExpect(jsonPath("$.company").value(DEFAULT_COMPANY.toString()))
            .andExpect(jsonPath("$.position").value(DEFAULT_POSITION.toString()))
            .andExpect(jsonPath("$.location").value(DEFAULT_LOCATION.toString()))
            .andExpect(jsonPath("$.dateFrom").value(DEFAULT_DATE_FROM.toString()))
            .andExpect(jsonPath("$.dateTo").value(DEFAULT_DATE_TO.toString()))
            .andExpect(jsonPath("$.ongoing").value(DEFAULT_ONGOING.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingAtApplicantsExperience() throws Exception {
        // Get the atApplicantsExperience
        restAtApplicantsExperienceMockMvc.perform(get("/api/at-applicants-experiences/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAtApplicantsExperience() throws Exception {
        // Initialize the database
        atApplicantsExperienceRepository.saveAndFlush(atApplicantsExperience);
        atApplicantsExperienceSearchRepository.save(atApplicantsExperience);
        int databaseSizeBeforeUpdate = atApplicantsExperienceRepository.findAll().size();

        // Update the atApplicantsExperience
        AtApplicantsExperience updatedAtApplicantsExperience = atApplicantsExperienceRepository.findOne(atApplicantsExperience.getId());
        // Disconnect from session so that the updates on updatedAtApplicantsExperience are not directly saved in db
        em.detach(updatedAtApplicantsExperience);
        updatedAtApplicantsExperience
            .company(UPDATED_COMPANY)
            .position(UPDATED_POSITION)
            .location(UPDATED_LOCATION)
            .dateFrom(UPDATED_DATE_FROM)
            .dateTo(UPDATED_DATE_TO)
            .ongoing(UPDATED_ONGOING);

        restAtApplicantsExperienceMockMvc.perform(put("/api/at-applicants-experiences")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedAtApplicantsExperience)))
            .andExpect(status().isOk());

        // Validate the AtApplicantsExperience in the database
        List<AtApplicantsExperience> atApplicantsExperienceList = atApplicantsExperienceRepository.findAll();
        assertThat(atApplicantsExperienceList).hasSize(databaseSizeBeforeUpdate);
        AtApplicantsExperience testAtApplicantsExperience = atApplicantsExperienceList.get(atApplicantsExperienceList.size() - 1);
        assertThat(testAtApplicantsExperience.getCompany()).isEqualTo(UPDATED_COMPANY);
        assertThat(testAtApplicantsExperience.getPosition()).isEqualTo(UPDATED_POSITION);
        assertThat(testAtApplicantsExperience.getLocation()).isEqualTo(UPDATED_LOCATION);
        assertThat(testAtApplicantsExperience.getDateFrom()).isEqualTo(UPDATED_DATE_FROM);
        assertThat(testAtApplicantsExperience.getDateTo()).isEqualTo(UPDATED_DATE_TO);
        assertThat(testAtApplicantsExperience.getOngoing()).isEqualTo(UPDATED_ONGOING);

        // Validate the AtApplicantsExperience in Elasticsearch
        AtApplicantsExperience atApplicantsExperienceEs = atApplicantsExperienceSearchRepository.findOne(testAtApplicantsExperience.getId());
        assertThat(atApplicantsExperienceEs).isEqualToIgnoringGivenFields(testAtApplicantsExperience);
    }

    @Test
    @Transactional
    public void updateNonExistingAtApplicantsExperience() throws Exception {
        int databaseSizeBeforeUpdate = atApplicantsExperienceRepository.findAll().size();

        // Create the AtApplicantsExperience

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restAtApplicantsExperienceMockMvc.perform(put("/api/at-applicants-experiences")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(atApplicantsExperience)))
            .andExpect(status().isCreated());

        // Validate the AtApplicantsExperience in the database
        List<AtApplicantsExperience> atApplicantsExperienceList = atApplicantsExperienceRepository.findAll();
        assertThat(atApplicantsExperienceList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteAtApplicantsExperience() throws Exception {
        // Initialize the database
        atApplicantsExperienceRepository.saveAndFlush(atApplicantsExperience);
        atApplicantsExperienceSearchRepository.save(atApplicantsExperience);
        int databaseSizeBeforeDelete = atApplicantsExperienceRepository.findAll().size();

        // Get the atApplicantsExperience
        restAtApplicantsExperienceMockMvc.perform(delete("/api/at-applicants-experiences/{id}", atApplicantsExperience.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate Elasticsearch is empty
        boolean atApplicantsExperienceExistsInEs = atApplicantsExperienceSearchRepository.exists(atApplicantsExperience.getId());
        assertThat(atApplicantsExperienceExistsInEs).isFalse();

        // Validate the database is empty
        List<AtApplicantsExperience> atApplicantsExperienceList = atApplicantsExperienceRepository.findAll();
        assertThat(atApplicantsExperienceList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void searchAtApplicantsExperience() throws Exception {
        // Initialize the database
        atApplicantsExperienceRepository.saveAndFlush(atApplicantsExperience);
        atApplicantsExperienceSearchRepository.save(atApplicantsExperience);

        // Search the atApplicantsExperience
        restAtApplicantsExperienceMockMvc.perform(get("/api/_search/at-applicants-experiences?query=id:" + atApplicantsExperience.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(atApplicantsExperience.getId().intValue())))
            .andExpect(jsonPath("$.[*].company").value(hasItem(DEFAULT_COMPANY.toString())))
            .andExpect(jsonPath("$.[*].position").value(hasItem(DEFAULT_POSITION.toString())))
            .andExpect(jsonPath("$.[*].location").value(hasItem(DEFAULT_LOCATION.toString())))
            .andExpect(jsonPath("$.[*].dateFrom").value(hasItem(DEFAULT_DATE_FROM.toString())))
            .andExpect(jsonPath("$.[*].dateTo").value(hasItem(DEFAULT_DATE_TO.toString())))
            .andExpect(jsonPath("$.[*].ongoing").value(hasItem(DEFAULT_ONGOING.toString())));
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AtApplicantsExperience.class);
        AtApplicantsExperience atApplicantsExperience1 = new AtApplicantsExperience();
        atApplicantsExperience1.setId(1L);
        AtApplicantsExperience atApplicantsExperience2 = new AtApplicantsExperience();
        atApplicantsExperience2.setId(atApplicantsExperience1.getId());
        assertThat(atApplicantsExperience1).isEqualTo(atApplicantsExperience2);
        atApplicantsExperience2.setId(2L);
        assertThat(atApplicantsExperience1).isNotEqualTo(atApplicantsExperience2);
        atApplicantsExperience1.setId(null);
        assertThat(atApplicantsExperience1).isNotEqualTo(atApplicantsExperience2);
    }
}
