<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Change Password</title>
</head>
<body style="background-image: url('images/background.jpg');
  background-color: #f2f2f2;
  background-blend-mode: screen;">

<jsp:include page="_navLogin.jsp"></jsp:include>

<%	
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setDateHeader("Expires", 0); // Proxies.
	

	User user = (User) session.getAttribute("user");
	if(user == null){
		response.setHeader("refresh", "0; URL = login.jsp"); 
	}
%>

<div class="container">
  
  <form class="form-horizontal" action="resetPassword" method="Post">
  	<div class="form-group">
      <label class="control-label col-sm-2" >User Name:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="uname" value="<%=user.getUserName() %>" name="uname" readonly>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Email:</label>
      <div class="col-sm-8">
        <input type="email" class="form-control" id="email" value="<%= user.getEmail() %>" name="email" readonly>
      </div>
    </div>
  	<div class="form-group">
      <label class="control-label col-sm-2" >New Password:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="fname" name="newPass">
      </div>
    </div>
   
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-8">
        <button type="submit" class="btn btn-primary center-block">Update</button>
      </div>
    </div>
    
    <div class="form-row">
    	<label>
       		<span><%=(request.getAttribute("errMessage") == null) ? ""
					: request.getAttribute("errMessage")%></span>
         </label>
    </div>
  </form>
</body>
</html>