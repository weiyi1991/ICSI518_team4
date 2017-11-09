<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Product</title>
</head>
<body>
<jsp:include page="_navLogin.jsp"></jsp:include>
<%
User seller = (User)request.getAttribute("seller");
Product product = (Product)request.getAttribute("product");
User user = (User) session.getAttribute("user");
if(user == null){
	response.setHeader("refresh", "0; URL = login.jsp"); 
}
%>

<div class="container">
  <center><h2>Product information</h2></center>
  <br>
 
  <form class="form-horizontal" action="submitComments" method="Post">
    <input type="hidden" name="pid" value="<%=product.getProductId()%>" />  
  	<input type="hidden" name="sid" value="<%=seller.getUserId()%>" />  
  	<input type="hidden" name="uid" value="<%=user.getUserId()%>" /> 
  	<div class="form-group">
      <label class="control-label col-sm-2" >Product Name:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="pname" value="<%=product.getName() %>" name="pname" readonly>
      </div>
    </div>
      	<div class="form-group">
      <label class="control-label col-sm-2" >Product Description:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="desp" value="<%=product.getDescription() %>" name="desp" readonly>
      </div>
    </div>
      	<div class="form-group">
      <label class="control-label col-sm-2" >Price:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="price" value="<%=product.getPrice() %>" name="price" readonly>
      </div>
    </div>

  	<div class="form-group">
      <label class="control-label col-sm-2" >Seller Name:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="sname" value="<%= seller.getFirstName()+ ' ' + seller.getLastName() %>" name="sname" readonly>
      </div>
    </div>

    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Email:</label>
      <div class="col-sm-8">
        <input type="email" class="form-control" id="email" value="<%= seller.getEmail() %>" name="email" readonly>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Phone Number:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="phone" value="<%= seller.getPhoneNumber() %>" name="phone" readonly>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Address:</label>
      <div class="col-sm-8">          
        <input type="text" class="form-control" id="address" value="<%= seller.getAddress() %>" name="address" readonly>
    	</div>
    </div>
  
    <div class="form-group">
      <label class="control-label col-sm-2" >Guaranteed:</label>
      <div class="col-sm-8">          
        <input type="text" class="form-control" id="verify" value="<%= seller.getUserVerify() %>" name="verify" readonly>
    	</div>
    </div>
  
  
    <br><hr><br>
    <h3>Comments</h3><br>
    <div class="form-group">
      <label class="control-label col-sm-2" >Rating score:</label>
      <div class="col-sm-8">          
        <select class="form-control" name="rates">
	      		<option>5.0</option>
	      		<option>4.0</option>
	      		<option>3.0</option>
	      		<option>2.0</option>
	      		<option>1.0</option>
    	</select>
    	</div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Comments:</label>
      <div class="col-sm-8">
        <textarea class="form-control" id="comments" rows="3" name="comments"></textarea>
      </div>
    </div>
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-8">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  </form>
</div> 
</body>
</html>