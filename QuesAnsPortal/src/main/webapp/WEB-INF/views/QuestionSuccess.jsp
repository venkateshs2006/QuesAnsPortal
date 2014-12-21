<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QuestionSuccess</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css"/>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"/>
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js" />
<style type="text/css">
#content {
    background-color:#ffaa00;
    width:500px;
    height:500px;
    padding:3px;
}
</style>
<script type="text/javascript">
$("#content").click(function() {
	alert("Clicked");
    $("#content").animate(
            {"height": "100px", "width": "250px"},
            "slow", function(){});
});
</script>
</head>
<body>
<p>Question : ${ques}.</p>
<p>Answer : ${answer}</p>
<br><br>
<h3>Wiki Search result</h3>
<div id="content">${wiki}</div>
</body>
</html>