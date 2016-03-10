Ext.define('carparking.view.ParkingRequestsDataView', {
	extend : 'Ext.dataview.DataView',
	requires : 'Ext.plugin.PullRefresh',
	xtype : 'parkingRequestsDataView',
	config : {
		scrollable : null,
		inline : {
			//wrap : true
		},
		itemCls: 'dataview-item',
		store : 'ParkingRequest',
		itemTpl : '',
		 plugins: [
        {
            xclass: 'Ext.plugin.PullRefresh',
            pullText: 'Pull down for more new Tweets!'
        }
    ],
         items : [{
					xtype: 'titlebar',
    				docked: 'top',
    				cls : 'iOSStatusBarFix',
    				title: Ext.util.Format.date(new Date(),'d-M-y H:i'),
    				items : [{
    					xtype : 'button',					
						ui : 'decline',
						iconCls : 'exit',
						align : 'right',
						action : 'logout'
    				}, {
    					xtype : 'button',					
						ui : 'normal',
						iconCls : 'refresh',
						align : 'left',
						action : 'refresh'
    				}]
    				
				}]
    
	}
});