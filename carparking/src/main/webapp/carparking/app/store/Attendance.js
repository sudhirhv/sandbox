Ext.define('carparking.store.Attendance', {
	extend:			'Ext.data.Store',	
	config: {
		model:		'carparking.model.Attendance',
		autoLoad:	false,
		pageSize:	'100'
	}
});