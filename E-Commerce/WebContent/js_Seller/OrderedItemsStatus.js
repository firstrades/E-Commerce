var application = angular.module('Jewel', []);

application.controller('LoopController', function($scope, $http, $window) {	
		
	
	
	$scope.generateTrackNumberCOD = function(orderTableId) {	
		
		$scope.loader = true;
		
		var data = $.param ({
			orderTableId: orderTableId
		});
		
		var config = {
                headers : {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                }
            }
		
		$http.post('GenerateTrackNumberCOD', data, config).success(function(data) {			
			
			if (data.pickup) {				
				$scope.trackNumberCOD = false;
				$scope.pickupLabelCOD = true;
				$scope.loader = false;
			}
		});	
		
	};
	
	
	$scope.generateTrackNumberBANK = function(orderTableId) {
		
		$scope.loader = true;
		
		var data = $.param ({
			orderTableId: orderTableId
		});
		
		var config = {
                headers : {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                }
            }
		
		$http.post('GenerateTrackNumberBANK', data, config).success(function(data) {
			
			if (data.pickup) {				
				$scope.trackNumberBANK = false;
				$scope.pickupLabelBANK = true;
				$scope.loader = false;
			}
		});	
		
	};
	
	
	
	//$window.alert(orderTableId);
	
	
	
	
		
	
});