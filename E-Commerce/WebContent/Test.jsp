<%@page import="ecom.common.FrequentUse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<script src="<%=FrequentUse.jQuery%>"></script>


<script type="text/javascript">
  var userip;
</script>
<script type="text/javascript" src="https://l2.io/ip.js?var=userip"></script>
<script type="text/javascript">
  document.write("Your IP is :", userip);
</script>
<script src="http://freegeoip.net/json/?callback=cb" type="text/javascript"></script>
<script type="text/javascript">
		
function cb(a){
	alert(a.ip)
}
</script>






</head>
<body>

	
</body>
</html>