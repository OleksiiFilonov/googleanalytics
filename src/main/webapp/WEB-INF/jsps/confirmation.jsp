<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<html>
<head>
    <title>Confirmation Page</title>
	<jsp:include page="fragments/styles.jsp"/>
	<jsp:include page="fragments/googleanalytics.jsp"/>
</head>	
<body>
	<h1>Confirmation Page</h1>
    <t:cartDetailsWithoutLinks order="${cart}"/>
       <div>
          <form method="post" action="/checkout/thankyou.do">
              <input type="submit" value="Confirm"/>
          </form>      
       </div>		
</body>
<jsp:include page="fragments/trackLoadTime.jsp"/>
</html>