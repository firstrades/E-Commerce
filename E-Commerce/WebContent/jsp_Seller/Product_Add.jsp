<%@page import="ecom.common.FrequentUse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
<script type="text/javascript" src="<%=FrequentUse.jQuery %>"></script>
<script type="text/javascript" src="js_Seller/Product_Add.js"></script>
<link type="text/css" href="css/bootstrap.css" rel="stylesheet">
<script type="text/javascript">

</script>
<style type="text/css">

.row {
    margin-left:0px !important;
    margin-right:0px !important;
    margin-bottom: 16px;
}
label{
font-weight: normal !important; 
color:#337AB7;
}
hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
}
</style>
</head>

<body>
<section>


		<form method="post" enctype="multipart/form-data" id="data"> 
		
			<h3 style="font-size: 25px; color:#337AB7;">Add New Product</h3>  
			<div id="msg" style="color:red;"></div>
			<hr>
			<!-- -------------------------------------------------- -->
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label><span> <span style="color:red;">*</span> Category </span></label>
			   	</div>
			   	<div class="col-md-3 col-sm-6 col-xs-12">
					<select name="category" id="category" class="form-control">
						<option value="null">---category---</option>
						<option value="ELECTRONICS">ELECTRONICS</option>
						<option value="MEN">MEN</option>
						<option value="WOMEN">WOMEN</option>
						<option value="KIDS">KIDS</option>
					</select>
				</div>				
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label> <span style="color:red;">*</span> Sub Category </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<select name="subCategory" id="subCategory" class="form-control">
						<option value="null">--sub category--</option>								
					</select>						
				</div>
			</div>
			<!-- -------------------------------------------------- -->
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label><span style="color:red;">*</span> Company Name </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="company" class="form-control" required placeholder="Samsung" value="Pantaloons" />
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>	<span style="color:red;">*</span> Product Name </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="product" class="form-control" required placeholder="Galaxy S4" value="Naughty Ninos Printed Boy's Polo Neck T-Shirt" />
				</div>
			</div>	
			
			<hr>	<!-- ----------------------------------------------------------------------------------- -->
								
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>	Key Feature 1 </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="kf1" class="form-control" placeholder="Key Feature" value="Half Sleeve" />
				</div>	
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label> Key Feature 2 </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="kf2" class="form-control" placeholder="Key Feature" value="Cotton" />
				</div>			
			</div>	
					
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12"> 
					<label> Key Feature 3  </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12"> 
					<input type="text" name="kf3" class="form-control" placeholder="Key Feature" value="Polo Neck" /></div>			
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label> Key Feature 4 </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="kf4" class="form-control" placeholder="Key Feature" value="Printed" />
				</div>			
			</div>			
			
			<hr>	<!-- ----------------------------------------------------------------------------------- -->
			
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>	<span style="color:red;">*</span> Manufacturing Cost </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="manufacturingCost" id="manufacturingCost" class="form-control" required value="1700" />
				</div>
				
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label><span style="color:red;">*</span> Profit Margin % </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="profitMarginPercentage" id="profitMarginPercentage" class="form-control" required value="5"/>
				</div> 
			</div>		
			
			
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>	Sale Price To Admin </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="salePriceToAdmin" id="salePriceToAdmin" class="form-control" readonly value="105" />
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>Profit Margin </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="profitMargin" id="profitMargin" class="form-control" readonly value="5"/>
				</div> 
			</div>	
			
			
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label> <span style="color:red;">*</span> List Price </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="listPrice" id="ListPrice" class="form-control" required value="1000" />
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label> Discount %</label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="discount" id="discount" class="form-control" required readonly value="89.5"/>
				</div>					
			</div>
			
					
			
			<hr>	<!-- ----------------------------------------------------------------------------------- -->	
			
			<div class="row">				
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label><span style="color:red;">*</span> Stock </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="stock" class="form-control" required placeholder="50" value="500"/>
				</div> 
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label><span style="color:red;">*</span> Weight In KG</label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="weight" class="form-control" required placeholder="0.2" value="0.3" />
				</div> 
			</div>			
						
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>	<span style="color:red;">*</span> Warranty </label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="warranty" class="form-control" required placeholder="1 year warranty is applicable" value="1 year warranty is applicable"/>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label>	<span style="color:red;">*</span> Cancellation Period In DAYS</label>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="text" name="cancellationPeriod" class="form-control" required placeholder="7" value="7" />
				</div>				
			</div>
							
						
			<hr>	<!-- ----------------------------------------------------------------------------------- -->
					
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label><span style="color:red;">*</span> Icon Image </label>				
					<input type="file" name="iconImage" required />
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label> <span style="color:red;">*</span> Image 1 </label>
					<input type="file" name="image1" required />
				</div>			
				<div class="col-md-3 col-sm-6 col-xs-12">
					<label><span style="color:red;">*</span> Image 2 </label>					
					<input type="file" name="image2" required />
				</div>				
					
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input type="submit" value="Submit" 
						style="width: 50% !important;  padding: 7px 1px;background:linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5);border: 1px solid #0098fe;color:#ffffff;margin-top:18px;" />
				</div>
			</div>			
				
		</form>
	</section>
</body>
</html>

