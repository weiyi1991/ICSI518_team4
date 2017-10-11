<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up Page</title>
<script>
function validate() {
	var fname = document.forms["form"]["firstname"].value;
	var lname = document.forms["form"]["lastname"].value;
    var uname = document.forms["form"]["username"].value;
    var pass = document.forms["form"]["pass"].value;
    var email = document.forms["form"]["email"].value;
    if (fname == "" && lname == "" && uname == "" && pass == "" && email == "") {
        alert("Please enter information.");
        return false;
    } 
    else if (fname == "") {
        alert("Please enter first name.");
        return false;
    } 
    else if (lname == "") {
        alert("Please enter last name.");
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
    else if (email == "") {
        alert("Please enter E-mail.");
        return false;
    }
}
</script>

<link rel="stylesheet" href="form.css" type="text/css">

</head>
<body>
<jsp:include page="_nav.jsp"></jsp:include>
<form class = "form" name = "form" action="signup" method="post" onsubmit="return validate()">

	<div class="form-title-row">
		<h1>Sign Up</h1>
	</div>

    <div class="form-row">
    	<label>
       		<span>First Name</span>
        	<input type="text" name="firstname">
        </label>
    </div>

    <div class="form-row">
    	<label>
       		<span>Last Name</span>
        	<input type="text" name="lastname">
        </label>
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
    	<label>
       		<span>E-mail</span>
        	<input type="text" name="email">
        </label>
    </div>

    <div class="form-row">
    	<button type="submit">Sign Up</button>
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