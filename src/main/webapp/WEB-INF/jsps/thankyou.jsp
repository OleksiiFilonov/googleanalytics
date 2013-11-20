<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<html>
<head>
<jsp:include page="styles.jsp"/>
</head>
<body>
	<h1>Thank You Page</h1>
	<jsp:include page="navHeader.jsp"/>
    <t:CartDetailsWithoutLinks order="${lastOrder}"/>
</body>
</html>