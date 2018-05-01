package by.htp.carparking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import by.htp.carparking.dao.hbn.SessionFactoryManager;
import by.htp.carparking.domain.Entity;

public interface BaseDao<T extends Entity> {

	default void create(T entity) {
		SessionFactory sessionFactory = SessionFactoryManager.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(entity);
		session.getTransaction().commit();
		session.close();
	}

	T read(int id);

	List<T> readAll();

	default void update(T entity) {
		SessionFactory sessionFactory = SessionFactoryManager.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(entity);
		session.getTransaction().commit();
		session.close();
	}

	default void delete(int id) {
		SessionFactory sessionFactory = SessionFactoryManager.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		T entity = read(id);
		session.delete(entity);
		session.getTransaction().commit();
		session.close();
	}

}
