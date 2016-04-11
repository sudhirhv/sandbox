Ext.define('carparking.controller.Initialize', {
	extend:				'Ext.app.Controller',
	
	init : function() {	
			Ext.Ajax.request({
				url : carparking.config.constants.BASEURL+carparking.config.constants.CONTROLLER.APPLICATION_CONTROLLER,
				timeout : carparking.config.constants.TIMEOUT,
				params : {},
				success : function(response) {					
					if (response && response.responseText) {
						try {
						    var result = Ext.decode(response.responseText);		
						}
						catch(err) {
						    window.location = carparking.config.constants.BASEURL + "login"	
						}						
						console.log(result.userName)
						if(result) {
							var employee = result.employee ? result.employee : null;					
							carparking.config.userName = result.userName ? result.userName : '';
							carparking.config.currentDate = new Date().getTime();
							if(employee) {
								carparking.config.employeeName = employee.employeeName;
								carparking.config.employeeId = employee.id;
							}	
						}						
					} else if (response && response.raw) {
						window.location = carparking.config.constants.BASEURL + "login"	
					}					
				},
				/*success : function(response) {					
					if (response && response.responseText) {
						var result = Ext.decode(response.responseText);												
						console.log(result.userName)
						if(result) {
							var employee = result.employee ? result.employee : null;					
							carparking.config.userName = result.userName ? result.userName : '';
							carparking.config.currentDate = new Date().getTime();
							if(employee) {
								carparking.config.employeeName = employee.employeeName;
								carparking.config.employeeId = employee.id;
							}	
						}						
					} else if (response && response.raw) {
						window.location = carparking.config.constants.BASEURL + "login"	
					}					
				},*/
				failure : function(response) {
					//window.location = carparking.config.constants.BASEURL + "login"	
					window.location = "/login"
					console.log('Failure in ApplicationController call. Could not verify current users access.');			
				}
			})	
	}
})