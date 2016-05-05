<%@page import="ecom.model.SizeGarment"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.Map"%>
<%@page import="ecom.model.ProductBean"%>
<%@page import="ecom.common.FrequentUse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html data-ng-app="ProductDetailsApplication">
<head>
	<title>Product Details</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="First Trades" />
	<!-- start menu -->
	<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />	
	<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	
	<link  href="<%=FrequentUse.style %>" rel='stylesheet' type='text/css' />	
	<script src="<%=FrequentUse.jQuery %>" type="text/javascript"></script>	
	<script src="<%=FrequentUse.angular %>" type="text/javascript"></script>	
	<script src="js_Buyer/ProductDetails.js" type="text/javascript"></script>
	
	<!-- Custom Theme files -->
	<!--//theme-style-->	
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>	
	<script type="text/javascript" src="js/megamenu.js"></script>
	<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
	<script src="js/menu_jquery.js"></script>
	
	<style>
		.details{
			font-size:12px;
			color: #999;
			margin-right:13px;
		}
		hr{
			border-top:1px solid #EEE;
			margin-top: 10px;
		    margin-bottom: 10px;
		}
	
	    
	     .btn_default_sd{
	        float: left;
    margin-right: 10px;
    }
	    .btn_default_sd a{
	    font-family: 'Open Sans', sans-serif;
    cursor: pointer;
    border: none;
    outline: none;
    display: inline-block;
    font-size: 1em;
    padding: 10px 34px;
    background: #ccc;
    color: #fff;
    text-transform: uppercase;
    -webkit-transition: all 0.3s ease-in-out;
    -moz-transition: all 0.3s ease-in-out;
    -o-transition: all 0.3s ease-in-out;
    transition: all 0.3s ease-in-out;
	    }
	    
.multiSelectionWrapper .multiSelectionWidget .multiSelectionWidget-selectors-wrap .multiSelectionWidget-selector.current {
    cursor: pointer;
}
.selector-boxes{
    display: inline-block;
    margin: 2px;
    border: 1px solid #e2e2e2;
    border-radius: 2px;
    min-height: 26px;
    min-width: 26px;
    text-align: center;
    line-height: 26px;
    -webkit-box-shadow: 1px 1px 3px -2px #818080;
    -moz-box-shadow: 1px 1px 3px -2px #818080;
    box-shadow: 1px 1px 3px -2px #818080;
}
.selector-boxes {
    padding: 2px 10px;
}
.multiSelectionWidget-selector{
float: left;
}	    
	</style>
</head>

<%
	User user = (User) session.getAttribute("user");
%>

<body data-ng-controller="ProductDetailsController">

<% if (user == null) { %>

	<!-- Header -->
	<%@ include file="HeaderAllUser.jsp" %>
	<!-- End Header -->

<% } else { %>

	<!-- Header -->
	<%@ include file="Header.jsp" %>
	<!-- End Header -->

<% } %>

<%

	/************************* /CompleteProductDetails ********************************/

	ProductBean productBean       = (ProductBean)        request.getAttribute("productBean"  ); 
	@SuppressWarnings("all")
	Map<String,String> featureMap = (Map<String,String>) request.getAttribute("featureMap"   );
	String sellerCompany          = (String)             request.getAttribute("sellerCompany");
	int stock                     = (Integer)            request.getAttribute("stock"        );	
	
	// API
	BigDecimal rate               = (BigDecimal)         request.getAttribute("rate"         );
	String delivery               = (String)             request.getAttribute("delivery"     );	
	
	

