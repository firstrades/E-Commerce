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
	<link href="css/style.css" rel='stylesheet' type='text/css' />
	<link href="css/order.css" rel='stylesheet' type='text/css' />
	
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


<style type="text/css">
   .menu{
        padding: 0;
        list-style: none;
        background: #f2f2f2;
        width: 106px;
        font-size: 13px;
    }
    .menu li{
        display: inline-block;
        position: relative;
        line-height: 21px;
        text-align: left;
    }
    .menu li a{
        display: block;
        padding: 4px 18px;
        color: #333;
        text-decoration: none;
        border-bottom: 1px solid #ccc;
    }
   .menu li a:hover{
        color: #fff;
        background: #939393;
    }
    .menu li ul.dropdown{
      min-width: 175px;
    background: #FFFFFF;
    display: none;
    position: absolute;
    z-index: 1000;
    left: 0;
    padding: 0px;
    margin: 0px;
    box-shadow: 1px 1px 1px #ccc;
    border-left: 1px solid #ccc;
    border-top: 1px solid #ccc;
    }
   .menu li:hover ul.dropdown{
        display: block; /* Display the dropdown */
    }
    .menu li ul.dropdown li{
        display: block;
    } 
   

</style>
</head>
<body>

<%
	User user = (User) session.getAttribute("user");
%>


<!-- Header -->
<%@ include file="Header.jsp" %>
<!-- End Header -->


<!-- Navigation -->
<%@ include file="Navigation.jsp" %>
<!-- End Navigation -->


<!-- ----------------------------------------------------BODY-------------------------------------------------------- -->
<div class="container"> <ul class="line bmargin20 tmargin20 fk-font-17"> <li class="fk-inline-block" id="myAccountBtn"><a href="https://www.flipkart.com/account?link=my_account">My Account</a> / </li> <li class="fk-inline-block"><h1>My Orders</h1></li> </ul> <div class="myorder-tabs"> <ul> <li class="fk-inline-block tab" id="recent-orders"><span class="text">RECENT ORDERS</span><span id="subText" class="text fk-font-small">(Last 6 Months)</span></li> </ul> </div> <div id="order-section"> <div id="recent-orders-tab" class="line tmargin20" >
<div class="fk-inf-scroll-item order physical">
 <div class="line order-collapsed fk-hidden">
 <div class="unit size1of5">
 <strong>OD101246839208188700</strong>
 </div>
 <div class="unit size3of5 smallText">
 How to Read a Cash Flow Statement (English) 2nd Edition, How to An... (Total: 2 items)
 </div>
 <div class="unit size1of6">
 <span class="smallText">Order Total:</span> <strong>Rs.289</strong>
 </div>
 <div class="lastUnit text_right">
 <a class="toggle-details" title="Show order details"></a>
 </div>
 </div>
 <div class="line order-expanded">
 <div class="unit size1of4">
 <a class="orderIdBtn btn btn-medium btn-blue" target="_blank" href="https://www.flipkart.com/order_details?order_id=OD101246839208188700&amp;src=od&amp;link=order_number">OD101246839208188700</a>
 </div>
 <div class="unit size3of5">
 </div>
 <div class="lastUnit text_right">
 <a class="toggle-details" title="Hide order details"></a>
 </div>
 </div>
 <div class="line js-order-details fk-hidden" style="display: block;">
 <div class="line order-item ">
 <div class="line order-item-inner">
 <div class="unit size1of8 fk-text-center product-image">
 <a href="#" target="__blank">
 <img class="item-image"  src="images/histroy.jpeg">
 </a>
 </div>
 <div class="unit size2of7">
 <a target="_blank" href="#">
 How to Read a Cash Flow Statement (En... </a>
 <p class="smallText tmargin10">N. Ramachandran, Ram Kumar Kakani</p>
 <p class="smallText tmargin10">
 Qty: 1 </p>
 </div>
 <div class="unit size1of6">
 <div class="lpadding10">
 Rs. 132 </div>

 </div>
 <div class="unit size2of7">
 <p class="greyText bmargin10">
 Delivered on Fri, 14th Nov'14 </p>
 
 </div>
 <div class="lastUnit text_right">
 </div>
 </div>
 
 </div>
 
 
 <div class="line order-total">
 <div class="line">
 <div class="unit size2of5">
 <span class="smallText">Seller:</span> <span class="rmargin20">WS Retail</span>
 <span class="smallText fk-inline-block">Date:</span> Mon, 10th Nov'14 </div>
 <div class="lastUnit text_right">
 <span class="smallText">Order Total:</span> <strong>Rs.289</strong>
 </div>
 </div>
 </div>
 </div>
 </div>

 
 </div>
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