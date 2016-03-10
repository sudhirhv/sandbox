Ext.define('carparking.controller.Main', {
	extend : 'Ext.app.Controller',		
	config: {
		control: {
			'button[action=logout]': {
				tap:	'logout'
			}
		}
	
	},
	logout : function() {		
		window.location = carparking.config.constants.BASEURL + "logout"	
	}
})