/**
 * custom directives
 */
 
 (function(){
 	var ApplicationDirectiveModule = angular.module("applicationDirectiveModule");
 	ApplicationDirectiveModule.directive("mainContainer", function(){ //in camelcase every "hump" gets converted to hyphen , customerView gets converted to "customer-view"(in the html camelCase to hyphen string)
 		return {
 			restrict : 'E',
 			templateUrl : 'components/application/mainContainer.html'
 		}
 		
 	}).directive("navBar", function(){
 		return {
 			restrict : 'E',
 			templateUrl : 'components/application/navBar.html'
 		}
 	}).directive("leftMenu", function(){
 		return {
 			restrict : 'E',
 			templateUrl : 'components/application/leftMenu.html'
 		}
 	})  
 	
 /*	ApplicationDirectiveModule.config(function($routeProvider) {
 		console.log('in routing')
		$routeProvider
			.when('/mainContainer', {
				templateUrl : "components/application/mainContainer.html",
				controller : "ApplicationController"
			})
	});*/
 	
 	
 })();