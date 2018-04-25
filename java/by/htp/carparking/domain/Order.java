package by.htp.carparking.domain;

import java.io.Serializable;
import java.time.LocalDate;

public class Order extends Entity implements Serializable {

	private static final long serialVersionUID = 1997512656362334676L;
	
	private int userId;
	private int carId;
	private LocalDate startOfRental;
	private LocalDate endOfRental;

	public Order() {
		super();
	}

	public Order(int id) {
		super(id);
	}

	public Order(int userId, int carId) {
		super();
		this.userId = userId;
		this.carId = carId;
	}

	public Order(int id, int userId, int carId) {
		super(id);
		this.userId = userId;
		this.carId = carId;
	}

	public Order(int userId, int carId, LocalDate startOfRental, LocalDate endOfRental) {
		super();
		this.userId = userId;
		this.carId = carId;
		this.startOfRental = startOfRental;
		this.endOfRental = endOfRental;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public LocalDate getStartOfRental() {
		return startOfRental;
	}

	public void setStartOfRental(LocalDate startOfRental) {
		this.startOfRental = startOfRental;
	}

	public LocalDate getEndOfRental() {
		return endOfRental;
	}

	public void setEndOfRental(LocalDate endOfRental) {
		this.endOfRental = endOfRental;
	}

}