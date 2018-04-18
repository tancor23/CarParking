package by.htp.carparking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.carparking.dao.OrderDao;
import by.htp.carparking.dao.util.DBConnectionHelper;
import by.htp.carparking.domain.Order;

public class OrderDaoDBImpl implements OrderDao {
	
	private static final Logger logger = LogManager.getLogger(); 

	@Override
	public void create(Order entity) {

	}

	@Override
	public Order read(int id) {
		
		return null;
	}

	@Override
	public List<Order> readAll() {

		return null;
	}

	@Override
	public void update(Order entity) {

	}

	@Override
	public void delete(int id) {

	}

	@Override
	public void insertNewOrder(int userId, int carId) {
		try (Connection connection = DBConnectionHelper.connect();
				PreparedStatement ps = connection
						.prepareStatement("INSERT INTO orders ('id_user', 'id_car') VALUES ('?', '?');")) {
			ps.setInt(1, userId);
			ps.setInt(2, carId);
			ps.executeUpdate();
			
			logger.error("Error is in insertNewOrder");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
