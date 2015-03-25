Ext.define('sobisleave.model.Superbox', {
	extend: 'Ext.data.Model',
	requires: 'sobisleave.proxy.Superbox',	
	config: {
		fields: [			
				'employeeName',
				sobisleave.config.constants.FIELDS.ID					
		],
		proxy: {
			type: 'Superbox'
		}
	}
});