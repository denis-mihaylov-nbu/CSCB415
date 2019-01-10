package com.nbu.ap;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.nbu.ap.entity.*;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() throws HibernateException {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(AmusementPark.class);
            configuration.addAnnotatedClass(Attraction.class);
            configuration.addAnnotatedClass(AttractionType.class);
            configuration.addAnnotatedClass(Manager.class);
            configuration.addAnnotatedClass(Ticket.class);
            ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }

        return sessionFactory;
    }
}
