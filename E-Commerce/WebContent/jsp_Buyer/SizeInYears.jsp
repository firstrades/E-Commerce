<%@page import="ecom.model.SizeInYears"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
   <%
    
    	SizeInYears sizeInYears = (SizeInYears) request.getAttribute("sizeInYears"  );
    
	    boolean isSizeInYearsExists = sizeInYears.isProductIdExists() == true;
		boolean isYear_1_2Exists   = sizeInYears.getStockOfSIZE_1_2()   != 0;
		boolean isYear_2_3Exists   = sizeInYears.getStockOfSIZE_2_3()   != 0;
		boolean isYear_3_4Exists   = sizeInYears.getStockOfSIZE_3_4()   != 0;
		boolean isYear_4_5Exists   = sizeInYears.getStockOfSIZE_4_5()   != 0;
		boolean isYear_5_6Exists   = sizeInYears.getStockOfSIZE_5_6()   != 0;
		boolean isYear_6_7Exists   = sizeInYears.getStockOfSIZE_6_7()   != 0;
		boolean isYear_7_8Exists   = sizeInYears.getStockOfSIZE_7_8()   != 0;
		boolean isYear_8_9Exists   = sizeInYears.getStockOfSIZE_8_9()   != 0;
		boolean isYear_9_10Exists  = sizeInYears.getStockOfSIZE_9_10()  != 0;
		boolean isYear_10_11Exists = sizeInYears.getStockOfSIZE_10_11() != 0;
		boolean isYear_11_12Exists = sizeInYears.getStockOfSIZE_11_12() != 0;
		
    %>
    
    
    
    
   
	          	    	
	   
	   <%	   
	   		if (isSizeInYearsExists) {  // main if   		
	   
	   %>
	   
	         <!--     text-decoration: line-through;--> 	    	
	        <div class="multiSelectionWidget unit size1of2" id="sizeBlock" style="display: block;">
				<div class="multiSelectionWidget-title">Select Size</div>			
				<div class="multiSelectionWidget-selectors-wrap">
				
				
				<%  if (isYear_1_2Exists) {      %>
					<a class="multiSelectionWidget-selector-link"  data-ng-click="selectSize('Year 1-2', this);">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color26">
							<div class="selector-boxes">
								<span id="26" class="size">Year 1-2</span>
							</div>
						</div>
					</a>
				<%  } else { %>
					<a class="multiSelectionWidget-selector-link">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color26">
							<div class="selector-boxes">
								<span id="26" class="size" style="text-decoration: line-through;">Year 1-2</span>
							</div>
						</div>
					</a>
				<%  } %>
				
				
				<%  if (isYear_2_3Exists) {      %>
					<a class="multiSelectionWidget-selector-link"  data-ng-click="selectSize('Year 2-3', this);">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color28">
							<div class="selector-boxes">
								<span id="28" class="size">Year 2-3</span>
							</div>
						</div>
					</a>
				<%  } else { %>
					<a class="multiSelectionWidget-selector-link">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color28">
							<div class="selector-boxes">
								<span id="28" class="size" style="text-decoration: line-through;">28Year 2-3span>
							</div>
						</div>
					</a>
				<%  } %>
				
				
				<%  if (isYear_3_4Exists) {      %>
					<a class="multiSelectionWidget-selector-link"  data-ng-click="selectSize('Year 3-4', this);">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color30">
							<div class="selector-boxes">
								<span id="30" class="size">Year 3-4</span>
							</div>
						</div>
					</a>
				<%  } else { %>
					<a class="multiSelectionWidget-selector-link">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color30">
							<div class="selector-boxes">
								<span id="30" class="size" style="text-decoration: line-through;">Year 3-4</span>
							</div>
						</div>
					</a>
				<%  } %>
					
					
				<%  if (isYear_4_5Exists) {      %>
					<a class="multiSelectionWidget-selector-link"  data-ng-click="selectSize('Year 4-5', this);">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color32">
							<div class="selector-boxes">
								<span id="32" class="size">Year 4-5</span>
							</div>
						</div>
					</a>
				<%  } else { %>
					<a class="multiSelectionWidget-selector-link">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color32">
							<div class="selector-boxes">
								<span id="32" class="size" style="text-decoration: line-through;">Year 4-5</span>
							</div>
						</div>
					</a>
				<%  } %>
				
				
				<%  if (isYear_5_6Exists) {      %>
					<a class="multiSelectionWidget-selector-link"  data-ng-click="selectSize('Year 5-6', this);">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color34">
							<div class="selector-boxes">
								<span id="34" class="size">Year 5-6</span>
							</div>
						</div>
					</a>
				<%  } else { %>
					<a class="multiSelectionWidget-selector-link">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color34">
							<div class="selector-boxes">
								<span id="34" class="size" style="text-decoration: line-through;">Year 5-6</span>
							</div>
						</div>
					</a>
				<%  } %>
				
				
				<%  if (isYear_6_7Exists) {      %>
					<a class="multiSelectionWidget-selector-link"  data-ng-click="selectSize('Year 6-7', this);">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color36">
							<div class="selector-boxes">
								<span id="36" class="size">Year 6-7</span>
							</div>
						</div>
					</a>
				<%  } else { %>
					<a class="multiSelectionWidget-selector-link">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color36">
							<div class="selector-boxes">
								<span id="36" class="size" style="text-decoration: line-through;">Year 6-7</span>
							</div>
						</div>
					</a>
				<%  } %>
				
				
				<%  if (isYear_7_8Exists) {      %>
					<a class="multiSelectionWidget-selector-link"  data-ng-click="selectSize('Year 7-8', this);">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color38">
							<div class="selector-boxes">
								<span id="38" class="size">Year 7-8</span>
							</div>
						</div>
					</a>
				<%  } else { %>
					<a class="multiSelectionWidget-selector-link">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color38">
							<div class="selector-boxes">
								<span id="38" class="size" style="text-decoration: line-through;">Year 7-8</span>
							</div>
						</div>
					</a>
				<%  } %>
				
				
				<%  if (isYear_8_9Exists) {      %>
					<a class="multiSelectionWidget-selector-link"  data-ng-click="selectSize('Year 8-9', this);">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color40">
							<div class="selector-boxes">
								<span id="40" class="size">Year 8-9</span>
							</div>
						</div>
					</a>
				<%  } else { %>
					<a class="multiSelectionWidget-selector-link">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color40">
							<div class="selector-boxes">
								<span id="40" class="size" style="text-decoration: line-through;">Year 8-9</span>
							</div>
						</div>
					</a>
				<%  } %>
				
				
				<%  if (isYear_9_10Exists) {      %>
					<a class="multiSelectionWidget-selector-link"  data-ng-click="selectSize('Year 9-10', this);">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color42">
							<div class="selector-boxes">
								<span id="42" class="size">Year 9-10</span>
							</div>
						</div>
					</a>
				<%  } else { %>
					<a class="multiSelectionWidget-selector-link">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color42">
							<div class="selector-boxes">
								<span id="42" class="size" style="text-decoration: line-through;">Year 9-10</span>
							</div>
						</div>
					</a>
				<%  } %>
				
				
				
				<%  if (isYear_10_11Exists) {      %>
					<a class="multiSelectionWidget-selector-link"  data-ng-click="selectSize('Year 10-11', this);">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color44">
							<div class="selector-boxes">
								<span id="44" class="size">Year 10-11</span>
							</div>
						</div>
					</a>
				<%  } else { %>
					<a class="multiSelectionWidget-selector-link">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color44">
							<div class="selector-boxes">
								<span id="44" class="size" style="text-decoration: line-through;">Year 10-11</span>
							</div>
						</div>
					</a>
				<%  } %>
				
				
				<%  if (isYear_11_12Exists) {      %>
					<a class="multiSelectionWidget-selector-link"  data-ng-click="selectSize('Year 11-12', this);">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color46">
							<div class="selector-boxes">
								<span id="46" class="size">Year 11-12</span>
							</div>
						</div>
					</a>
				<%  } else { %>
					<a class="multiSelectionWidget-selector-link">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color46">
							<div class="selector-boxes">
								<span id="46" class="size" style="text-decoration: line-through;">Year 11-12</span>
							</div>
						</div>
					</a>
				<%  } %>					
					
					
					
				</div>				
			</div>
	          	    	
	   <%	} // main if %>       	
	       	
	      