package com.infostudio.ba.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AtApplicantsExperience.class)
public abstract class AtApplicantsExperience_ {

	public static volatile SingularAttribute<AtApplicantsExperience, String> ongoing;
	public static volatile SingularAttribute<AtApplicantsExperience, LocalDate> dateTo;
	public static volatile SingularAttribute<AtApplicantsExperience, String> company;
	public static volatile SingularAttribute<AtApplicantsExperience, String> location;
	public static volatile SingularAttribute<AtApplicantsExperience, Long> id;
	public static volatile SingularAttribute<AtApplicantsExperience, String> position;
	public static volatile SingularAttribute<AtApplicantsExperience, LocalDate> dateFrom;
	public static volatile SingularAttribute<AtApplicantsExperience, AtApplicants> atApplicants;

}

