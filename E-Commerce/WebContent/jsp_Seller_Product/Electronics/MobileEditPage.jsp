<%@page import="ecom.common.FrequentUse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ecom.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mobile Edit Page</title>
<script type="text/javascript" src="<%=FrequentUse.jQuery %>"></script>
<script type="text/javascript" src="js_Seller/CommonForEditPages.js"></script>
<script type="text/javascript" src="js_Seller/EditProductFeatures.js"></script>
<script type="text/javascript" src="js_Seller/Product_Add.js"></script>
<link type="text/css" href="css/bootstrap.css" rel="stylesheet">

<style type="text/css">

.row{
    margin-left:0px !important;
    margin-right:0px !important;
    margin-bottom: 16px;
}
label{
font-weight: normal !important; 
color:#337AB7;
}
hr {
 
    border-top: 1px solid #eee;
    margin-top:4px;
    margin-bottom: 4px;
}
.key_feature{
padding: 0px;
margin: 0px;
}
.key_feature li{
    font-size: 11px;
    color: #777;
    margin-left: 14px;

}
</style>

</head>
<body>

<%
	MobileFeatures mobileFeatures = (MobileFeatures) request.getAttribute("mobileFeatures");
%>

<%@ include file="../BasicFeatures.jsp" %>

<section id="2">	
	
	<div id="invisible" style="display:none;">
		<div id="advanceFeatures" style="width:100%;">
			<form method="post" enctype="multipart/form-data" id="form2"> 
				<input type="hidden" name="productId" value="<%=productId%>" />
				<input type="hidden" name="sellerId" value="<%=sellerId%>" />
				<h3>Advance Features</h3>
					<div class="row">					
						<div class="col-md-3 col-sm-6 col-xs-12">
						<label> Internal Storage </label>
							</div>
							<% if (mobileFeatures == null) { %>
							<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="internalStorage" class="form-control" required placeholder="16 GB" /></div>
							<% } else { %>
							<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="internalStorage" class="form-control" required value="<%=mobileFeatures.getInternalStorage() %>" />
							</div>
							<% } %>

						<div class="col-md-3 col-sm-6 col-xs-12">
						<label> O.S. </label>
						</div>
							<% if (mobileFeatures == null) { %>
							<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="os" class="form-control" required placeholder="Android 4.4 (KitKat)" />
							</div>
							<% } else { %>
							<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="os" class="form-control" required value="<%=mobileFeatures.getOs() %>" />
							</div>
							<% } %>							
					      </div>
					
					
					<div class="row">	
					<div class="col-md-3 col-sm-6 col-xs-12">
							<label> Touch Screen </label>
							</div>
							<% if (mobileFeatures == null) { %>
							<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" class="form-control" name="touch" required placeholder="Touch Screen"/> </div>
							<% } else { %>
							<div class="col-md-3 col-sm-6 col-xs-12"><input type="text" class="form-control" name="touch" required value="<%=mobileFeatures.getTouch() %>" /></div>
							<% } %>								
						
						<div class="col-md-3 col-sm-6 col-xs-12">
						<label> WiFi </label>
							</div>
							<% if (mobileFeatures == null) { %>
							<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="wifi" class="form-control" required placeholder="Wifi Enabled"/> </div>
							<% } else { %>
							<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="wifi" class="form-control" required value="<%=mobileFeatures.getWifi() %>" /> </div>
							<% } %>	
							</div>							
						
						
						<div class="row">
						<div class="col-md-3 col-sm-6 col-xs-12">	
						<label> F.M. </label>
						</div>
							<% if (mobileFeatures == null) { %>
							<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="fm" class="form-control" required placeholder="FM Radio" /> </div>
							<% } else { %>
							<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="fm" class="form-control" required value="<%=mobileFeatures.getFm() %>" /> </div>
							<% } %>								
						
							<div class="col-md-3 col-sm-6 col-xs-12">	
							<label>  Front Camera </label>
							</div>
							<% if (mobileFeatures == null) { %>
							<div class="col-md-3 col-sm-6 col-xs-12">	
							<input type="text" class="form-control" name="frontCamera" required placeholder="13 MP" /> </div>
							<% } else { %>
							<div class="col-md-3 col-sm-6 col-xs-12">	
							<input type="text" class="form-control" name="frontCamera" required value="<%=mobileFeatures.getFrontCamera() %>" /> </div>
							<% } %>								
					
						</div>
						<div class="row">
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label> Rear Camera </label>
							</div>
							<% if (mobileFeatures == null) { %>
							<div class="col-md-3 col-sm-6 col-xs-12">
						    <input type="text" class="form-control" name="rearCamera" required placeholder="0.3 MP" /> </div>
							<% } else { %>
							 <div class="col-md-3 col-sm-6 col-xs-12"> <input type="text" class="form-control" name="rearCamera" required value="<%=mobileFeatures.getRearCamera() %>" /></div>
							<% } %>								
						
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label> Internet Connectivity </label>
							</div>
							<% if (mobileFeatures == null) { %>
							<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" class="form-control" name="connectivity" required placeholder="3G" />
							</div>
							<% } else { %>
							<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" class="form-control" name="connectivity" required value="<%=mobileFeatures.getConnectivity() %>" /> </div>
							<% } %>	
							
					
						</div>		
						
												<div class="row">
						<div class="col-md-3 col-sm-6 col-xs-12"> 
						<label>	Demo </label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12"> 
							<input type="text" class="form-control" name="salePrice" readonly="readonly" required value="" />
							</div>					
					
					
						<div class="col-md-3 col-sm-6 col-xs-12"> 
						<label>	Demo</label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12"> 
							<input type="text" class="form-control" name="salePrice" readonly="readonly" required value="" />
							</div>
				
						</div>		
						<div class="row">
						<div class="col-md-3 col-sm-6 col-xs-12"> 
						<label>	Demo</label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12"> 
							<input type="text" class="form-control" name="salePrice" readonly="readonly" required value="" />
							</div>					
					
					
						<div class="col-md-3 col-sm-6 col-xs-12"> 
						<label>	Demo </label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12"> 
							<input type="text" class="form-control" name="salePrice" readonly="readonly" required value="" />
							</div>
				
						</div>				
					
						<div class="row">
						<div class="col-md-12 col-sm-6 col-xs-12">
							<input type="submit" value="Submit" style=" padding: 7px 14px;background:linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5);border: 1px solid #0098fe;color:#ffffff; float: right;" />
							</div>
							</div>
					
			</form>
	
        
		</div>
	</div>	

</section>

</body>
</html>