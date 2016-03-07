$(function() {
	
	/******************************* Select Category ******************************************************/
	
	$("#category").change(function() {
		var option = $(this).find('option:selected').val();		
		$.ajax({
				url: 'ProductCategoryList',
				type: 'POST',
				data: {value: option},
				success: function(response) {					
					$('#subCategory').find('option').remove();
					$('#subCategory').append(response);
				}
		});		
	});
	
	
	
	/******************************* Submit Form ***********************************************************/
	
	
	$("form#data").submit(function(event) { 
		
			//disable the default form submission
		  	event.preventDefault();
		  	
		  	$('#msg').empty();
		  	
		  	if ( $('#category').val() === 'null' || $('#subCategory').val() === 'null' ) {
		  		
		  		alert('You have not Selected any Category.');
		  		return false;
		  	}
		
			var r = confirm("Alert: Do You Really Want To Add This Product!");
			
			if (r == true) {  
		 
				  //grab all form data  
				  var formData = new FormData($(this)[0]);   
				 
				  $.ajax({
				    url: 'CreateProduct',
				    type: 'POST',
				    data: formData,
				    async: false,
				    cache: false,
				    contentType: false,
				    processData: false,
				    success: function (returndata) {
				    	$('#msg').empty();
				    	$('#msg').append(returndata);
				    },
				  	error: function() {
				  		$('#msg').empty();
				  		$('#msg').append("Product Not Updated.");
				  	}
				  });
			} 
		 
		  return false;
		
	
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*************************** Discount - Calculation  *****************************************************************/	
	
	$('#ListPrice').keyup(function(e) {  
		
		var listPrice = $(this).val();		
		var numeric = $.isNumeric( listPrice );  
		var salePriceToAdmin  = $('#salePriceToAdmin').val();			
		var discount = ((parseInt(listPrice) - parseInt(salePriceToAdmin)) / parseInt(listPrice)) * 100;
		
		if (numeric == true) {
		
			$(this).css({"background-color": "#9EE69E"});
			$('#discount').val(discount);
			
		} else {
			
			$(this).css({"background-color": "#E89D9D"});
		}
	});
	
	
	
	/*************************** Profit Margin  And Sale Price to Admin - Calculation *****************************************************************/	
	
	$('#profitMarginPercentage').keyup(function(e) { 
		
		var profitMarginPercentage = $(this).val();		
		var numeric = $.isNumeric( profitMarginPercentage );  
		var manufacturingCost  = $('#manufacturingCost').val();
		var salePriceToAdmin = parseInt(manufacturingCost) + (parseInt(manufacturingCost) * (parseInt(profitMarginPercentage) / 100));
		var profitMargin = parseInt(manufacturingCost) * (parseInt(profitMarginPercentage) / 100);
		
		
		if (numeric == true) {
		
			$(this).css({"background-color": "#9EE69E"});
			$('#profitMargin').val(profitMargin);
			$('#salePriceToAdmin').val(salePriceToAdmin);
			
		} else {
			
			$(this).css({"background-color": "#E89D9D"});
		}
	});
	
	
	/*************************************************************************************/
	/**********************************  Basic Features  *********************************/
	/*************************************************************************************/
	
	
	$('#manufacturingCost1').keyup(function(e) {  
		
		var manufacturingCost1 = $(this).val();		
		var numeric = $.isNumeric( manufacturingCost1 );  
		
		
		if (numeric == true) {
		
			$(this).css({"background-color": "#9EE69E"});
			
			
		} else {
			
			$(this).css({"background-color": "#E89D9D"});
		}
	});
	
});