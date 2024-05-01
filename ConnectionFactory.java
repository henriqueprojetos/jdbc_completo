package br.com.fj21.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		String connectionString = "jdbc:mysql://localhost:3306/fj21";
		try {
			return DriverManager.getConnection
					(connectionString, "root", "root");
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
