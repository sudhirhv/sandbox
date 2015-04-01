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
	},
	
	getSuperboxValues : function(config) {		
		var values = [];
		var superboxDataView = config.superboxDataView ? config.superboxDataView : null;		
		if(superboxDataView) {
			var records = superboxDataView.getStore().getRange();
			if(records.length > 0) {
				for (var i = 0; i < records.length; i++) {
					if(records[i].data['employeeName']) values.push(records[i].data['id']);
				}	
			};	
		};
		return values;
	},
	
	getSuperboxSearchField : function(config){
		
		var superboxObj = config && config.superboxObj ? config.superboxObj : null;
		
		superboxId = superboxObj && superboxObj['id'] ? superboxObj['id'] : '';		
		superboxValue = superboxObj && superboxObj['employeeName'] ? superboxObj['employeeName'] : '';
		var cn = superboxValue;		
		var isSearchField = config && config.isSearchField ? true : false;
		
		var width = cn.length * 7 ;
			//width = width < 150 ? 150 : width;
			width = width + 40;
	
		return {
			employeeName : cn,
			id : superboxId,
			width: isSearchField ? 260 : width,
			clearIcon : false,
			style : isSearchField ? 'border: 0px none' : 'border-bottom: 1px solid #ddd;',
			readOnly : isSearchField ? null	 : true, // setReadOnly(null) works for native iOS app and not false
			cls : isSearchField ? 'recipients' : 'recipients x-field-clearable x-clear-icon',			
			deleted : '',
			dirty : config.dirty ? config.dirty : false // For recipients coming from backend, we set the property as false. when a modification happens it is changed to true
		}		
	}
})