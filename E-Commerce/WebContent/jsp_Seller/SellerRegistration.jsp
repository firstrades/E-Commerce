<%@page import="ecom.common.FrequentUse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Seller Registration Page</title>
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


			<div class="tag_pannel"> <h1> SELLER REGISTRATION </h1> </div>
			<hr>
			
			
		<form>
			
			<!-- ----------------------- Main Data ------------------------------------------ -->

			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label> *User Id  </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="user_id" class="form-control"  placeholder="User Id" required />
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>	*Password </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="password" name="password" class="form-control" placeholder="Password" required  />
				</div>
			</div>	
			
			
			
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label> *First Name </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="first_name" class="form-control"  placeholder="Enter First Name" required />
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>	*Last Name </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="last_name" class="form-control" placeholder="Enter Last Name"  required  />
				</div>
			</div>		


			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label> *Gender </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<select name="sex" id="sex" class="form-control" >
						<option value="null">---Select Sex---</option>
						<option value="Male">Male</option>
						<option value="Female">Female</option>
					</select>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>	*Company  </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="company" class="form-control" placeholder="Enter Company Name"  required  />
				</div>
			</div>	


			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label> *Mobile Number 1 </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="mobile1" class="form-control"  placeholder="Enter Mobile Number 1" required />
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>	Mobile Number 2 </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="mobile2" class="form-control" placeholder="Enter Mobile Number 2"  />
				</div>
			</div>	



			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label> *E-mail 1 </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="email1" class="form-control"  placeholder="Enter E-mail Id 1" required />
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>	E-mail 2 </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="email2" class="form-control" placeholder="Enter E-mail Id 2"   />
				</div>
			</div>	
			
			
			
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label> *Landphone 1 </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="landphone1" class="form-control" placeholder="Enter Landphone Number 1" required />
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>	Landphone 2 </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="landphone2" class="form-control" placeholder="Enter Landphone Number 2"  />
				</div>
			</div>	
			
			
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label> Fax 1 </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="fax1" class="form-control" placeholder="Enter Fax  Number 1"  />
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>	Fax 2 </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="fax2" class="form-control" placeholder="Enter Fax Number 2"  />
				</div>
			</div>			
			
			
			
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>*Address Line 1 </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="address1" class="form-control"  placeholder="Enter Address 1" required />
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>	Address Line 2 </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="address2" class="form-control" placeholder="Enter Address 2"  />
				</div>
			</div>	
			
			
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>*City </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="city" class="form-control"  placeholder="Enter City" required />
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label> *State </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<select name="state1" id="state1" class="form-control" required  >
						<option value="null">---Select State---</option>
						
						
<option value="AN">Andaman and Nicobar Islands</option>

<option value="AP">Andhra Pradesh</option>

<option value="AR">Arunachal Pradesh</option>

<option value="AS">Assam</option>

<option value="BR">Bihar</option>

<option value="CH">Chandigarh</option>

<option value="CG">Chhattisgarh</option>

<option value="DH">Dadra and Nagar Haveli</option>

<option value="DD">Daman and Diu</option>

<option value="DL">Delhi</option>

<option value="GA">Goa</option>

<option value="GJ">Gujarat</option>

<option value="HR">Haryana</option>

<option value="HP">Himachal Pradesh</option>

<option value="JK">Jammu And Kashmir</option>

<option value="JH">Jharkhand</option>

<option value="KA">Karnataka</option>

<option value="KL">Kerala</option>

<option value="LD">Lakshadweep</option>

<option value="MP">Madhya Pradesh</option>

<option value="MH">Maharashtra</option>

<option value="MN">Manipur</option>

<option value="ML">Meghalaya</option>

<option value="MZ">Mizoram</option>

<option value="NL">Nagaland</option>

<option value="OR">Orissa</option>

<option value="PY">Pondicherry</option>

<option value="PB">Punjab</option>

<option value="RJ">Rajasthan</option>

<option value="SK">Sikkim</option>

<option value="TN">Tamilnadu</option>

<option value="TR">Tripura</option>

<option value="UK">Uttarakhand (Uttaranchal)</option>

<option value="UP">Uttar Pradesh</option>

