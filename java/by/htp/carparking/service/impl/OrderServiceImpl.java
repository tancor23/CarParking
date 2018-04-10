package by.htp.carparking.service.impl;

import by.htp.carparking.dao.DaoFactory;
import by.htp.carparking.dao.OrderDao;
import by.htp.carparking.service.OrderService;

public class OrderServiceImpl implements OrderService{
	
	//TODO add  IoC, singleton
	private static OrderDao orderDao = DaoFactory.getOrderDao();

	@Override
	public void orderCar(int userId, int carId) {
		orderDao.insertNewOrder(userId, carId);
		
	}

}
