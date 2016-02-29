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
                    'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8;'
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
	
	
	$scope.date = '12-02-2016';	
	$scope.changeStateToPicked = function(orderTableId) {	  	

		var date = $scope.date;      
		
		var data = $.param ({
			orderTableId: orderTableId,
			date        : date
		});
		
		var config = {
                headers : {
                    'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8;'
                }
        }
		
		$http.post('SetPickedUp', data, config).success(function(data) {
			
			if (data.picked) {				
				
				$scope.trackParcel     = true;
				$scope.trackNumberBANK = false;
				$scope.trackNumberCOD  = false;
				$scope.pickupLabelBANK = false;				
				$scope.pickupLabelCOD  = false;
			}
		});	
		
		
	};
	
	
	$scope.trackingDetails = function(orderTableId) {		
		
		$scope.loader1 = true;
		$scope.trackDetails = "";
		
		var data = $.param ({
			orderTableId: orderTableId			
		});
		
		var config = {
                headers : {
                    'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8;'
                }
        }
		
		$http.post('GetTrackingDetails', data, config).success(function(data) {
			
			if (data.picked) {				
				
				$scope.trackDetails = "Hai, no details yet....";
				
				$scope.loader1 = false;
			}
		});	
	};
	
	
	//$window.alert(orderTableId);
	
	
	
		
	
});






