Ext.define('carparking.view.ParkingRequestsContainer', {
	extend : 'Ext.Container',
	xtype : 'parkingRequestsContainer',
	config : {
		items : [{
					xtype : 'parkingRequestsDataView'					
				}, {
					xtype: 'titlebar',
    				docked: 'top',
    				title: Ext.util.Format.date(new Date(),'d-M-y H:i'),
    				items : [{
    					xtype : 'button',					
						ui : 'decline',
						iconCls : 'refresh',
						align : 'right',
						action : 'logout'
    				}]
    				
				}]		
	}
});