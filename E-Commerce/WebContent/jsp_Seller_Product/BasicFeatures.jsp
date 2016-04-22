<%@page import="ecom.model.product.features.MobileFeatures"%>
<%@page import="ecom.model.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    

<%

	/***********  EditProductServlet  /MobileEdit  **************/

	Long sellerId              = (Long)        session.getAttribute("sellerId");   
	Long productId             = (Long)        session.getAttribute("productId");
	ProductBean productBean    = (ProductBean) request.getAttribute("productBean");	
	
%>
<br>
	<div id="radio">		
		<span style="float: left;display: block; margin-right: 30px;"><input type="radio" name="choose" id="basic" class="change" checked /><label for="basic">&nbsp;Basic Features</label> </span> &nbsp;&nbsp;&nbsp;&nbsp;
		<span style="float: left;display: block; margin-right: 30px;"> <input type="radio" name="choose" id="advance" class="change" /><label for="advance">&nbsp;Advance Features</label> </span> &nbsp;&nbsp;&nbsp;&nbsp;
		<div id="radio3" style="display: none; float: left; ">
			<input type="radio" name="choose" id="size" class="change" /><label for="size">&nbsp;Size Of Product</label>
		</div>
	</div>
	
	<div id="msg1" style="color:red;"></div>
	
	
