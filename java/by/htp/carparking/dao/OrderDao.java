package by.htp.carparking.dao;

import java.time.LocalDate;
import java.util.Set;

import by.htp.carparking.domain.Order;

public interface OrderDao extends BaseDao<Order> {
	
	void insertNewOrder (int userId, int carId);
	Set<Integer> getOrderedCarIds(LocalDate startOfRental, LocalDate endOfRental);

}
