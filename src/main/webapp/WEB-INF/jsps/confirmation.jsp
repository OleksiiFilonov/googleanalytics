<%@ taglib tagdir="/WEB-INF/tags" prefix="cart" %>

<html>
<head>
<jsp:include page="styles.jsp"/>
</head>	
<body>
	<h1>Confirmation Page</h1>
    <cart:CartDetails order="${cart}"/>
       <div>
          <form method="post" action="/checkout/thankyou.do">
              <input type="submit" value="Confirm"/>
          </form>      
       </div>		
</body>
</html>