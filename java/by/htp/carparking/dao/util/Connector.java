package by.htp.carparking.dao.util;

import static by.htp.carparking.dao.util.DaoConstantDeclaration.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	
	    private static Connection connection;

	    public static Connection getConnection() {
	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	            if (connection == null || connection.isClosed()){
	                connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	        return connection;
	    }

}
