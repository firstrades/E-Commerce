<%@page import="ecom.beans.CartAttributesBean"%>
<%@page import="ecom.common.FrequentUse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %> 
<%@ page import="ecom.model.*" %>  

<!DOCTYPE HTML>
<html>
<head>
	<title> Buyer's Search Page </title>
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
	
	<script type="text/javascript" src="js_Buyer/BuyerProductSearchResult.js"></script>
	
	<style type="text/css">
	.clear_fix{
		clear: both;
	} 
	
	</style>
	

</head>
<body>

<%    //--------------------From Servlet - ecom.SERVLET.buyer.BuyerServlet  /SearchBySubCategory------------------------         %>

<%
	User user = (User) session.getAttribute("user"); 
	
%>

<%
	@SuppressWarnings("all")
	List<ProductBean> productBeanList = (List<ProductBean>) request.getAttribute("productBeanList");
	Integer MAX = (Integer) request.getAttribute("MAX");
	
	int tempCount = productBeanList.size() / 5; 
	int productBeanList_DivCount = 0;
	if (productBeanList.size() % 5 == 0)
		productBeanList_DivCount =  tempCount;
	else
		productBeanList_DivCount =  tempCount + 1;
	
	System.out.println("productBeanList_DivCount: " + productBeanList_DivCount);
	
	//int productBeanList_DivCount = productBeanList.size() / 5;  
	
	int k = 0;
	int id = 0;
	
	//System.out.println(productBeanList_DivCount);
%>

<% if (user == null) { %>

	<!-- Header -->
	<%@ include file="HeaderAllUser.jsp" %>
	<!-- End Header -->

<% } else { %>

	<!-- Header -->
	<%@ include file="Header.jsp" %>
	<!-- End Header -->

<% } %>

