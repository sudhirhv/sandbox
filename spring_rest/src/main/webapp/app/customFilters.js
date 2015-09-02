/**
 * custom filters
 */
 
 (function(){
 	var app = angular.module("filterModule", []);
 	app.filter('myFilter', function() {
 		return function(customers, searchText) {
 			var searchFields = ['firstName', 'lastName', 'address'];
 			if (!searchText) return customers;
 			var searchRegx = new RegExp(searchText, "i");
		    console.log('in custom filter',customers, searchText)
		    var filteredCustomers = [];
		    for(i = 0; i < customers.length; i++) {
		    	for (var xi = 0; xi < searchFields.length; xi++) {		    		
		    		var field = searchFields[xi];		    		
		    		if (customers[i][field].search(searchRegx) != -1 ) {		        		
		            	filteredCustomers.push(customers[i]);
		       		}
		    	}
		    }
		    return filteredCustomers;
 		}
 	}) 	
 })();