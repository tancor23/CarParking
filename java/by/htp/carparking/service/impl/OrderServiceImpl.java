package by.htp.carparking.service.impl;

import java.time.LocalDate;

import by.htp.carparking.dao.OrderDao;
import by.htp.carparking.domain.Order;
import by.htp.carparking.service.OrderService;

public class OrderServiceImpl implements OrderService {
	
	private OrderDao orderDao;

	@Override
	public void orderCar(int userId, int carId, LocalDate startOfRental, LocalDate endOfRental) {
		Order order = new Order();
		order.setCarId(carId);
		order.setUserId(userId);
		order.setStartOfRental(startOfRental);
		order.setEndOfRental(endOfRental);
		orderDao.create(order);

	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	
	
}