package by.htp.carparking.service.impl;

import java.util.List;

import by.htp.carparking.dao.CarDao;
import by.htp.carparking.dao.DaoFactory;
import by.htp.carparking.domain.Car;
import by.htp.carparking.service.CarService;

public class CarServiceImpl implements CarService {

	//TODO change to IoC, singleton
	private CarDao carDao = DaoFactory.getCarDao();
	
	@Override
	public List<Car> getCarsList() {
		return carDao.readAll();
	}

}
