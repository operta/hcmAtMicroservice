package com.infostudio.ba.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AtJobAppNotifications.class)
public abstract class AtJobAppNotifications_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<AtJobAppNotifications, AtJobApplications> idJobApplication;
	public static volatile SingularAttribute<AtJobAppNotifications, AtNotificationTemplates> idNotification;
	public static volatile SingularAttribute<AtJobAppNotifications, Long> id;
	public static volatile SingularAttribute<AtJobAppNotifications, LocalDate> dateSent;
	public static volatile SingularAttribute<AtJobAppNotifications, String> isActive;

}

