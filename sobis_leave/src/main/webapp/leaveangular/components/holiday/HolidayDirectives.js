(function(){
	angular.module("sobisleave.holiday.directives",[]);
	
	angular.module("sobisleave.holiday.directives")	
 		   .directive("holidayForm", function(){
 			return {
 				restrict : 'AEC',
 				templateUrl : 'components/holiday/HolidayForm.html'
 			}
 	})	
})()

