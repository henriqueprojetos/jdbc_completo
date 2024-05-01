package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		String connString = 
				"jdbc:mysql://localhost:3306/fj21";
		try {
			return DriverManager.getConnection(connString, "root", "root");
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
