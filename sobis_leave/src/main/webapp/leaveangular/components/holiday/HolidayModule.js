angular.module('sobisleave.holiday',[	
	'sobisleave.holiday.controller',
	'sobisleave.holiday.service',
	'sobisleave.holiday.directives'
]);

angular.module('sobisleave.holiday').config(function($routeProvider) {
	$routeProvider.when('/holidays', {
		templateUrl : "components/holiday/HolidayGrid.html",
		controller : "HolidayController"
	})
})
