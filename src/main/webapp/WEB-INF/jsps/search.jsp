<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<jsp:include page="styles.jsp"/>
</head>
<body>
	<h1>Search Page</h1>
	<div>Found Products:</div>
	<div>
	  <table class="productsTable">
	      <thead>
	          <tr>
	              <td>Title</td><td>Description</td><td>Price</td>
	          </tr>
	      </thead>
	      <tbody>
	          <c:forEach var="product" items="${products}">
	              <tr>
	                  <td><a href="/product/${product.id}.do">${product.title}</a></td>
	                  <td>${product.description}</td>
	                  <td>${product.price}</td>
	              </tr>
	          </c:forEach>
	      </tbody>
	  </table>
	</div>
</body>
</html>