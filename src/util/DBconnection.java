package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

	public static Connection createConnection() {	
		
		Connection con = null;
		
		String url = "jdbc:mysql://localhost:3306/teamdb"; //teamdb is database name
		String username = "root"; //MySQL username
		String password = ""; //MySQL password
		
		try 
		{
		try 
		{
		Class.forName("com.mysql.jdbc.Driver"); //loading MySQL drivers 
		} 
		catch (ClassNotFoundException e)
		{
		e.printStackTrace();
		}
		con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
		} 
		catch (SQLException e) 
		{
		e.printStackTrace();
		}
		return con; 
		}
	}
