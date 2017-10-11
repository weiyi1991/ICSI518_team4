<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Product</title>

<script>
function validate() {
    var name = document.forms["form"]["name"].value;
    var desp = document.forms["form"]["description"].value;
    var price = document.forms["form"]["price"].value;
    
    if (name == "" && desp == "" && price == "") {
        alert("Please enter product information.");
        return false;
    } 
    else if (name == "") {
        alert("Please enter product name.");
        return false;
    } 
    else if (desp == "") {
        alert("Please enter product description.");
        return false;
    }
    else if (price == "") {
        alert("Please enter product price.");
        return false;
    }
}
</script>

</head>
<body>

	<jsp:include page="_navLogin.jsp"></jsp:include>

	<!-- If not login, can't sell -->
	<% 
    if(session.getAttribute("user")==null){
    	response.sendRedirect("login.jsp");    	
    }
    
	%>
	
	<!-- selling form -->
	
	
	 <h3>Create Product</h3>
       
      <p style="color: red;">${errorString}</p>
       
      <form name="form" method="POST" action="createProduct" onsubmit="return validate()">
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