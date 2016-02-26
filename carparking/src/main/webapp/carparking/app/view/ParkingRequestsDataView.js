Ext.define('carparking.view.ParkingRequestsDataView', {
	extend : 'Ext.DataView',
	xtype : 'parkingRequestsDataView',
	config : {
		scrollable : null,
		inline : {
			wrap : true
		},
		itemCls: 'dataview-item',
		store : 'ParkingRequest',
		itemTpl : ''
		
	}
});