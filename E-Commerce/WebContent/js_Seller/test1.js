$(function() {


	$('form#form4').submit(function(event) {  
		
		event.preventDefault();
		
		$('#msg1').empty();
		
		var r = confirm("Alert: Do You Really Want To Edit This Advanced Product!");
		
		if (r == true) { 
		
				var formData = new FormData($(this)[0]);
				
				$.ajax({
					url: 'EditSizeFeatures',
					type: 'POST',
					data: formData,
					async: false,
				    cache: false,
				    contentType: false,
				    processData: false,
				    dataType: 'json',
				    success: function (array) {
				    	
				    	$("input[name=size26]").val(array[0] );
				    	$("input[name=size28]").val(array[1] );
				    	$("input[name=size30]").val(array[2] );
				    	$("input[name=size32]").val(array[3] );
				    	$("input[name=size34]").val(array[4] );
				    	$("input[name=size36]").val(array[5] );
				    	$("input[name=size38]").val(array[6] );
				    	$("input[name=size40]").val(array[7] );
				    	$("input[name=size42]").val(array[8] );
				    	$("input[name=size44]").val(array[9] );
				    	$("input[name=size46]").val(array[10]);
				    	$("input[name=size48]").val(array[11]);
				    	
				    	
				    	
				    	$('#msg1').empty();
				    	$('#msg1').append('Advance Features Updated');
				    },
				    error: function() {
				  		$('#msg1').empty();
				  		$('#msg1').append('Advance Features Not Updated');
				  	}
				});
		
		} // if close
		
		
		return false;
	});


});
	