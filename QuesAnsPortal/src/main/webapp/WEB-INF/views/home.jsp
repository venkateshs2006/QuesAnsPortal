<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<form:form action="/quesans/RequestQuestion"  method="post" commandName="question">
<form:hidden path="id" value="1"/>
<form:input path="ques" size="70"/>
<input type="submit" />
</form:form>
<p>The time on the server is ${serverTime}.</p>
</body>
</html>
