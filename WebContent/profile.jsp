<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile</title>
</head>
<body>

<jsp:include page="_navLogin.jsp"></jsp:include>

<%
	User user = (User) session.getAttribute("user");
	if(user == null){
		response.setHeader("refresh", "0; URL = login.jsp"); 
	}
%>

<div class="container">
  <center><h2>Update Profile</h2></center>
  <br>
  <form class="form-horizontal" action="profile_update" method="Post">
  	<div class="form-group">
      <label class="control-label col-sm-2" >User Name:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="uname" value="<%=user.getUserName() %>" name="uname" readonly>
      </div>
    </div>
  	<div class="form-group">
      <label class="control-label col-sm-2" >First Name:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="fname" value="<%= user.getFirstName() %>" name="fname">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Last Name:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="lname" value="<%= user.getLastName() %>" name="lname">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Role:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="role" value="<%= user.getRole() %>" name="role" readonly>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Email:</label>
      <div class="col-sm-8">
        <input type="email" class="form-control" id="email" value="<%= user.getEmail() %>" name="email" readonly>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Phone Number:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="phone" value="<%= user.getPhoneNumber() %>" name="phone">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Address:</label>
      <div class="col-sm-8">          
        <select class="form-control" name="address">
	      		<option>Albany</option>
	      		<option>Schenectady</option>
	      		<option>Troy</option>
	      		<option>New York City</option>
    	</select>
    	</div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-8">
        <div class="checkbox">
          <label><input type="checkbox" name="remember"> Remember me</label>
        </div>
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-8">
        <button type="submit" class="btn btn-default">Update</button>
      </div>
    </div>
    
    <div class="form-row">
    	<label>
       		<span><%=(request.getAttribute("errMessage") == null) ? ""
					: request.getAttribute("errMessage")%></span>
         </label>
    </div>
  </form>
</div> 


</body>
</html>