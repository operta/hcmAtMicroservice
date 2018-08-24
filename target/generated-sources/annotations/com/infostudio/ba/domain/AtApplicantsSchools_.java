package com.infostudio.ba.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AtApplicantsSchools.class)
public abstract class AtApplicantsSchools_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<AtApplicantsSchools, String> major;
	public static volatile SingularAttribute<AtApplicantsSchools, String> school;
	public static volatile SingularAttribute<AtApplicantsSchools, Integer> grade;
	public static volatile SingularAttribute<AtApplicantsSchools, LocalDate> dateTo;
	public static volatile SingularAttribute<AtApplicantsSchools, String> degree;
	public static volatile SingularAttribute<AtApplicantsSchools, String> link;
	public static volatile SingularAttribute<AtApplicantsSchools, String> description;
	public static volatile SingularAttribute<AtApplicantsSchools, Long> id;
	public static volatile SingularAttribute<AtApplicantsSchools, AtApplicants> idApplicant;
	public static volatile SingularAttribute<AtApplicantsSchools, LocalDate> dateFrom;
	public static volatile SingularAttribute<AtApplicantsSchools, Integer> idQualifcation;
	public static volatile SingularAttribute<AtApplicantsSchools, Integer> idSchool;

}