<section id="1">
	
	<div id="visible">
	
	
		<div id="basicFeatures" style="width:100%;float:left;">
		
			<form method="post" id="form1"> 
			
				<input type="hidden" name="productId" value="<%=productId%>" />
				<input type="hidden" name="sellerId" value="<%=sellerId%>" />
				<h3>Basic Features</h3>
				
				<div class="row">					
					<div class="col-md-3 col-sm-6 col-xs-12">
						<label>	Category </label>
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<input type="text" name="category" readonly class="form-control" value="<%=productBean.getCategory() %>" />
					</div>						
					<div class="col-md-3 col-sm-6 col-xs-12">
						<label>	Sub Category </label>
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<input type="text" name="subCategory" class="form-control" readonly value="<%=productBean.getSubCategory() %>" />
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-3 col-sm-6 col-xs-12">
						<label> <span style="color:red;">*</span> Company Name </label>
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<input type="text" name="companyOfTheProduct" required class="form-control" value="<%=productBean.getCompanyName() %>" />
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<label>  <span style="color:red;">*</span> Product Name </label>
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">		
						<input type="text" name="productName" class="form-control" required value="<%=productBean.getProductName() %>" />
					</div>					
				</div>	
				
				<hr> <!-- --------------------------------------------------------------------------------------------- -->
				<br>					
				<div class="row">
			    	<div class="col-md-3 col-sm-6 col-xs-12">
						<label> Key Feature 1 </label>
			   		</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<input type="text" class="form-control" name="kf1" value="<%=productBean.getKeyFeatures().getKf1() %>" />			
					</div>	
					<div class="col-md-3 col-sm-6 col-xs-12">
			 			<label>  Key Feature 2 </label>
					</div>
			  		<div class="col-md-3 col-sm-6 col-xs-12"> 
			  			<input type="text" class="form-control" name="kf2" value="<%=productBean.getKeyFeatures().getKf2() %>" />				
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-3 col-sm-6 col-xs-12"> 
						<label> Key Feature 3 </label>
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12"> 
						<input type="text" class="form-control" name="kf3" value="<%=productBean.getKeyFeatures().getKf3() %>" />
					</div>			
					<div class="col-md-3 col-sm-6 col-xs-12"> 
						<label>   Key Feature 4 </label>
			  		</div>
					<div class="col-md-3 col-sm-6 col-xs-12"> 
						<input type="text" class="form-control" name="kf4" value="<%=productBean.getKeyFeatures().getKf4() %>" />
					</div>						
				</div>
				
				<hr> <!-- --------------------------------------------------------------------------------------------- -->
				<br>
				
				<div class="row">
					<div class="col-md-3 col-sm-6 col-xs-12">
						<label>	<span style="color:red;">*</span> Manufacturing Cost </label>
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<input type="text" name="manufacturingCost" id="manufacturingCost1" class="form-control" required value="<%=productBean.getPrice().getManufacturingCost() %>" />
					</div>
					
					<div class="col-md-3 col-sm-6 col-xs-12">
						<label><span style="color:red;">*</span> Profit Margin % </label>
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<input type="text" name="profitMarginPercentage" id="profitMarginPercentage1" class="form-control" required value="<%=productBean.getPrice().getProfitMarginPercentage() %>"/>
					</div> 
				</div>		
				
				
				<div class="row">
					<div class="col-md-3 col-sm-6 col-xs-12">
						<label>	Sale Price To Admin </label>
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<input type="text" name="salePriceToAdmin" id="salePriceToAdmin1" class="form-control" readonly value="<%=productBean.getPrice().getSalePriceToAdmin() %>" />
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<label>Profit Margin </label>
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<input type="text" name="profitMargin1" id="profitMargin1" class="form-control" readonly value=""/>
					</div> 
				</div>	
				
				<div class="row">
					<div class="col-md-3 col-sm-6 col-xs-12">
						<label>	Sale Price To Customer </label>
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<input type="text" name="salePriceToCustomer" id="salePriceToCustomer1" class="form-control" readonly value="<%=productBean.getPrice().getSalePriceCustomer() %>" />
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<label>Markup % </label>
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<input type="text" name="markupPercentage" id="markupPercentage1" class="form-control" readonly value="<%=productBean.getPrice().getMarkup() %>"/>
					</div> 
				</div>	
				
				
				<div class="row">
					<div class="col-md-3 col-sm-6 col-xs-12">
						<label> <span style="color:red;">*</span> List Price </label>
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<input type="text" name="listPrice" id="listPrice1" class="form-control" required value="<%=productBean.getPrice().getListPrice() %>" />
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<label> Discount %</label>
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<input type="text" name="discount" id="discount1" class="form-control" required readonly value="<%=productBean.getPrice().getDiscount() %>"/>
					</div>					
				</div>
				
						
				
				<hr>	<!-- ----------------------------------------------------------------------------------- -->	
				<br>
				<div class="row">				
					<div class="col-md-3 col-sm-6 col-xs-12">
						<label><span style="color:red;">*</span> Stock </label>
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<input type="text" name="stock" class="form-control" required placeholder="50" value="<%=productBean.getStock() %>"/>
					</div> 
					<div class="col-md-3 col-sm-6 col-xs-12">
						<label><span style="color:red;">*</span> Weight In KG</label>
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<input type="text" name="weight" class="form-control" required placeholder="0.2" value="<%=productBean.getWeight() %>" />
					</div> 
				</div>			
							
				<div class="row">
					<div class="col-md-3 col-sm-6 col-xs-12">
						<label>	<span style="color:red;">*</span> Warranty </label>
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<input type="text" name="warranty" class="form-control" required placeholder="1 year warranty" value="<%=productBean.getWarranty() %>"/>
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<label>	<span style="color:red;">*</span> Cancellation Period In DAYS</label>
					</div>
					<div class="col-md-3 col-sm-6 col-xs-12">
						<input type="text" name="cancellationPeriod" class="form-control" required placeholder="7" value="<%=productBean.getCancellationAfterBooked() %>" />
					</div>				
				</div>
								
							
				<hr>	<!-- ----------------------------------------------------------------------------------- -->		
				<br>	
				<div class="row">
					<div class="col-md-12 col-sm-6 col-xs-12"> 
						<input type="submit" value="Submit" style="padding: 7px 28px;background:linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5);border: 1px solid #0098fe; color: #ffffff; float: right;" />
					</div>						
				</div>					
					
			</form>
			<br>
			
			<div class="row">
				<div class="col-md-4 col-sm-6 col-xs-12">
					<form method="post" enctype="multipart/form-data" id="iconImage">	
						<input type="hidden" id="img1" value="<%=productBean.getProductId() %>" />	
						<label>	Icon Image </label>
						<input type="file" name="iconImage" required />						
						<br>
						<input type="hidden" name="productId" value="<%=productId%>" />
						<input type="hidden" name="sellerId" value="<%=sellerId%>" />
						<input type="submit" value="Change" />	
						<br>				
						<div id="img2" style="margin-top: 10px;">
							<img alt="image" src="IconImageFromProduct?productId=<%=productBean.getProductId() %>" width="70" height="70" id="showIconImage"/>
						</div>			
					</form>
				</div>
				
				<div class="col-md-4 col-sm-6 col-xs-12">
					<form method="post" enctype="multipart/form-data" id="image1">	
						<input type="hidden" id="img3" value="<%=productBean.getProductId() %>" />					
						<label> Image1 </label>
						<input type="file" name="image1" required /> <br>
						<input type="hidden" name="productId" value="<%=productId%>" />
						<input type="hidden" name="sellerId" value="<%=sellerId%>" />
						<input type="submit" value="Change" />
						<br>					
						<div id="img4" style="margin-top: 10px;">
							<img alt="image" src="Image1FromProduct?productId=<%=productBean.getProductId() %>" width="70" height="70" id="showImage1"/>
						</div>			
					</form>
				</div>
			
				<div class="col-md-4 col-sm-6 col-xs-12">
					<form method="post" enctype="multipart/form-data" id="image2">	
						<input type="hidden" id="img5" value="<%=productBean.getProductId() %>" />		
						<label>Image2</label>
						<input type="file" name="image2" required /> <br>
						<input type="hidden" name="productId" value="<%=productId%>" />
						<input type="hidden" name="sellerId" value="<%=sellerId%>" />
						<input type="submit" value="Change" />		 
						<br>		
						<div id="img6" style="margin-top: 10px;">
							<img alt="image" src="Image2FromProduct?productId=<%=productBean.getProductId() %>" width="70" height="70" id="showImage2"/>
						</div>				
					</form>
				</div>
			
			</div>
			
		</div>
		
	</div>
	
</section>