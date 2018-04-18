package by.htp.carparking.dao;

import by.htp.carparking.dao.impl.CarDaoDBImpl;

public class DAOSingletonOfCar {
	
	private DAOSingletonOfCar() {}
	
	private static DAOSingletonOfCar instance;
	
	public final CarDaoDBImpl carDAO = new CarDaoDBImpl();
	
	public static DAOSingletonOfCar getDAO(){
        if (instance == null){
            synchronized (DAOSingletonOfCar.class){
                if (instance == null){
                    instance = new DAOSingletonOfCar();
                }
            }
        }
        return instance;
    }

}
