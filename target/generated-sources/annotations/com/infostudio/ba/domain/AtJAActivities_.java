package com.infostudio.ba.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AtJAActivities.class)
public abstract class AtJAActivities_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<AtJAActivities, AtActivityStatuses> idStatus;
	public static volatile SingularAttribute<AtJAActivities, LocalDate> dateActivity;
	public static volatile SingularAttribute<AtJAActivities, String> review;
	public static volatile SingularAttribute<AtJAActivities, Integer> grade;
	public static volatile SingularAttribute<AtJAActivities, AtJobApplications> idJobApplication;
	public static volatile SingularAttribute<AtJAActivities, Long> id;
	public static volatile SingularAttribute<AtJAActivities, AtActivities> idActivity;

}

