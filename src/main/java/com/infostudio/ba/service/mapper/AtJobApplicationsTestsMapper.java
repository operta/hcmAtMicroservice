package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.AtJobApplicationsTestsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AtJobApplicationsTests and its DTO AtJobApplicationsTestsDTO.
 */
@Mapper(componentModel = "spring", uses = {AtJobApplicationsMapper.class})
public interface AtJobApplicationsTestsMapper extends EntityMapper<AtJobApplicationsTestsDTO, AtJobApplicationsTests> {

    @Mapping(source = "jobApplicationId.id", target = "jobApplicationIdId")
    AtJobApplicationsTestsDTO toDto(AtJobApplicationsTests atJobApplicationsTests);

    @Mapping(source = "jobApplicationIdId", target = "jobApplicationId")
    AtJobApplicationsTests toEntity(AtJobApplicationsTestsDTO atJobApplicationsTestsDTO);

    default AtJobApplicationsTests fromId(Long id) {
        if (id == null) {
            return null;
        }
        AtJobApplicationsTests atJobApplicationsTests = new AtJobApplicationsTests();
        atJobApplicationsTests.setId(id);
        return atJobApplicationsTests;
    }
}
