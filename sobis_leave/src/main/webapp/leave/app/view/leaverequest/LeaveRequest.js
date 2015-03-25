Ext.define('sobisleave.view.leaverequest.LeaveRequest', {
	
	extend: 'Ext.Panel',	
	xtype: 'leaveRequestCardPanel',		
	requires: [	'sobisleave.view.leaverequest.list.LeaveRequests'],
	
	config: {
		title : 'Leave Requests',
		iconCls: '',		
		layout: {
			type: 'card'
		}
	},

	initialize : function() {
		var me = this;
		this.callParent(arguments);		
		this.leaveRequestsList = Ext.create('sobisleave.view.leaverequest.list.LeaveRequests');
		this.add([me.leaveRequestsList])
	}	
});