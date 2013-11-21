<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Google Analytics Category Page</title>
<jsp:include page="fragments/styles.jsp"/>
</head>
<body>
	<h1>Basket Page</h1>
	<jsp:include page="fragments/navHeader.jsp"/>
	<div>Added Products:</div>
	<div>
	  <table>
	      <thead>
	          <tr>
	              <th>Title</th><th>Description</th><th>Price</th><th>Quantity</th>
	          </tr>
	      </thead>
	      <tbody>
	          <c:forEach var="entry" items="${cart.entries}">
	              <tr>
	                  <td><a href="/product/${entry.product.id}.do">${entry.product.title}</a></td>
	                  <td>${entry.product.description}</td>
	                  <td>${entry.product.price}</td>
	                  <td>${entry.quantity}</td>
	              </tr>
	          </c:forEach>
	          <tr>
	           <td colspan="2">Total</td>
	           <td colspan="2">${cart.total}</td>
	          </tr>
	      </tbody>
	  </table>
	</div>
	<div>
	   <form method="post" action="/checkout/delivery.do">
	       <input type="submit" value="Checkout"/>
	   </form>
	</div>
</body>
</html>