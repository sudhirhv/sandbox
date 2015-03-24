Ext.define('sobisleave.store.Holiday', {
	extend:					'Ext.data.Store',
	config: {
		model:				'sobisleave.model.Holiday',
		autoLoad:			false,
		pageSize:			sobisleave.config.constants.LISTPAGESIZE_UNLIMITED	
	}
});