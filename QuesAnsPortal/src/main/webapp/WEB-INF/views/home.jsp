<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	    <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />
 
    <script type="text/javascript"
        src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    <script type="text/javascript"
        src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
 
</head>
<body>
<form:form action="/quesans/RequestQuestion"  method="post" commandName="question">
<form:hidden path="id" id="id" name="id" value="1"/>
<form:input path="ques" id="ques" name="ques" size="70"/>
<input type="submit" />
</form:form>
<p>The time on the server is ${serverTime}.</p>
</body>
</html>
