<%@page import="ecom.common.FrequentUse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en" data-ng-app="admin">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Admin Panel</title>
    
	    <!-- jQuery -->    
	    <script type="text/javascript" src="<%=FrequentUse.jQuery %>"></script>	
	    <script type="text/javascript" src="<%=FrequentUse.angular %>"></script>    
	    <script type="text/javascript" src="js_Administration/Admin.js"></script>
	    
	    <!-- Bootstrap Core JavaScript -->
	    <script src="js/bootstrap.min.js"></script>	
	    <!-- Metis Menu Plugin JavaScript -->
	    <script src="js/metisMenu.min.js"></script>	
	    <!-- Custom Theme JavaScript -->
	    <script src="js/sb-admin-2.js"></script>	    

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="css/metisMenu.min.css" rel="stylesheet">
    <!-- Timeline CSS -->
    <link href="css/timeline.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="css/sb-admin-2.css" rel="stylesheet">
    <!-- Morris Charts CSS -->
    <link href="css/morris.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<style type="text/css">
.container{
    width: 98%;
    border: 1px solid #ccc;
    float: left;
    margin-left: 1%;
    background-color: #FFF2F2;
    padding-left: 0px;
    padding-right: 0px;
    margin-bottom: 5px;
}
.dots{
float: left;
margin-right: 24px;
    text-transform: uppercase;
}
#hr{margin-top:9px;margin-bottom:9px;border:0;border-top:1px solid #eee}
</style>

</head>

<body>

