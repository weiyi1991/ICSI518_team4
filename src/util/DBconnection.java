package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

	public static Connection createConnection() {	
		
		Connection con = null;
		

		//String url = "jdbc:mysql://localhost:3306/ecommerce"; //ecommerce is database name
		String url = "jdbc:mysql://localhost/ecommerce";
		String username = "root"; //MySQL username
		String password = "root";
		//String password = "tnat410"; //MySQL password
		
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
