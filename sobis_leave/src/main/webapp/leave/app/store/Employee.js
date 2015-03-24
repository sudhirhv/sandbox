Ext.define('sobisleave.store.Employee', {
	extend:					'Ext.data.Store',
	config: {
		model:				'sobisleave.model.Employee',
		autoLoad:			false,
		pageSize:			sobisleave.config.constants.LISTPAGESIZE_UNLIMITED	
	}
});