<div data-ng-controller="ViewController">

    <div id="wrapper">  <!-- Wrapper -->

		<!-- -------------------------- Flip Drop Down ------------------------------- -->

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">ADMIN MAIN PANEL</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>Read All Messages</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-messages -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-tasks fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-tasks">
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 1</strong>
                                        <span class="pull-right text-muted">40% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            <span class="sr-only">40% Complete (success)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 2</strong>
                                        <span class="pull-right text-muted">20% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                            <span class="sr-only">20% Complete</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 3</strong>
                                        <span class="pull-right text-muted">60% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 4</strong>
                                        <span class="pull-right text-muted">80% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                            <span class="sr-only">80% Complete (danger)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Tasks</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-tasks -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-comment fa-fw"></i> New Comment
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                    <span class="pull-right text-muted small">12 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> Message Sent
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-tasks fa-fw"></i> New Task
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Alerts</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-alerts -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="index.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->
            
            
            <!-- -------------------------------------------------------------------------------------------- -->

            <div class="navbar-default sidebar">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="#" data-ng-click="approveProductList()">
                            	<i class="fa fa-dashboard fa-fw"></i>
                            	PRODUCTS FOR APPROVAL
                            </a>
                        </li>
                        <li>
                            <a href="#" data-ng-click="statusForBookedProducts()">
                            	<i class="fa fa-dashboard fa-fw"></i>
                            	Status For Booked Products
                            </a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> FRANCHISE<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">                            	
                                <li>
                                	<a href="#" data-ng-click="redirectToUserRegistration()">REGISTRATION</a>
                                </li>
                                <li>
                                    <a href="#" data-ng-click="getPinCommission()">SET PIN / COMMISSION</a>
                                </li>
                                <li>
                                    <a href="#">VIEW DETAILS</a>
                                </li>
                                <li>
                                    <a href="#">Camera</a>
                                </li>
                                <li>
                                    <a href="#">Television</a>
                                </li>
                                <li>
                                    <a href="#">Kitchen Appliance</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                        <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> DISTRIBUTOR<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="#">VIEW DETAILS</a>
                                </li>
                                <li>
                                    <a href="#">Second Level Item</a>
                                </li>
                                <li>
                                    <a href="#">Third Level <span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                       
                        
                        <li>
                            <a href="#"><i class="fa fa-files-o fa-fw"></i> Sample Pages<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="#">Blank Page</a>
                                </li>
                                <li>
                                    <a href="#">Login Page</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
        
        <!-- -------------------------- End Flip Drop Down ------------------------------- -->
        
        
        
        <!-- -------------------------- Dashboard ------------------------------- -->

       	<div class="right_pannel" style="position:absolute;top:13%;left:19%;width:81%; height:580px;border:none;" data-ng-show="dashboard">
			<div class="initional">
				<div class="page-wrapper" >
            		<div class="row">
                		<div class="col-lg-12">
                    		<h1 class="page-header">Dashboard</h1>
                		</div>                		
            		</div>
            		<div class="auto">            			
            			<div class="row">
                			<div class="col-lg-3 col-md-6">
                    			<div class="panel panel-primary">
                        			<div class="panel-heading">
                            			<div class="row">
                                			<div class="col-xs-3">
                                    			<i class="fa fa-comments fa-5x"></i>
                                			</div>
                                			<div class="col-xs-9 text-right">
                                    			<div class="huge">26</div>
                                    			<div>New Comments!</div>
                                			</div>
                            			</div>
                        			</div>
                        			
                           			<div class="panel-footer">
                               			<a href="#"><span class="pull-left">View Details</span></a>
                               			<span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                               			<div class="clearfix"></div>
                           			</div>
                        			
                    			</div>
                			</div>
                			<div class="col-lg-3 col-md-6">
                    			<div class="panel panel-green">
                        			<div class="panel-heading">
                            			<div class="row">
                                			<div class="col-xs-3">
                                    			<i class="fa fa-tasks fa-5x"></i>
                               			 	</div>
                                			<div class="col-xs-9 text-right">
                                    			<div class="huge">12</div>
                                    			<div>New Tasks!</div>
                                			</div>
                            			</div>
                        			</div>
                        			
                           			<div class="panel-footer">
		                               <a href="#"> <span class="pull-left">View Details</span></a>
		                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
		                                <div class="clearfix"></div>
                           			</div>
                        			
                    			</div>
                			</div>
                			<div class="col-lg-3 col-md-6">
                    			<div class="panel panel-yellow">
                        			<div class="panel-heading">
                            			<div class="row">
                                			<div class="col-xs-3">
                                    			<i class="fa fa-shopping-cart fa-5x"></i>
                                			</div>
			                                <div class="col-xs-9 text-right">
			                                    <div class="huge">124</div>
			                                    <div>New Orders!</div>
			                                </div>
                            			</div>
                        			</div>
			                        
		                            <div class="panel-footer">
		                                <a href="#"><span class="pull-left">View Details</span> </a>
		                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
		                                <div class="clearfix"></div>
		                            </div>
			                       
                    			</div>
                			</div>
			                <div class="col-lg-3 col-md-6">
			                    <div class="panel panel-red">
			                        <div class="panel-heading">
			                            <div class="row">
			                                <div class="col-xs-3">
			                                    <i class="fa fa-support fa-5x"></i>
			                                </div>
			                                <div class="col-xs-9 text-right">
			                                    <div class="huge">13</div>
			                                    <div>Support Tickets!</div>
			                                </div>
			                            </div>
			                        </div>
			                        
		                            <div class="panel-footer">
		                                <a href="#"><span class="pull-left">View Details</span> </a>
		                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
		                                <div class="clearfix"></div>
		                            </div>
			                       
			                    </div>
			                </div>
            			</div>            			
         			</div>
        		</div>		
			</div>		
		</div>
		
		<!-- -------------------------- Dashboard ------------------------------- -->
		
		<!-- -------------- Approve Product ---------------------- -->
		
		<div data-ng-show="productApproval" style="position:absolute;top:8%;left:16%;width:83%;max-height: 700px;border:1px solid #ccc; overflow: auto; overflow-x: none;">
		
			<h1 style="margin-left: 1%;background-color: #eee;padding: 8px 14px; font-size: 23px;width: 98%;"> Products For Approval </h1>
			
		
			<div class="container" style="width: 96%;border: 1px solid #ccc; float: left;" data-ng-repeat="item in items" data-ng-remove-item>
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-1" style="padding: 0px;">
							<img src="IconImageFromProduct?productId={{item.productId}}" style="width:100%; height: 124px;"/>		
						</div>
						<div class="col-md-11">
							<div class="row">
								<div class="col-md-11"> <h1 style="font-size: 18px; margin-top: 9px;margin-top: 6px;">  Product Name: {{item.productName}} </h1>
								</div> 
							</div>
			
							<div class="row">
								<div class="col-md-2">
									<div class="row">
										<div class="col-md-12"> 
											<span style="font-size: 12px;margin-top: 5px;color: #337AB7;">  Product Id : {{item.productId}} </span>
										</div> 
									</div>
									<div class="row">
										<div class="col-md-12"> 
											<span style="font-size: 12px;margin-top: 5px;color: #337AB7;">  Company : {{item.companyName}} </span>
										</div>
									</div> 
									<div class="row">
										<div class="col-md-12"> 
											<span style="font-size: 12px;margin-top: 5px;color: #337AB7;">  Category : {{item.category}} </span>
										</div> 
									</div>
									<div class="row">
										<div class="col-md-12"> 
											<span style="font-size: 12px;margin-top: 5px;color: #337AB7;">  SubCategory : {{item.sub_category}} </span>
										</div> 
									</div>
								</div>
								<div class="col-md-3">
									<div class="row">
										<div class="col-md-12"> 
											<span style="font-size: 12px;">  Seller : {{item.seller}}  </span>
										</div> 
									</div>
									<div class="row">
										<div class="col-md-12"> 
											<span style="font-size: 12px;">  Franchise :  Skypoint india E Services PVT LTD  (Jewel Saha)  </span>
										</div> 
									</div>
									<div class="row">
										<div class="col-md-12"> 
											<span style="font-size: 12px;">  Distributor :  Skypoint india E Services PVT LTD  (Jewel Saha)  </span>
										</div>
									</div>
								</div>
								<div class="col-md-2" style="width: 13%;">
									<div class="row">
										<div class="col-md-12"> 
											<span style="font-size: 12px; color: #d9534f;">  List Price : {{item.listPrice}}  </span>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12"> <span style="font-size: 12px; color: #d9534f;">  Discount :  {{item.discount}}  </span>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12"> 
											<span style="font-size: 12px; color: #d9534f;">  Sell price :  {{item.salePrice}}  </span>
										</div>
									</div>
									
								</div>
								
								<div class="col-md-1" style="width: 11%;">
								<div class="row">
								<div class="row">
										<div class="col-md-12"> 
											<span style="font-size: 12px; color: #d9534f;">  Markup : <input type="text" data-ng-model="markup" value="{{item.markup}}" size="3" style="margin-left: 17px;">  </span>
										</div>
									</div>
										<div class="row">
										<div class="col-md-12"> 
											<span style="font-size: 12px; color: #d9534f;">  FranComm : <input type="text" data-ng-model="franComm" value="" size="3">  </span>
										</div>
									</div>
									
									
									<div class="row">
										<div class="col-md-12"> 
											<span style="font-size: 12px; color: #d9534f;">  DrisComm : <input type="text" data-ng-model="drisComm" value="" size="3" style="margin-left: 3px;">  </span>
										</div>
									</div>
									
								</div>
								
								</div>
			
								<div class="col-md-4" style="margin-top: 60px;">
				
									<ul>
										<li class="dots" style="list-style: none;"> 
											<a href="#" style="font-size: 12px;" data-ng-click="approveProduct()"> Approve </a> 
										</li> 
										<li class="dots"> 
											<a href="#" style="font-size: 12px;">Cancel </a> 
										</li> 
										<li class="dots">  
											<a href="#" style="font-size: 12px;"> Remove </a> 
										</li> 
										<li class="dots">  
											<a href="#" style="font-size: 12px;"> Delete </a> 
										</li> 
									</ul>  
				
								</div>								
							</div>	
						</div>		
					</div>
				</div>		
			</div>		
    	</div>   
    
    	<!-- -------------- End Approve Product ---------------------- -->
    
    	<!-- -------------- Edit Franchise ---------------------- -->
		
		<div data-ng-show="editFranchise" style="position:absolute;top:8%;left:16%;width:83%;max-height: 700px;border:1px solid #ccc; overflow: auto; overflow-x: none;">
			
			<h1 style="margin-left: 1%;background-color: #eee;padding: 8px 14px; font-size: 23px;width: 98%;"> Set Pin And Commission </h1>
			
			<div class="container" data-ng-repeat="item in pinCommissions" data-ng-controller="SetPinCommissionController">
			
				<div class="row">
				
					<div class="col-md-4">	
							
						<div class="row" style="padding: 7px 10px;">
							<div class="col-md-12">
								<span style="font-size: 14px; color:#F10B0B;">  Company Name :  {{item.companyName}}  </span>			
							</div>
						</div>
			
						<div class="row" style="padding: 7px 10px;">
							<div class="col-md-12">
								<span style="font-size: 14px;color:#0B6BBD;">  Franchise Name :  {{item.firstName + " " + item.lastName}}  </span>			
							</div>
						</div>
						
						<div class="row" style="padding: 7px 10px;">
							<div class="col-md-12">
								<span style="font-size: 14px;color:#D67F03;"> ID :  {{item.id}}  </span>			
							</div>			
						</div>
			
					</div>		
		
					<div class="col-md-3">			
			
						<div class="row" style="padding: 7px 10px;">
							<div class="col-md-12">
								<span style="font-size: 14px;">  Pin1 :  <input type="text"  data-ng-model="item.pin1" placeholder="Set Pin1" size="16" style="padding: 3px 11px;"> 
									<a href="#" style="font-size: 14px;" data-ng-click="setPin(0)">save</a>
								</span>			
							</div>
						</div>			
			
			   			<div class="row" style="padding: 7px 10px;">
							<div class="col-md-12">
								<span style="font-size: 14px;">  Pin2 :  <input type="text"   data-ng-model="item.pin2"  placeholder="Set Pin2" size="16" style="padding: 3px 11px;"> 
									<a href="#" style="font-size: 14px;" data-ng-click="setPin(1)">save</a>
								</span>			
							</div>
						</div>
				
						<div class="row" style="padding: 7px 10px;">
							<div class="col-md-12">
								<span style="font-size: 14px;">  Pin3 :  <input type="text"   data-ng-model="item.pin3"  placeholder="Set Pin2" size="16" style="padding: 3px 11px;"> 
									<a href="#" style="font-size: 14px;" data-ng-click="setPin(2)">save</a>
								</span>			
							</div>
						</div>
			
					</div>		
			
					<div class="col-md-3">			
		
						<div class="row" style="padding: 7px 10px;">
							<div class="col-md-12">
								<span style="font-size: 14px;">  Pin4 :  <input type="text"   data-ng-model="item.pin4"  placeholder="Set Pin1" size="16" style="margin-left: 15%;padding: 3px 11px;"> 
									<a href="#" style="font-size: 14px;" data-ng-click="setPin(3)">save</a>
								</span>			
							</div>
						</div>
			
						<div class="row" style="padding: 7px 10px;">
							<div class="col-md-12">
								<span style="font-size: 14px;">  Pin5 :  <input type="text"   data-ng-model="item.pin5"  placeholder="Set Pin2" size="16" style="margin-left: 15%;padding: 3px 11px;"> 
									<a href="#" style="font-size: 14px;" data-ng-click="setPin(4)">save</a>
								</span>			
							</div>
						</div>
			
						<div class="row" style="padding: 7px 10px;">
							<div class="col-md-12">
								<span style="font-size: 14px;">  Commission :  <input type="text"   data-ng-model="item.commission"  placeholder="Commission" size="3" style="padding: 3px 11px;"> %
									<a href="#" style="font-size: 14px;" data-ng-click="setCommission()">save</a>
								</span>			
							</div>			
						</div>		
		
					</div>
		          
		          	<div class="col-md-2" style="margin-top:10px;">
			          	<div class="row">
							<div class="col-md-12">	
			          			<span style="font-size: 14px;">  Additional Balance :  
			          				<input type="text"   data-ng-model="addtionalBalance"  placeholder="Balance" size="8" style="margin-left: 0%;padding: 3px 11px;"> 
									<a href="#" style="font-size: 14px;" data-ng-click="setAdditionalBalance()">save</a>
									<span data-ng-bind="item.balance" style="margin-left: 9px;"></span>
								</span>	
							</div>
						</div>								
					</div>
					
					
					<div style="margin-top: 85px;color: red;" data-ng-bind="message1" data-js-empty><!-- message --></div>	
		
				</div>			
			
			</div>
			
		</div>
		<!-- -------------- End Edit Franchise ---------------------- -->	
		
		<!-- -------------- Status for booked products ---------------------- -->
		
