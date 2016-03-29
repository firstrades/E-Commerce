<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<!-- -------------------------------------Header--------------------------------------------------- -->

<div class="top_bg">
	<div class="container">
		<div class="header_top">
			<div class="top_right">
				<ul>
					<li><a href="SellerLoginPage">Stockist</a></li>|
					<li><a href="#" data-toggle="modal" data-target="#myModal">Administration</a></li>|
					<li><a href="#">24X7 Customer Care </a></li> |
					<li><a href="#">Track Order</a></li>
				</ul>
			</div>
			<div class="top_left">
				<h2><span></span> Call us :  (+91) - 7890000448 / 9831016768 /7890020448 &nbsp;;
				<a  style="color:#ffffff;"> mail:  suport@firstrades.com  &nbsp; info@firstrades.com 
</a> </h2>
			</div>
				<div class="clearfix"> </div>
		</div>
	</div>
</div>
<!-- header -->
<div class="header_bg">
	<div class="container">
		<div class="header">
			<div class="head-t">
				<div class="logo">
					<a href="index.jsp"> <img src="images/logoFirstTrade.png" /> </a>
				</div>
				<!-- start header_right -->
				<div class="header_right">
					<div class="rgt-bottom">
						<div class="log">
							<div class="login" >
								<div id="loginContainer"><a href="#" id="loginButton"><span>Login</span></a>
								    <div id="loginBox">                
								        <form id="loginForm" action="CustomerLogin" method="post">
								                <fieldset id="body">
								                	<fieldset>
								                          <label for="email">Mobile/Email Address</label>
								                          <input type="text" name="userId" id="email" placeholder="Enter Mobile/Email" value="9007785663" />
								                    </fieldset>
								                    <fieldset>
								                            <label for="password">Password</label>
								                            <input type="password" name="password" id="password" placeholder="Enter Password" value="12345" />
								                     </fieldset>
								                    <input type="submit" id="login" value="Sign in">
								                	<label for="checkbox"><input type="checkbox" id="checkbox"> <i>Remember me</i></label>
								            	</fieldset>
								            <span><a href="#">Forgot your password?</a></span>
										</form>
									</div>
								</div>
							</div>
						</div>
						<div class="reg">
							
							<div id="loginContainer"><a href="CustomerRegistrationPage" id="loginButton" style="background-color: #099C0C;color: #fff;padding: 1px 0px;"><span>REGISTER</span></a> </div>
						</div>
						<div class="cart box_1">
							<h3><a href="#">
								<span>CART INR 0.00</span> (<span id="" class="">0</span> items)<img src="images/bag.png" alt="">
							</a></h3>	
							
							<div class="clearfix"> </div>
						</div>
					
						<div class="clearfix"> </div>
					</div>
					<div class="search">
					    <form>
					    	<input type="text" value="" placeholder="search...">
							<input type="submit" value="">
						</form>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="clearfix"> </div>
			</div>
    	</div>
    </div>
</div>
    
<!-- -------------------------------------End Header------------------------------------------ -->