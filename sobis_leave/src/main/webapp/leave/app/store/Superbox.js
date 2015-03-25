Ext.define('sobisleave.store.Superbox', {
	extend :		'Ext.data.Store',	
	requires :		'sobisleave.model.Superbox',
	config: {		
		model:				'sobisleave.model.Superbox',
		autoLoad:			false,
		pageSize:			sobisleave.config.constants.LISTPAGESIZE_UNLIMITED
	}
});