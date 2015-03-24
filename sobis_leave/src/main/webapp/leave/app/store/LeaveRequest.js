Ext.define('sobisleave.store.LeaveRequest', {
	extend:					'Ext.data.Store',
	config: {
		model:				'sobisleave.model.LeaveRequest',
		autoLoad:			false,
		pageSize:			sobisleave.config.constants.LISTPAGESIZE_UNLIMITED	
	}
});