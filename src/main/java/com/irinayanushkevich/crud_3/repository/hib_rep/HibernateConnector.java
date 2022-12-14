package com.irinayanushkevich.crud_3.repository.hib_rep;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnector {

    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            System.out.println("Database connection error.");
            e.printStackTrace();
        }
    }

    private SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session openSession() {
        return getSessionFactory().openSession();
    }

    public Session openTransactionSession() {
        Session session = openSession();
        session.beginTransaction();
        return session;
    }
}
