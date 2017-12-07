<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
</head>
<body style="background-image: url('images/background.jpg');
  background-color: #f2f2f2;
  background-blend-mode: screen;">
     <jsp:include page="_navLogin.jsp"></jsp:include>
        
      <ul style="list-style: none;padding: 0.5%;">
        <li>		
        	<form action="productList" method="post">
  		 		<input type="submit" class="btn btn-primary center-block" style="width: 25%" value="Product List" /><br>
       	 	</form>
       	</li>
       	
       	<li>		
        	<form action="myList" method="post">
  		 		<input type="submit" class="btn btn-primary center-block" style="width: 25%" value="My Product List" /><br>
       	 	</form>
       	</li>
       	
        <li>
         	<form action="createProduct.jsp">
   			 	<input type="submit" class="btn btn-primary center-block" style="width: 25%" value="Create Product" /><br>
			</form>
		</li>
		<li>
         	<form action="searchProduct.jsp">
   			 	<input type="submit" class="btn btn-primary center-block" style="width: 25%" value="Search Product" /><br>
			</form>
		</li>
		<li>
         	<form action="viewComments" method="post">
   			 	<input type="submit" class="btn btn-primary center-block" style="width: 25%" value="View my comments" /><br>
			</form>
		</li>
     </ul>
</body>
</html>