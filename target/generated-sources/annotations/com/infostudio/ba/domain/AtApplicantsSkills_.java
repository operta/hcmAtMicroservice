package com.infostudio.ba.domain;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AtApplicantsSkills.class)
public abstract class AtApplicantsSkills_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<AtApplicantsSkills, Integer> idSkill;
	public static volatile SingularAttribute<AtApplicantsSkills, String> skill;
	public static volatile SingularAttribute<AtApplicantsSkills, String> grade;
	public static volatile SingularAttribute<AtApplicantsSkills, Long> id;
	public static volatile SingularAttribute<AtApplicantsSkills, AtApplicants> idApplicant;
	public static volatile SingularAttribute<AtApplicantsSkills, Integer> idGrade;
	public static volatile SingularAttribute<AtApplicantsSkills, Instant> dateSkill;

}

