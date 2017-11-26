package ru.caf82.lectures.lectureDB;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class UserManager {
    public static void watchListOfUsers() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            for (Object user : session.createQuery("from User").list()) {
                System.out.println(user);
            }
            transaction.commit();
        }
        catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        finally {
            HibernateUtil.closeSessionFactory();
        }

    }

    public static void addUserWithPassword(String login,int age, String stringPassword) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            User user = new User(login,age);
            Password password = new Password(stringPassword,user);
            session.save(user);
            session.save(password);
            transaction.commit();
        }
        catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        finally {
            HibernateUtil.closeSessionFactory();
        }

    }

    public static void deleteUser(String login) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            for (Object id : session.createQuery(" select id from User where login = :login ").setParameter("login",login).list()) {
            Integer idInteger = (Integer) id;
                session.createQuery("delete from User where id = :idInteger").setParameter("idInteger",idInteger).executeUpdate();
                session.createQuery("delete from Password where id = :idInteger").setParameter("idInteger",idInteger).executeUpdate();
            }
            transaction.commit();
        }

        catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        finally {
            HibernateUtil.closeSessionFactory();
        }
    }

    public static boolean userExist(String login) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        boolean result = false;
        try {
            transaction = session.beginTransaction();
            result = session.createQuery("from User where login = :login").setParameter("login",login).list().size() == 0;
            transaction.commit();
        }
        catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            result = false;
        }
        finally {
            HibernateUtil.closeSessionFactory();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(userExist("maks08197"));
    }
}
