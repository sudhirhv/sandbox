(function(){
	
	angular.module('sobisleave.holiday.controller',[]);
	
	
	
	
	function HolidayController($scope, holidayService) {
		
		holidayService.getHolidays().then(function(holidays){
			console.log('data',holidays.rows)
			$scope.holidays = holidays.rows;
		});
		
		console.log('in holiday controller')
		
		/*$scope.highlightFilteredHeader = function( row, rowRenderIndex, col, colRenderIndex ) {
			return col.filters[0].term ? 'header-filtered' : ''			
		};
		
		var paginationOptions = {
				pageNumber: 1,
				pageSize: 20,
				sort: null
		};
		
		$scope.gridOptions = {
			paginationPageSizes: [10,30, 50, 75],
			paginationPageSize: 20,
			enableFiltering: true,
			useExternalPagination: true,
			useExternalSorting: true,
			useExternalFiltering: true,
			columnDefs: [{ name:"Holiday Name", field:"holidayName", headerCellClass: $scope.highlightFilteredHeader  },
			             { field: 'id', visible: false}]
		};
		
		$http.get(url)
			.success(function (holidayData) {

				var data=holidayData.rows;
				$scope.gridOptions.totalItems = countryData.total;
				$scope.gridOptions.data = data;
				$scope.gridOptions.minRowsToShow = 10;
				$scope.gridOptions.enableHorizontalScrollbar = 0;
				$scope.gridOptions.enableVerticalScrollbar = false;
		});*/
		
	};

	angular
		.module('sobisleave.holiday.controller')
		.controller('HolidayController',['$scope', 'HolidayService', HolidayController]);
})()	

