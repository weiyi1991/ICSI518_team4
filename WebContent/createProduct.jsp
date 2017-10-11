<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Product</title>
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>

	<!-- If not login, can't sell -->
	<% 
    if(session.getAttribute("user")==null){
    //	response.sendRedirect("login.jsp");    	
    }
    
	%>
	
	<!-- selling form -->
	
	
	 <h3>Create Product</h3>
       
      <p style="color: red;">${errorString}</p>
       
      <form method="POST" action="createProduct">
         <table border="0">
            <tr>
               <td>Name</td>
               <td><input type="text" name="name" /></td>
            </tr>
            <tr>
               <td>Description</td>
               <td><textarea name="description"></textarea></td>
            </tr>
            <tr>
               <td>Price</td>
               <td><input type="text" name="price" /></td>
            </tr>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                
               </td>
            </tr>
         </table>
      </form>

</body>
</html>