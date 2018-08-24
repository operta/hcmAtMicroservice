package com.infostudio.ba.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AtApplicantAcc.class)
public abstract class AtApplicantAcc_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<AtApplicantAcc, AtAccomplishmentTypes> idAccomplishmentType;
	public static volatile SingularAttribute<AtApplicantAcc, String> occupation;
	public static volatile SingularAttribute<AtApplicantAcc, String> licenceNumber;
	public static volatile SingularAttribute<AtApplicantAcc, String> link;
	public static volatile SingularAttribute<AtApplicantAcc, String> description;
	public static volatile SingularAttribute<AtApplicantAcc, String> association;
	public static volatile SingularAttribute<AtApplicantAcc, String> title;
	public static volatile SingularAttribute<AtApplicantAcc, LocalDate> dateFrom;
	public static volatile SingularAttribute<AtApplicantAcc, String> proficiency;
	public static volatile SingularAttribute<AtApplicantAcc, String> ongoing;
	public static volatile SingularAttribute<AtApplicantAcc, String> organization;
	public static volatile SingularAttribute<AtApplicantAcc, LocalDate> dateTo;
	public static volatile SingularAttribute<AtApplicantAcc, String> location;
	public static volatile SingularAttribute<AtApplicantAcc, Long> id;
	public static volatile SingularAttribute<AtApplicantAcc, AtApplicants> idApplicant;

}

