package by.htp.carparking.dao;

import by.htp.carparking.dao.impl.OrderDaoDBImpl;

public class DAOSingletonOfOrder {
	
	private DAOSingletonOfOrder() {}
	
	private static DAOSingletonOfOrder instance;
	
	public final OrderDaoDBImpl carDAO = new OrderDaoDBImpl();
	
	public static DAOSingletonOfOrder getDAO(){
        if (instance == null){
            synchronized (DAOSingletonOfOrder.class){
                if (instance == null){
                    instance = new DAOSingletonOfOrder();
                }
            }
        }
        return instance;
    }

}
