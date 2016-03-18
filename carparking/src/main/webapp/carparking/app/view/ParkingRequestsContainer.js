Ext.define('carparking.view.ParkingRequestsContainer', {
		extend : 'Ext.Container',
		requires : 'Ext.TitleBar',
		xtype : 'parkingRequestsContainer',
		config : {
			layout : {
				type : 'vbox',
				align : 'stretch',
				pack : 'start'
			},
			scrollable : true,		
			items : [{
				xtype : 'parkingRequestsDataView',
				flex : 1
			}, {
				xtype : 'attendance',
				flex : 1
			}]
	}
});