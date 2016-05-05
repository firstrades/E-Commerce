$(function() { 
	
	var stock1 = $('#stock').html();
	var stock  = parseInt(stock1);
	
	if (stock == 0) {
		
		$('#buyNow').on("click", function (e) {
	        e.preventDefault();	        
	    });
		$('#buyNow').removeClass('btn_form').addClass('btn_default_sd');
		
		
		$('#addToCart').on("click", function (e) {
	        e.preventDefault();	        
	    });
		$('#addToCart').removeClass('btn_form').addClass('btn_default_sd')
		$('#addToCart a').removeAttr("style");
		
	} // if	
	
	
	$('.checkBeforeSubmit').click(function(event) {    
		
		var noneBlock = $('#sizeBlock').css('display');		
		
		if (noneBlock === 'block') {   	
			
			var status = false;
			
			$('.checkStyleJ').each(function() {  // check if style contains background-color
				
				var color = $(this).css('background-color');   //alert(color);
				
				if(color === 'rgb(255, 165, 0)') {  // space is must in 'rgb'					
					status = true;					
				}				
				
			});	
			
			if (status == false)   { 
				event.preventDefault();
			}	
			
		} // main if
		
	});
	
	$('#location').click(function() {
		
		var pincode = $('#pincode').val();
		$('#loader').css('display', 'block');
		$('#right').css('display', 'none');
		$('#cross').css('display', 'none');
		$('#msgLocation').css('display', 'none');
		$('#noNet').css('display', 'none');
		$('#error').css('display', 'none');
		
		$.getJSON('CheckPincode', {pincode: pincode} , function(data) {	
			
			if(data.status && !data.noNet && !data.error) {				
				$('#right').css('display', 'block');
				$('#cross').css('display', 'none');
				$('#loader').css('display', 'none');
			} else if (data.noNet && !data.error) {				
				$('#noNet').css('display', 'block');
				$('#right').css('display', 'none');
				$('#loader').css('display', 'none');
				$('#cross').css('display', 'block');
			} else if (data.error) {
				$('#error').css('display', 'block');
				$('#right').css('display', 'none');
				$('#loader').css('display', 'none');
				$('#cross').css('display', 'block');
			} else {				
				$('#cross').css('display', 'block');
				$('#right').css('display', 'none');
				$('#loader').css('display', 'none');
			}
			if (!data.notANumber) {
				$('#msgLocation').css('display', 'block');
			}
		});
		
	});
	
	$('#pincode').keyup(function() {
		
		$('#right').css('display', 'none');
		$('#cross').css('display', 'none');
		$('#msgLocation').css('display', 'none');
		$('#noNet').css('display', 'none');
	});
	
});

var application = angular.module('ProductDetailsApplication', []);

/********************** AdminPanel.js *********************************/
application.controller('ProductDetailsController', function($scope, $http, $window) {   
	
	/***********   !important  ***************/
	/******* Used for SizeGarment.jsp / SizeInYears.jsp *************/
	
	$scope.size = '';
	
	$scope.selectSize = function(size, element) {
		
		$scope.size = size;
		
		//$window.alert(size);
			
		
		if (size == '26' || size == 'Year 1-2') {
			resetColor();
			$scope.color26 = { 'background-color' : 'orange' };
		}
		else if (size == '28' || size == 'Year 2-3') {
			resetColor();
			$scope.color28 = { 'background-color' : 'orange' };
		}
		else if (size == '30' || size == 'Year 3-4') {
			resetColor();
			$scope.color30 = { 'background-color' : 'orange' };
		}
		else if (size == '32' || size == 'Year 4-5') {
			resetColor();
			$scope.color32 = { 'background-color' : 'orange' };
		}
		else if (size == '34' || size == 'Year 5-6') {
			resetColor();
			$scope.color34 = { 'background-color' : 'orange' };
		}
		else if (size == '36' || size == 'Year 6-7') {
			resetColor();
			$scope.color36 = { 'background-color' : 'orange' };
		}
		else if (size == '38' || size == 'Year 7-8') {
			resetColor();
			$scope.color38 = { 'background-color' : 'orange' };
		}
		else if (size == '40' || size == 'Year 8-9') {
			resetColor();
			$scope.color40 = { 'background-color' : 'orange' };
		}
		else if (size == '42' || size == 'Year 9-10') {
			resetColor();
			$scope.color42 = { 'background-color' : 'orange' };
		}
		else if (size == '44' || size == 'Year 10-11') {
			resetColor();
			$scope.color44 = { 'background-color' : 'orange' };
		}
		else if (size == '46' || size == 'Year 11-12') {
			resetColor();
			$scope.color46 = { 'background-color' : 'orange' };
		}
		else if (size == '48') {
			resetColor();
			$scope.color48 = { 'background-color' : 'orange' };
		}
		
		
	};
	
	
	function resetColor() {
		
		$scope.color26 = { 'background-color' : 'white' };
		$scope.color28 = { 'background-color' : 'white' };
		$scope.color30 = { 'background-color' : 'white' };
		$scope.color32 = { 'background-color' : 'white' };
		$scope.color34 = { 'background-color' : 'white' };
		$scope.color36 = { 'background-color' : 'white' };
		$scope.color38 = { 'background-color' : 'white' };
		$scope.color40 = { 'background-color' : 'white' };
		$scope.color42 = { 'background-color' : 'white' };
		$scope.color44 = { 'background-color' : 'white' };
		$scope.color46 = { 'background-color' : 'white' };
		$scope.color48 = { 'background-color' : 'white' };
		
		
	};
	
	

});
	