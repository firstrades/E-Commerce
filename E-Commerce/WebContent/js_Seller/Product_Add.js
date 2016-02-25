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
	
	
	
	/*************************** List Price Numeric  *****************************************************************/	
	
	$('#ListPrice').keyup(function(e) {  
		
		var listPrice = $(this).val();		
		var numeric = $.isNumeric( listPrice );  
		var discount  = $('#discount').val();
		var salePrice = listPrice * (1 - discount / 100);
		
		
		if (numeric == true) {
		
			$(this).css({"background-color": "#9EE69E"});
			$('#salePrice').val(salePrice);
			
		} else {
			
			$(this).css({"background-color": "#E89D9D"});
		}
	});
	
	
	
	/*************************** Calculate Sale Price  *****************************************************************/	
	
	$('#discount').keyup(function(e) {  
		
		var listPrice = $('#ListPrice').val();
		var discount  = $(this).val();		
		var numeric   = $.isNumeric( discount );  
		var salePrice = listPrice * (1 - discount / 100);
		
		
		if (numeric == true) {
		
			$(this).css({"background-color": "#9EE69E"});			
			$('#salePrice').val(salePrice);
			
		} else {
			
			$(this).css({"background-color": "#E89D9D"});
		}
	});
	
});