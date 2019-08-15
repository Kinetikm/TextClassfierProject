package ru.caf82.lectures.lectureDB;

import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.Map;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();

            sessionFactory = configuration.configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }

    public static void closeSessionFactory() {
        sessionFactory.close();
    }

}