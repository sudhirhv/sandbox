Ext.define('sobisleave.store.LeaveDurationType', {
	extend:					'Ext.data.Store',
	config: {
		model:				'sobisleave.model.LeaveDurationType',
		autoLoad:			true,
		pageSize:			sobisleave.config.constants.LISTPAGESIZE_UNLIMITED,
		data : [
				        {id: "Full",    value: "Full"},
				        {id: "Half",    value: "Half"}
		]
	}
});