package com.infostudio.ba.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AtJAInt.class)
public abstract class AtJAInt_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<AtJAInt, Integer> locationId;
	public static volatile SingularAttribute<AtJAInt, Integer> grade;
	public static volatile SingularAttribute<AtJAInt, String> description;
	public static volatile SingularAttribute<AtJAInt, LocalDate> interviewDate;
	public static volatile SingularAttribute<AtJAInt, AtJobApplications> jobApplicationId;
	public static volatile SingularAttribute<AtJAInt, Long> id;

}

