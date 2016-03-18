Ext.define('carparking.model.Attendance', {
	extend: 'Ext.data.Model',
	requires: 'carparking.proxy.Attendance',
	
	config: {
		fields: [
			  'id',
		      'employee',
		      'date'	      		      
		],
		proxy: {
			type: 'Attendance'
		}
	}
})