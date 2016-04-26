<%@page import="ecom.common.FrequentUse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ecom.model.product.features.*, ecom.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Leggings Edit Page</title>
<script type="text/javascript" src="<%=FrequentUse.jQuery %>"></script>
<script type="text/javascript" src="js_Seller/CommonForEditPages.js"></script>

<script type="text/javascript" src="js_Seller/EditProductFeatures.js"></script>
<!-- <script type="text/javascript" src="js_Seller/test1.js"></script> -->

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
	_TopFeatures topFeatures = (_TopFeatures) request.getAttribute("topFeatures");
	//Size size                = (Size)         request.getAttribute("size"       );
%>

<%@ include file="../BasicFeatures.jsp" %>

<section id="2">	
	
	<div id="invisible" style="display:none;">
		<div id="advanceFeatures" style="width:100%;">
		
			<form method="post" enctype="multipart/form-data" id="form5"> 
			
				<input type="hidden" name="productId" value="<%=productId%>" />
				<input type="hidden" name="sellerId" value="<%=sellerId%>" />
				<h3>Advance Features</h3>
					<div class="row">					
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label> Sleeve </label>
						</div>
						<% if (topFeatures == null) { %>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="sleeve" class="form-control" required placeholder="Sleeveless" />
						</div>
						<% } else { %>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="sleeve" class="form-control" required value="<%=topFeatures.getSleeve() %>" />
						</div>
						<% } %>

						<div class="col-md-3 col-sm-6 col-xs-12">
						<label> Fabric </label>
						</div>
						<% if (topFeatures == null) { %>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="fabric" class="form-control" required placeholder="Poly Crape" />
						</div>
						<% } else { %>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="fabric" class="form-control" required value="<%=topFeatures.getFabric() %>" />
						</div>
						<% } %>							
					</div>
					
					
					<div class="row">	
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label> Neck </label>
						</div>
						<% if (topFeatures == null) { %>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" class="form-control" name="neck" required placeholder="Round Neck"/> </div>
						<% } else { %>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" class="form-control" name="neck" required value="<%=topFeatures.getNeck() %>" />
						</div>
						<% } %>								
						
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label> Pattern </label>
						</div>
						<% if (topFeatures == null) { %>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="pattern" class="form-control" required placeholder="Printed"/> </div>
						<% } else { %>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="pattern" class="form-control" required value="<%=topFeatures.getPattern() %>" /> </div>
						<% } %>	
					</div>							
						
						
					<div class="row">
						<div class="col-md-3 col-sm-6 col-xs-12">	
							<label> Occasion </label>
						</div>
						<% if (topFeatures == null) { %>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="occasion" class="form-control" required placeholder="Casual" /> </div>
						<% } else { %>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="occasion" class="form-control" required value="<%=topFeatures.getOccasion() %>" />
						</div>
						<% } %>								
						
						<div class="col-md-3 col-sm-6 col-xs-12"> 
							<label>	Demo </label>
						</div>		
						<div class="col-md-3 col-sm-6 col-xs-12"> 
							<input type="text" class="form-control" name="salePrice" readonly="readonly" required value="" />
						</div>						
					
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


<!-- ----  Size  ------- -->
<%@ include file="../Size.jsp" %>
<!-- ----  End Size  ------- -->

<%-- <!-- ----------------------     Size          ---------------------------------------------------------------------- -->


