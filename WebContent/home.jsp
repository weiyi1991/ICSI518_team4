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
     <jsp:include page="_nav.jsp"></jsp:include>
       
     <!-- <ul>
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
		<li>
         	<form action="searchProduct.jsp">
   			 	<input type="submit" value="Search Product" />
			</form>
		</li>
     </ul> -->
     
     
     <div id="myCarousel" class="carousel slide" data-ride="carousel" style="width:80%;max-height: 65%;margin-left: 10%;margin-right: 10%">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" >
    <div class="item active">
      <form action="productList" method="post">
      <input type="image" alt="productList" class="center-block" name="Product List" src="images/productList.jpg"><br>
       </form>
    </div>

    <div class="item">
      <form action="createProduct.jsp">
   	   <input type="image" alt="addProduct" class="center-block" name="Create Product" src="images/addProduct.png" ><br>
			</form>
    </div>

    <div class="item">
      <form action="searchProduct.jsp">
   	<input type="image" alt="search" class="center-block" name="Search Product" src="images/search.jpg" ><br>
			</form>
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>

</body>
</html>