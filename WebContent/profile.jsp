<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile</title>
</head>
<body>

<jsp:include page="_nav.jsp"></jsp:include>

<div class="container">
  <center><h2>Update Profile</h2></center>
  <br>
  <form class="form-horizontal" action="profile_update" method="Post">
  	<div class="form-group">
      <label class="control-label col-sm-2" >User Name:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="uname" placeholder="" name="uname" disabled>
      </div>
    </div>
  	<div class="form-group">
      <label class="control-label col-sm-2" >First Name:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="fname" placeholder="" name="fname">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Last Name:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="lname" placeholder="" name="lname">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Role:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="role" placeholder="" name="role" disabled>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Email:</label>
      <div class="col-sm-8">
        <input type="email" class="form-control" id="email" placeholder="" name="email" disabled>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Phone Number:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="phone" placeholder="" name="phone">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Address:</label>
      <div class="col-sm-8">          
        <select class="form-control" name="role">
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
  </form>
</div> 


</body>
</html>