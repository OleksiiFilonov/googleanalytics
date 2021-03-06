<html>
<head>
    <title>Product Page</title>
    <script src="/js/jquery.min.js"></script>
    <jsp:include page="fragments/styles.jsp"/>
    <jsp:include page="fragments/googleanalytics.jsp"/>
</head>
	<body>
		<h1>Product Page</h1>
		<div>
		<jsp:include page="fragments/navHeader.jsp"/>
		<table>
		  <tr><td>Title</td><td>${product.title}</td></tr>m
		  <tr><td>Description</td><td>${product.description}</td></tr>
		  <tr><td>Price</td><td>${product.price}</td></tr>
		</table>
		</div>
		<div><a id="download" href="#">Download Specification</a></div>
		<div>
		  <form action="/cart/addToCart.do" method="post">
		      <input type="hidden" value="${product.id}" name="productId"/>
		      <input type="submit" value="Add To Cart" name="addToCart"/>
		  </form>
		</div>
	</body>
	<script>
		$('#download').on('click', function() {
			  ga('send', 'event', 'link', 'click', 'specification', ${product.id});
			  $('#download').text('Downloaded')
			});	
	</script>
	<jsp:include page="fragments/trackLoadTime.jsp"/>
</html>