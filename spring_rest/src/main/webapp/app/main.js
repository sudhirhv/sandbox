/**
 * Main Module for Angualar Js 
 */
(function(){
	var MainModule = angular.module("customerApp",["ngRoute","customerServiceModule", "directiveModule", "filterModule", 'ui.grid']);	
	
	MainModule.config(function($routeProvider) {
		$routeProvider.when('/customers', {
			templateUrl : "partials/customer_view.html",
			controller : "CustomerController"
		}).when('/', {
			templateUrl : "partials/login.html",
			controller : "CustomerController"
		}).when('/orders/:id', {
			//templateUrl : 'partials/orderCustomer.html',
			templateUrl : 'partials/uigrid.html',
			controller : "OrderController"
		})
	});
	
	MainModule.controller("OrderController", ['$scope', '$routeParams', 'customerService', 
		function($scope, $routeParams, customerService) {
			customerService.getOrdersOfCustomer($routeParams.id).then(
				function(data) {
					$scope.orders = data; 
					//$scope.myData = data;
					console.log(data)
				}
			)
		}]);
	
	
	MainModule.controller("CustomerController",function($scope, $location, $rootScope, customerService){
		$scope.customers = [];
		customerService.getCustomers().then(function(data){
			$scope.customers = data;
		});
		
		$scope.editMode = false;
		$scope.editCustomer = function(customer) {
			console.log(customer)
			$scope.currentCustomer = customer;
			$scope.editMode = true;			
		}
		$scope.myData = [{"id":1,"name":"L.G Washing Machine","price":23000.9},
							{"id":2,"name":"MotoG Mobile","price":12999.9},
							{"id":3,"name":"Samsung s6","price":45000},
							{"id":4,"name":"iPhone 6","price":53000.9}
		];
		
	    /*$scope.myData = [{
						"name" : "Ethel Price",
						"gender" : "female",
						"company" : "Enersol"
					}, {
						"name" : "Claudine Neal",
						"gender" : "female",
						"company" : "Sealoud"
					}, {
						"name" : "Beryl Rice",
						"gender" : "female",
						"company" : "Velity"
					}, {
						"name" : "Wilder Gonzales",
						"gender" : "male",
						"company" : "Geekko"
					}]*/
		
		$scope.updateCustomer = function(customer) {
			console.log('changed customer',customer)
			$scope.editMode = false;
			customerService.updateCustomer(customer);
		}
		
		$scope.deleteCustomer = function(customer) {
			console.log('deleting customer',customer)
			//$scope.customers.splice(2,1)
			//customerService.deleteCustomer(customer);
			for (var i = 0; i < $scope.customers.length; i++) {
				$scope.customers[i].id == customer.id ? $scope.customers.splice(i,1) : ''
			}
		}	
		$scope.login = function() {
			$rootScope.user = null;
			customerService.login($scope.firstName, $scope.lastName).then(
				function(data) {
					$rootScope.user = data;
					$rootScope.user ? $location.path("/customers") : '';
				}
			)
		}
	});	
	
	

	
	
})();