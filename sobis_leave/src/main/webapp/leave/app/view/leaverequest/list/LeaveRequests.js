Ext.define("sobisleave.view.leaverequest.list.LeaveRequests", {
	
	extend : 'sobisleave.view.ux.GeneralView',	
	xtype : 'leaveRequestsList',

	config : {		
		store : 'LeaveRequest',
		cls : 'leaveRequestsList',		
		title: 'My Leave Requests',
		emptyText  : '<div class="icon-search"></div>'+'No results',
		itemTpl: Ext.create('Ext.XTemplate',
					'<div class="contact-list-entry">'+
						'{[this.getLeaveRequestEntry(values)]}' +				
					'</div>'	
					, {
					getLeaveRequestEntry : function(rec) {
						console.log('rec')
						var result = '<div>'+ rec['typeOfLeave'] + '</div>';
						return result;
					}
		})
	}
});









