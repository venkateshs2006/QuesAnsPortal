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
        	alert(formData);
            $.ajax( {
               url:'${pageContext.request.contextPath}/RequestQuestion',
               type: "POST",
               data : "ques="+formData,               
               success:function(response) { 
            	  alert(response);
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
  margin-left:100px;
  
 }
 
 #page-wrap {
     width: 600px;     
     margin: 0 auto;
}
.drop-shadow {
            position:relative;
            float:left;
            width:40%;
            padding:1em;
            margin:2em 10px 4em;
            background:#fff;
            -webkit-box-shadow:0 1px 4px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.1) inset;
            -moz-box-shadow:0 1px 4px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.1) inset;
            box-shadow:0 1px 4px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.1) inset;
        }
 </style>
 
</head>
<body >
<div id="page-wrap" name="page-wrap" style="border: 3px solid #FF0000; padding: 10px;">
<div>
<form id="question" name="question" method="post">
<input path="ques" id="ques" name="ques" size="70"/>
<input type="button" name="mySubmit" id="mySubmit" value="Get Result" />
</form>
<div id="myresulttabs">
</div>
</div>
</div>
</body>
</html>
