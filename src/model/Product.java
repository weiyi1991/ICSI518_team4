package model;

public class Product {
	 
       private String name;
	   private String description;
	   private int productId;
	   private String category;
	   private int price;
	   private String seller;
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
	 
	}