<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Product</title>

</head>
<body style="background-image: url('images/background.jpg');
  background-color: #f2f2f2;
  background-blend-mode: screen;">

	<jsp:include page="_navLogin.jsp"></jsp:include>

	<!-- If not login, can't sell -->
	<% 
    if(session.getAttribute("user")==null){
    	//response.sendRedirect("login.jsp");    	
    }
    
	%>
	
	<!-- selling form  onsubmit="return validate()" -->
	
  <div class="container">
   <center><img alt="searchProduct" class="center-block" src="images/searchProduct.jpg" style="width:60%; height: 20%"></center>
  </div>
  <br>
  <div class="container">
  <center>
  
   <p style="color: red;">${errorString}</p>
   
   
  <form class="form-horizontal" action="searchProduct" method="Post" >

	 <div class="form-group">
      <label class="control-label col-sm-2" >Category:</label>
      <div class="col-sm-8">          
        <select class="form-control" name="category">
	      		<option>Electronics</option>
	      		<option>Fine Arts</option>
	      		<option>Furniture</option>
	      		<option>Books</option>
	      		<option>Cars</option>
    	</select>
    	</div>
    </div>
    <div class="form-group ">
    	<label class="control-label col-sm-2" for="inputfile">Location:</label>
    	<div class="col-sm-8">
    		<input type="text" class="form-control" id="location" name="location">
    	</div>
  	</div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-8">
        <button type="submit" class="btn btn-primary center-block">Submit</button>
      </div>
    </div>
    
  </form>
  </center>
	</div>
</body>
</html>