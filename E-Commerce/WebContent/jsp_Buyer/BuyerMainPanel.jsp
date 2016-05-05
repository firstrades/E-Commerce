<%@page import="java.util.Map"%>
<%@page import="ecom.model.User"%>
<%@page import="ecom.beans.CartAttributesBean"%>
<%@page import="ecom.model.ProductBean"%>
<%@page import="java.util.List"%>
<%@page import="ecom.common.FrequentUse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
	<title> Customer Page </title>
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />	
	<script type="text/javascript" src="<%=FrequentUse.jQuery %>"></script>
	<!-- Custom Theme files -->
	<link href="<%=FrequentUse.style %>" rel='stylesheet' type='text/css' />
	
	<!-- Custom Theme files -->
	<!--//theme-style-->
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="First Trades Online Shoppin" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- start menu -->
	<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
	<script type="text/javascript" src="js/megamenu.js"></script>
	<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
	<script src="js/menu_jquery.js"></script>
	<script src="js/simpleCart.min.js"> </script>



</head>
<body>

<%
	User user = (User) session.getAttribute("user");
	@SuppressWarnings("all")
	Map<String,ProductBean> map = (Map<String,ProductBean>) request.getAttribute("map");
	
	ProductBean productBean = null;
%>


<!-- Header -->
<%@ include file="Header.jsp" %>
<!-- End Header -->


<!-- Navigation -->
<%@ include file="Navigation.jsp" %>
<!-- End Navigation -->





<!-- ------------------------------------Banner----------------------------------------------------- -->

<div class="arriv">
	<div class="advertisment">
      
<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<!-- www.charge-it-up.com -->
<ins class="adsbygoogle"
     style="display:inline-block;width:300px;height:400px"
     data-ad-client="ca-pub-3038271016444605"
     data-ad-slot="9291379173"></ins>
<script>
(adsbygoogle = window.adsbygoogle || []).push({});
</script>
    
    </div>
    
	<div class="slider-area">
       	<!-- Slider -->
		<div class="block-slider block-slider4">
			<ul class="" id="bxslider-home4">
               <li>
               <img src="images/banner.jpg">
               </li>
               <li>  <img src="images/banner2.jpg">  </li>
               <li> <img src="images/banner3.jpg"> </li>
				
			</ul>
		</div>
		<!-- ./Slider -->
    </div> <!-- End slider area -->
    
    <div class="advertisment2">
    
    <div class="surakasha">
 <a href="http://www.surakshaecommerce.com/" target="_blank">   <img src="images/add_link.png" style="width: 100%;">  Suraksha travel portal   </a>
    
    </div>
      
<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<!-- www.charge-it-up.com -->
<ins class="adsbygoogle"
     style="display:inline-block;width:200px;height:400px"
     data-ad-client="ca-pub-3038271016444605"
     data-ad-slot="9291379173"></ins>
<script>
(adsbygoogle = window.adsbygoogle || []).push({});
</script>
    
    </div>

    <div class="clearfix"></div>
        <div class="container">
			<div class="arriv-las">
				<div class="col-md-4 arriv-left2">
					<img src="images/5.jpg" class="img-responsive" alt="">
					<div class="arriv-info2">
						<h3><a href="#">Casual Glasses<i class="ars"></i></a></h3>
					</div>
				</div>
				<div class="col-md-4 arriv-middle">
					<img src="images/6.jpg" class="img-responsive" alt="">
					<div class="arriv-info3">
						<h3>FRESH LOOK T-SHIRT</h3>
						<div class="crt-btn">
							<a href="#">SHOP NOW</a>
						</div>
					</div>
				</div>
				<div class="col-md-4 arriv-right2">
					<img src="images/7.jpg" class="img-responsive" alt="">
					<div class="arriv-info2">
						<h3><a href="#">Elegant Watches<i class="ars"></i></a></h3>
					</div>
				</div>
            </div>
			<div class="clearfix"> </div>
		</div>
