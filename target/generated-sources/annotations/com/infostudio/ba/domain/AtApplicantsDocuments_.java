package com.infostudio.ba.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AtApplicantsDocuments.class)
public abstract class AtApplicantsDocuments_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<AtApplicantsDocuments, Integer> idDocumentType;
	public static volatile SingularAttribute<AtApplicantsDocuments, LocalDate> dateCreated;
	public static volatile SingularAttribute<AtApplicantsDocuments, String> name;
	public static volatile SingularAttribute<AtApplicantsDocuments, String> description;
	public static volatile SingularAttribute<AtApplicantsDocuments, Long> id;
	public static volatile SingularAttribute<AtApplicantsDocuments, LocalDate> validFrom;
	public static volatile SingularAttribute<AtApplicantsDocuments, AtApplicants> idApplicant;
	public static volatile SingularAttribute<AtApplicantsDocuments, Integer> idDocumentLink;
	public static volatile SingularAttribute<AtApplicantsDocuments, LocalDate> validTo;

}

