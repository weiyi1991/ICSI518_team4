package model;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		String dbemail = "";
		String dbphone = "";
		String dbaddress = "";
				
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
			dbemail = rs1.getString("EMAIL");
			dbphone = rs1.getString("Phone");
			dbaddress = rs1.getString("ADDRESS");
		}
		
		user.setFirstName(dbfname);	
		user.setLastName(dblname);
		user.setUserName(dbusername);
		user.setPassword(dbpassword);
		user.setRole(dbrole);
		user.setUserId(userId);
		user.setAddress(dbaddress);
		user.setEmail(dbemail);
		user.setPhoneNumber(dbphone);
		
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
		String fname = user.getFirstName();
		String lname = user.getLastName();
		String email = user.getEmail();
		
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
		String query1 = "INSERT INTO user(UNAME,PASS,ROLE) values (?,?,?)"; 
		//ps1 = (PreparedStatement) con1.prepareStatement(query1);
		ps1 = (PreparedStatement) con1.prepareStatement(query1, PreparedStatement.RETURN_GENERATED_KEYS); 
		ps1.setString(1, username);
		ps1.setString(2, password);
		ps1.setString(3, role);
		
		int i1= ps1.executeUpdate();
		ResultSet rs = ps1.getGeneratedKeys();
		rs.next();
	
		if (i1!=0) {
			con2 = DBconnection.createConnection();
			String query2 = "INSERT INTO user_profile(UID,FNAME,LNAME,EMAIL) values (?,?,?,?)"; 
			ps2 = (PreparedStatement) con2.prepareStatement(query2); 
			ps2.setInt(1, (int) rs.getLong(1));
			ps2.setString(2, fname);
			ps2.setString(3, lname);
			ps2.setString(4, email);
			System.out.println(query2);
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
	
	// update user_prorfile for profile.jsp
	public String updateProfile(User user)
	{
		String username = user.getUserName();
		String password = user.getPassword();
		String fname = user.getFirstName();
		String lname = user.getLastName();
		String email = user.getEmail();
		String phone = user.getPhoneNumber();
		String address = user.getAddress();
		
		Connection con1 = null;
		PreparedStatement ps1 = null;
		
		try
		{
			con1 = DBconnection.createConnection();
			String query1 = "UPDATE user_profile set FNAME=?, LNAME=?, Phone=?, ADDRESS=? where UID=(SELECT UID FROM USER WHERE UNAME=?)"; 
			//ps1 = (PreparedStatement) con1.prepareStatement(query1);
			ps1 = (PreparedStatement) con1.prepareStatement(query1); 
			ps1.setString(1, fname);
			ps1.setString(2, lname);
			ps1.setString(3, phone);
			ps1.setString(4, address);
			ps1.setString(5, username);
			
			int i1= ps1.executeUpdate();
		
			if (i1!=0) {
				return "SUCCESS"; 
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
			return "Failure";  
		}
	
	public String authenticateUser(User user)
	{
	String username = user.getUserName(); 
	String password = user.getPassword();
	//String role = user.getRole();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String dbusername = "";
	String dbpassword = "";
	String dbrole = "";
	int dbstatus = 0;
	try
		{
		con = DBconnection.createConnection();
		String query = "SELECT UNAME,PASS,ROLE,STATUS from user"; 
		
		ps = (PreparedStatement) con.prepareStatement(query);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			dbusername = rs.getString("UNAME");
			dbpassword = rs.getString("PASS");
			dbrole = rs.getString("ROLE");
			dbstatus = rs.getInt("STATUS");
			System.out.println("result: " + dbusername + dbpassword + dbrole);
			
			//check for correct username && wrong password
			
			
			if(username.equalsIgnoreCase(dbusername) && password.equals(dbpassword)) {
				if(dbstatus == 0) 
					return dbrole;
				else
					return "Your account has been blocked.";
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
		String dbemail = "";
		String dbphone = "";
		String dbaddress = "";
		int dbuserId = 0;
		int dbstatus = 0;
		
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
			dbstatus = rs.getInt("STATUS");
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
			dbemail = rs1.getString("EMAIL");
			dbaddress = rs1.getString("ADDRESS");
			dbphone = rs1.getString("Phone");
			}
		
		user.setFirstName(dbfname);	
		user.setLastName(dblname);
		user.setUserName(dbusername);
		user.setPassword(dbpassword);
		user.setRole(dbrole);
		user.setUserId(dbuserId);
		user.setEmail(dbemail);
		user.setAddress(dbaddress);
		user.setPhoneNumber(dbphone);
		user.setUserStatus(dbstatus);
		
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

    public List<Product> queryProduct(){
    	Connection con = null;
    	PreparedStatement ps = null;
		ResultSet rs = null;
		
    	List<Product> list = new ArrayList<Product>();
    	
    	try
		{
		con = DBconnection.createConnection();
		String query = "SELECT * FROM product"; 
		ps = (PreparedStatement) con.prepareStatement(query);
		rs = ps.executeQuery();
		
		while(rs.next()) {
            String name = rs.getString("PNAME");
            String desp = rs.getString("DESP");
            String cat = rs.getString("CATEGORY");
            int productID = rs.getInt("PID");
            int price = rs.getInt("PRICE");
            int sellerID = rs.getInt("UID");
            
            Product product = new Product();

            product.setName(name);
            product.setDescription(desp);
            product.setCategory(cat);
            product.setPrice(price);
            product.setSellerID(sellerID);
            product.setProductId(productID);
            
            
            list.add(product);
			}
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
    	
    	return list;
    }
    
    public List<Product> searchProduct(String category){
    	Connection con = null;
    	PreparedStatement ps = null;
		ResultSet rs = null;
		
    	List<Product> list = new ArrayList<Product>();
    	
    	try
		{
		con = DBconnection.createConnection();
		String query = "SELECT * FROM product WHERE CATEGORY=?"; 
		ps = (PreparedStatement) con.prepareStatement(query);
		ps.setString(1, category);
		rs = ps.executeQuery();
		
		while(rs.next()) {
            String name = rs.getString("PNAME");
            String desp = rs.getString("DESP");
            String cat = rs.getString("CATEGORY");
            int price = rs.getInt("PRICE");
            int sellerID = rs.getInt("UID");
            
            Product product = new Product();

            product.setName(name);
            product.setDescription(desp);
            product.setCategory(cat);
            product.setPrice(price);
            product.setSellerID(sellerID);
            
            
            list.add(product);
			}
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
    	
    	return list;
    }
    
    public Product searchProductByID(int productID){
    	Connection con = null;
    	PreparedStatement ps = null;
		ResultSet rs = null;
		Product product = new Product();
    	try
		{
		con = DBconnection.createConnection();
		String query = "SELECT * FROM product WHERE PID=?"; 
		ps = (PreparedStatement) con.prepareStatement(query);
		ps.setInt(1, productID);
		rs = ps.executeQuery();
        
		while(rs.next()) {
            String name = rs.getString("PNAME");
            String desp = rs.getString("DESP");
            String cat = rs.getString("CATEGORY");
            int price = rs.getInt("PRICE");
            int sellerID = rs.getInt("UID");


            product.setName(name);
            product.setDescription(desp);
            product.setCategory(cat);
            product.setPrice(price);
            product.setSellerID(sellerID);
            product.setProductId(productID);
            
			}
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
    	
		return product;
    }
    
    public List<Product> myList(int userID){
    	Connection con = null;
    	PreparedStatement ps = null;
		ResultSet rs = null;
		
    	List<Product> list = new ArrayList<Product>();
    	
    	try
		{
		con = DBconnection.createConnection();
		String query = "SELECT * FROM product WHERE UID=?"; 
		ps = (PreparedStatement) con.prepareStatement(query);
		ps.setInt(1, userID);
		rs = ps.executeQuery();
		
		while(rs.next()) {
            String name = rs.getString("PNAME");
            String desp = rs.getString("DESP");
            String cat = rs.getString("CATEGORY");
            int price = rs.getInt("PRICE");
            int sellerID = rs.getInt("UID");
            int productID = rs.getInt("PID");
            
            
                        
            Product product = new Product();

            product.setName(name);
            product.setDescription(desp);
            product.setCategory(cat);
            product.setPrice(price);
            product.setSellerID(sellerID);
            product.setProductId(productID);
            
            list.add(product);
			}
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
    	
    	return list;
    }
    
    public void deleteProduct(int productID) {
    	
    	Connection con = null;
    	PreparedStatement ps = null;
        
        try {
        	con = DBconnection.createConnection();
        	
        	String query = "DELETE FROM product where PID= ?";
        	
			ps = (PreparedStatement) con.prepareStatement(query);
			 
	        ps.setInt(1, productID);
	 
	        ps.executeUpdate();
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}

    }
    
    public String creatComments(Comments comments) {
        
    	Connection con = null;
    	PreparedStatement ps;
        
		try {
			
			con = DBconnection.createConnection();
	    	String query = "INSERT INTO COMMENTS(CID, UID, PID, SID, RATES, COMM) values (NULL,?,?,?,?,?)";
			ps = (PreparedStatement) con.prepareStatement(query);
			
	        ps.setInt(1, comments.getUserID());
	        ps.setInt(2, comments.getProductID());
            ps.setInt(3, comments.getSellerID());
	        ps.setFloat(4, comments.getRates());
	        ps.setString(5, comments.getComments());
	        
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
    
    public List<Comments> myComments(int userID){
    	Connection con = null;
    	PreparedStatement ps = null;
		ResultSet rs = null;
		
    	List<Comments> list = new ArrayList<Comments>();
    	
    	try
		{
		con = DBconnection.createConnection();
		String query = "SELECT COMMENTS.CID, comments.UID, comments.PID, comments.SID, comments.rates, comments.comm, user_profile.FNAME, user_profile.LNAME, product.PNAME FROM COMMENTS, user_profile, product WHERE SID=? and comments.UID=user_profile.UID and comments.PID = product.PID;"; 
		ps = (PreparedStatement) con.prepareStatement(query);
		ps.setInt(1, userID);
		rs = ps.executeQuery();
		
		while(rs.next()) {
            int commentID = rs.getInt("COMMENTS.CID");
            int UID = rs.getInt("COMMENTS.UID");
            int productID = rs.getInt("COMMENTS.PID");
            int sellerID = rs.getInt("COMMENTS.SID");
            
            float rates = rs.getFloat("COMMENTS.RATES");
            String comments = rs.getString("COMMENTS.COMM");
            String fname = rs.getString("user_profile.FNAME"); 
            String lname = rs.getString("user_profile.LNAME");
            String productName = rs.getString("product.PNAME");
            
            
            
                        
            Comments comm = new Comments();
            comm.setCommentID(commentID);
            comm.setUserID(UID);
            comm.setProductID(productID);
            comm.setSellerID(sellerID);
            comm.setBuyerName(fname + " " + lname);
            comm.setProductName(productName);
            comm.setRates(rates);
            comm.setComments(comments);


            
            list.add(comm);
		}
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
    	
    	return list;
    }
    
    public List<User> queryUser(){
    	Connection con = null;
    	PreparedStatement ps = null;
		ResultSet rs = null;
		int status = 0;
		
    	List<User> list = new ArrayList<User>();
    	
    	try
		{
		con = DBconnection.createConnection();
		String query = "SELECT * FROM user WHERE role=? AND status=?"; 
		ps = (PreparedStatement) con.prepareStatement(query);
		ps.setString(1, "Customer");
		ps.setInt(2, status);
		rs = ps.executeQuery();
		
		while(rs.next()) {
            String username = rs.getString("UNAME");
            
            User user = new User();

            user = getUserByUserName(username);
            
            list.add(user);
			}
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
    	
    	return list;
    }
    
    public void blockUser(int userID) {
    	
    	Connection con = null;
    	PreparedStatement ps = null;
    	int block = 1;
        
        try {
        	con = DBconnection.createConnection();
        	
        	String query = "UPDATE user SET status=? WHERE UID=?";
        	
			ps = (PreparedStatement) con.prepareStatement(query);
			
			ps.setInt(1, block); 
	        ps.setInt(2, userID);
	 
	        ps.executeUpdate();
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}

    }
    
    
}




