package by.htp.carparking.dao.hbn;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.testng.annotations.Test;

import by.htp.carparking.dao.CarDao;
import by.htp.carparking.domain.Car;

public class CarDaoHibernateImpl implements CarDao {

	@Override
	public void create(Car car) {
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(car);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Car read(int id) {
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		Car car = (Car) session.load(Car.class, id);
		session.close();
		return car;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Car> readAll() {
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		List<Car> users = session.createCriteria(Car.class).list();
		session.close();
		return users;
	}

	@Override
	public void update(Car car) {
		SessionFactory sessionFactory = SessionFactoryManager.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(car);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(int carId) {
		SessionFactory sessionFactory = SessionFactoryManager.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Car car = read(carId);
		session.delete(car);
		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void testCreate() {
		create(new Car("brand", "model"));
	}
}
