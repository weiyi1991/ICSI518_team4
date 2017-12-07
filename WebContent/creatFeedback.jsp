<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create feedback</title>
</head>
<body style="background-image: url('images/background.jpg');
  background-color: #f2f2f2;
  background-blend-mode: screen;">

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
  <center><h2>Create feedback</h2></center>
  <br>
 
  <form class="form-horizontal" action="submitFeedbacks" method="Post">
    <input type="hidden" name="pid" value="<%=product.getProductId()%>" />  
  	<input type="hidden" name="sid" value="<%=seller.getUserId()%>" />  
  	<input type="hidden" name="uid" value="<%=user.getUserId()%>" /> 
  	<div class="form-group">
      <label class="control-label col-sm-2" >Your Name:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="uname" value="<%=user.getFirstName()+ ' ' + user.getLastName() %>" name="uname" readonly>
      </div>
    </div>
  	
  	<div class="form-group">
      <label class="control-label col-sm-2" >Product Name:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="pname" value="<%=product.getName() %>" name="pname" readonly>
      </div>
    </div>
      	
  	<div class="form-group">
      <label class="control-label col-sm-2" >Seller Name:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="sname" value="<%= seller.getFirstName()+ ' ' + seller.getLastName() %>" name="sname" readonly>
      </div>
    </div>

    <div class="form-group">
      <label class="control-label col-sm-2" >Feedback:</label>
      <div class="col-sm-8">
        <textarea class="form-control" id="comments" rows="3" name="feedback"></textarea>
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