package com.mcds5510.connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://dev.cs.smu.ca:3306/user_name";
	private static final String USERNAME = "******";

	private static final String PASSWORD = "*****";
	
	static Connection connection = null;
	
	private DBConnection() {}
	
	
	public static Connection getDBConnection() {
		Connection connection = null;
		try {
			Class.forName(DATABASE_DRIVER);

			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			System.out.println("connected ");

		} catch (Exception e) {
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {

		}
		return connection;
	}
}
