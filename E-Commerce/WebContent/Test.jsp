<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>j-Query Form Submit</title>

<script type="text/javascript" src="test_Js/jQueryAjax.js"></script>
<script src="js/jquery-1.11.3.js" type="text/javascript"></script>

<script type="text/javascript">

$(function() {
	$('#checkbox').change(function() {
	
	var display = $('#aux').css('display');  
	
	if (display == 'none')
	$('#aux').css('display', 'block'); 
	else
	$('#aux').css('display', 'none'); 
	})
});

</script>
</head>

<body>

<h1>j-Query Rules</h1>

<form   method="post">

First Name :<input type="text" name="first_name" id="first_name" /><br>

<input type="checkbox" name="checkbox" id="checkbox"> <span > &nbsp; Click CheckBox1 If Last Name Is Difference </span><br>

<div style="display:none;" id="aux">
Last_Name :<input type ="text" name="last_name" id="last_name" /><br>
</div>



<input type="button" id="button" value="submit">

</form>


</body>
</html>