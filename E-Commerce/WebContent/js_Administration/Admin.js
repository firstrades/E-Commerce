var admin = angular.module('admin', []);

/********************** AdminPanel.js *********************************/

admin.controller('ViewController', function($scope, $http, $window) {   
	
	$scope.dashboard = true;	
	
	$scope.approveProductList = function() { 		
		
		$scope.hideAll();
		$scope.productApproval = true;
		
		$http.post('RetrieveProductForApproval', {}).success(function(data) {
			
			$scope.items = data.items;
		});
		
		
	};	
	
	$scope.statusForBookedProducts = function() { 		
		
		$scope.hideAll();
		$scope.bookedProductsStatus = true;
		
		$http.post('RetrieveOrderedItemsForAdmin', {}).success(function(data) {
			
			$scope.bookedProducts = data.items;
			
			if (data.items.orderState = 'Booked') {
				
				$scope.booked = true;
			}
		});
		
		
		
	};	
	
	$scope.getPinCommission = function() { 		
		
		$scope.hideAll();
		$scope.editFranchise = true;
		
		$http.post('RetrievePinCommission', {}).success(function(data) {
			
			$scope.pinCommissions = data.items;
		});
		
		
	};	
	
	$scope.hideAll = function() {   
		
		$scope.productApproval = false;
		$scope.dashboard = false;
		$scope.editFranchise = false;
		$scope.bookedProductsStatus = false;
	};
	
	$scope.redirectToUserRegistration = function() {
		
		$window.open('FranchiseRegistration', '_blank');
	};
	
	
	
}) ;

admin.controller('SetPinCommissionController', function($scope, $http, $window) {
	
	$scope.setPin = function(position) {	
		
		//$scope.emptyMessage();
		
		var r = $window.confirm("Alert: Do You Want To Set This Pin!");
		
		if (r == true) { 
		
			if (position == 0) {			
				pin = $scope.item.pin1;
			} else if (position == 1) {			
				pin = $scope.item.pin2;
			} else if (position == 2) {			
				pin = $scope.item.pin3;
			} else if (position == 3) {			
				pin = $scope.item.pin4;
			} else if (position == 4) {		
				pin = $scope.item.pin5;
			}		
			
			//$window.alert($scope.item.id);
				
			var keyValue = JSON.stringify({position: position, pin: pin, id: $scope.item.id});
			
			$http.post('SetPin', keyValue, {headers: {'Content-Type': 'application/json'} }).success( function(data) {						
				
				if (data.success) {
					
					$scope.message1 = data.success;	
					
				} else {
					
					$scope.message1 = data.failed;	
				}
			});	
			
		} // if
		
	};  // setPin
	
	$scope.setCommission = function() {		
		
		//$window.alert($scope.item.id);
			
		var keyValue = JSON.stringify({commission: $scope.item.commission, id: $scope.item.id});
		
		$http.post('SetCommission', keyValue, {headers: {'Content-Type': 'application/json'} }).success( function(data) {						
			
			if (data.success) {
				
				$scope.message1 = data.success;	
				
			} else {
				
				$scope.message1 = data.failed;	
			}
		});			
		
	};  // set
	
	$scope.setAdditionalBalance = function() {
		
		var keyValue = JSON.stringify({addtionalBalance: $scope.addtionalBalance, id: $scope.item.id});
		
		$http.post('FranchiseAdditionalBalance', keyValue, {headers: {'Content-Type': 'application/json'} }).success( function(data) {						
			
			if (data.success) {
				
				$scope.message1      = data.success;
				$scope.item.balance  = data.balance;
				
			} else {
				
				$scope.message1 = data.failed;	
			}
		});		
	};
});

admin.directive('ngRemoveItem', function($http, $window) {	
	
	return {
		
		link: function(scope, element, attr) {
		
			scope.approveProduct = function() {
				
				var r = $window.confirm("Alert: Do You Want To Approve This Product!");
				
				if (r == true) { 
				
					var productId = scope.item.productId;
					var markup    = scope.markup;
					var franComm  = scope.franComm;
					var drisComm  = scope.drisComm;
					
					var keyValue = JSON.stringify({productId: productId, markup: markup, franComm: franComm, drisComm: drisComm});
					
					$http.post('ApproveProduct', keyValue, {headers: {'Content-Type': 'application/json'} }).success( function(data) {						
						
						if (data.success) {
							
							element.remove();
						}
					});
					
				}
			};
		} // link close
	};  // return close
	
});

/*admin.directive('jsEmpty', function($http, $window) {
	
	return {
		
		link: function(scope, element, attr) {
			
			scope.emptyMessage = function() {
				
				element.html('E');
			};
		}
	};
});*/

/************************ Registration For Franchise *****************************/


admin.controller('CreateEditUserController', function($scope, $http, $window) {  

	//$scope.message = "";
	
	$scope.userId = "1"; $scope.password = "2"; $scope.fName = "3"; $scope.lName = "4"; $scope.sex = "Male"; 
	$scope.company = "6"; $scope.mobile1 = "7"; $scope.mobile2 = "8"; $scope.email1 = "9"; $scope.email2 = "10"; $scope.phone1 = "11";
	$scope.phone2 = "12"; $scope.fax1 = "13"; $scope.fax2 = "14"; $scope.address = "15"; $scope.city = "16"; $scope.state = "17";
	$scope.pin = "18"; $scope.pan = "19"; $scope.voterId = "20";
	
	$scope.createFranchise = function() {
		
		var myEl = angular.element( document.querySelector( '#message' ) );
		myEl.empty(); 
		
		var r = $window.confirm("Alert: Do You Want To Add this user as Franchise!");
		
		if (r == true) { 
			
			var keyValue = JSON.stringify({userId: $scope.userId, password: $scope.password, fName: $scope.fName, lName: $scope.lName, sex: $scope.sex, 
				company: $scope.company, mobile1: $scope.mobile1, mobile2: $scope.mobile2, email1: $scope.email1, email2: $scope.email2, phone1: $scope.phone1,
				phone2: $scope.phone2, fax1: $scope.fax1, fax2: $scope.fax2, address: $scope.address, city: $scope.city, state: $scope.state,
				pin: $scope.pin, pan: $scope.pan, voterId: $scope.voterId});
			
			$http.post('AddFranchise', keyValue, {headers: {'Content-Type': 'application/json'} }).success( function(data) {						
				
				if (data.message) {
					
					myEl.html(data.message);					
				}
			});
		} // if close
	};
	
});  // CreateEditUserController


