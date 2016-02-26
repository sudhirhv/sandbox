Ext.define('carparking.store.ParkingRequest', {
	extend:			'Ext.data.Store',	
	config: {
		model:		'carparking.model.ParkingRequest',
		autoLoad:	true,
		pageSize:	'100'
	}
});