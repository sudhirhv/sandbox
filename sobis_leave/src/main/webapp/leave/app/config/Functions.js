Ext.define('sobisleave.config.Functions', {	
	singleton : true,
	
	openCard : function(card) {			
		var applicationViewPort = Ext.ComponentQuery.query('applicationViewPort')[0];
		if(!card) {
			var appContainer = Ext.ComponentQuery.query('applicationContainer')[0];		
			if(!appContainer) {
				card = Ext.create('sobisleave.view.viewport.ApplicationContainer');
			} else card = appContainer;			
		};		
		applicationViewPort.add(card);		
		applicationViewPort.setActiveItem(card);	
	}
})