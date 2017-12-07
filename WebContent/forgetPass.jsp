<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forget password</title>

<script>
function validate() {
    var uname = document.forms["form"]["uname"].value;
    var email = document.forms["form"]["email"].value;
    if (uname == "" && email == "") {
        alert("Please enter user name and E-mail.");
        return false;
    } 
    else if (uname == "") {
        alert("Please enter user name.");
        return false;
    } 
    else if (email == "") {
        alert("Please enter E-mail.");
        return false;
    }
}
</script>
</head>
<body>
<body style="background-image: url('images/background.jpg');
  background-color: #f2f2f2;
  background-blend-mode: screen;">

<jsp:include page="_nav.jsp"></jsp:include>

<div class="container">
  
  <form name ="form" class="form-horizontal" action="forgetPass" method="Post" onsubmit="return validate()">
  	<center><h5>Please enter your user name and the registration E-mail</h5></center>
  	<br>
  	<div class="form-group">
      <label class="control-label col-sm-2" >User Name:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="uname" name="uname">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Email:</label>
      <div class="col-sm-8">
        <input type="email" class="form-control" id="email" name="email">
      </div>
    </div>
   
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-8">
        <button type="submit" class="btn btn-primary center-block">Submit</button>
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