/**
 * Angular service to connect to REST end-points 
 */
//IIFE
(function(){
	var customerServiceModule = angular.module('customerServiceModule',[]);
	customerServiceModule.service("customerService", function($http, $q){
		
		this.login = function(firstName, lastName) {
			var deferred = $q.defer();
			$http.get("rest/login?firstName="+firstName+"&lastName="+lastName).success(function(data) {
				deferred.resolve(data);
			}).error(function(data) {
				deferred.error(data)
			});
			return deferred.promise;
		}
		
		this.getCustomers = function(){
			var deferred = $q.defer();
			$http.get("rest/customers").success(function(data){
				deferred.resolve(data);
			}).error(function(data){
				deferred.error(data);
			});
			return deferred.promise;
		};
		
		this.getOrdersOfCustomer = function(id) {
			console.log(id)
			var deferred = $q.defer();
			$http.get("rest/orders/"+id).success(function(data){
				deferred.resolve(data);
			}).error(function(data){
				deferred.error(data);
			});
			return deferred.promise;
		}
		
		this.getOrders = function(){
			var deferred = $q.defer();
			$http.get("rest/customers").success(function(data){
				deferred.resolve(data);
			}).error(function(data){
				deferred.error(data);
			});
			return deferred.promise;
		};
		
		this.updateCustomer = function(customer){
			$http.put("rest/updateCustomer",customer)
		};
		
		this.deleteCustomer = function(customer) {
			console.log('in deletion', customer);
			
		}
	});
})();