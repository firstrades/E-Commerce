<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TestPage</title>
</head>
<body>

<h1>TestPageSS</h1>

<center>

<form action="<%=request.getContextPath() %>/User" method="post">


<div>
<label>First Name</label>
<input type="text" name="first_name" />
</div>

<div>
<input type="checkbox" name="checkbox" id="checkbox" value="1"> &nbsp<span style="color: red;">If The Last Name Is Different</span>
</div>

<div>

<label>Last Name
</label>
<input type="text" name="last_name" />

</div>

<div>
<input type="submit" value="Submit">

</div>

</form>

</center>

</body>
</html>