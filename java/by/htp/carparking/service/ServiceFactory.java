package by.htp.carparking.service;

import by.htp.carparking.service.impl.CarServiceImpl;
import by.htp.carparking.service.impl.OrderServiceImpl;

public class ServiceFactory {
	
	public static CarService getCarService() {
		return new CarServiceImpl();
	}
	
	public static OrderService getOrderService() {
		return new OrderServiceImpl();
	}

}
