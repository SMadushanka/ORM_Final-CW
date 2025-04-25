package lk.ijse.orm.ormh.config;

import lk.ijse.orm.ormh.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private final SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration config = new Configuration();
        config.configure();
        // has call entity classes.
        config.addAnnotatedClass(Admin.class)
                .addAnnotatedClass(Programme.class)
                .addAnnotatedClass(Reception.class)
                .addAnnotatedClass(Patients.class)
                .addAnnotatedClass(Sessions.class)
                .addAnnotatedClass(Therapists.class)
                .addAnnotatedClass(Payment.class);
        sessionFactory = config.buildSessionFactory();
    }

    public static FactoryConfiguration getFactoryConfiguration() {
        return factoryConfiguration != null ? factoryConfiguration : new FactoryConfiguration();
        // return factoryConfiguration == null ? new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSessionFactory() {
        return sessionFactory.openSession();
    }
}


