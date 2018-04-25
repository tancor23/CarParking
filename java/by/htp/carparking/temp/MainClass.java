package by.htp.carparking.temp;

import java.util.List;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.htp.carparking.dao.CarDao;
//import by.htp.carparking.dao.hbn.SessionFactoryManager;
import by.htp.carparking.domain.Car;

public class MainClass {

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("app-beans.xml");
		CarDao dao = (CarDao) context.getBean("carDao");
		List<Car> cars = dao.readAll();
		for (Car car : cars) {
			System.out.println(car);
		}
		System.out.println();
		System.out.println(dao.read(2));
		dao.create(new Car("audi", "80"));

		System.out.println();
		List<Car> cars1 = dao.readAll();
		for (Car car : cars1) {
			System.out.println(car);
		}

		// SessionFactory factory = SessionFactoryManager.getSessionFactory();
		// Session session = factory.openSession();

		// Session session = factory.getCurrentSession();

		// Session session2 = factory.getCurrentSession();

		// System.out.println(session.hashCode());

		// session.close();
	}

}
