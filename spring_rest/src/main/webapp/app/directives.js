/**
 * custom directives
 */
 
 (function(){
 	var DirectiveModule = angular.module("directiveModule", []);
 	DirectiveModule.directive("customerView", function(){ //in camelcase every "hump" gets converted to hyphen , customerView gets converted to "customer-view"(in the html camelCase to hyphen string)
 		return {
 			restrict : 'E',
 			templateUrl : 'partials/customer_view.html'
 		}
 		
 	}).directive("navBar", function(){
 		return {
 			restrict : 'A',
 			templateUrl : 'partials/nav_bar.html'
 		}
 	}).directive("editView", function(){
 		return {
 			restrict : 'E',
 			templateUrl : 'partials/edit_view.html'
 		}
 	})
 	
 })();