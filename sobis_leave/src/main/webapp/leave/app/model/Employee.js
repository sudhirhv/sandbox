Ext.define('sobisleave.model.Employee', {
	extend: 'Ext.data.Model',
	requires: 'sobisleave.proxy.Employee',
	
	config: {
		fields: [
			sobisleave.config.constants.FIELDS.ID,
			'employeeName'
		],		
		proxy: {
			type: 'Employee'
		}
	}
});