<!-- -----------------------------Navigation-------------------------------------------------- -->  
    
    <div class="navigation" style="background-color: #F57D51;height: 39px;">
    	<div class="container">
		<!-- start header menu -->
			<ul class="megamenu skyblue">
				<li class="grid"><a class="color1" href="BuyerMainPanel">HOME</a>
				<% if (productBeanList.get(0).getCategory().equals("ELECTRONICS")) { %>
				<li class="active grid"><a class="color1" href="index.jsp">ELECTRONICS</a>
				<% } else { %> 
				<li class="grid"><a class="color1" href="index.jsp">ELECTRONICS</a>
				<% } %>
					<div class="megapanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4>Commons</h4>
									<ul>										
										<li><a href="SearchBySubCategory?subCategory=Mobile">Mobile</a></li>
										<li><a href="SearchBySubCategory?subCategory=Laptop">Laptop</a></li>
										<li><a href="#">Tablet</a></li>
										<li><a href="#">Camera</a></li>
										<li><a href="#">Kitchen Appliances</a></li>
										<li><a href="#">Television</a></li>	
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>Accessories</h4>
									<ul>
										<li><a href="#">Mobile Accessories</a></li>
										<li><a href="#">Laptop Accessories</a></li>
										<li><a href="#">Tablet Accessories</a></li>
										<li><a href="#">Camera Accessories</a></li>
										<li><a href="#">Home Accessories</a></li>
										<li><a href="#">Television Accessories</a></li>
									</ul>	
								</div>							
							</div>



								<div class="col_images">
								<div class="h_nav">
									<img src="images/electronic.jpg" alt="Electronic">
									</div>
									</div>
													
							


						</div>
						<div class="row">
							<div class="col2"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
						</div>
    				</div>
				</li>
				<li class="grid"><a class="color2" href="#">MEN</a>
					<div class="megapanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4>Clothing</h4>
									<ul>
										<li><a href="#">new arrivals</a></li>
										<li><a href="#">men</a></li>
										<li><a href="#">women</a></li>
										<li><a href="#">accessories</a></li>
										<li><a href="#">kids</a></li>
										<li><a href="#">brands</a></li>	
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>kids</h4>
									<ul>
										<li><a href="#">Pools&#38;Tees</a></li>
										<li><a href="#">shirts</a></li>
										<li><a href="#">shorts</a></li>
										<li><a href="#">twinsets</a></li>
										<li><a href="#">kurts</a></li>
										<li><a href="#">jackets</a></li>
									</ul>	
								</div>							
							</div>

								<div class="col_images">
								<div class="h_nav">
									<img src="images/men.jpg" alt="men">
									</div>
									</div>


						</div>
						<div class="row">
							<div class="col2"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
						</div>
    				</div>
				</li>
				<!-- <li><a class="color4" href="#">WOMEN</a> -->				
				<% if (productBeanList.get(0).getCategory().equals("WOMEN")) { %>
				<li class="active grid"><a class="color1" href="index.jsp">WOMEN</a>
				<% } else { %> 
				<li class="grid"><a class="color1" href="index.jsp">WOMEN</a>
				<% } %>
					<div class="megapanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4>Clothing</h4>
									<ul>
										<li><a href="SearchBySubCategory?subCategory=Leggings">Leggings</a></li>
										<li><a href="SearchBySubCategory?subCategory=Top">Tops</a></li>
										<li><a href="#">women</a></li>
										<li><a href="#">accessories</a></li>
										<li><a href="#">kids</a></li>
										<li><a href="#">brands</a></li>
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>kids</h4>
									<ul>
										<li><a href="#">Pools&#38;Tees</a></li>
										<li><a href="#">shirts</a></li>
										<li><a href="#">shorts</a></li>
										<li><a href="#">twinsets</a></li>
										<li><a href="#">kurts</a></li>
										<li><a href="#">jackets</a></li>
									</ul>	
								</div>							
							</div>


								<div class="col_images">
								<div class="h_nav">
									<img src="images/women.jpg" alt="women">
									</div>
									</div>

						</div>
						<div class="row">
							<div class="col2"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
						</div>
    				</div>
				</li>				
				<li><a class="color5" href="#">HERBAL</a>
					<div class="megapanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4>Clothing</h4>
									<ul>
										<li><a href="#">new arrivals</a></li>
										<li><a href="#">men</a></li>
										<li><a href="#">women</a></li>
										<li><a href="#">accessories</a></li>
										<li><a href="#">kids</a></li>
										<li><a href="#">brands</a></li>
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>kids</h4>
									<ul>
										<li><a href="#">Pools&#38;Tees</a></li>
										<li><a href="#">shirts</a></li>
										<li><a href="#">shorts</a></li>
										<li><a href="#">twinsets</a></li>
										<li><a href="#">kurts</a></li>
										<li><a href="#">jackets</a></li>
									</ul>	
								</div>							
							</div>

							<div class="col_images">
								<div class="h_nav">
									<img src="images/herbal.jpg" alt="herbal">
									</div>
									</div>


						</div>
						<div class="row">
							<div class="col2"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
						</div>
	    			</div>
				</li>
				<li><a class="color6" href="#">BABY&KIDS</a>
					<div class="megapanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4>Clothing</h4>
									<ul>
										<li><a href="#">new arrivals</a></li>
										<li><a href="#">men</a></li>
										<li><a href="#">women</a></li>
										<li><a href="#">accessories</a></li>
										<li><a href="#">kids</a></li>
										<li><a href="#">brands</a></li>
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>kids</h4>
									<ul>
										<li><a href="#">Pools&#38;Tees</a></li>
										<li><a href="#">shirts</a></li>
										<li><a href="#">shorts</a></li>
										<li><a href="#">twinsets</a></li>
										<li><a href="#">kurts</a></li>
										<li><a href="#">jackets</a></li>
									</ul>	
								</div>							
							</div>

								<div class="col_images">
								<div class="h_nav">
									<img src="images/baby.jpg" alt="baby">
									</div>
									</div>
	
		
						</div>
						<div class="row">
							<div class="col2"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
						</div>
	    				</div>
				</li>				
			
				<li><a class="color7" href="#">HOME&KITCHEN</a>
					<div class="megapanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4>Clothing</h4>
									<ul>
										<li><a href="#">new arrivals</a></li>
										<li><a href="#">men</a></li>
										<li><a href="#">women</a></li>
										<li><a href="#">accessories</a></li>
										<li><a href="#">kids</a></li>
										<li><a href="#">brands</a></li>
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>kids</h4>
									<ul>
										<li><a href="#">Pools&#38;Tees</a></li>
										<li><a href="#">shirts</a></li>
										<li><a href="#">shorts</a></li>
										<li><a href="#">twinsets</a></li>
										<li><a href="#">kurts</a></li>
										<li><a href="#">jackets</a></li>
									</ul>	
								</div>							
							</div>
		
					
								<div class="col_images">
								<div class="h_nav">
									<img src="images/home&Kitchen.jpg" alt="home&Kitchen">
									</div>
									</div>
					
						</div>
						<div class="row">
							<div class="col2"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
						</div>
	    				</div>
				</li>				
				<li><a class="color4" href="#">FOOD&GROCERY</a>
				<div class="megapanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4>Clothing</h4>
									<ul>
										<li><a href="#">new arrivals</a></li>
										<li><a href="#">men</a></li>
										<li><a href="#">women</a></li>
										<li><a href="#">accessories</a></li>
										<li><a href="#">kids</a></li>
										<li><a href="#">brands</a></li>
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>kids</h4>
									<ul>
										<li><a href="#">Pools&#38;Tees</a></li>
										<li><a href="#">shirts</a></li>
										<li><a href="#">shorts</a></li>
										<li><a href="#">twinsets</a></li>
										<li><a href="#">kurts</a></li>
										<li><a href="#">jackets</a></li>
									</ul>	
								</div>							
							</div>
					
						
									<div class="col_images">
								<div class="h_nav">
									<img src="images/food.jpg" alt="food">
									</div>
									</div>
					
						</div>
						<div class="row">
							<div class="col2"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
						</div>
	    				</div>
				
				</li>
				<li><a class="color5" href="#">BOND & MUTUAL FUND</a>	
				<div class="megapanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4>Clothing</h4>
									<ul>
										<li><a href="#">new arrivals</a></li>
										<li><a href="#">men</a></li>
										<li><a href="#">women</a></li>
										<li><a href="#">accessories</a></li>
										<li><a href="#">kids</a></li>
										<li><a href="#">brands</a></li>
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>kids</h4>
									<ul>
										<li><a href="#">Pools&#38;Tees</a></li>
										<li><a href="#">shirts</a></li>
										<li><a href="#">shorts</a></li>
										<li><a href="#">twinsets</a></li>
										<li><a href="#">kurts</a></li>
										<li><a href="#">jackets</a></li>
									</ul>	
								</div>							
							</div>

								<div class="col_images">
								<div class="h_nav">
									<img src="images/matual.jpg" alt="matual">
									</div>
									</div>
	
		
						</div>
						<div class="row">
							<div class="col2"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
						</div>
	    				</div>
	    				</li>	
				<li><a class="color3" href="#">OFFER</a>	
				<div class="megapanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4>Clothing</h4>
									<ul>
										<li><a href="#">new arrivals</a></li>
										<li><a href="#">men</a></li>
										<li><a href="#">women</a></li>
										<li><a href="#">accessories</a></li>
										<li><a href="#">kids</a></li>
										<li><a href="#">brands</a></li>
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>kids</h4>
									<ul>
										<li><a href="#">Pools&#38;Tees</a></li>
										<li><a href="#">shirts</a></li>
										<li><a href="#">shorts</a></li>
										<li><a href="#">twinsets</a></li>
										<li><a href="#">kurts</a></li>
										<li><a href="#">jackets</a></li>
									</ul>	
								</div>							
							</div>

								<div class="col_images">
								<div class="h_nav">
									<img src="images/Offer-Banner.jpg" alt="Offer-Banner" style="height: 220px;">
									</div>
									</div>
	
		
						</div>
						<div class="row">
							<div class="col2"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
						</div>
	    				</div>
				</li>	
		 	</ul> 
		</div>    
	</div>
