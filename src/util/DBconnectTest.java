package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		//conn = DBconnection.createConnection();
		String url = "jdbc:mysql://localhost/ecommerce";
		//String url = "jdbc:mysql://localhost:3306/ecommerce";
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
		conn = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
		} 
		catch (SQLException e) 
		{
		e.printStackTrace();
		}
		if(conn == null){
			System.out.println("connection to DB failed.");
		}
		else{
			System.out.println("connection to DB succeed!");
		}
	}

}
