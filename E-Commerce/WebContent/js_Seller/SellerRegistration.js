$(function() { 		  		
	
	  $('#button').click(function() {
		  
		  var fName1 = $("#first_name").val();  alert(fName1);
		  
		  
		  $.getJSON("RegisterSeller", { fName1: fName1 } )
		  .done(function( json ) {
		    
		  })
		  .fail(function( jqxhr, textStatus, error ) {
		    
		});
	  });
	  
});