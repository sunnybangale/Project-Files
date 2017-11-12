package com.cts.cbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import com.cts.cbc.exceptions.DBException;


import static com.cts.cbc.util.MyUtil.getConn;

/**
 * The Class DBManager.
 */
public final class DBManager {
	
	private DBManager() {
		
	}
	
	
	public static Connection connection = null;


	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 * @throws DBException the dB exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the sQL exception
	 */
	public static Connection getConnection() throws DBException, ClassNotFoundException, SQLException {
		
			if(connection==null)
			{	
			Class.forName(getConn("driver"));
			connection = DriverManager.getConnection(getConn("url"),
					getConn("username"), getConn("password"));
			
			//System.out.println("Connected!!!");
			}
			

		return connection;
	}
}
