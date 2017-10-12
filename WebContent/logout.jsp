<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log out</title>
</head>
<body>

	<%
	/*
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.*/
    
    if(session.getAttribute("user")!=null){
    	session.invalidate();    	
    }
	%>

<p>You have been successfully logout</p>


<br>
<input type="button" onclick="location.href='login.jsp';" value="Login" />
<br>



</body>
</html>