<%@page import="ecom.common.FrequentUse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Customer Registration Page</title>
	<script type="text/javascript" src="<%=FrequentUse.angular %>"></script>	
	<script type="text/javascript" src="<%=FrequentUse.jQuery %>"></script>
	<link href="<%=FrequentUse.style %>" rel='stylesheet' type='text/css' />
	<link type="text/css" href="css/bootstrap.css" rel="stylesheet">
	
	<style type="text/css">
		.row {
		    padding: 5px 23px;
		}
		hr {
		    margin-top: 20px;
		    margin-bottom: 20px;
		    border: 0;
		    border-top: 1px solid #e5e5e5;c;
		}
		label {
		    display: inline-block;
		    margin-bottom: 5px;
		    font-weight: bold;
		    color: #8B2498;
		}
		html,body {
			background-color: #f5f5f5 !important;
		}
	</style>
</head>
<body >

<div class="register_pannel">

		<div class="logo_pannel">
		 	<a href="index.html"> <img src="images/logoFirstTrade.png" /> </a>
		</div>

		<div class="register_page">


			<div class="tag_pannel"> <h1> CUSTOMER REGISTRATION </h1> </div>
			<hr>
			
			
		<form>
			
			<!-- ----------------------- Main Data ------------------------------------------ -->

			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label> *User Id  </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="company" class="form-control"  placeholder="User Id" required />
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>	*Password </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="password" name="product" class="form-control" placeholder="Password" required  />
				</div>
			</div>	
			
			
			
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label> *First name </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="company" class="form-control"  placeholder="Enter First Name" required />
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>	*Last Name </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="product" class="form-control" placeholder="Enter Last Name"  required  />
				</div>
			</div>		


			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label> *Sex </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<select name="category" id="category" class="form-control" >
						<option value="null">---Select Sex---</option>
						<option value="Male">Male</option>
						<option value="Female">Female</option>
					</select>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label> Company </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<select name="company1" id="company1" class="form-control" >								
						<option value="Individual">Individual</option>								
					</select>
				</div>
			</div>	


			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label> *Mobile Number1 </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="company" class="form-control"  placeholder="Enter Mobile Number" required />
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>	Mobile Number2 </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="product" class="form-control" placeholder="Enter Last Name"  />
				</div>
			</div>	



			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label> *E-mail Id1 </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="company" class="form-control"  placeholder="Enter E-mail Id1" required />
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>	E-mail Id2</label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="product" class="form-control" placeholder="Enter E-mail Id2"   />
				</div>
			</div>	
			
			
			
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>*Address Line 1 </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="company" class="form-control"  placeholder="Enter Address" required />
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>	Address Line 2</label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="product" class="form-control" placeholder="Enter City Name"   />
				</div>
			</div>	
			
			
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>*City </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="company" class="form-control"  placeholder="Enter State" required />
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label> *State </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<select name="state1" id="state1" class="form-control" >
						<option value="null">---Select Sex---</option>
						<option value="Male">West Bengal</option>
						<option value="Female">Female</option>
					</select>
				</div>
			</div>	
			
			
			
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>*Pin </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="company" class="form-control"  placeholder="Enter Pan card" required />
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label> Country </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<select name="country1" id="country1" class="form-control" >								
						<option value="IN">India</option>								
					</select>
				</div>
			</div>			
			
			
			
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>Demo----  </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="" class="form-control"  placeholder="Enter Pan card"  />
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>	Demo----</label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="" class="form-control" placeholder="Enter Voter id"   />
				</div>
			</div>	
			
			
			
			
			<!-- ------------------------------- End Main Data ------------------------------------------ -->
			
			
			
			
			
			
			
			
			
			<!-- ----------------------- CheckBox for Aux Data ------------------------------------------ -->
			
				<div class="row">
			
				<div class="col-md-12 col-sm-6 col-xs-12" style="font-size: 17px;color: #00405d;font-weight: bold;margin-bottom: 34px;margin-top: 16px;">
					<input type="checkbox" name="checkbox" id="checkbox" value="1" style="width: 18px; height: 19px;"> 
					&nbsp; Tick this Box, if Product Delivery Address is different
				</div>
				
			</div>	
			
			<!-- ----------------------- End CheckBox for Aux Data ------------------------------------------ -->
			
			
			
			
			
			
			
			
			
			
			<!-- ---------------------------------- Aux Data -------------------------------------------------- -->
			
			<div id="aux" style="display: none;">
			
					<div class="row">
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label>*First Name  </label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="company" class="form-control" placeholder="Enter Pan card" required />
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label>	*Last Name</label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="product" class="form-control" placeholder="Enter Voter id"  required  />
						</div>
					</div>	
					
					
					
					<div class="row">
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label> Company </label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<select name="company2" id="company2" class="form-control" >								
								<option value="Individual">Individual</option>								
							</select>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label>	*Contact</label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="product" class="form-control" placeholder="Enter Voter id"  required />
						</div>
					</div>	
					
					
					
					<div class="row">
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label>*Address Line 1 </label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="company" class="form-control"  placeholder="Enter Pan card" required />
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label>	Address Line 2</label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="product" class="form-control" placeholder="Enter Voter id"   />
						</div>
					</div>	
					
					
					
					<div class="row">
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label>*City  </label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="company" class="form-control"  placeholder="Enter Pan card" required />
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label>	*Pin</label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="product" class="form-control" placeholder="Enter Voter id"  required  />
						</div>
					</div>	
					
					
					
					<div class="row">
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label> *State </label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<select name="state2" id="state2" class="form-control" >
								<option value="null">---Select Sex---</option>
								<option value="Male">West Bengal</option>
								<option value="Female">Female</option>
							</select>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label> Country </label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<select name="country2" id="country2" class="form-control" >								
								<option value="IN">India</option>								
							</select>
						</div>
					</div>	
					
					
					<div class="row">
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label>*Contact  </label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="company" class="form-control"  placeholder="Enter Pan card" required />
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label>	Demo----</label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="product" class="form-control" placeholder="Enter Voter id"  required  />
						</div>
					</div>	
					
					
					
					
			</div>
			
			<!-- ---------------------------------- End Aux Data -------------------------------------------------- -->
			
			
			
			<!-- ---------------------------------- Submit -------------------------------------------------- -->
			
			
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12" style="float: left;">
					<span style="color: red;margin-top:41px; display: block;" id="message"><!-- message --></span>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12" style="float: right;">
					<input type="submit" value="Submit" 
						style="width: 64% !important;padding: 5px 1px;background:linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5);
						border: 1px solid #0098fe;color:#ffffff;margin-top:25px; margin-left:98px; font-size: 20px; margin-bottom: 15px;" 
						/>
				</div>
			</div>
			
			<!-- ---------------------------------- End Submit -------------------------------------------------- -->
			
		</form>
			
			
			
			
		</div>  <!-- register_page -->


</div>  <!-- register_pannel -->


</body>  <!-- CreateEditUserController -->

<script type="text/javascript">
$(function() {
	$('#checkbox').change(function() {
		
		var display = $('#aux').css('display');  
		
		if (display == 'none')
			$('#aux').css('display', 'block'); 
		else
			$('#aux').css('display', 'none'); 
	})
});
</script>
</html>
