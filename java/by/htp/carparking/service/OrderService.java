package by.htp.carparking.service;

import java.time.LocalDate;

public interface OrderService {

	void orderCar(int userId, int carId, LocalDate startOfRental, LocalDate endOfRental);
	
}
