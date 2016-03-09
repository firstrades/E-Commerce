<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>j-Query Form Submit</title>

<script src="js/jquery-1.11.3.js" type="text/javascript"></script>
<script type="text/javascript" src="test_js/jQueryAjax.js"></script>

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


$(function() {
	$('#checkbox1').change(function() {

	var display = $('#aux1').css('display');  

	if (display == 'none')
	$('#aux1').css('display', 'block'); 
	else
	$('#aux1').css('display', 'none'); 
	})
	});

</script>

</head>

<body>

<h1>j-Query Rules</h1>

<form   method="post">

First Name :<input type="text" name="first_name" id="first_name" /><br>

<input type="checkbox" name="checkbox" id="checkbox" value="1"> <span > &nbsp; Click CheckBox1 If Last Name Is Difference </span><br>

<div style="display:none;" id="aux">
Last_Name :<input type ="text" name="last_name" id="last_name" /><br>
</div>

<input type="checkbox" name="checkbox2" id="checkbox1" value="3"> <span > &nbsp; Click CheckBox2 If Email Id Is Difference </span><br>

<div style="display:none;" id="aux1">
Email :<input type="text" name="email" id="email" /><br>
</div>
<span id="insertdata"></span>
<input type="button" onclick="insertdata();" value="submit">

</form>


</body>
</html>