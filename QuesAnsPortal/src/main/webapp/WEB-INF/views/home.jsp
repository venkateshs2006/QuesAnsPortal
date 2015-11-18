<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>
</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<script type="text/javascript" src="resources/jquery.min.js"></script>
<script src="resources/jquery-ui.js"></script>
<link rel="stylesheet" href="resources/jquery-ui.css"/>
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link href="resources/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="resources/fonts.css" rel="stylesheet" type="text/css" media="all" />
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
<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->

</head>
<body>
<div id="header-wrapper">
	<div id="header" class="container">
		<div id="logo">
			<h1><span class="fa fa-bolt"></span><a href="#">interrogative System</a></h1>
		</div>
		
	</div>
</div>
<div id="header-featured" style="height:10px;">
	<div id="banner-wrapper">
		<div id="banner" class="container">
			<div>
<form id="question" name="question" method="post">
<input path="ques" id="ques" name="ques" size="70"/>
<input type="button" name="mySubmit" id="mySubmit" value="Get Result" />
</form>
</div>
		</div>
	</div>
</div>
<div id="wrapper">
	<div id="featured-wrapper">
		<div id="featured" class="extra2 margin-btm container">
			<div class="main-title">
				<h2>Search Engines Results</h2>
				<span class="byline">Fetching results from Our Database, google & wiki </span> </div>	
			<div id="myresulttabs" style="text-align: left;"/>
		</div>
		
	</div>
</div>
</div>
<div id="copyright" class="container">
	<p>&copy; Untitled. All rights reserved. </p>
</div>
</body>
</html>
