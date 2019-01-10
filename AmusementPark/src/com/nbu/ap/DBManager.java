package com.nbu.ap;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@SuppressWarnings("unchecked")
public class DBManager {

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
	public static <T> T create(T t) {
		Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(t);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return t;
	}
	
	public static <T> List<T> read(Class<T> c) {
		Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<T> entities = null;
        try {
            tx = session.beginTransaction();
            entities = (List<T>) session.createQuery("FROM " + c.getSimpleName()).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
		return entities;		
	}
	
	public static <T> List<T> read(T t) {
		Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<T> entities = null;
        try {
            tx = session.beginTransaction();
            entities = (List<T>) session.createQuery("FROM " + t.getClass().getSimpleName()).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
		return entities;		
	}
	
	public static <T> T update(T t) {
		Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(t);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
		return t;
	}
	
	public static <T> T delete(T t) {
		Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(t);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
		return t;
	}
	
}
