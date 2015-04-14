<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ page session="false" %>
<html>
<head>
<title>Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/jquery-ui.css">
<script type="text/javascript" src="resources/jquery.min.js"></script>
<script src="resources/jquery-ui.js"></script>
<script type="text/javascript">
    $(function() {      
        $("#ques").autocomplete({
            source: function (request, response) {
               $.getJSON("${pageContext.request.contextPath}/getMachedQuestion", {
                    term: request.term
                }, response);
               
            }
        });
    });
    
</script>
 
</head>
<body>
<form:form action="/quesans/RequestQuestion"  method="post" commandName="question">
<form:input path="ques" id="ques" size="70"/>
<input type="submit" />
</form:form>
<p>The time on the server is ${serverTime}.</p>
</body>
</html>
