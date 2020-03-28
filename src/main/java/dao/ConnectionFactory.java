package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exception.DataBaseException;

public class ConnectionFactory {
	//Mudar para postgres
	private static final String timezone = "?useTimezone=true&serverTimezone=UTC";
	private static final String bd = "db_project";
	private static final String url = "jdbc:postgresql://localhost:5432/" + bd + timezone;
	private static final String user = "root";
	private static final String psw = "telemaco98";
	private static final String driver = "org.postgresql.Driver";
	
	public static Connection getConnection() throws DataBaseException {
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, user, psw);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DataBaseException(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		try {
			ConnectionFactory.getConnection();
			System.out.println("Connection sucessfull");
		} catch (DataBaseException e) {
			System.out.println("Connection failed");
		}
	} 
}
