package model;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;

import model.User;
import model.Product;
import util.DBconnection;

public class AuthDAO {

    //private String username;
	//private String firstName;
	//private String lastName;
	//private String role;
	//private String password;
	//private int userId;
	//private static User User;
	   
	public static User getUserById (int userId) {
		
		Connection con = null;
		Connection con1 = null;
		
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		
		ResultSet rs = null;
		ResultSet rs1 = null;
		
		User user = new User();
		
		String dbusername = "";
		String dbpassword = "";
		String dbrole = "";
		String dbfname = "";
		String dblname = "";
				
		try
		{
		con = DBconnection.createConnection();
		String query = "SELECT * FROM user WHERE UID=?"; 
		
		ps = (PreparedStatement) con.prepareStatement(query);
		ps.setInt(1, userId);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			dbusername = rs.getString("UNAME");
			dbpassword = rs.getString("PASS");
			dbrole = rs.getString("ROLE");
		}
		
		con1 = DBconnection.createConnection();
		String query1 = "SELECT * FROM user_profile WHERE UID=?"; 
		ps1 = (PreparedStatement) con1.prepareStatement(query1);
		ps1.setInt(1, userId);
		rs1 = ps1.executeQuery();
		
		while(rs1.next()) {
			dbfname = rs1.getString("FNAME");
			dblname = rs1.getString("LNAME");
			}
		
		user.setUserFirstName(dbfname);	
		user.setUserLastName(dblname);
		user.setUserName(dbusername);
		user.setPassword(dbpassword);
		user.setRole(dbrole);
		user.setUserId(userId);
		
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return user;

	}
	
