<html>
<head>
<jsp:include page="styles.jsp"/>
</head>
	<body>
		<h1>Product Page</h1>
		<table>
		  <tr><td>Title</td><td>${product.title}</td></tr>
		  <tr><td>Description</td><td>${product.description}</td></tr>
		  <tr><td>Price</td><td>${product.price}</td></tr>
		</table>
	</body>
</html>