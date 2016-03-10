Ext.define('carparking.controller.Initialize', {
	extend:				'Ext.app.Controller',
	
	init : function() {	
			Ext.Ajax.request({
				url : '../'+carparking.config.Constants.CONTROLLER.APPLICATION_CONTROLLER,
				timeout : carparking.config.Constants.TIMEOUT,
				params : {},
				success : function(response) {					
					var result = Ext.decode(response.responseText);		
					console.log(result.userName)
					var employee = result.employee ? result.employee : null;
					
					carparking.config.userName = result.userName ? result.userName : '';
					carparking.config.currentDate = new Date().getTime();
					if(employee) {
						carparking.config.employeeName = employee.employeeName;
						carparking.config.employeeId = employee.id;
						
					}
				},
				failure : function(response) {
					console.log('Failure in ApplicationController call. Could not verify current users access.');			
				}
			})	
	}
})