angular.module('sobisleave.application',[	
	'sobisleave.application.controller',
	'sobisleave.application.service',
	'sobisleave.application.directives'
]);

angular.module('sobisleave.application').config(function($routeProvider) {
	$routeProvider.when('/mainContainer', {
		templateUrl : "components/application/mainContainer.html",
		controller : "ApplicationController"
	}).when('/holidays', {
			templateUrl : "components/holiday/HolidayGrid.html",
			controller : "CustomerController"
	})
})
