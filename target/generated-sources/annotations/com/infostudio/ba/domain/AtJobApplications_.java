package com.infostudio.ba.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AtJobApplications.class)
public abstract class AtJobApplications_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<AtJobApplications, Integer> testGrade;
	public static volatile SingularAttribute<AtJobApplications, AtJobApplicationStatuses> idStatus;
	public static volatile SingularAttribute<AtJobApplications, String> review;
	public static volatile SingularAttribute<AtJobApplications, Integer> grade;
	public static volatile SingularAttribute<AtJobApplications, Integer> interviewGrade;
	public static volatile SingularAttribute<AtJobApplications, Long> id;
	public static volatile SingularAttribute<AtJobApplications, LocalDate> dateApplied;
	public static volatile SingularAttribute<AtJobApplications, AtApplicants> applicantId;
	public static volatile SingularAttribute<AtJobApplications, AtVacancies> vacancyId;

}

