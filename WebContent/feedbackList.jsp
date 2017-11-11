<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Feedback List</title>
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
    	<jsp:include page="_navLoginAdmin.jsp"></jsp:include>
    <%} %>
  

	<!-- user lists  -->
	
	<h3>Feedback List</h3>
 
   
    <table style="width:80%" >
       <tr>
 		  <th>Index</th>
          <th>User ID</th>
          <th>Product ID</th>
          <th>Seller ID</th>
          <th>Feedback</th>
       </tr>
       <c:forEach items="${feedbackList}" var="fb" >
          <tr>
          	<td>${fb.feedbackID}</td>
            <td>${fb.userID}</td>
            <td>${fb.productID}</td>
            <td>${fb.sellerID}</td>
            <td>${fb.feedback}</td>
          </tr>
      	 </c:forEach>
   		</table>
</body>
</html>