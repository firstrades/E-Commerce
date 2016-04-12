<%@page import="ecom.common.FrequentUse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<script src="<%=FrequentUse.jQuery%>"></script>
<script>


function iframe1 () {
$("#if2").hide();
$("#if1").show();
$("#if3").hide();
}

function iframe2 () {
$("#if2").show();
$("#if1").hide();
$("#if3").hide();
}


function iframe3 () {
$("#if2").hide();
$("#if1").hide();
$("#if3").show();
}

function iframe4 () {debugger;


}
</script>
</head>
<body>
<input type="button" value="soffront" onclick="iframe1()">
<input type="button" value="w3school" onclick="iframe2()">
<input type="button" value="tutorialspoint" onclick="iframe3()">
<input type="button" value="submit-3" onclick="iframe4()">

<iframe id="if1" src="http://www.soffront.com" name="if1"></iframe>
<iframe id="if2" src="http://www.w3schools.com/" style="display:none;" name="if2"></iframe>
<iframe id="if3" src="http://www.tutorialspoint.com/" style="display:none;" name="if3"></iframe>

</body>
</html>