package by.htp.carparking.service.impl;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import by.htp.carparking.dao.CarDao;
import by.htp.carparking.dao.OrderDao;
import by.htp.carparking.domain.Car;
import by.htp.carparking.service.CarService;

public class CarServiceImpl implements CarService{

	private CarDao carDao;
	private OrderDao orderDao;
	
	@Override
	public List<Car> getCarsList() {
		return carDao.readAll();
		
	}

	@Override
	public List<Car> getAvaliableCarsList(LocalDate startOfRental, LocalDate endOfRental) {
		List<Car> cars = carDao.readAll();
		Set<Integer> orderedCars = orderDao.getOrderedCarIds(startOfRental, endOfRental);
		Iterator<Car> iterator = cars.iterator();
		while (iterator.hasNext()) {
			Car car = iterator.next();
			if (orderedCars.contains(car.getId())) iterator.remove();
		}
		return cars;
	}

	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	

}
