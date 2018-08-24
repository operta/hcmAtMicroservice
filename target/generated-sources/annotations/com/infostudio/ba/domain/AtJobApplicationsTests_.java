package com.infostudio.ba.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AtJobApplicationsTests.class)
public abstract class AtJobApplicationsTests_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<AtJobApplicationsTests, Integer> score;
	public static volatile SingularAttribute<AtJobApplicationsTests, Integer> locationId;
	public static volatile SingularAttribute<AtJobApplicationsTests, String> review;
	public static volatile SingularAttribute<AtJobApplicationsTests, AtJobApplications> jobApplicationId;
	public static volatile SingularAttribute<AtJobApplicationsTests, Long> id;
	public static volatile SingularAttribute<AtJobApplicationsTests, String> shortDescription;
	public static volatile SingularAttribute<AtJobApplicationsTests, LocalDate> testDate;

}