</div>

<!-- ------------------------------------End Banner--------------------------------------------- -->

<!-- ----------------------------------------------------BODY-------------------------------------------------------- -->



<div class="special">
	<div class="container">
		<h3>Electronic Products</h3>
			<div class="specia-top">
				<ul class="grid_2">
					<% 
						productBean = map.get("Mobile");
					%>
					<li>
						<a href="CompleteProductDetails?subCategory=<%=productBean.getSubCategory() %>&productId=<%=productBean.getProductId() %>">
							<img src="IconImageFromProduct?productId=<%=productBean.getProductId() %>" class="img-responsive" alt="">
						</a>
						<div class="special-info grid_1 simpleCart_shelfItem">
							<h5> 
								<a href="CompleteProductDetails?subCategory=<%=productBean.getSubCategory() %>&productId=<%=productBean.getProductId() %>"> <%=productBean.getProductName() %>  (<%=productBean.getCompanyName() %>)  </a> 
							</h5>
						
	                    	<div class="div_key_feature">
	                      		<ul>
				                    <li> <%=productBean.getKeyFeatures().getKf1() %> </li>
		                    		<li> <%=productBean.getKeyFeatures().getKf2() %> </li>
		                    		<li> <%=productBean.getKeyFeatures().getKf3() %> </li>
		                    		<li> <%=productBean.getKeyFeatures().getKf4() %> </li>
	                    		</ul>
	                    	</div>
	                    	<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.<%=productBean.getPrice().getListPrice() %> </small> &nbsp; <small class="item_price"> (<%=productBean.getPrice().getDiscount() %>% Off) </small> <br> <strong class="main_value">Rs <%=productBean.getPrice().getSalePriceCustomer() %></strong> </span></h6></div>
							<div class="item_add">
								<span class="item_price">
									<a href="CompleteProductDetails?subCategory=<%=productBean.getSubCategory() %>&productId=<%=productBean.getProductId() %>">More Details</a>
								</span>
							</div>
						</div>
					</li>
					<% 
						productBean = map.get("Laptop");
					%>
					<li>
						<a href="CompleteProductDetails?subCategory=<%=productBean.getSubCategory() %>&productId=<%=productBean.getProductId() %>">
							<img src="IconImageFromProduct?productId=<%=productBean.getProductId() %>" class="img-responsive" alt="">
						</a>
						<div class="special-info grid_1 simpleCart_shelfItem">
							<h5> 
								<a href="CompleteProductDetails?subCategory=<%=productBean.getSubCategory() %>&productId=<%=productBean.getProductId() %>"> <%=productBean.getProductName() %>  (<%=productBean.getCompanyName() %>)  </a> 
							</h5>
						
	                    	<div class="div_key_feature">
	                      		<ul>
				                    <li> <%=productBean.getKeyFeatures().getKf1() %> </li>
		                    		<li> <%=productBean.getKeyFeatures().getKf2() %> </li>
		                    		<li> <%=productBean.getKeyFeatures().getKf3() %> </li>
		                    		<li> <%=productBean.getKeyFeatures().getKf4() %> </li>
	                    		</ul>
	                    	</div>
	                    	<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.<%=productBean.getPrice().getListPrice() %> </small> &nbsp; <small class="item_price"> (<%=productBean.getPrice().getDiscount() %>% Off) </small> <br> <strong class="main_value">Rs <%=productBean.getPrice().getSalePriceCustomer() %></strong> </span></h6></div>
							<div class="item_add">
								<span class="item_price">
									<a href="CompleteProductDetails?subCategory=<%=productBean.getSubCategory() %>&productId=<%=productBean.getProductId() %>">More Details</a>
								</span>
							</div>
						</div>
					</li>
					<li>
						<a href="#"><img src="images/electronic3.jpg" class="img-responsive" alt=""></a>
						<div class="special-info grid_1 simpleCart_shelfItem">
							<h5><a href="#"> LAPTOP(LENOVO) </a></h5>
                     		<div class="div_key_feature">
                      			<ul>
				                    <li> Key feature </li>
				                    <li> Key feature1 </li>
				                    <li> Key feature2 </li>
				                    <li> Key feature3 </li>
                    			</ul>
                    		</div>
							<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.28000 </small> &nbsp; <strong>Rs 25800</strong> <small> (8% Off) </small></span></h6></div>
							<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
						</div>
					</li>
					<li>
						<a href="#"><img src="images/electronic4.jpg" class="img-responsive" alt=""></a>
						<div class="special-info grid_1 simpleCart_shelfItem">
							<h5><a href="#"> LAPTOP(LENOVO) </a> </h5>
                     		<div class="div_key_feature">
                      			<ul>
				                    <li> Key feature </li>
				                    <li> Key feature1 </li>
				                    <li> Key feature2 </li>
				                    <li> Key feature3 </li>
                    			</ul>
                    		</div>
							<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.24000 </small> &nbsp; <strong>Rs 22200</strong> <small> (8% Off) </small></span></h6></div>
							<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
						</div>
					</li>
        
        			<li>
						<a href="#"><img src="images/electronic5.jpg" class="img-responsive" alt=""></a>
						<div class="special-info grid_1 simpleCart_shelfItem">
							<h5> <a href="#"> Mixer Grinder(Bajaj) </a> </h5>
                     		<div class="div_key_feature">
                      			<ul>
				                    <li> Juice Extractor  </li>
				                    <li> Key feature1 </li>
				                    <li> Key feature2 </li>
				                    <li> Key feature3 </li>
                    			</ul>
                    		</div>
							<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.3100.00 </small> &nbsp; <strong>Rs 1725.00</strong> <small> (45% Off) </small></span></h6></div>
							<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
						</div>
					</li>		
				</ul>
				<div class="clearfix"> </div>
			</div>
		
			<h3>Women Section </h3>	
				<div class="specia-top">
					<ul class="grid_2">
						<% 
							productBean = map.get("Leggings"); 
						%>
						<li>
							<a href="CompleteProductDetails?subCategory=<%=productBean.getSubCategory() %>&productId=<%=productBean.getProductId() %>">
								<img src="IconImageFromProduct?productId=<%=productBean.getProductId() %>" class="img-responsive" alt="">
							</a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> 
									<a href="CompleteProductDetails?subCategory=<%=productBean.getSubCategory() %>&productId=<%=productBean.getProductId() %>"> <%=productBean.getProductName() %>  (<%=productBean.getCompanyName() %>)  </a> 
								</h5>
							
		                    	<div class="div_key_feature">
		                      		<ul>
					                    <li> <%=productBean.getKeyFeatures().getKf1() %> </li>
			                    		<li> <%=productBean.getKeyFeatures().getKf2() %> </li>
			                    		<li> <%=productBean.getKeyFeatures().getKf3() %> </li>
			                    		<li> <%=productBean.getKeyFeatures().getKf4() %> </li>
		                    		</ul>
		                    	</div>
		                    	<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.<%=productBean.getPrice().getListPrice() %> </small> &nbsp; <small class="item_price"> (<%=productBean.getPrice().getDiscount() %>% Off) </small> <br> <strong class="main_value">Rs <%=productBean.getPrice().getSalePriceCustomer() %></strong> </span></h6></div>
								<div class="item_add">
									<span class="item_price">
										<a href="CompleteProductDetails?subCategory=<%=productBean.getSubCategory() %>&productId=<%=productBean.getProductId() %>">More Details</a>
									</span>
								</div>
							</div>
						</li>
						<% 
							productBean = map.get("Top"); 
						%>
						<li>
							<a href="CompleteProductDetails?subCategory=<%=productBean.getSubCategory() %>&productId=<%=productBean.getProductId() %>">
								<img src="IconImageFromProduct?productId=<%=productBean.getProductId() %>" class="img-responsive" alt="">
							</a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> 
									<a href="CompleteProductDetails?subCategory=<%=productBean.getSubCategory() %>&productId=<%=productBean.getProductId() %>"> <%=productBean.getProductName() %>  (<%=productBean.getCompanyName() %>)  </a> 
								</h5>
							
		                    	<div class="div_key_feature">
		                      		<ul>
					                    <li> <%=productBean.getKeyFeatures().getKf1() %> </li>
			                    		<li> <%=productBean.getKeyFeatures().getKf2() %> </li>
			                    		<li> <%=productBean.getKeyFeatures().getKf3() %> </li>
			                    		<li> <%=productBean.getKeyFeatures().getKf4() %> </li>
		                    		</ul>
		                    	</div>
		                    	<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.<%=productBean.getPrice().getListPrice() %> </small> &nbsp; <small class="item_price"> (<%=productBean.getPrice().getDiscount() %>% Off) </small> <br> <strong class="main_value">Rs <%=productBean.getPrice().getSalePriceCustomer() %></strong> </span></h6></div>
								<div class="item_add">
									<span class="item_price">
										<a href="CompleteProductDetails?subCategory=<%=productBean.getSubCategory() %>&productId=<%=productBean.getProductId() %>">More Details</a>
									</span>
								</div>
							</div>
						</li>
						<li>
							<a href="#"><img src="images/camera.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5><a href="#"> Camera </a></h5>
                     				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.16000 </small> &nbsp; <strong>Rs 7000</strong> <small> (40% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>
						<li>
							<a href="#"><img src="images/electronic9.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5><a href="#"> Sandwich Toaster </a></h5>
                     				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.1460 </small> &nbsp; <strong>Rs 876</strong> <small> (40% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>
        				<li>
							<a href="#"><img src="images/electronic10.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#"> Pop-Toaster </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.1850 </small> &nbsp; <strong>Rs 1110</strong> <small> (40% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>
		
					</ul>
					<div class="clearfix"> </div>
				</div>


				<div class="specia-top">
					<ul class="grid_2">
						<% 
							productBean = map.get("MenTshirt"); 
						%>
						<li>
							<a href="CompleteProductDetails?subCategory=<%=productBean.getSubCategory() %>&productId=<%=productBean.getProductId() %>">
								<img src="IconImageFromProduct?productId=<%=productBean.getProductId() %>" class="img-responsive" alt="">
							</a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> 
									<a href="CompleteProductDetails?subCategory=<%=productBean.getSubCategory() %>&productId=<%=productBean.getProductId() %>"> <%=productBean.getProductName() %>  (<%=productBean.getCompanyName() %>)  </a> 
								</h5>
							
		                    	<div class="div_key_feature">
		                      		<ul>
					                    <li> <%=productBean.getKeyFeatures().getKf1() %> </li>
			                    		<li> <%=productBean.getKeyFeatures().getKf2() %> </li>
			                    		<li> <%=productBean.getKeyFeatures().getKf3() %> </li>
			                    		<li> <%=productBean.getKeyFeatures().getKf4() %> </li>
		                    		</ul>
		                    	</div>
		                    	<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.<%=productBean.getPrice().getListPrice() %> </small> &nbsp; <small class="item_price"> (<%=productBean.getPrice().getDiscount() %>% Off) </small> <br> <strong class="main_value">Rs <%=productBean.getPrice().getSalePriceCustomer() %></strong> </span></h6></div>
								<div class="item_add">
									<span class="item_price">
										<a href="CompleteProductDetails?subCategory=<%=productBean.getSubCategory() %>&productId=<%=productBean.getProductId() %>">More Details</a>
									</span>
								</div>
							</div>
						</li>
						
						<% 
							productBean = map.get("Jeans"); 
						%>
						<li>
							<a href="CompleteProductDetails?subCategory=<%=productBean.getSubCategory() %>&productId=<%=productBean.getProductId() %>">
								<img src="IconImageFromProduct?productId=<%=productBean.getProductId() %>" class="img-responsive" alt="">
							</a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> 
									<a href="CompleteProductDetails?subCategory=<%=productBean.getSubCategory() %>&productId=<%=productBean.getProductId() %>"> <%=productBean.getProductName() %>  (<%=productBean.getCompanyName() %>)  </a> 
								</h5>
							
		                    	<div class="div_key_feature">
		                      		<ul>
					                    <li> <%=productBean.getKeyFeatures().getKf1() %> </li>
			                    		<li> <%=productBean.getKeyFeatures().getKf2() %> </li>
			                    		<li> <%=productBean.getKeyFeatures().getKf3() %> </li>
			                    		<li> <%=productBean.getKeyFeatures().getKf4() %> </li>
		                    		</ul>
		                    	</div>
		                    	<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.<%=productBean.getPrice().getListPrice() %> </small> &nbsp; <small class="item_price"> (<%=productBean.getPrice().getDiscount() %>% Off) </small> <br> <strong class="main_value">Rs <%=productBean.getPrice().getSalePriceCustomer() %></strong> </span></h6></div>
								<div class="item_add">
									<span class="item_price">
										<a href="CompleteProductDetails?subCategory=<%=productBean.getSubCategory() %>&productId=<%=productBean.getProductId() %>">More Details</a>
									</span>
								</div>
							</div>
						</li>
						<li>
							<a href="#"><img src="images/electronic13.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#"> Induction Cooktops(Jaipan) </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
						                    <li> 2000 Watt </li>
						                    <li> Push Button </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.3995.00 </small> &nbsp; <strong>Rs 1600.00</strong> <small> (60% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>
						<li>
							<a href="#"><img src="images/electronic14.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#"> Rice Cooker(Jaipan) </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.3995.00 </small> &nbsp; <strong>Rs 1300.00</strong> <small> (68% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>
				        
				        <li>
							<a href="#"><img src="images/electronic15.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#"> Voluptate velit </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.2800 </small> &nbsp; <strong>Rs 1680</strong> <small> (40% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>		
					</ul>
					<div class="clearfix"> </div>
				</div>		
		
				<div class="specia-top">
					<ul class="grid_2">
						<% 
							productBean = map.get("Boys_Shirt"); 
						%>
						<li>
							<a href="CompleteProductDetails?subCategory=<%=productBean.getSubCategory() %>&productId=<%=productBean.getProductId() %>">
								<img src="IconImageFromProduct?productId=<%=productBean.getProductId() %>" class="img-responsive" alt="">
							</a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> 
									<a href="CompleteProductDetails?subCategory=<%=productBean.getSubCategory() %>&productId=<%=productBean.getProductId() %>"> <%=productBean.getProductName() %>  (<%=productBean.getCompanyName() %>)  </a> 
								</h5>
							
		                    	<div class="div_key_feature">
		                      		<ul>
					                    <li> <%=productBean.getKeyFeatures().getKf1() %> </li>
			                    		<li> <%=productBean.getKeyFeatures().getKf2() %> </li>
			                    		<li> <%=productBean.getKeyFeatures().getKf3() %> </li>
			                    		<li> <%=productBean.getKeyFeatures().getKf4() %> </li>
		                    		</ul>
		                    	</div>
		                    	<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.<%=productBean.getPrice().getListPrice() %> </small> &nbsp; <small class="item_price"> (<%=productBean.getPrice().getDiscount() %>% Off) </small> <br> <strong class="main_value">Rs <%=productBean.getPrice().getSalePriceCustomer() %></strong> </span></h6></div>
								<div class="item_add">
									<span class="item_price">
										<a href="CompleteProductDetails?subCategory=<%=productBean.getSubCategory() %>&productId=<%=productBean.getProductId() %>">More Details</a>
									</span>
								</div>
							</div>
						</li>
						<li>
							<a href="#"><img src="images/men2.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#"> Men Trousers </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.1290 </small> &nbsp; <strong>Rs 774</strong> <small> (40% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>
						<li>
							<a href="#"><img src="images/men3.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#"> Men Trousers </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
                    						<li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.1290 </small> &nbsp; <strong>Rs 774</strong> <small> (40% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>
						<li>
							<a href="#"><img src="images/men4.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5><a href="#"> Men Trousers </a> </h5>
                    				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.1290 </small> &nbsp; <strong>Rs 774</strong> <small> (40% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>				        
				        <li>
							<a href="#"><img src="images/men5.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#"> Men Shirts </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.799 </small> &nbsp; <strong>Rs 479.4</strong> <small> (40% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>		
					</ul>
					<div class="clearfix"> </div>
				</div>	



				<div class="specia-top">
					<ul class="grid_2">
						<li>
							<a href="#"><img src="images/men6.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#"> Men Shirts </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.799 </small> &nbsp; <strong>Rs 479.4</strong> <small> (40% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>
						<li>
							<a href="#"><img src="images/men7.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#"> Men Shirts </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.799 </small> &nbsp; <strong>Rs 479.4</strong> <small> (40% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>
						<li>
							<a href="#"><img src="images/men8.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#"> Men Shirts </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
                    						<li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.799 </small> &nbsp; <strong>Rs 479.4</strong> <small> (40% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>
						<li>
							<a href="#"><img src="images/men9.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5><a href="#"> Men Trousers </a> </h5>
                    				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.1290 </small> &nbsp; <strong>Rs 774</strong> <small> (40% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>				        
				        <li>
							<a href="#"><img src="images/men10.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#">  Men Trousers </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.1290 </small> &nbsp; <strong>Rs 774</strong> <small> (40% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>	
						
						
						
							
					</ul>
					<div class="clearfix"> </div>
				</div>	





					<div class="specia-top">
					<ul class="grid_2">
						<li>
							<a href="#"><img src="images/Women1.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#"> Women Jeans </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.600 </small> &nbsp; <strong>Rs 360</strong> <small> (40% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>
						<li>
							<a href="#"><img src="images/women2.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#">  Women Jeans  </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.600 </small> &nbsp; <strong>Rs 360</strong> <small> (40% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>
						<li>
							<a href="#"><img src="images/Women3.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#">  Women Jeans  </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
                    						<li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.600 </small> &nbsp; <strong>Rs 360</strong> <small> (40% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>
						<li>
							<a href="#"><img src="images/Women4.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5><a href="#">  Women Jeans </a> </h5>
                    				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.600 </small> &nbsp; <strong>Rs 360</strong> <small> (40% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>				        
				        <li>
							<a href="#"><img src="images/Women5.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#">  Women Jeans  </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.600 </small> &nbsp; <strong>Rs 360</strong> <small> (40% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>	
						
						
						
							
					</ul>
					<div class="clearfix"> </div>
				</div>	
				
				
				
				<div class="specia-top">
					<ul class="grid_2">
						<li>
							<a href="#"><img src="images/Women6.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#">  Women Jeans  </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.600 </small> &nbsp; <strong>Rs 1360</strong> <small> (40% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>
						<li>
							<a href="#"><img src="images/Women7.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#"> Women Kurtis </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.600 </small> &nbsp; <strong>Rs 360</strong> <small> (40% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>
						<li>
							<a href="#"><img src="images/Women8.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#"> Women Kurtis </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
                    						<li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.600 </small> &nbsp; <strong>Rs 360</strong> <small> (40% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>
						<li>
							<a href="#"><img src="images/Women9.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5><a href="#"> Women Kurtis </a> </h5>
                    				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.600 </small> &nbsp; <strong>Rs 360</strong> <small> (40% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>				        
				        <li>
							<a href="#"><img src="images/Women10.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#">  Women Kurtis </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.600 </small> &nbsp; <strong>Rs 360</strong> <small> (40% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>	
						
						
						
							
					</ul>
					<div class="clearfix"> </div>
				</div>	





<div class="specia-top">
					<ul class="grid_2">
						<li>
							<a href="#"><img src="images/kitchen1.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#"> Basmati Rice </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.110.00 </small> &nbsp; <strong>Rs 100.00</strong> <small> (10% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>
						<li>
							<a href="#"><img src="images/kitchen2.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#"> Mustard Oil(Emami) </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.120.00 </small> &nbsp; <strong>Rs 110.00</strong> <small> (9% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>
						<li>
							<a href="#"><img src="images/kitchen3.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#"> Sabji Masala(Everest) </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
                    						<li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.40.00 </small> &nbsp; <strong>Rs 35.00</strong> <small> (13% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>
						<li>
							<a href="#"><img src="images/kitchen4.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5><a href="#"> Basmati Rice(Kohinoor) </a> </h5>
                    				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.110.00 </small> &nbsp; <strong>Rs 100.00</strong> <small> (10% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>				        
				        <li>
							<a href="#"><img src="images/kitchen5.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#">  Biryani Masala(Fortune) </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.60.00 </small> &nbsp; <strong>Rs 48.00</strong> <small> (20% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>	
						
						
						
							
					</ul>
					<div class="clearfix"> </div>
				</div>	
				
				
				
				<div class="specia-top">
					<ul class="grid_2">
						<li>
							<a href="#"><img src="images/kitchen6.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#"> Besan(Fortune) </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.125.00 </small> &nbsp; <strong>Rs 105.00</strong> <small> (16% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>
						<li>
							<a href="#"><img src="images/kitchen7.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#"> Mustard Oil(Fortune) </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.130.00 </small> &nbsp; <strong>Rs 110.00</strong> <small> (16% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>
						<li>
							<a href="#"><img src="images/kitchen8.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#"> Refined Oil (Fortune) </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
                    						<li> 5 leter </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.550.00 </small> &nbsp; <strong>Rs 450.00</strong> <small> (19% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>
						<li>
							<a href="#"><img src="images/kitchen9.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5><a href="#"> Besan (Sakti Bhog) </a> </h5>
                    				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.135.00 </small> &nbsp; <strong>Rs 110.00</strong> <small> (19% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>				        
				        <li>
							<a href="#"><img src="images/kitchen10.jpg" class="img-responsive" alt=""></a>
							<div class="special-info grid_1 simpleCart_shelfItem">
								<h5> <a href="#">  ATTA (Sakti Bhog) </a> </h5>
                     				<div class="div_key_feature">
                      					<ul>
						                    <li> Key feature </li>
						                    <li> Key feature1 </li>
						                    <li> Key feature2 </li>
						                    <li> Key feature3 </li>
                    					</ul>
                    				</div>
									<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.140.00 </small> &nbsp; <strong>Rs 112.00</strong> <small> (20% Off) </small></span></h6></div>
									<div class="item_add"><span class="item_price"><a href="#">More Details</a></span></div>
							</div>
						</li>	
						
						
						
							
					</ul>
					<div class="clearfix"> </div>
				</div>




				<h3>Hot Categori</h3>	
					<div class="hot_categori" style="margin-top:10px;">
						<img src="images/hot_deal.jpg">
					</div>
		
			<h3>Shop By Branded</h3>		
	</div>
</div>



<!-- ------------------------------------------End Body----------------------------------------------- -->



<!-- -------------------------------------Footer------------------------------------------------------ -->
<%@ include file="Footer.jsp" %>
<!-- -------------------------------------End Footer-------------------------------------------------- -->


	<script type="text/javascript" src="js/bxslider.min.js"></script>
	<script type="text/javascript" src="js/script.slider.js"></script>
</body>
</html>