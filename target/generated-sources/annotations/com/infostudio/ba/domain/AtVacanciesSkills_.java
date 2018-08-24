package com.infostudio.ba.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AtVacanciesSkills.class)
public abstract class AtVacanciesSkills_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<AtVacanciesSkills, Integer> skillId;
	public static volatile SingularAttribute<AtVacanciesSkills, Integer> gradeId;
	public static volatile SingularAttribute<AtVacanciesSkills, Long> id;
	public static volatile SingularAttribute<AtVacanciesSkills, AtVacancies> vacancyId;

}

