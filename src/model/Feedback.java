package model;

public class Feedback {
	private int feedbackID;
	private int userID; // user who gives comments
	private int productID;

	private int sellerID; // UID of the product seller
	private String feedback;
	public int getFeedbackID() {
		return feedbackID;
	}
	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getSellerID() {
		return sellerID;
	}
	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
}
