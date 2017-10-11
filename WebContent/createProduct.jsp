<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Product</title>
</head>
<body>

	<jsp:include page="_nav.jsp"></jsp:include>

	<!-- If not login, can't sell -->
	<% 
    if(session.getAttribute("user")==null){
    //	response.sendRedirect("login.jsp");    	
    }
    
	%>
	
	<!-- selling form -->
	
	<div class="container">
  <center><h2>Create Product</h2></center>
  <br>
   <p style="color: red;">${errorString}</p>
  <form class="form-horizontal" action="createProduct" method="Post">
       
    <div class="form-group">
      <label class="control-label col-sm-2" >Product Name:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="pname" placeholder="" name="pname">
      </div>
    </div>
  	<div class="form-group">
      <label class="control-label col-sm-2" >Description:</label>
      <div class="col-sm-8">
        <textarea class="form-control" id="desp" rows="3" name="desp"></textarea>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Price:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="price" placeholder="" name="price">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Category:</label>
      <div class="col-sm-8">          
        <select class="form-control" name="category">
	      		<option>Electronics</option>
	      		<option>Fine Arts</option>
	      		<option>Furnitures</option>
	      		<option>Books</option>
	      		<option>Cars</option>
    	</select>
    	</div>
    </div>
    <div class="form-group">
    	<label class="control-label col-sm-2" for="inputfile">Photo:</label>
    	<div class="col-sm-8">
    		<input type="file" id="photo" name="photo">
    	</div>
  	</div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-8">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
    
  </form>

</body>
</html>