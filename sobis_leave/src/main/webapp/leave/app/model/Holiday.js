Ext.define('sobisleave.model.Holiday', {
	extend: 'Ext.data.Model',
	requires: 'sobisleave.proxy.Holiday',
	
	config: {
		fields: [
			sobisleave.config.constants.FIELDS.ID		
		],		
		proxy: {
			type: 'Holiday'
		}
	}
});