<div data-ng-show="bookedProductsStatus" style="position:absolute;top:8%;left:16%;width:83%;max-height: 700px; border:1px solid #ccc; overflow: auto; overflow-x: hidden;">
		
			
			
			
		<div class="row" style="margin-bottom: 20px;" data-ng-repeat="item in bookedProducts"> 
			<div class="col-md-12"> <h1 style="margin-left: 1%;background-color: #eee;padding: 8px 14px; font-size: 23px;width: 98%;"> Status For Booked Products </h1>  </div> 
			<div class="col-md-12" style="width:100%;border:1px solid #ddd;margin-bottom:-12px;box-shadow: 1px 1px 1px #f5f5f5;background-color: #FFFFF5;">
				<div class="col-md-2" style="border: 1px solid #EAEAEA; box-shadow: 1px 1px 1px #e7e7e7; margin-top:10px; margin-bottom: 11px;">
					<img alt="image" src="IconImageFromProduct?productId={{item.productId}}" width="150" height="150" />
				</div>
				<div class="col-md-7">
					<div class="col-md-6">
						<h3 style="margin-bottom: 7px;margin-top: 8px;color: #337ab7; font-size: 16px;">  Order Id : {{item.orderId}}  </h3> <hr id="hr">
						<span>   Id :    </span>  
						<span style=""></span>					
						<hr id="hr">					
						<span style="margin-right:15px;">Product Id : {{item.productId}} </span> <br> <hr id="hr">
						<span>  Sell Price : {{item.sellPrice}} </span> <br> <hr id="hr">
						<span>Warranty  : {{item.warranty}}</span>
						
					</div>					
					<div class="col-md-5" style="margin-top: 6px;">
					
						<span>Shipping Cost : Rs {{item.shippingCost}}</span>
						<hr id="hr">
						<span>Quantity : {{item.qty}}</span>
						<hr id="hr">
						<span>Order  Booked On : {{item.bookedDateTime}}</span>
						<hr id="hr">
						
						<span>Size : {{item.size}}</span>
						<hr id="hr">
						
						
					</div>					
				</div>
				<!-- -------------------------------------------------------------- -->
				
				
				<div class="col-md-3" style="margin-top:100px;" data-ng-show="booked">
					<span style="float: left;margin-top: 9px;">
						Order Booked By Customer
					</span>					
					                                                                 
				<!-- -------------------------------------------------------------- -->					
				
				</div>
			</div>
		</div>			
			
			
