Ext.define('sobisleave.controller.leaverequest.LeaveRequest', {
	extend : 'Ext.app.Controller',
	requires : ['sobisleave.view.employee.list.Employees'],
	
	config : {
		control : {
			'employeesList' : {
				itemtap : 'itemtap',
				initialize : 'initialize'
			},
			'button[action=newLeaveRequest]' : {
				tap : 'newLeaveRequest'
			}
		}
	},
	
	initialize : function(leaveRequestsList) {
		var newLeaveRequestButton = Ext.create('Ext.Button', {
			 iconCls: 'compose',
			 align:  'right',
			 action: 'newLeaveRequest'			  
		});		
		leaveRequestsList.titlebar.add([newLeaveRequestButton]);
		leaveRequestsList.getStore().loadPage(1);
	},
	
	newLeaveRequest : function(button) {
		console.log('in creation of new leave requests');
		var leaveRequest = Ext.create('sobisleave.view.leaverequest.form.LeaveRequestForm');
		console.log(leaveRequest);
		if(leaveRequest) sobisleave.config.Functions.openCard(leaveRequest);
	}
	
})
 
 
 
 