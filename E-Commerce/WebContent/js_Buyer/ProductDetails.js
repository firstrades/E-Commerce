$(function() { //alert('jjjjjjjjj');
	
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
	
});

var application = angular.module('ProductDetailsApplication', []);

/********************** AdminPanel.js *********************************/

application.controller('ProductDetailsController', function($scope, $http, $window) {   
	
	$scope.size = 0;
	
	$scope.selectSize = function(size, element) {
		
		//$window.alert(size);
		$scope.size = size;
		
		if (size == 26) {
			resetColor();
			$scope.color26 = { 'background-color' : 'orange' };
		}
		else if (size == 28) {
			resetColor();
			$scope.color28 = { 'background-color' : 'orange' };
		}
		else if (size == 30) {
			resetColor();
			$scope.color30 = { 'background-color' : 'orange' };
		}
		else if (size == 32) {
			resetColor();
			$scope.color32 = { 'background-color' : 'orange' };
		}
		else if (size == 34) {
			resetColor();
			$scope.color34 = { 'background-color' : 'orange' };
		}
		else if (size == 36) {
			resetColor();
			$scope.color36 = { 'background-color' : 'orange' };
		}
		else if (size == 38) {
			resetColor();
			$scope.color38 = { 'background-color' : 'orange' };
		}
		else if (size == 40) {
			resetColor();
			$scope.color40 = { 'background-color' : 'orange' };
		}
		else if (size == 42) {
			resetColor();
			$scope.color42 = { 'background-color' : 'orange' };
		}
		else if (size == 44) {
			resetColor();
			$scope.color44 = { 'background-color' : 'orange' };
		}
		else if (size == 46) {
			resetColor();
			$scope.color46 = { 'background-color' : 'orange' };
		}
		else if (size == 48) {
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
	