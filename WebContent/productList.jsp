<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List</title>
</head>
<body style="background-image: url('images/background.jpg');
  background-color: #f2f2f2;
  background-blend-mode: screen;">

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
  

	<!-- product lists -->
	
	<%-- <h3>Product List</h3>
 
   
    <table class="table table-bordered" >
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
            <td><a href="viewProduct?pid=<c:out value="${product.productId}"/>">Buy</a></td>
          </tr>
      	 </c:forEach>
   		</table> --%>
   		
   		
   <div class="container">
  <Center><h3>Product List</h3></Center>
            
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Price ($)</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${productList}" var="product" >
          <tr>
          	<td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td><a href="viewProduct?pid=<c:out value="${product.productId}"/>">Buy</a></td>
          </tr>
      	 </c:forEach>
      <tr>
        <td>July</td>
        <td>Dooley</td>
        <td>july@example.com</td>
        <td>hii</td>
      </tr>
      <tr>
        <td>July</td>
        <td>Dooley</td>
        <td>july@example.com</td>
        <td>hii</td>
      </tr>
    </tbody>
  </table>
</div>
</body>
</html>