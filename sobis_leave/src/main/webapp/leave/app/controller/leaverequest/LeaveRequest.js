Ext.define('sobisleave.controller.leaverequest.LeaveRequest', {
	extend : 'Ext.app.Controller',
	requires : ['sobisleave.view.employee.list.Employees'],
	
	config : {
		control : {
			'leaveRequestsList' : {
				itemtap : 'itemtap',
				initialize : 'initializeLeaveRequestsList'
			},
			'button[action=createNewLeaveRequest]' : {
				tap : 'createNewLeaveRequest'
			}, 
			'leaveRequestForm' : {
				initialize : 'initializeNewLeaveRequest'
			}
		}
	},
	
	initializeLeaveRequestsList : function(leaveRequestsList) {
		var newLeaveRequestButton = Ext.create('Ext.Button', {
			 iconCls: 'compose',
			 align:  'right',
			 action: 'createNewLeaveRequest'			  
		});		
		leaveRequestsList.titlebar.add([newLeaveRequestButton]);
		leaveRequestsList.getStore().loadPage(1);
	},
	
	createNewLeaveRequest : function(button) {
		console.log('in creation of new leave requests');
		var leaveRequest = Ext.create('sobisleave.view.leaverequest.form.LeaveRequestForm');
		console.log(leaveRequest);
		if(leaveRequest) sobisleave.config.Functions.openCard(leaveRequest);
	},
	
	initializeNewLeaveRequest : function(leaveRequestForm) {
		var superboxDataViews = [leaveRequestForm.requestorDataView, leaveRequestForm.approverDataView];
		for ( var xi = 0; xi < superboxDataViews.length; xi++) {
			superboxDataViews[xi].getStore().add(sobisleave.config.Functions.getSuperboxSearchField({isSearchField : true}));			
		}	
	}
	
})
 
 
 
 