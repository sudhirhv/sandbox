(function() {

	angular.module('sobisleave.holiday.service', []);	
	
	function HolidayService($http, $q) {
		this.getHolidays = function(){
			var deferred = $q.defer();
			$http.get("../allHolidays.view").success(function(data){				
				deferred.resolve(data);
			}).error(function(data){
				deferred.error(data);
			});
			return deferred.promise;
		};
	};
	
	/*function HolidayService($http, $q, $log) {		
			this.getHolidays = function(movie) {
				var deferred = $q.defer();
				$http.post("../allHolidays.view").success(function(data) {
							deferred.resolve(data);
						}).error(function(msg, code) {
							deferred.reject(msg);
							$log.error(msg, code);
						});
				return deferred.promise;
			}
		
	};*/

	angular.module('sobisleave.holiday.service')
		   .service('HolidayService', ['$http', '$q', '$log', HolidayService]);
})();
