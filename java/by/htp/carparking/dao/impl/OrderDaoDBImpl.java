package by.htp.carparking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.carparking.dao.OrderDao;
import by.htp.carparking.dao.util.DBConnectionHelper;
import by.htp.carparking.domain.Order;

public class OrderDaoDBImpl implements OrderDao {

	private final Logger logger = LogManager.getLogger();

	private final String SQL_CREATE_ORDER = "INSERT INTO `carparking`.`orders` "
			+ "(`id_user`, `id_car`, `start_of_rental`, `end_of_rental`) " + "VALUES (?, ?, ?, ?)";
	private final String SQL_INSERT_ORDER = "INSERT INTO orders (id_user, id_car) VALUES (?, ?);";
	private final String SQL_ORDERED_CAR_IDS = "SELECT DISTINCT id_car FROM orders "
			+ "WHERE NOT ((?<start_of_rental AND ?<end_of_rental) OR (?>start_of_rental AND ?>end_of_rental))";

	@Override
	public void create(Order order) {
		try (Connection connection = DBConnectionHelper.connect();
				PreparedStatement ps = connection.prepareStatement(SQL_CREATE_ORDER, Statement.RETURN_GENERATED_KEYS)) {
			ps.setInt(1, order.getUserId());
			ps.setInt(2, order.getCarId());
			ps.setString(3, formatDate(order.getStartOfRental()));
			ps.setString(4, formatDate(order.getEndOfRental()));
			int rowsAffected = ps.executeUpdate();
			if (rowsAffected == 1) {
				ResultSet result = ps.getGeneratedKeys();
				result.next();
				int id = result.getInt(1);
				order.setId(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

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
				PreparedStatement ps = connection.prepareStatement(SQL_INSERT_ORDER)) {
			ps.setInt(1, userId);
			ps.setInt(2, carId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Set<Integer> getOrderedCarIds(LocalDate startOfRental, LocalDate endOfRental) {
		Set<Integer> carIds = new HashSet<>();
		try (Connection connection = DBConnectionHelper.connect();
				PreparedStatement ps = connection.prepareStatement(SQL_ORDERED_CAR_IDS)) {
			ps.setString(1, formatDate(startOfRental));
			ps.setString(2, formatDate(endOfRental));
			ps.setString(3, formatDate(startOfRental));
			ps.setString(4, formatDate(endOfRental));
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				int carID = result.getInt("id_car");
				carIds.add(carID);
			}
		} catch (SQLException e) {
			logger.error("", e);
		}
		return carIds;
	}

	private String formatDate(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return date.format(formatter);
	}
}
