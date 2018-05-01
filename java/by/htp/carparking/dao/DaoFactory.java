package by.htp.carparking.dao;

import by.htp.carparking.dao.impl.CarDaoDBImpl;
import by.htp.carparking.dao.impl.OrderDaoDBImpl;
import by.htp.carparking.dao.impl.UserDaoDBImpl;

public class DaoFactory {
	
	public static CarDao getCarDao() {
		return new CarDaoDBImpl();
	}
	
	public static OrderDao getOrderDao() {
		return new OrderDaoDBImpl();
	}
	
	public static UserDao getUserDao() {
		return new UserDaoDBImpl();
	}
}
