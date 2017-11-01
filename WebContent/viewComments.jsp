<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% if(session.getAttribute("user")==null){%>
    	<jsp:include page="_nav.jsp"></jsp:include>    	
    <%}else{%>
    	<jsp:include page="_navLogin.jsp"></jsp:include>
    <%} %>
  

	<!-- product lists -->
	
	<h3>My Comments List</h3>
 
   
    <table style="width:80%" >
       <tr>
		  <th>Product name</th>
          <th>Buyer name</th>
          <th>Rating score</th>
          <th>Comments</th>
       </tr>
       <c:forEach items="${commentsList}" var="comment" >
          <tr>
          	<td>${comment.productName}</td>
            <td>${comment.buyerName}</td>
            <td>${comment.rates}</td>
            <td>${comment.comments}</td>
          </tr>
      	 </c:forEach>
   		</table>

</body>
</html>