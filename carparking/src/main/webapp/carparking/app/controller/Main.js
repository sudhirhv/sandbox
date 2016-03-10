Ext.define('carparking.controller.Main', {
	extend : 'Ext.app.Controller',		
	config: {
		control: {
			'button[action=logout]': {
				tap:	'logout'
			},
			'button[action=refresh]': {
				tap:	'refresh'			
			}
		}
	
	},
	logout : function() {		
		window.location = carparking.config.constants.BASEURL + "logout"	
	}, 
	refresh : function(button) {
		var titlebar = button.up('titlebar');
		if(titlebar) {
			var list = titlebar.up('dataview');
			if(list) list.getStore().loadPage(1);	
		}				
	}
})