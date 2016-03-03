Ext.define('carparking.controller.Initialize', {
	extend:				'Ext.app.Controller',
	
	init : function() {	
			Ext.Ajax.request({
				url : '../'+'applicationController.view',
				timeout : carparking.config.Constants.TIMEOUT,
				params : {},
				success : function(response) {					
					var result = Ext.decode(response.responseText);		
					console.log(result.userName)
					carparking.config.userName = result.userName ? result.userName : '';
					carparking.config.currentDate = new Date().getTime();
				},
				failure : function(response) {
					console.log('Failure in ApplicationController call. Could not verify current users access.');			
				}
			})	
	}
})