package model;

public class Product {
	 
       private String name;
	   private String description;
	   private int productId;
	   private String category;
	   private int price;
	   private int sellerID;
	   private String address;
	 
	   public Product() {  
	   }
	    
	   public String getName() {
	       return name;
	   }
	 
	   public void setName(String name) {
	       this.name = name;
	   }
	   
	   public String getDescription() {
	       return description;
	   }
	 
	   public void setDescription(String description) {
	       this.description = description;
	   }
	 
	   public int getProdcutId() {
	       return productId;
	   }
	   	   
	   public void setProductId(int productId) {
	       this.productId = productId;
	   }
	 
	   public int getPrice() {
	       return price;
	   }
	 
	   public void setPrice(int price) {
	       this.price = price;
	   }
	  
	   public int getSellerID() {
	       return sellerID;
	   }
	 
	   public void setSellerID(int sellerID) {
	       this.sellerID = sellerID;
	   }
	   
	   public String getAddress() {
	       return address;
	   }
	 
	   public void setAddress(String address) {
	       this.address = address;
	   }
	   
	   public String getCategory() {
	       return category;
	   }
	 
	   public void setCategory(String category) {
	       this.category = category;
	   }
	   
	   
	}