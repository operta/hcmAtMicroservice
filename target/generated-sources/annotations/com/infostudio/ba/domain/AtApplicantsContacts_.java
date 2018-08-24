package com.infostudio.ba.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AtApplicantsContacts.class)
public abstract class AtApplicantsContacts_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<AtApplicantsContacts, AtApplicants> idApllicant;
	public static volatile SingularAttribute<AtApplicantsContacts, Integer> idContactType;
	public static volatile SingularAttribute<AtApplicantsContacts, String> contact;
	public static volatile SingularAttribute<AtApplicantsContacts, String> description;
	public static volatile SingularAttribute<AtApplicantsContacts, Long> id;

}