<section id="3">	
	
	<div id="invisible2" style="display:none;">
	
		<div id="sizeFeatures" style="width:100%;">
		
			<form method="post" enctype="multipart/form-data" id="form4"> 
			
				<input type="hidden" name="productId" value="<%=productId%>" />
				<input type="hidden" name="sellerId" value="<%=sellerId%>" /> 
				<h3>Size Features</h3>
					
					<div class="row" style="margin-top: 15px;">						
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Size 26</label>
							<% if (size == null) { %>
							<input type="text" class="form-control" name="size26" required placeholder="1" style="width: 40%;"/>
							<% } else { %>
							<input type="text" class="form-control" name="size26" required value="<%=size.getQtyOfSize26() %>" style="width: 40%;"/>
							<% } %>
						</div>
						
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Size 28</label>
							<% if (size == null) { %>
							<input type="text" class="form-control" name="size28" required placeholder="1" style="width: 40%;"/>
							<% } else { %>
							<input type="text" class="form-control" name="size28" required value="<%=size.getQtyOfSize28() %>" style="width: 40%;"/>
							<% } %>
						</div>
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Size 30</label>
							<% if (size == null) { %>
							<input type="text" class="form-control" name="size30" required placeholder="1" style="width: 40%;"/>
							<% } else { %>
							<input type="text" class="form-control" name="size30" required value="<%=size.getQtyOfSize30() %>" style="width: 40%;"/>
							<% } %>
						</div>
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Size 32</label>
							<% if (size == null) { %>
							<input type="text" class="form-control" name="size32" required placeholder="1" style="width: 40%;"/>
							<% } else { %>
							<input type="text" class="form-control" name="size32" required value="<%=size.getQtyOfSize32() %>" style="width: 40%;"/>
							<% } %>
						</div>
				
					</div>	
					
					
					
					
					<div class="row" style="margin-top: 15px;">
					
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Size 34</label>
							<% if (size == null) { %>
							<input type="text" class="form-control" name="size34" required placeholder="1" style="width: 40%;"/>
							<% } else { %>
							<input type="text" class="form-control" name="size34" required value="<%=size.getQtyOfSize34() %>" style="width: 40%;"/>
							<% } %>
						</div>
						
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Size 36</label>
							<% if (size == null) { %>
							<input type="text" class="form-control" name="size36" required placeholder="1" style="width: 40%;"/>
							<% } else { %>
							<input type="text" class="form-control" name="size36" required value="<%=size.getQtyOfSize36() %>" style="width: 40%;"/>
							<% } %>
						</div>
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Size 38</label>
							<% if (size == null) { %>
							<input type="text" class="form-control" name="size38" required placeholder="1" style="width: 40%;"/>
							<% } else { %>
							<input type="text" class="form-control" name="size38" required value="<%=size.getQtyOfSize38() %>" style="width: 40%;"/>
							<% } %>
						</div>
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Size 40</label>
							<% if (size == null) { %>
							<input type="text" class="form-control" name="size40" required placeholder="1" style="width: 40%;"/>
							<% } else { %>
							<input type="text" class="form-control" name="size40" required value="<%=size.getQtyOfSize40() %>" style="width: 40%;"/>
							<% } %>
						</div>
				
					</div>	
					
					
					
					<div class="row" style="margin-top: 15px;">
					
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Size 42</label>
							<% if (size == null) { %>
							<input type="text" class="form-control" name="size42" required placeholder="1" style="width: 40%;"/>
							<% } else { %>
							<input type="text" class="form-control" name="size42" required value="<%=size.getQtyOfSize42() %>" style="width: 40%;"/>
							<% } %>
						</div>
						
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Size 44</label>
							<% if (size == null) { %>
							<input type="text" class="form-control" name="size44" required placeholder="1" style="width: 40%;"/>
							<% } else { %>
							<input type="text" class="form-control" name="size44" required value="<%=size.getQtyOfSize44() %>" style="width: 40%;"/>
							<% } %>
						</div>
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Size 46</label>
							<% if (size == null) { %>
							<input type="text" class="form-control" name="size46" required placeholder="1" style="width: 40%;"/>
							<% } else { %>
							<input type="text" class="form-control" name="size46" required value="<%=size.getQtyOfSize46() %>" style="width: 40%;"/>
							<% } %>
						</div>
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Size 48</label>
							<% if (size == null) { %>
							<input type="text" class="form-control" name="size48" required placeholder="1" style="width: 40%;"/>
							<% } else { %>
							<input type="text" class="form-control" name="size48" required value="<%=size.getQtyOfSize48() %>" style="width: 40%;"/>
							<% } %>
						</div>
				
					</div>	
					


					
					<div class="row" style="margin-top: 15px;">
					
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Size 11</label>
							<input type="text" class="form-control" name="" required readonly="readonly" value="1" style="width: 40%;"/>
						</div>
						
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Size 11</label>
							<input type="text" class="form-control" name="" required readonly="readonly" value="1" style="width: 40%;"/>
						</div>
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Size 11</label>
							<input type="text" class="form-control" name="" required readonly="readonly" value="1" style="width: 40%;"/>
						</div>
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Size 11</label>
							<input type="text" class="form-control" name="" required readonly="readonly" value="1" style="width: 40%;"/>
						</div>
				
					</div>									
					
					<div class="row">
					
						<div class="col-md-8 col-sm-6 col-xs-12">
							<input type="submit" value="Submit" style=" padding: 7px 14px;background:linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5);border: 1px solid #0098fe;color:#ffffff; float: right; margin-right: 63px; margin-top: 17px;" />
						</div>
					</div>
					
			</form>	
        
		</div>
	</div>	

</section>



<!-- ----------------------   End  Size          ---------------------------------------------------------------------- --> --%>

</body>
</html>