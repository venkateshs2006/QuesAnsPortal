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
        $( "#tabs" ).tabs();
        $("#mySubmit").click(function(event){
        	var formData=$("#ques").val();
        	
            $.ajax( {
               url:'${pageContext.request.contextPath}/RequestQuestion',
               type: "POST",
               data : "ques="+formData,               
               success:function(response) { 
            	//  alert(response);
                  $('#myresulttabs').html(response);
               },
               error: function() {
                   $('#myresulttabs').text('An error occurred');
                }
            });
         });

        
        
        
    });
    
</script>
 <style type="text/css">
 body {
  text-align: left;
  margin-top: 150px;
  margin-left:50px;
  
 }
 
 #page-wrap {
     width: 800px;     
     margin: 0 auto;
}

 </style>
 
</head>
<body >
<div id="page-wrap" name="page-wrap" style="border: 3px solid #a6c9e2; padding: 10px;">
<div>
<form id="question" name="question" method="post">
<input path="ques" id="ques" name="ques" size="70"/>
<input type="button" name="mySubmit" id="mySubmit" value="Get Result" />
</form>
</div>
</div>
<div id="myresulttabs" style="width: 800px;margin: 0 auto;border: 3px solid #a6c9e2; padding:10px;"/>
</body>
</html>
