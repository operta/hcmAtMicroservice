package com.infostudio.ba.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AtJobApplicantHistory.class)
public abstract class AtJobApplicantHistory_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<AtJobApplicantHistory, AtJobApplicationStatuses> idStatusFrom;
	public static volatile SingularAttribute<AtJobApplicantHistory, AtJobApplicationStatuses> idStatusTo;
	public static volatile SingularAttribute<AtJobApplicantHistory, AtJobApplications> idJobApplication;
	public static volatile SingularAttribute<AtJobApplicantHistory, Long> id;

}