</div>

<!-- ------------------------------------End Navigation--------------------------------------------- -->


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

<% 

	if (request.getAttribute("errorMsg") != null) { System.out.println("Jewel 2");
		String errorMsg = (String) request.getAttribute("errorMsg"); 
		out.println("<div style=\"margin-left: 342px;color:red;\">"+errorMsg+"</div>");
	}
%>

<div class="special">
	<div class="container" id="append">		
		<h3>Search Results </h3>	
		
		<% for (int i = 0; i < productBeanList_DivCount; i++) { %>
			<div class="specia-top" id="<%=id%>">
				<ul class="grid_2">	
							
				<% for (int j = 0; j < 5; j++) { %>
					<li>
						<a href="CompleteProductDetails?subCategory=<%=productBeanList.get(k+j).getSubCategory() %>&productId=<%=productBeanList.get(k+j).getProductId() %>">
							<img src="IconImageFromProduct?productId=<%=productBeanList.get(k+j).getProductId() %>" class="img-responsive" alt="">
						</a>
						<div class="special-info grid_1 simpleCart_shelfItem">
							<div class="all_pannel">
								<h5>
									<a href="CompleteProductDetails?subCategory=<%=productBeanList.get(k+j).getSubCategory() %>&productId=<%=productBeanList.get(k+j).getProductId() %>"> <%=productBeanList.get(k+j).getProductName() %>  (<%=productBeanList.get(k+j).getCompanyName() %>) </a>
								</h5>
                    				<div class="div_key_feature">
                     					<ul>
				                    		<li> <%=productBeanList.get(k+j).getKeyFeatures().getKf1() %> </li>
				                    		<li> <%=productBeanList.get(k+j).getKeyFeatures().getKf2() %> </li>
				                    		<li> <%=productBeanList.get(k+j).getKeyFeatures().getKf3() %> </li>
				                    		<li> <%=productBeanList.get(k+j).getKeyFeatures().getKf4() %> </li>
                   						</ul>
                   					</div>
                   				
								<div class="item_add"><h6><span class="item_price"> <small class="over_flow"> Rs.<%=productBeanList.get(k+j).getPrice().getListPrice() %> </small> &nbsp; <small class="item_price"> (<%=productBeanList.get(k+j).getPrice().getDiscount() %>% Off) </small> <br> <strong class="main_value">Rs <%=productBeanList.get(k+j).getPrice().getSalePriceCustomer() %></strong> </span></h6></div>
								<div class="item_add">
									<span class="item_price">
										<a href="CompleteProductDetails?subCategory=<%=productBeanList.get(k+j).getSubCategory() %>&productId=<%=productBeanList.get(k+j).getProductId() %>">More Details</a>
									</span>
								</div>
							</div>
						</div>
						
					</li>
				<% 		
						if ((k+j) == productBeanList.size()-1) break;
				    } 
				%>
					
				</ul>
				<div class="clearfix"> </div>
			</div>
			
			
		<% 
				id++;
				k = k + 5;
		   } // productBeanList_DivCount loop ends 
		%>
		
		<!-- For jQuery calculation -->
		<div id="max" style="display:none;"><%=id %></div>
		<div id="subCat" style="display:none;"><%=productBeanList.get(0).getSubCategory() %></div>		
			
	</div>
</div>

<div id="loadMore">
	<div class="item_add"><span class="item_price" id="span"><a id="a" data-max="<%=MAX%>">Load More</a></span></div>
</div>

<!-- ------------------------------------------End Body----------------------------------------------- -->



<!-- -------------------------------------Footer------------------------------------------------------ -->
<%@ include file="Footer.jsp" %>
<!-- -------------------------------------End Footer-------------------------------------------------- -->


	<script type="text/javascript" src="js/bxslider.min.js"></script>
	<script type="text/javascript" src="js/script.slider.js"></script>

</body>
</html>