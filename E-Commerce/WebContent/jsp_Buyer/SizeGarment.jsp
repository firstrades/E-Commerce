<%@page import="ecom.model.SizeGarment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <%
    
    	SizeGarment sizeGarment       = (SizeGarment)        request.getAttribute("sizeGarment"  );
    
	    boolean isSizeExists = sizeGarment.isProductIdExists() == true;
		boolean isSize26Exists = sizeGarment.getSize().getQtyOfSize26() != 0;
		boolean isSize28Exists = sizeGarment.getSize().getQtyOfSize28() != 0;
		boolean isSize30Exists = sizeGarment.getSize().getQtyOfSize30() != 0;
		boolean isSize32Exists = sizeGarment.getSize().getQtyOfSize32() != 0;
		boolean isSize34Exists = sizeGarment.getSize().getQtyOfSize34() != 0;
		boolean isSize36Exists = sizeGarment.getSize().getQtyOfSize36() != 0;
		boolean isSize38Exists = sizeGarment.getSize().getQtyOfSize38() != 0;
		boolean isSize40Exists = sizeGarment.getSize().getQtyOfSize40() != 0;
		boolean isSize42Exists = sizeGarment.getSize().getQtyOfSize42() != 0;
		boolean isSize44Exists = sizeGarment.getSize().getQtyOfSize44() != 0;
		boolean isSize46Exists = sizeGarment.getSize().getQtyOfSize46() != 0;
		boolean isSize48Exists = sizeGarment.getSize().getQtyOfSize48() != 0;
    
    %>
    
    
    
    
   
	          	    	
	   
	   <%	   
	   		if (isSizeExists) {  // main if   		
	   
	   %>
	   
	         <!--     text-decoration: line-through;--> 	    	
	        <div class="multiSelectionWidget unit size1of2" id="sizeBlock" style="display: block;">
				<div class="multiSelectionWidget-title">Select Size</div>			
				<div class="multiSelectionWidget-selectors-wrap">
				
				
				<%  if (isSize26Exists) {      %>
					<a class="multiSelectionWidget-selector-link"  data-ng-click="selectSize('26', this);">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color26">
							<div class="selector-boxes">
								<span id="26" class="size">26</span>
							</div>
						</div>
					</a>
				<%  } else { %>
					<a class="multiSelectionWidget-selector-link">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color26">
							<div class="selector-boxes">
								<span id="26" class="size" style="text-decoration: line-through;">26</span>
							</div>
						</div>
					</a>
				<%  } %>
				
				
				<%  if (isSize28Exists) {      %>
					<a class="multiSelectionWidget-selector-link"  data-ng-click="selectSize('28', this);">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color28">
							<div class="selector-boxes">
								<span id="28" class="size">28</span>
							</div>
						</div>
					</a>
				<%  } else { %>
					<a class="multiSelectionWidget-selector-link">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color28">
							<div class="selector-boxes">
								<span id="28" class="size" style="text-decoration: line-through;">28</span>
							</div>
						</div>
					</a>
				<%  } %>
				
				
				<%  if (isSize30Exists) {      %>
					<a class="multiSelectionWidget-selector-link"  data-ng-click="selectSize('30', this);">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color30">
							<div class="selector-boxes">
								<span id="30" class="size">30</span>
							</div>
						</div>
					</a>
				<%  } else { %>
					<a class="multiSelectionWidget-selector-link">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color30">
							<div class="selector-boxes">
								<span id="30" class="size" style="text-decoration: line-through;">30</span>
							</div>
						</div>
					</a>
				<%  } %>
					
					
				<%  if (isSize32Exists) {      %>
					<a class="multiSelectionWidget-selector-link"  data-ng-click="selectSize('32', this);">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color32">
							<div class="selector-boxes">
								<span id="32" class="size">32</span>
							</div>
						</div>
					</a>
				<%  } else { %>
					<a class="multiSelectionWidget-selector-link">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color32">
							<div class="selector-boxes">
								<span id="32" class="size" style="text-decoration: line-through;">32</span>
							</div>
						</div>
					</a>
				<%  } %>
				
				
				<%  if (isSize34Exists) {      %>
					<a class="multiSelectionWidget-selector-link"  data-ng-click="selectSize('34', this);">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color34">
							<div class="selector-boxes">
								<span id="34" class="size">34</span>
							</div>
						</div>
					</a>
				<%  } else { %>
					<a class="multiSelectionWidget-selector-link">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color34">
							<div class="selector-boxes">
								<span id="34" class="size" style="text-decoration: line-through;">34</span>
							</div>
						</div>
					</a>
				<%  } %>
				
				
				<%  if (isSize36Exists) {      %>
					<a class="multiSelectionWidget-selector-link"  data-ng-click="selectSize('36', this);">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color36">
							<div class="selector-boxes">
								<span id="36" class="size">36</span>
							</div>
						</div>
					</a>
				<%  } else { %>
					<a class="multiSelectionWidget-selector-link">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color36">
							<div class="selector-boxes">
								<span id="36" class="size" style="text-decoration: line-through;">36</span>
							</div>
						</div>
					</a>
				<%  } %>
				
				
				<%  if (isSize38Exists) {      %>
					<a class="multiSelectionWidget-selector-link"  data-ng-click="selectSize('38', this);">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color38">
							<div class="selector-boxes">
								<span id="38" class="size">38</span>
							</div>
						</div>
					</a>
				<%  } else { %>
					<a class="multiSelectionWidget-selector-link">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color38">
							<div class="selector-boxes">
								<span id="38" class="size" style="text-decoration: line-through;">38</span>
							</div>
						</div>
					</a>
				<%  } %>
				
				
				<%  if (isSize40Exists) {      %>
					<a class="multiSelectionWidget-selector-link"  data-ng-click="selectSize('40', this);">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color40">
							<div class="selector-boxes">
								<span id="40" class="size">40</span>
							</div>
						</div>
					</a>
				<%  } else { %>
					<a class="multiSelectionWidget-selector-link">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color40">
							<div class="selector-boxes">
								<span id="40" class="size" style="text-decoration: line-through;">40</span>
							</div>
						</div>
					</a>
				<%  } %>
				
				
				<%  if (isSize42Exists) {      %>
					<a class="multiSelectionWidget-selector-link"  data-ng-click="selectSize('42', this);">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color42">
							<div class="selector-boxes">
								<span id="42" class="size">42</span>
							</div>
						</div>
					</a>
				<%  } else { %>
					<a class="multiSelectionWidget-selector-link">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color42">
							<div class="selector-boxes">
								<span id="42" class="size" style="text-decoration: line-through;">42</span>
							</div>
						</div>
					</a>
				<%  } %>
				
				
				
				<%  if (isSize44Exists) {      %>
					<a class="multiSelectionWidget-selector-link"  data-ng-click="selectSize('44', this);">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color44">
							<div class="selector-boxes">
								<span id="44" class="size">44</span>
							</div>
						</div>
					</a>
				<%  } else { %>
					<a class="multiSelectionWidget-selector-link">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color44">
							<div class="selector-boxes">
								<span id="44" class="size" style="text-decoration: line-through;">44</span>
							</div>
						</div>
					</a>
				<%  } %>
				
				
				<%  if (isSize46Exists) {      %>
					<a class="multiSelectionWidget-selector-link"  data-ng-click="selectSize('46', this);">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color46">
							<div class="selector-boxes">
								<span id="46" class="size">46</span>
							</div>
						</div>
					</a>
				<%  } else { %>
					<a class="multiSelectionWidget-selector-link">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color46">
							<div class="selector-boxes">
								<span id="46" class="size" style="text-decoration: line-through;">46</span>
							</div>
						</div>
					</a>
				<%  } %>
				
				
				<%  if (isSize48Exists) {      %>
					<a class="multiSelectionWidget-selector-link"  data-ng-click="selectSize('48', this);">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color48">
							<div class="selector-boxes">
								<span id="48" class="size">48</span>
							</div>
						</div>
					</a>
				<%  } else { %>
					<a class="multiSelectionWidget-selector-link">
						<div class="multiSelectionWidget-selector selector-type-boxes  checkStyleJ" data-ng-style="color48">
							<div class="selector-boxes">
								<span id="48" class="size" style="text-decoration: line-through;">48</span>
							</div>
						</div>
					</a>
				<%  } %>	
					
					
					
					
				</div>				
			</div>
	          	    	
	   <%	} // main if %>       	
	       	
	    