</div> <!-- Main -->
		<!-- -------------- End Status for booked products ---------------------- -->
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		<!-- -------------- Spare ---------------------- -->
		
		<!-- <div data-ng-show="editFranchise" style="position:absolute;top:8%;left:16%;width:83%;max-height: 700px;border:1px solid #ccc; overflow: auto; overflow-x: none;">
		
		sdkjfcscvjksdjds
		</div> -->
		<!-- -------------- End Spare ---------------------- -->
		
		<!-- -------------- Spare ---------------------- -->
		
		<!-- <div data-ng-show="editFranchise" style="position:absolute;top:8%;left:16%;width:83%;max-height: 700px;border:1px solid #ccc; overflow: auto; overflow-x: none;">
		
		sdkjfcscvjksdjds
		</div> -->
		<!-- -------------- End Spare ---------------------- -->
		
		<!-- <div data-ng-show="editFranchise" style="position:absolute;top:8%;left:16%;width:83%;max-height: 700px;border:1px solid #ccc; overflow: auto; overflow-x: none;">
		
		sdkjfcscvjksdjds
		</div> -->
		<!-- -------------- End Spare ---------------------- -->
		
		<!-- <div data-ng-show="editFranchise" style="position:absolute;top:8%;left:16%;width:83%;max-height: 700px;border:1px solid #ccc; overflow: auto; overflow-x: none;">
		
		sdkjfcscvjksdjds
		</div> -->
		<!-- -------------- End Spare ---------------------- -->
		
		<!-- <div data-ng-show="editFranchise" style="position:absolute;top:8%;left:16%;width:83%;max-height: 700px;border:1px solid #ccc; overflow: auto; overflow-x: none;">
		
		sdkjfcscvjksdjds
		</div> -->
		<!-- -------------- End Spare ---------------------- -->
		
		<!-- <div data-ng-show="editFranchise" style="position:absolute;top:8%;left:16%;width:83%;max-height: 700px;border:1px solid #ccc; overflow: auto; overflow-x: none;">
		
		sdkjfcscvjksdjds
		</div> -->
		<!-- -------------- End Spare ---------------------- -->
    
</div> <!-- End Wrapper -->

</div> <!-- End ViewController -->

</body>

</html>
