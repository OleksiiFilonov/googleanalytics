<html>
<head>
	<title>Delivery Page</title>
	<jsp:include page="fragments/googleanalytics.jsp"/>
</head>
<body>
	<h1>Delivery Page</h1>
	<div>
       <form method="post" action="/checkout/payment.do">
           <input type="submit" value="Payment"/>
       </form>		
	</div>
</body>
</html>