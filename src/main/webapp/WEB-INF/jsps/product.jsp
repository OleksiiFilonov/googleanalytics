<html>
<head>
<jsp:include page="styles.jsp"/>
</head>
	<body>
		<h1>Product Page</h1>
		<div>
		<jsp:include page="navHeader.jsp"/>
		<table>
		  <tr><td>Title</td><td>${product.title}</td></tr>
		  <tr><td>Description</td><td>${product.description}</td></tr>
		  <tr><td>Price</td><td>${product.price}</td></tr>
		</table>
		</div>
		<div>
		  <form action="/cart/addToCart.do" method="post">
		      <input type="hidden" value="${product.id}" name="productId"/>
		      <input type="submit" value="Add To Cart" name="addToCart"/>
		  </form>
		</div>
	</body>
</html>