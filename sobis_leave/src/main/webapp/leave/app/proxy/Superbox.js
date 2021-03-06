Ext.define('sobisleave.proxy.Superbox', {			
	extend: 'Ext.data.proxy.Ajax',	
	alias: 'proxy.Superbox',	
	config: {
		url: 'http://localhost:8080/sobis_leave/allEmployees.view',
		reader: {
			type: 'json',
			totalProperty: sobisleave.config.constants.JSON_READER.TOTAL_PROPERTY, 
			rootProperty: sobisleave.config.constants.JSON_READER.ROOT,
			successProperty: 'success',
			idProperty: sobisleave.config.constants.JSON_READER.ID_PROPERTY
		},
		actionMethods: {
			create: 'POST',
			read: 'POST',
			update: 'POST',
			destroy: 'POST'
		},
		extraParams: {
			
		}
	}
});
