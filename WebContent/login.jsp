<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<script>
function validate() {
    var uname = document.forms["form"]["username"].value;
    var pass = document.forms["form"]["pass"].value;
    if (uname == "" && pass == "") {
        alert("Please enter user name and password.");
        return false;
    } 
    else if (uname == "") {
        alert("Please enter user name.");
        return false;
    } 
    else if (pass == "") {
        alert("Please enter password.");
        return false;
    }
}
</script>

<link rel="stylesheet" href="form.css" type="text/css">

</head>
<body>
    
   	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.     
    
	%>
    
<jsp:include page="_nav.jsp"></jsp:include>



<form class="form" name ="form" action="login" method="post" onsubmit="return validate()">

	<div class="form-title-row">
		<h1>Log In</h1>
	</div>

    <div class="form-row">
    	<label>
       		<span>Username</span>
        	<input type="text" name="username">
        </label>
    </div>

    <div class="form-row">
    	<label>
       		<span>Password</span>
        	<input type="password" name="pass">
        </label>
    </div>

    <div class="form-row">
    	<button type="submit">Log In</button>
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