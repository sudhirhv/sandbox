Ext.define('carparking.model.ParkingRequest', {
	extend: 'Ext.data.Model',
	requires: 'carparking.proxy.ParkingRequest',
	
	config: {
		fields: [
			'id',
			'employee'			
		],
		proxy: {
			type: 'ParkingRequest'
		}
	}
})