Ext.define('carparking.view.ParkingRequestsContainer', {
	extend : 'Ext.Container',
	requires :'Ext.TitleBar',
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
						iconCls : 'reply',
						align : 'right',
						action : 'logout'
    				}]
    				
				}]		
	}
});