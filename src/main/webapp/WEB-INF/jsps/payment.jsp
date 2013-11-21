<html>
<head>
	<title>Payment Page</title>
	<jsp:include page="fragments/googleanalytics.jsp"/>
</head>
	<body>
		<h1>Payment Page</h1>
        <div>
           <form method="post" action="/checkout/confirmation.do">
               <input type="submit" value="Submit Payment"/>
           </form>      
        </div>		
	</body>
</html>