%>

	<div class="container">
		<div class="women_main">
			<!-- start content -->
			<div class="row single" style="margin-left:0px; width:100%;">
				<div class="col-md-12 det" style="border:1px solid #ccc; box-shadow:1px 1px 1px #ccc;  margin-bottom: 30px;">
					<div class="single_left" style="margin-bottom:47px;">
						<div class="grid images_3_of_2">
							<div class="flexslider">
						        <!-- FlexSlider -->
								<script src="js/imagezoom.js"></script>
								<script defer src="js/jquery.flexslider.js"></script>
								<script>
									// Can also be used with $(document).ready()
									$(window).load(function() {
									  $('.flexslider').flexslider({
										animation: "slide",
										controlNav: "thumbnails"
									  });
									});
								</script>
								<!-- //FlexSlider-->
	
							  	<ul class="slides">
									<li data-thumb="IconImageFromProduct?productId=<%=productBean.getProductId() %>">
										<div class="thumb-image"> <img src="IconImageFromProduct?productId=<%=productBean.getProductId() %>" data-imagezoom="true" class="img-responsive"> </div>
									</li>
									<li data-thumb="Image1FromProduct?productId=<%=productBean.getProductId() %>">
										 <div class="thumb-image"><img src="Image1FromProduct?productId=<%=productBean.getProductId() %>" data-imagezoom="true" class="img-responsive"> </div>
									</li>
									<li data-thumb="Image2FromProduct?productId=<%=productBean.getProductId() %>">
									   <div class="thumb-image">  <img src="Image2FromProduct?productId=<%=productBean.getProductId() %>" data-imagezoom="true" class="img-responsive"> </div>
									</li>									
								</ul>
								<div class="clearfix"></div>
							</div>
						</div>
					  	<div class="desc1 span_3_of_2">
							<h3><%=productBean.getProductName() %></h3>
							<span class="brand">Brand: <a href="#"> <%=productBean.getCompanyName() %> </a></span> <br>
						 	<small class="details"> Seller : <%=productBean.getSellerCompany() %> </small> <br>
						 	<span>Product ID: <%=productBean.getProductId() %></span>
						 	<hr>
						 	<small class="details"> - 1 Year Warranty </small> 	                      	
	                     	<hr>
							<div class="price">								
	                            <span class="price-old">Rs <%=productBean.getPrice().getListPrice() %></span> <br>
								<span class="price-tax">Discount: <%=productBean.getPrice().getDiscount() %>%</span><br>
	                            <span class="text">Price:</span>
								<span class="price-new">Rs <%=productBean.getPrice().getSalePriceCustomer() %></span> <br>
								<% if (stock == 0) { %>	         
									<span style="color:red;float:right;text-transform: uppercase;font-size: 23px;">Out Of Stock</span>
								<% } %>                   
								<span class="points">
									<% if (rate.doubleValue() == 0) { %>
										<small style="font-size: 140%">Free Shipping &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Delivery: <%=delivery %></small>
									<% } else { %>
										<small style="font-size: 140%">+ Shipping Rs. <%=rate %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Delivery: <%=delivery %></small>
									<% } %>
								</span><br>
								<br>
		
		
	<!----------------------------------- Size Selection -------------------------------------->							
								
	<%@ include file="SizeGarment.jsp" %>
								
	<!----------------------------------- End Size Selection -------------------------------------->			
	      
	<!-- -------------------------------- Kids Garment Size Selection -------------------------- -->      
	      
	<%@ include file="SizeInYears.jsp" %>      
	      
	<!-- -------------------------------- End Kids Garment Size Selection -------------------------- -->
								
							</div>
							 <div class="clearfix"></div>	                        
	                        <hr>
	                        
	                        
	                        <!-- ------------------------------ Location ------------------------------ -->
	                        
							<div class="price">
								<span class="price-tax" style="display:block;">Check Your Delivery and payment at your location </span><br>
	                        	<input type="text" name="pincode" id="pincode" class="input_text" placeholder="Enter pin Code" style="float:left;">	                        
	                        	<div class="btn_form">
									<a id="location" style="padding:6px 20px;">CHECK</a>									
								</div>
								<!-- Error Handle -->
								<span id="error" style="display: none;float: right;font-family: serif;
    								color: blue;margin-top: 5px;margin-right: 56px;">Error! Try again.</span>
								<span id="msgLocation" style="display: none;float: right;font-family: serif;
    								color: blue;margin-top: 5px;margin-right: 12px;">Enter a valid Postal Code</span>
    							<span id="noNet" style="display: none;float: right;font-family: serif;
    								color: blue;margin-top: 5px;margin-right: 27px;">Check your Internet connection!</span>
								<img id="loader" alt="loader" src="images/loader1.gif" style="width: 40px; height: 40px;display: none;" />
								<img id="right" alt="" src="images/right.jpg" width="30" height="30" style="display: none;margin-left: 123px;" />
								<img id="cross" alt="" src="images/cross.jpg" width="30" height="30" style="display: none;margin-left: 120px;" />
								<!-- End Error Handle -->
							</div>
	                        <div class="clearfix"></div>
						 	<hr>
						 	
						 	
						 	<!-- ------------------------------ End Location ------------------------------ -->
						 	
						 	
						 	
						 	<% if (user != null)  { %>
							<div class="btn_form" id="buyNow">
								<a href="OrderReview_ProductDetails?productId=<%=productBean.getProductId() %>&cartOrWishlist=cart&size={{size}}" class="checkBeforeSubmit">BUY NOW</a>
							</div>	
		                    <div class="btn_form" id="addToCart">
								<a href="AddToCartOrWishlist?productId=<%=productBean.getProductId() %>&cartOrWishlist=cart&size={{size}}" style="background-color:#ffffff;color: #0D90D0;border: 1px solid #0D90D0;" class="checkBeforeSubmit">ADD TO CART</a>
							</div>                    
	                     	<div class="btn_form" >
								<a href="AddToCartOrWishlist?productId=<%=productBean.getProductId() %>&cartOrWishlist=wishlist&size={{size}}" style="background-color:#3c763d;" class="checkBeforeSubmit">ADD TO WISHLIST</a>
							</div>		
							<% } else { %>	
								<div style="font-size: 140%;font-weight: bold;">Please Login Or Register As User</div>
							<% } %>			
				   	 	</div>
	          	    	<div class="clearfix"></div>
	          	    	
	          	    	
	          	    	
	      			</div>
	      			
	      			
	      			
	      			<!-- -----------------------------  Features Section  ------------------------ -->
	      			
	      			
	      			
	          	    <div class="single-bottom1">
						<h6> Product Details</h6>
						<table>
						<% if (featureMap != null) {
			
								for (Map.Entry<String,String> entry : featureMap.entrySet()) {
						
									System.out.println(entry.getKey());
									System.out.println(entry.getValue());
						%>									
									<tr>
										<td><%=entry.getKey() %></td>
										<td>&nbsp; : &nbsp;</td>
										<td><%=entry.getValue() %></td>										
									</tr>
																	
						<%
								}	// for close
							}  else {
						%>
									<tr>
										<td>No Product features updated.</td>
									</tr>
									<!-- <p class="prod-desc"></p> -->
						<%  } %>
						</table>
	                    
					</div>	                
	                <div class="single-bottom1">
						<h6> Key features</h6>
						<ul>
							<li><%=productBean.getKeyFeatures().getKf1() %></li>
							<li><%=productBean.getKeyFeatures().getKf2() %></li>
							<li><%=productBean.getKeyFeatures().getKf3() %></li>
							<li><%=productBean.getKeyFeatures().getKf4() %></li>
						</ul>						
						<!-- <p class="prod-desc"> Reading Level : 7      </p> -->	                    
					</div>				
		    	</div>		
				<div class="clearfix"></div>		
			</div>
			<!-- end content -->
		</div>
	</div>
	
	
	<!-- -----------------------------  Features Section  ------------------------ -->

	<!-- jQuery data -->
	<div style="display:none;" id="stock"><%=stock %></div>

<!-- -------------------------------------Footer------------------------------------------------------ -->
<%@ include file="Footer.jsp" %>
<!-- -------------------------------------End Footer-------------------------------------------------- -->
</body>
</html>