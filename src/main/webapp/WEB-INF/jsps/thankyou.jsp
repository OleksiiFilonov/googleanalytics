<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<html>
<head>
    <title>Thank You Page</title>
    <jsp:include page="fragments/styles.jsp"/>
    <jsp:include page="fragments/googleanalytics.jsp"/>
    <t:ecommerceAnalytics order="${lastOrder}"/>
</head>
<body>
	<h1>Thank You Page</h1>
	<jsp:include page="fragments/navHeader.jsp"/>
    <t:cartDetailsWithoutLinks order="${lastOrder}"/>
</body>
<jsp:include page="fragments/trackLoadTime.jsp"/>
</html>