	public static int checkUserPass (String username, String password, String role) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String dbusername = "";
		String dbpassword = "";
		String dbrole = "";
		try
			{
			con = DBconnection.createConnection();
			String query = "SELECT UNAME,PASS,ROLE FROM user"; 
			
			ps = (PreparedStatement) con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dbusername = rs.getString("UNAME");
				dbpassword = rs.getString("PASS");
				dbrole = rs.getString("ROLE");
				if(username.equalsIgnoreCase(dbusername) && password.equals(dbpassword) && role.equalsIgnoreCase(dbrole)) {
					return 1;
				}
			}
			}
			
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		
		return 0;
	}
	
	public static boolean checkUserNameAvailable (String username) {

		Connection con = null;	
		PreparedStatement ps = null;
		
		try	{		
			
			con = DBconnection.createConnection();
			String query = "SELECT UNAME FROM user where UNAME=?"; 
			ps = (PreparedStatement) con.prepareStatement(query);

			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()) {
				
				return false;
			}
		
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return true;
	}
	
	public static boolean enterNewUser(String username, String password, String role) {
		
		Connection con = null;	
		PreparedStatement ps = null;
		
		try	{
			con = DBconnection.createConnection();
			String query = "INSERT INTO user (UNAME,PASS,ROLE) values (?,?,?)"; 
			ps = (PreparedStatement) con.prepareStatement(query); 
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, role);
		
		
			int i= ps.executeUpdate();
		
			if (i!=0)
				return true;
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
	
		return false;
	}
	
	public static boolean enterNewUserProfile(String username, String firstname, String lastname) {
		//wrong
		Connection con = null;	
		PreparedStatement ps = null;
		
		try	{
			con = DBconnection.createConnection();
			String query = "INSERT INTO user_profile (FNAME,LNAME) values (?,?)"; 
			ps = (PreparedStatement) con.prepareStatement(query); 
			ps.setString(1, firstname);
			ps.setString(2, lastname);
		
		
			int i= ps.executeUpdate();
		
			if (i!=0)
				return true;
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
	
		return false;
	}
	
	public String registerUser(User user)
	{
	String username = user.getUserName();
	String password = user.getPassword();
	String role = user.getRole();
	String fname = user.getUserFirstName();
	String lname = user.getUserLastName();
	
	Connection con1 = null;
	Connection con2 = null;
	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;
	
	try
	{
		
		boolean avai = checkUserNameAvailable(username);
		//System.out.println("avai" + avai);
		
		if(!avai)
			return "Username already exists.";
		
		con1 = DBconnection.createConnection();
		String query1 = "INSERT INTO user(UID,UNAME,PASS,ROLE) values (NULL,?,?,?)"; 
		ps1 = (PreparedStatement) con1.prepareStatement(query1); 
		ps1.setString(1, username);
		ps1.setString(2, password);
		ps1.setString(3, role);
		int i1= ps1.executeUpdate();
	
		if (i1!=0) {
			con2 = DBconnection.createConnection();
			String query2 = "INSERT INTO user_profile(UID,FNAME,LNAME) values (NULL,?,?)"; 
			ps2 = (PreparedStatement) con2.prepareStatement(query2); 
			ps2.setString(1, fname);
			ps2.setString(2, lname);
			int i2= ps2.executeUpdate();
			if(i2!=0)
				return "SUCCESS"; 
		}
	}
	catch(SQLException e)
	{
	e.printStackTrace();
	}
	return "Failure.";  
	}

	public String authenticateUser(User user)
	{
	String username = user.getUserName(); 
	String password = user.getPassword();
	String role = user.getRole();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String dbusername = "";
	String dbpassword = "";
	String dbrole = "";
	try
		{
		con = DBconnection.createConnection();
		String query = "SELECT UNAME,PASS,ROLE from user"; 
		
		ps = (PreparedStatement) con.prepareStatement(query);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			dbusername = rs.getString("UNAME");
			dbpassword = rs.getString("PASS");
			dbrole = rs.getString("ROLE");
			if(username.equalsIgnoreCase(dbusername) && password.equals(dbpassword) && role.equalsIgnoreCase(dbrole)) {
				return dbrole;
			}
		}
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return "Invalid user credentials"; 
	}

	public User getUserByUserName (String username) {
		
		Connection con = null;
		Connection con1 = null;
		
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		
		ResultSet rs = null;
		ResultSet rs1 = null;
		
		User user = new User();
		
		String dbusername = "";
		String dbpassword = "";
		String dbrole = "";
		String dbfname = "";
		String dblname = "";
		int dbuserId = 0;
		
		try
		{
		con = DBconnection.createConnection();
		String query = "SELECT * FROM user WHERE UNAME=?"; 
		
		ps = (PreparedStatement) con.prepareStatement(query);
		ps.setString(1, username);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			dbusername = rs.getString("UNAME");
			dbpassword = rs.getString("PASS");
			dbrole = rs.getString("ROLE");
			dbuserId = rs.getInt("UID");
		}
		
		//System.out.println("id" + dbuserId);
		con1 = DBconnection.createConnection();
		String query1 = "SELECT * FROM user_profile WHERE UID=?"; 
		ps1 = (PreparedStatement) con1.prepareStatement(query1);
		ps1.setInt(1, dbuserId);
		rs1 = ps1.executeQuery();
		
		while(rs1.next()) {
			dbfname = rs1.getString("FNAME");
			dblname = rs1.getString("LNAME");
			}
		
		user.setUserFirstName(dbfname);	
		user.setUserLastName(dblname);
		user.setUserName(dbusername);
		user.setPassword(dbpassword);
		user.setRole(dbrole);
		user.setUserId(dbuserId);
		
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return user;
	
	}
	
    public String createProduct(Product product) {
        
    	Connection con = null;
    	PreparedStatement ps;
        
		try {
			
			con = DBconnection.createConnection();
	    	String query = "INSERT INTO Product(PID,PNAME,CATEGORY,PRICE,UID,DESP) values (NULL,?,?,?,?,?)";
			ps = (PreparedStatement) con.prepareStatement(query);
			
	        ps.setString(1, product.getName());
	        ps.setString(2, product.getCategory());
            ps.setInt(3, product.getPrice());
	        ps.setInt(4, product.getSellerID());
	        ps.setString(5, product.getDescription());
	        
	       	int i  = ps.executeUpdate();
	       	
	       	if(i!=0) {
	       		return "SUCCESS";
	       	}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        return "FAILURE";
    }

}




