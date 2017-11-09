package model;

public class User {
	 
       private String userName;
	   private String firstName;
	   private String lastName;
	   private String role;
	   private String password;
	   private int userId;
	   private String email;
	   private String phoneNumber;
	   private String address;
	   private int status;
	   private int verify;
	 
	   public User() {  
	   }
	    
	   public String getUserName() {
	       return userName;
	   }

	   public void setUserName(String userName) {
		   this.userName = userName;
	   }

	   public String getFirstName() {
		   return firstName;
	   }

	   public void setFirstName(String firstName) {
		   this.firstName = firstName;
	   }

	   public String getLastName() {
		   return lastName;
	   }

	   public void setLastName(String lastName) {
		   this.lastName = lastName;
	   }

	   public String getEmail() {
		   return email;
	   }

	   public void setEmail(String email) {
		   this.email = email;
	   }

	   public String getPhoneNumber() {
		   return phoneNumber;
	   }

	   public void setPhoneNumber(String phoneNumber) {
		   this.phoneNumber = phoneNumber;
	   }

	   public String getAddress() {
		   return address;
	   }

	   public void setAddress(String address) {
			this.address = address;
	   }
		
	   
	   public String getPassword() {
	       return password;
	   }
	 
	   public void setPassword(String password) {
	       this.password = password;
	   }
	   
	   public String getRole() {
	       return role;
	   }
	 
	   public void setRole(String role) {
	       this.role = role;
	   }
	   
	   public int getUserId() {
	       return userId;
	   }
	   
	   public void setUserId(int userId) {
	       this.userId = userId;
	   }
	 
	   public int getUserStatus() {
	       return status;
	   }
	   
	   public void setUserStatus(int status) {
	       this.status = status;
	   }
	   
	   public int getUserVerify() {
	       return verify;
	   }
	   
	   public void setUserVerify(int verify) {
	       this.verify = verify;
	   }
	}