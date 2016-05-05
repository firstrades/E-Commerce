<%@page import="ecom.model.Clothings"%>
<%@page import="ecom.model.Size"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<%  

	Long sellerId1    = (Long)      session.getAttribute("sellerId");   
	Long productId1   = (Long)      session.getAttribute("productId");
	 
	Clothings size    = (Clothings) request.getAttribute("sizeInfo");   
	
%>    
    
    
<section id="3">	
	
	<div id="invisible2" style="display:none;">
	
		<div id="sizeFeatures" style="width:100%;">
		
			<form method="post" enctype="multipart/form-data" id="form11"> 
			
				<input type="hidden" name="productId" value="<%=productId1%>" />
				<input type="hidden" name="sellerId" value="<%=sellerId1%>" /> 
				<h3>Size Features</h3>
					
					<div class="row" style="margin-top: 15px;">						
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Year 1-2</label>
							<% if (size == null) { %>
							<input type="text" class="form-control" name="year_1_2" required placeholder="1" style="width: 40%;"/>
							<% } else { %>
							<input type="text" class="form-control" name="year_1_2" required value="<%=size.getStockOfSIZE_1_2() %>" style="width: 40%;"/>
							<% } %>
						</div>
						
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Year 2-3</label>
							<% if (size == null) { %>
							<input type="text" class="form-control" name="year_2_3" required placeholder="1" style="width: 40%;"/>
							<% } else { %>
							<input type="text" class="form-control" name="year_2_3" required value="<%=size.getStockOfSIZE_2_3() %>" style="width: 40%;"/>
							<% } %>
						</div>
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Year 3-4</label>
							<% if (size == null) { %>
							<input type="text" class="form-control" name="year_3_4" required placeholder="1" style="width: 40%;"/>
							<% } else { %>
							<input type="text" class="form-control" name="year_3_4" required value="<%=size.getStockOfSIZE_3_4() %>" style="width: 40%;"/>
							<% } %>
						</div>
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Year 4-5</label>
							<% if (size == null) { %>
							<input type="text" class="form-control" name="year_4_5" required placeholder="1" style="width: 40%;"/>
							<% } else { %>
							<input type="text" class="form-control" name="year_4_5" required value="<%=size.getStockOfSIZE_4_5() %>" style="width: 40%;"/>
							<% } %>
						</div>
				
					</div>	
					
					
					
					
					<div class="row" style="margin-top: 15px;">
					
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Year 5-6</label>
							<% if (size == null) { %>
							<input type="text" class="form-control" name="year_5_6" required placeholder="1" style="width: 40%;"/>
							<% } else { %>
							<input type="text" class="form-control" name="year_5_6" required value="<%=size.getStockOfSIZE_5_6() %>" style="width: 40%;"/>
							<% } %>
						</div>
						
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Year 6-7</label>
							<% if (size == null) { %>
							<input type="text" class="form-control" name="year_6_7" required placeholder="1" style="width: 40%;"/>
							<% } else { %>
							<input type="text" class="form-control" name="year_6_7" required value="<%=size.getStockOfSIZE_6_7() %>" style="width: 40%;"/>
							<% } %>
						</div>
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Year 7-8</label>
							<% if (size == null) { %>
							<input type="text" class="form-control" name="year_7_8" required placeholder="1" style="width: 40%;"/>
							<% } else { %>
							<input type="text" class="form-control" name="year_7_8" required value="<%=size.getStockOfSIZE_7_8() %>" style="width: 40%;"/>
							<% } %>
						</div>
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Year 8-9</label>
							<% if (size == null) { %>
							<input type="text" class="form-control" name="year_8_9" required placeholder="1" style="width: 40%;"/>
							<% } else { %>
							<input type="text" class="form-control" name="year_8_9" required value="<%=size.getStockOfSIZE_8_9() %>" style="width: 40%;"/>
							<% } %>
						</div>
				
					</div>	
					
					
					
					<div class="row" style="margin-top: 15px;">
					
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Year 9-10</label>
							<% if (size == null) { %>
							<input type="text" class="form-control" name="year_9_10" required placeholder="1" style="width: 40%;"/>
							<% } else { %>
							<input type="text" class="form-control" name="year_9_10" required value="<%=size.getStockOfSIZE_9_10() %>" style="width: 40%;"/>
							<% } %>
						</div>
						
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Year 10-11</label>
							<% if (size == null) { %>
							<input type="text" class="form-control" name="year_10_11" required placeholder="1" style="width: 40%;"/>
							<% } else { %>
							<input type="text" class="form-control" name="year_10_11" required value="<%=size.getStockOfSIZE_10_11() %>" style="width: 40%;"/>
							<% } %>
						</div>
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Year 11-12</label>
							<% if (size == null) { %>
							<input type="text" class="form-control" name="year_11_12" required placeholder="1" style="width: 40%;"/>
							<% } else { %>
							<input type="text" class="form-control" name="year_11_12" required value="<%=size.getStockOfSIZE_11_12() %>" style="width: 40%;"/>
							<% } %>
						</div>
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Size 11</label>
							<input type="text" class="form-control" name="" required readonly="readonly" value="1" style="width: 40%;"/>
						</div>
				
					</div>	
					


					
					<div class="row" style="margin-top: 15px;">
					
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Size 11</label>
							<input type="text" class="form-control" name="" required readonly="readonly" value="1" style="width: 40%;"/>
						</div>
						
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Size 11</label>
							<input type="text" class="form-control" name="" required readonly="readonly" value="1" style="width: 40%;"/>
						</div>
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Size 11</label>
							<input type="text" class="form-control" name="" required readonly="readonly" value="1" style="width: 40%;"/>
						</div>
						
						<div class="col-md-2 col-sm-6 col-xs-12"> 
							<label style="float: left;margin-right: 10px;margin-top: 6px;font-size: 16px;">	Size 11</label>
							<input type="text" class="form-control" name="" required readonly="readonly" value="1" style="width: 40%;"/>
						</div>
				
					</div>									
					
					<div class="row">
					
						<div class="col-md-8 col-sm-6 col-xs-12">
							<input type="submit" value="Submit" style=" padding: 7px 14px;background:linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5);border: 1px solid #0098fe;color:#ffffff; float: right; margin-right: 63px; margin-top: 17px;" />
						</div>
					</div>
					
			</form>	
        
		</div>
	</div>	

</section>    