<%@ taglib tagdir="/WEB-INF/tags" prefix="cart" %>

<html>
<head>
<jsp:include page="styles.jsp"/>
</head>
<body>
	<h1>Thank You Page</h1>
	<jsp:include page="navHeader.jsp"/>
    <cart:CartDetails order="${lastOrder}"/>
</body>
</html>