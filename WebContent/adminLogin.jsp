<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
</head>
<body>
     <jsp:include page="_navLoginAdmin.jsp"></jsp:include>
        
      <ul style="list-style: none;padding: 0.5%;">
       
        <li>		
        	<form action="adminUserList" method="post">
  		 		<input type="submit" class="btn btn-primary center-block" style="width: 25%" value="User List" /><br>
       	 	</form>
       	</li>
      
        <li>		
        	<form action="adminProductList" method="post">
  		 		<input type="submit" class="btn btn-primary center-block" style="width: 25%" value="Product List" /><br>
       	 	</form>
       	</li>
       	<li>		
        	<form action="feedbackList" method="post">
  		 		<input type="submit" class="btn btn-primary center-block" style="width: 25%" value="Feedback List" /><br>
       	 	</form>
       	</li>
       	
       	
     </ul>
</body>
</html>