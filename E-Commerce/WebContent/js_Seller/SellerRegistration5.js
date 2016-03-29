/******************************** Seller Registration Submit Form ********************************/
$(function() { 		  		
	
	  $('#button').click(function() {
		  
				var First_name = $.trim($("#first_name").val()); // alert ("MMM"+First_name);
				var Last_name = null; 

			 	var checkbox = $("#checkbox");  
				alert(checkbox.val());
	  		    if (checkbox.val() == 'on') {   
	  		    	Last_name  = $.trim($("#last_name").val());
	  		    }
	  		  else {
	  			Last_name  = $.trim($("#first_name").val());
	  			
	  		  }
	  		    
//		  		  var data = {fName1: First_name, lName1: Last_name};
		  	//	  alert(First_name+":::"+Last_name);
		  		  
			  		$.ajax({  
			  			//"status="+status+"name="+name
			  			
			  			type     : "POST",
			  			url      : "RegisterSeller",
			  			data     : "fName1="+First_name,
			  			dataType : "html",
			  			success  : function(response) {
			  				document.getElementById('button').innerHTML=response;
			  			},
			  			error: function(e) {
			  				document.getElementById('button').innerHTML="<font color='red'>Technical Error.Try again..</font>";
			  	        }
			  		});

		  	});
		
			
			$('#checkbox').change(function() {
				// alert("demo");
				var display = $('#aux').css('display');  
				
				if (display == 'none')
					$('#aux').css('display', 'block'); 
				else
					$('#aux').css('display', 'none'); 
			});
		
	   });