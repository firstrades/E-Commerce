/******************************** Seller Registration Submit Form ********************************/
$(function() { 		  		
	
	  $('#button').click(function() {
		  
			    var User_Id        = $.trim($("#user_id")   .val());
			    var Password       = $.trim($("#password")  .val());
			    var First_Name     = $.trim($("#first_name").val());
			    var Last_Name      = $.trim($("#last_name") .val());
			    var Gender         = $.trim($("#sex")       .val());
			    var Company        = $.trim($("#company")   .val());
			    var Mobile_Number1 = $.trim($("#mobile1")   .val());
			    var Mobile_Number2 = $.trim($("#mobile2")   .val());
			    var Email1         = $.trim($("#email1")    .val());
			    var Email2         = $.trim($("#email2")    .val());
			    var Landphone1     = $.trim($("#landphone1").val());
			    var Landphone2     = $.trim($("#landphone2").val());
			    var Fax1           = $.trim($("#fax1")      .val());
			    var Fax2           = $.trim($("#fax2")      .val());
			    var Address_Line1  = $.trim($("#address1")  .val());
			    var Address_Line2  = $.trim($("#address2")  .val());
			    var City           = $.trim($("#city")      .val());
			    var State          = $.trim($("#state1")    .val());
			    var Pin            = $.trim($("#pin")       .val());
			    var Country        = $.trim($("#country1")  .val());
			    var Pancard        = $.trim($("#pancard")   .val());
			    var VoterId        = $.trim($("#voterId")   .val());
			    
			 /* var First_Name2    = $.trim($("#first_name2").val());
			    var Last_Name2     = $.trim($("#last_name2") .val());
			    var Company2       = $.trim($("#company2")   .val());
			    var Mobile_Number3 = $.trim($("#mobile3")    .val());
			    var Address_Line3  = $.trim($("#address3")   .val());
			    var Address_Line4  = $.trim($("#address4")   .val());
			    var City2          = $.trim($("#city2")      .val());
			    var Pin2           = $.trim($("#pin2")       .val());
			    var State2         = $.trim($("#state2")     .val());
			    var Country2       = $.trim($("#country2")   .val());
			    var Email3         = $.trim($("#email3")     .val()); */
			    
			//	var First_name = $.trim($("#first_name").val());

			//	var Last_name = null;
				
				var First_Name2    = null;
				var Last_Name2     = null;
				var Company2       = null;
				var Mobile_Number3 = null;
				var Address_Line3  = null;
			    var Address_Line4  = null;
				var City2          = null;
				var Pin2           = null;
				var State2         = null;
				var Country2       = null;
				var Email3         = null;
				   
				   
	  		  	var checkbox = $("#checkbox");  
	
	  		    if (checkbox.val() == 'on') {    		 
	                
	  		    	First_Name2  = $.trim($("#last_name").val());
	  		    	Last_Name2  = $.trim($("#last_name").val());
	  		    	Company2  = $.trim($("#last_name").val());
	  		    	Mobile_Number3  = $.trim($("#last_name").val());
	  		    	Address_Line3 = $.trim($("#last_name").val());
	  		    	Address_Line4 = $.trim($("#last_name").val());
	  		    	City2  = $.trim($("#last_name").val());
	  		    	Pin2  = $.trim($("#last_name").val());
	  		    	State2  = $.trim($("#last_name").val());
	  		    	Country2  = $.trim($("#last_name").val());
	  		    	Email3  = $.trim($("#last_name").val());
	  		    	
	  		    //	 Last_name  = $.trim($("#last_name").val());
	
	  		    }
		  			
		  		else{

		  			 Last_name  = $.trim($("#first_name").val());

		  		}
		  		    
		  		alert (" first_name "+First_name+" last_name "+Last_name);
		  		
		  		var data = {fNam: First_name };
		  		
		  		$.ajax({
		  			
		  			type     : "POST",
		  			url      : "RegisterSeller",
		  			data     : data,
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