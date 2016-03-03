Ext.define('carparking.model.ParkingRequest', {
	extend: 'Ext.data.Model',
	requires: 'carparking.proxy.ParkingRequest',
	
	config: {
		fields: [
			  'ps_id',
		      'fk_employee',
		      'parkingDate',
		      'employeeName'		
		],
		proxy: {
			type: 'ParkingRequest'
		}
	}
})