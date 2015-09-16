(function(){
	
	angular.module('sobisleave.application.controller', []);
	
	function ApplicationController($scope) {
		console.log('in iife')		
	};

	angular
		.module('sobisleave.application.controller')
		.controller('ApplicationController', ApplicationController);
})()	

