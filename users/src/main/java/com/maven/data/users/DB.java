package com.maven.data.users;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

public class DB {
	private static final Logger logger = Logger.getLogger(DB.class);

	private static String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static String DB_USER = "root";
	private static String DB_PASSWORD = "karthik96";
	private static String DB_NAME = "data1";
	private static String DB_PORT = "3306";
	private static String DB_CONNECTION = "jdbc:mysql://" + DB_PORT + "/" + DB_NAME + "?user=" + DB_USER + "&password="
			+ DB_PASSWORD;
	private Connection conn = null;

	public DB() {
		logger.info("GETTING CONNECTION!");
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			logger.info(e.getMessage());
		}
		try {
			this.conn = DriverManager.getConnection(DB_CONNECTION);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		return conn;
	}
}
