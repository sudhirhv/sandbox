Ext.define('sobisleave.model.LeaveRequest', {
	extend: 'Ext.data.Model',
	requires: 'sobisleave.proxy.LeaveRequest',
	
	config: {
		fields: [
			sobisleave.config.constants.FIELDS.ID,
			'typeOfLeave',
			{
				name: 'leaveStartDate',
				type: 'date',
				dateFormat: 'time'
			}
		],		
		proxy: {
			type: 'LeaveRequest'
		}
	}
});