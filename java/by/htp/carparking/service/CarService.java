package by.htp.carparking.service;

import java.time.LocalDate;
import java.util.List;
import by.htp.carparking.domain.Car;

public interface CarService {

	List<Car> getCarsList();
	List<Car> getAvaliableCarsList(LocalDate startOfRental, LocalDate endOfRental);
}
