Ext.define('sobisleave.proxy.LeaveRequest', {
	extend: 'Ext.data.proxy.Ajax',
	
	alias: 'proxy.LeaveRequest',
	
	config: {
		url: sobisleave.config.constants.BASEURL+sobisleave.config.constants.CONTROLLER.LEAVE_REQUEST_CONTROLLER,
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