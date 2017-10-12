<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
</head>
<body>
     <jsp:include page="_navLogin.jsp"></jsp:include>
       
      <ul>
        <li>		
        	<form action="productList" method="post">
  		 		<input type="submit" value="Product List" />
       	 	</form>
       	</li>
        <li>
         	<form action="createProduct.jsp">
   			 	<input type="submit" value="Create Product" />
			</form>
		</li>
     </ul>
</body>
</html>