<option value="WB">West Bengal</option>


					</select>
				</div>
			</div>	
			
			
			
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>*Pin </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="pin" class="form-control"  placeholder="Enter Pin" required />
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
					<label> Pan card </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="pancard" class="form-control"  placeholder="Enter Pan card"  />
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>	Voter id </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="voterId" class="form-control" placeholder="Enter Voter id"   />
				</div>
			</div>	
			
			
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>Demo----  </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="" class="form-control"  placeholder="Demo"  />
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>	Demo----</label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="" class="form-control" placeholder="Demo"   />
				</div>
			</div>	
			
			
			
			
			
			<!-- ------------------------------- End Main Data ------------------------------------------ -->
			
			
			
			
			
			
			
			
			
			<!-- ----------------------- CheckBox for Aux Data ------------------------------------------ -->
			
				<div class="row">
			
				<div class="col-md-12 col-sm-6 col-xs-12" style="font-size: 17px;color: #00405d;font-weight: bold;margin-bottom: 34px;margin-top: 16px;">
					<input type="checkbox" name="checkbox" id="checkbox" value="1" style="width: 18px; height: 19px;"> 
					&nbsp; Tick This Box, If Product Pickup Address Is Different
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
							<input type="text" name="first_name2" class="form-control" placeholder="Enter First Name" required />
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label>	*Last Name</label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="last_name2" class="form-control" placeholder="Enter Last Name"  required  />
						</div>
					</div>	
					
					
					
					<div class="row">
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label>*Company  </label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="company2" class="form-control"  placeholder="Enter Company Name" required />
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label>	*Mobile Number</label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="mobile3" class="form-control" placeholder="Enter Mobile Number"  required />
						</div>
					</div>	
					
					
					
					<div class="row">
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label>*Address Line 1 </label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="address3" class="form-control"  placeholder="Enter Address 1" required />
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label>	Address Line 2</label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="address4" class="form-control" placeholder="Enter Address 2"   />
						</div>
					</div>	
					
					
					
					<div class="row">
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label>*City  </label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="city2" class="form-control"  placeholder="Enter City" required />
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label>	*Pin</label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="pin2" class="form-control" placeholder="Enter Pin"  required  />
						</div>
					</div>	
					
					
					
					<div class="row">
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label> *State </label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<select name="state2" id="state2" class="form-control" >
								<option value="null">---Select State---</option>
								
								
<option value="AN">Andaman and Nicobar Islands</option>

<option value="AP">Andhra Pradesh</option>

<option value="AR">Arunachal Pradesh</option>

<option value="AS">Assam</option>

<option value="BR">Bihar</option>

<option value="CH">Chandigarh</option>

<option value="CG">Chhattisgarh</option>

<option value="DH">Dadra and Nagar Haveli</option>

<option value="DD">Daman and Diu</option>

<option value="DL">Delhi</option>

<option value="GA">Goa</option>

<option value="GJ">Gujarat</option>

<option value="HR">Haryana</option>

<option value="HP">Himachal Pradesh</option>

<option value="JK">Jammu And Kashmir</option>

<option value="JH">Jharkhand</option>

<option value="KA">Karnataka</option>

<option value="KL">Kerala</option>

<option value="LD">Lakshadweep</option>

<option value="MP">Madhya Pradesh</option>

<option value="MH">Maharashtra</option>

<option value="MN">Manipur</option>

<option value="ML">Meghalaya</option>

<option value="MZ">Mizoram</option>

<option value="NL">Nagaland</option>

<option value="OR">Orissa</option>

<option value="PY">Pondicherry</option>

<option value="PB">Punjab</option>

<option value="RJ">Rajasthan</option>

<option value="SK">Sikkim</option>

<option value="TN">Tamilnadu</option>

<option value="TR">Tripura</option>

<option value="UK">Uttarakhand (Uttaranchal)</option>

<option value="UP">Uttar Pradesh</option>

<option value="WB">West Bengal</option>


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
							<label>*Email  </label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="email3" class="form-control"  placeholder="Enter E-mail Id" required />
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<label>	Demo----</label>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-12">
							<input type="text" name="" class="form-control" placeholder="Demo"  />
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
			
			
			<!-- ---------------------------------- Message -------------------------------------------------- -->
			
			<div id="message" style="margin-top: -44px; margin-bottom: 38px;
				margin-right: 535px;float: right;font-size: 30px;color: red;">
				Your Request Has Been Sent For Approval
			</div>
			<br>
			
			<div id="id" style="margin-top: -44px;
				margin-right: 535px;float: right;font-size: 30px;color: red;">
				Your Id is 123
			</div>
			<!-- ---------------------------------- End Message -------------------------------------------------- -->
			
			
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
