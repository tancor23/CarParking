package by.htp.carparking.dao.hbn;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import by.htp.carparking.dao.CarDao;
import by.htp.carparking.domain.Car;

public class CarDaoHibernateImpl implements CarDao{

	@Override
	public void create(Car car) {
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		            session.save(car);
		            session.getTransaction().commit();

	}

	@Override
	public Car read(int id) {
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		return (Car) session.load(Car.class, id);
	}

	@Override
	public List<Car> readAll() {
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		return session.createCriteria(Car.class).list();
	}

	@Override
	public void update(Car entity) {
		
	}

	@Override
	public void delete(int id) {
		
	}

}
