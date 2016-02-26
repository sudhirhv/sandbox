Ext.define('carparking.view.ParkingRequestsContainer', {
	extend : 'Ext.Container',
	xtype : 'parkingRequestsContainer',
	config : {
		items : [{
					xtype : 'parkingRequestsDataView'					
				}, {
					xtype: 'titlebar',
    				docked: 'top',
    				title: 'Status as on Feb 26, 2016'
		}]		
	}
});