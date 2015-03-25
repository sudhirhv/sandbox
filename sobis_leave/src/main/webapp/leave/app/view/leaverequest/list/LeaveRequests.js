Ext.define("sobisleave.view.leaverequest.list.LeaveRequests", {
	
	extend : 'sobisleave.view.ux.GeneralView',	
	xtype : 'employeesList',

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
						var result = '<div>'+ rec['typeOfLeave'] + '</div>';
						return result;
					}
		})
	}
});









