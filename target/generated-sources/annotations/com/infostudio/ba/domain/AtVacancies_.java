package com.infostudio.ba.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AtVacancies.class)
public abstract class AtVacancies_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<AtVacancies, String> experienceRequirement;
	public static volatile SingularAttribute<AtVacancies, String> code;
	public static volatile SingularAttribute<AtVacancies, Integer> idWorkPlace;
	public static volatile SingularAttribute<AtVacancies, String> jobWorkingTime;
	public static volatile SingularAttribute<AtVacancies, String> description;
	public static volatile SingularAttribute<AtVacancies, LocalDate> dateFrom;
	public static volatile SingularAttribute<AtVacancies, String> languageRequirement;
	public static volatile SingularAttribute<AtVacancies, Integer> idLocation;
	public static volatile SingularAttribute<AtVacancies, String> name;
	public static volatile SingularAttribute<AtVacancies, LocalDate> dateTo;
	public static volatile SingularAttribute<AtVacancies, String> jobRole;
	public static volatile SingularAttribute<AtVacancies, Long> id;
	public static volatile SingularAttribute<AtVacancies, String> skillsRequirement;
	public static volatile SingularAttribute<AtVacancies, String> educationRequirement;
	public static volatile SingularAttribute<AtVacancies, Integer> status;

}

