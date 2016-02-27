<%@page import="java.util.List"%>
<%@page import="ecom.model.OrderTable"%>
<%@page import="ecom.common.FrequentUse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html data-ng-app="Jewel">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>View Product List</title>
	<script type="text/javascript" src="<%=FrequentUse.jQuery %>"></script>
	<script type="text/javascript" src="<%=FrequentUse.angular %>"></script>
	<script type="text/javascript" src="js_Seller/OrderedItemsStatus.js"></script>	
	<link type="text/css" href="css/bootstrap.css" rel="stylesheet">
	<link  rel="stylesheet" href="<%=FrequentUse.style %>" type="text/css" />
	<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<script src="js/bootstrap.min.js"></script>
	
	 <link rel="stylesheet" href="css/reset.css" type="text/css"/>
<link rel="stylesheet" href="css/default.css" type="text/css"/>

	
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
.clear_fix{
clear: both;
}

</style>
</head>

<%
	@SuppressWarnings("all")
	List<OrderTable> orderTables = (List<OrderTable>) request.getAttribute("orderTables");

	
%>



<body id="top">


<!-- -----------------------------------    Loop     -------------------------------------------------- -->


<% 
	int i = 0;
	for (OrderTable orderTable : orderTables) { 
	    System.out.println(orderTable.getPaymentType());
%>

	<div class="row" data-ng-controller="LoopController"> 
			<div class="col-md-12" style="width:100%;border:1px solid #ddd;margin-bottom:-12px;box-shadow: 1px 1px 1px #f5f5f5;background-color: #FFFFF5;">
				<div class="col-md-2" style="border: 1px solid #EAEAEA; box-shadow: 1px 1px 1px #e7e7e7; margin-top:10px; margin-bottom: 11px;">
					<img alt="image" src="IconImageFromProduct?productId=<%=orderTable.getProductId() %>" width="150" height="150" />
				</div>
				<div class="col-md-7">
					<div class="col-md-6">
						<h3 style="margin-bottom: 7px;margin-top: 8px;color: #337ab7; font-size: 16px;">  Order Id : <%=orderTable.getOrderId() %>  </h3> <hr>
						<span>   Id :    </span>  
						<span style=""></span>					
						<hr>					
						<span style="margin-right:15px;">Product Id : <%=orderTable.getProductId() %> </span> <br> <hr>
						<span>  Sell Price : <%=orderTable.getSellPrice() %> </span> <br> <hr>
						<span>Warranty  : <%=orderTable.getWarranty() %></span>
						
					</div>					
					<div class="col-md-5" style="margin-top: 20px;">
					
						<span>Shipping Cost : Rs <%=orderTable.getShippingCost() %></span>
						<hr>
						<span>Quantity : <%=orderTable.getQty() %></span>
						<hr>
						<span>Order  Booked On : <%=orderTable.getBookedDateTime() %></span>
						<hr>
						<% if (orderTable.getSize() < 0) { %>
						<span>Size : <%=orderTable.getSize() %></span>
						<% } %>
						<hr>
						
						
					</div>					
				
				
				
				<img data-ng-show="loader" alt="loader" src="images/loader1.gif" style="width: 40px; height: 40px; margin-top: 40px;" />
				
				</div>
				<!-- -----------------Generate Track ID (COD)--------------------------------------------- -->
				
				<% if (orderTable.getOrderState().equals("Booked") && orderTable.getPaymentType().equals("COD")) { %>
				<div data-ng-init="trackNumberCOD=true"></div>
				<% } else { %>
				<div data-ng-init="trackNumberCOD=false"></div>
				<% } %>
				<% if (orderTable.getOrderState().equals("Booked") && orderTable.getPaymentType().equals("COD")) { %>
				<div class="col-md-3" style="margin-top:58px;" data-ng-show="trackNumberCOD">
					<a data-ng-click="generateTrackNumberCOD(<%=orderTable.getId() %>)" style="width: 50% !important;  padding: 9px 10px;background:linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5);border: 1px solid #0098fe;color:#ffffff;margin-top:18px;cursor: pointer;">Generate Track ID (COD)</a>
				</div>
				<% } %>
								
				<!-- -----------------Generate Track ID (BANK)--------------------------------------------- -->
				
				<% if (orderTable.getOrderState().equals("Booked") && orderTable.getPaymentType().equals("BANK")) { %>
				<div data-ng-init="trackNumberBANK=true"></div>
				<% } else { %>
				<div data-ng-init="trackNumberBANK=false"></div>
				<% } %>
				<% if (orderTable.getOrderState().equals("Booked") && orderTable.getPaymentType().equals("BANK")) { %>
				<div class="col-md-3" style="margin-top:58px;" data-ng-show="trackNumberBANK">
					<a data-ng-click="generateTrackNumberBANK(<%=orderTable.getId() %>)" style="width: 50% !important;  padding: 9px 7px;background:linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5);border: 1px solid #0098fe;color:#ffffff;margin-top:18px;cursor: pointer;">Generate Track ID (BANK)</a>
				</div>
				<% } %>
				
				<!-- -------------------------------------------------------------------------------------------- -->
				
				
				
				
				
				
				                                                                
				<!-- -------------------Pick Up - Print Label - Delete Shipment    (COD)   -------------------------------- -->		
				
				<% if (orderTable.getOrderState().equals("Pickup") && orderTable.getPaymentType().equals("COD")) { %>
				<div data-ng-init="pickupLabelCOD=true"></div>
				<% } else { %>
				<div data-ng-init="pickupLabelCOD=false"></div>
				<% } %>
				
				<div class="col-md-3" style="margin-top:58px;" data-ng-show="pickupLabelCOD">
					<a href="#" data-toggle="modal" data-target="#myModal<%=i%>" style="padding: 9px 20px;background:linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5);border: 1px solid #0098fe;color:#ffffff;margin-top:18px;">Pickup Req</a> 
					<a href="#" style="padding: 9px 20px;background:linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5);border: 1px solid #0098fe;color:#ffffff;margin-top:18px;">Pirnt Label</a>  <br><br>
					<a href="#" style="padding: 9px 39px;background:linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5);border: 1px solid #0098fe;color:#ffffff;margin-top:18px;">Delete Shipment (COD)</a>					
				</div>
				
				
				<!-- -------------------Pick Up - Print Label - Delete Shipment    (BANK)   ------------------------------ -->		
				
				<% if (orderTable.getOrderState().equals("Pickup") && orderTable.getPaymentType().equals("BANK")) { %>
				<div data-ng-init="pickupLabelBANK=true"></div>
				<% } else { %>
				<div data-ng-init="pickupLabelBANK=false"></div>
				<% } %>
				
				<div class="col-md-3" style="margin-top:58px;" data-ng-show="pickupLabelBANK">
					<a href="#" data-toggle="modal" data-target="#myModal<%=i%>" 
						style="padding: 9px 20px;background:linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5);border: 1px solid #0098fe;color:#ffffff;margin-top:18px;">Pickup Req</a> 
					<a href="#" style="padding: 9px 20px;background:linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5);border: 1px solid #0098fe;color:#ffffff;margin-top:18px;">Pirnt Label</a>  <br><br>
					<a href="#" style="padding: 9px 35px;background:linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5);border: 1px solid #0098fe;color:#ffffff;margin-top:18px;">Delete Shipment (BANK)</a>					
				</div>
				
				
				<!-- -------------------------------------------------------------------------------------------- -->
				
				
				
				
				
				
				
				<!-- -------------------  Picked Up  (BANK)   ------------------------------ -->		
				
				<% if (orderTable.getOrderState().equals("Picked")) { %>
				<div data-ng-init="trackParcel=true"></div>
				<% } else { %>
				<div data-ng-init="trackParcel=false"></div>
				<% } %>
				
				<div class="col-md-3" style="margin-top:58px;" data-ng-show="trackParcel">
					<a href="#" style="padding: 9px 79px;background:linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5);border: 1px solid #0098fe;color:#ffffff;margin-top:18px;">Track Parcel</a><br><br>
					<a href="#" style="padding: 9px 35px;background:linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5);border: 1px solid #0098fe;color:#ffffff;margin-top:18px;">Delete Shipment (BANK)</a>					
				</div>
				
				
				<!-- -------------------------------------------------------------------------------------------- -->
				
				
				
				
				
				
				
				<!-- ---------------------------- Pick Up ===== Pop Up ---------------------------------------------------- -->				
				
				
				<div class="modal fade pickpop" id="myModal<%=i%>">
			    	<div class="modal-dialog">    
			      		<!-- Modal content-->
			      		<div class="modal-content" style="width: 65%; margin-left: 15%;">
			        		<div class="modal-header">
			          			<button type="button" class="close" data-dismiss="modal">&times;</button>
			          			<h4 class="modal-title" style="text-align: center; color: #FF6978">Pickup Complete</h4>
			        		</div>
			        		<!-- -------------------------------------------------------------- -->
			        		
			        		<div class="modal-body">
			       				<div class="new-login-form">  			            			
			            			<div class="tmargin20 login-btn-wrap" style="margin-left: 20%;">
			                			<input type="text"  data-ng-model="date"
			                				class="span1"   placeholder="Pick a date" style="margin-bottom: 25px;"/> 
			                			<a href="#"  data-dismiss="modal" data-ng-click="changeStateToPicked(<%=orderTable.getId() %>)"
			                				style="padding: 9px 35px;background:linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5);border: 1px solid #0098fe;color:#ffffff;"> Ok  </a>
			            			</div>
			        			</div>			        		
			      			</div>   
			      			
			      			<!-- -------------------------------------------------------------- --> 
			    		</div>
			  		</div>  
				</div>					
				
			
			
				<!-- ------------------------------------------------------------------------------------------------------ -->	
		
			</div>
	</div>
	
	
	

<% 
	i++;
	} %>

<!-- ---------------------        End  Loop    ------------------------------------------ -->




</body>
</html>
