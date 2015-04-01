Ext.define('sobisleave.store.TypesOfLeave', {
	extend:					'Ext.data.Store',
	config: {
		model:				'sobisleave.model.TypesOfLeave',
		autoLoad:			true,
		pageSize:			sobisleave.config.constants.LISTPAGESIZE_UNLIMITED,
		data : [
				        {id: "Casual",    value: "Casual"},
				        {id: "Maternity",    value: "Maternity"}
		]
	}
});