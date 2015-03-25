Ext.define('sobisleave.model.LeaveRequest', {
	extend: 'Ext.data.Model',
	requires: 'sobisleave.proxy.LeaveRequest',
	
	config: {
		fields: [
			sobisleave.config.constants.FIELDS.ID		
		],		
		proxy: {
			type: 'LeaveRequest'
		}
	}
});