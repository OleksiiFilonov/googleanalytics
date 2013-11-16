<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<jsp:include page="styles.jsp"/>
</head>
<body>
	<h1>Search Page</h1>
	<jsp:include page="navHeader.jsp"/>
	<div>Found Products:</div>
	<div>
	  <table>
	      <thead>
	          <tr>
	              <th>Title</th><th>Description</th><th>Price</th>
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