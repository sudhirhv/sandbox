Ext.define('sobisleave.proxy.LeaveRequest', {
	extend: 'Ext.data.proxy.Ajax',
	
	alias: 'proxy.LeaveRequest',
	
	config: {
		url: 'http://localhost:8080/sobis_leave/getAllLeaveRequests.view',
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