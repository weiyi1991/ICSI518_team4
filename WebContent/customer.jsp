<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="form.css" type="text/css">
</head>
<body style="background-image: url('images/background.jpg');
  background-color: #f2f2f2;
  background-blend-mode: screen;">
	
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.
   
       
    if(session.getAttribute("user")==null){
    	//response.sendRedirect("login.jsp");    	
    }
    
	%>
	
	<div class = "intro">
		Welcome <%=session.getAttribute("username") %>
	
		<br>
		<br>
				
		<span>Current time: </span>	
		<p id="time">
			<script> document.getElementById("time").innerHTML = Date();</script>
		</p>
	
		<% System.out.println("customer session:" + session.getAttribute("user")); %>
		
		<ul class="list">
   			<li><a href="nav.jsp">Navigation</a></li>
  			<li><a href="login.jsp">Login</a></li>
  			<li><a href="signup.jsp">Sign Up</a> 
		</ul>
	
		<br>
	</div>
	
	
	
	
	<div class="user-info">
		Username: <%=session.getAttribute("username")%>
		<br>
		Role: <%=session.getAttribute("role")%> 
		<br>
		First name:<%=session.getAttribute("firstname")%>
		<br>
		Last name:<%=session.getAttribute("lastname")%>
		
		<div class="user-log-out">
			<form action="logout" method="post">
  		 		<input type="submit" value="Logout" />
       	 </form>
        </div>
	</div>
</body>
</html>