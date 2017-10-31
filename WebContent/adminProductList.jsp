<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List</title>
<link rel="stylesheet" href="form.css" type="text/css">
<style>
table, th, td {
    border: 1px solid black;
    padding: 0 50px 0 50px;
}
th, td {
    padding: 15px;
}
</style>
</head>
<body>

	<% 
    //if(request.getAttribute("productList")==null)
    	//response.sendRedirect("login.jsp");
	%>
	
	<% 
    if(session.getAttribute("user")==null){%>
    	<jsp:include page="_nav.jsp"></jsp:include>    	
    <%}else{%>
    	<jsp:include page="_navLogin.jsp"></jsp:include>
    <%} %>
  

	<!-- product lists  -->
	
	<h3>Product List</h3>
 
   
    <table style="width:80%" >
       <tr>
 		  <th>Name</th>
          <th>Description</th>
          <th>Price ($)</th>
          <th></th>
       </tr>
       <c:forEach items="${productList}" var="product" >
          <tr>
          	<td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td><a href="deleteProduct?productID=${product.productId}">Delete</a></td>
          </tr>
      	 </c:forEach>
   		</table>
</body>
</html>