<html>
<head>
    <title>Not Found Page</title>
    <jsp:include page="fragments/styles.jsp"/>
    <script src="/js/jquery.min.js"></script>
    <jsp:include page="fragments/googleanalytics.jsp"/>
    <script type="text/javascript">
    $(document).ready(function() {
    	ga('send', 'event', 'page', 'loaded', 'Not Found');
    });    
    </script>
</head>
    <body>
        <h1>Sorry, there is no such page. Please click one the one of the links below</h1>
        <jsp:include page="fragments/navHeader.jsp"/>
    </body>
</html>