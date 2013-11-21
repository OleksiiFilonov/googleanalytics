<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<html>
<head>
<jsp:include page="fragments/styles.jsp"/>
</head>	
<body>
	<h1>Confirmation Page</h1>
    <t:CartDetailsWithoutLinks order="${cart}"/>
       <div>
          <form method="post" action="/checkout/thankyou.do">
              <input type="submit" value="Confirm"/>
          </form>      
       </div>		
</body>
</html>