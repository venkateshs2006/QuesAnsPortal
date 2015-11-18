<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Search Engine</title>
	</head>
	<body>
		<h2>Add Search Engine</h2>
		<form:form method="POST" action="/quesans/save" commandName="searchEngine" modelAttribute="searchEngine">
	   		<table>
			    <tr>
			        <td><form:label path="searchEngineId">Search Engine ID:</form:label></td>
			        <td><form:input path="searchEngineId" value="${searchEngine.searchEngineId}" default=""/></td>
			    </tr>
			    <tr>
			        <td><form:label path="searchEngineName">Search Engine Name:</form:label></td>
			        <td><form:input path="searchEngineName" value="${searchEngine.searchEngineName}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="searchEngineURL">Search Engine URL:</form:label></td>
			        <td><form:input path="searchEngineURL" value="${searchEngine.searchEngineURL}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="resultTag">Result Tag:</form:label></td>
			        <td><form:input path="resultTag" value="${searchEngine.resultTag}"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="resultTagAttrbName">Result Tag AttributeName:</form:label></td>
                    <td><form:input path="resultTagAttrbName" value="${searchEngine.resultTagAttrbName}"/></td>
			    </tr>
			     <tr>
			        <td><form:label path="resultTagAttrbValue">Result Tag AttributeValue:</form:label></td>
                    <td><form:input path="resultTagAttrbValue" value="${searchEngine.resultTagAttrbValue}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="tagPosition">Result Tag Position:</form:label></td>
                    <td><form:input path="tagPosition" value="${searchEngine.tagPosition}" default=""/></td>
			    </tr>
			    <tr>
			        <td><form:label path="regexDetails">RegEx Details:</form:label></td>
                    <td><form:input path="regexDetails" value="${searchEngine.regexDetails}"/></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form:form>
		
  <c:if test="${!empty searchEngineList}">
		<h2>Search Engine List</h2>
	<table align="left" border="1">
		<tr>
			<th>Search Engine ID</th>
			<th>Search Engine Name</th>
			<th>Search Engine URL</th>
			<th>Result Tag</th>
			<th>AttributeName</th>
			<th>AttributeValue</th>
			<th>TagPosition</th>
			<th>RegEx</th>
		</tr>

		<c:forEach items="${searchEngineList}" var="searchEngine">
			<tr>
				<td><c:out value="${searchEngine.searchEngineId}"/></td>
				<td><c:out value="${searchEngine.searchEngineName}"/></td>
				<td><c:out value="${searchEngine.searchEngineURL}"/></td>
				<td><c:out value="${searchEngine.resultTag}"/></td>
				<td><c:out value="${searchEngine.resultTagAttrbName}"/></td>
				<td><c:out value="${searchEngine.resultTagAttrbValue}"/></td>
				<td><c:out value="${searchEngine.tagPosition}"/></td>
				<td><c:out value="${searchEngine.regexDetails}"/></td>
				<td align="center"><a href="edit?searchEngineId=${searchEngine.searchEngineId}">Edit</a> | <a href="delete?searchEngineId=${searchEngine.searchEngineId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
	</body>
</html>