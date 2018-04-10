package by.htp.carparking.domain;

import java.io.Serializable;

public class Order extends Entity implements Serializable {

	private static final long serialVersionUID = -5731960048387459760L;

	private int userId;
	private int carId;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * getId();
		result = prime * result + carId;
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Order other = (Order) obj;
		if (getId() != other.getId()) {
			return false;
		}
		if (carId != other.carId) {
			return false;
		}
		if (userId != other.userId) {
			return false;
		}
		return true;
	}

}