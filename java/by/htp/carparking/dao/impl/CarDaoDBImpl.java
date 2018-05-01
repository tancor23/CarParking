package by.htp.carparking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.carparking.dao.util.DBConnectionHelper;
import by.htp.carparking.dao.CarDao;
import by.htp.carparking.domain.Car;
/**
 * @author Vydra_Sergei
 * Needs to change String queries, lo4j
 */
public class CarDaoDBImpl implements CarDao {

	@Override
	public void create(Car car) {

		try (Connection connection = DBConnectionHelper.connect();
				PreparedStatement ps = connection.prepareStatement("INSERT INTO cars (brand, model) VALUES (?, ?);",
						Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, car.getBrand());
			ps.setString(2, car.getModel());
			int rowsCount = ps.executeUpdate();
			if (rowsCount == 1) {
				ResultSet result = ps.getGeneratedKeys();
				result.next();
				int id = result.getInt("car_id");
				car.setId(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Car read(int id) {
		try (Connection connection = DBConnectionHelper.connect();
				PreparedStatement ps = connection
						.prepareStatement("Select car_id, brand, model FROM cars WHERE id_car=?")) {
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			if (result.next()) {
				Car car = new Car(id);
				car.setBrand(result.getString("brand"));
				car.setModel(result.getString("model"));
				return car;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Car> readAll() {
		List<Car> cars = new ArrayList<>();

		try (Connection connection = DBConnectionHelper.connect(); Statement statement = connection.createStatement()) {

			ResultSet result = statement.executeQuery("SELECT car_id, brand, model FROM cars");
			while (result.next()) {
				Car car = new Car();
				car.setId(result.getInt("car_id"));
				car.setBrand(result.getString("brand"));
				car.setModel(result.getString("model"));
				cars.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cars;
	}

	@Override
	public void update(Car car) {
		try (Connection connection = DBConnectionHelper.connect();
				PreparedStatement ps = connection
						.prepareStatement("UPDATE cars SET brand=?, model=? WHERE car_id=?;")) {
			ps.setString(1, car.getBrand());
			ps.setString(2, car.getModel());
			ps.setInt(3, car.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try (Connection connection = DBConnectionHelper.connect();
				PreparedStatement pStatement = connection.prepareStatement("DELETE FROM cars WHERE id_car=?;")) {
			pStatement.setInt(1, id);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
