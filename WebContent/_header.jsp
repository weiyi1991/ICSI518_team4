<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div style="background: #E0E0E0; height: 85px; padding: 5px;">
  <div style="float: left">
     <h1>E-Commerce</h1>
  </div>
 
  <div style="float: right; padding: 10px; text-align: right;">
 
    
   <!-- Hello <b>${loginedUser.userName}</b>  Search <input name="search">  -->  
   
   <br/>
     
     <div class="form-group">
      <label class="control-label col-sm-2" >Search:</label>
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
 
  </div>
 
</div>