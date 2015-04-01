Ext.define('sobisleave.controller.leaverequest.LeaveRequest', {
	extend : 'Ext.app.Controller',
	requires : ['sobisleave.view.employee.list.Employees'],
	
	config : {
		control : {
			'leaveRequestsList' : {
				itemtap : 'itemtap',
				initialize : 'initializeLeaveRequestsList'
			},
			'leaveRequestsList button[action=createNewLeaveRequest]' : {
				tap : 'createNewLeaveRequest'
			}, 
			'leaveRequestForm' : {
				initialize : 'initializeNewLeaveRequest',				
				setHiddenDateFormat : 'setHiddenDateFormat'
			},
			'leaveRequestForm datepickerfield[name="leaveStartDateDisplay"]' :  {
				change : 'setHiddenDateFormatStartDate'
			},
			'leaveRequestForm datepickerfield[name="leaveEndDateDisplay"]' :  {
				change : 'setHiddenDateFormatEndDate'
			},
			'leaveRequestForm button[action=submitLeaveRequest]' : {
				tap : 'submitLeaveRequest'
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
		if(leaveRequest) sobisleave.config.Functions.openCard(leaveRequest);
	},
	
	initializeNewLeaveRequest : function(leaveRequestForm) {
		var me = this;
			
		//leaveRequestForm.requestorDataView.getStore().add(sobisleave.config.Functions.getSuperboxSearchField({isSearchField : true}));		
		leaveRequestForm.requestorDataView.getStore().add({
			id : '2c9089974be4024a014be404d9780002',
			employeeName : 'Sudhir'
		})
		
		var params = {}; 
		params['employeeId'] = '2c9089974be4024a014be404d9780002',
		params['leaveYear'] = 2015;
		
		var successHandler = function(response) {
			var result = response.responseText ? Ext.decode(response.responseText) : response;				
			var rec = result.rows ? result.rows : null;
			
	    	switch (result.success) {
				case true:
					//console.log('result',rec);
					var availableLeaveBalance = leaveRequestForm.down('numberfield[name="availableLeaveBalance"]');
					availableLeaveBalance.setValue(rec['availableLeaveBalance']);
					leaveRequestForm.approverDataView.getStore().add(rec['manager']);					
					break;
				case false:
					break;
	    	}
		};
		
		Ext.Ajax.request({
			url : 'http://localhost:8080/sobis_leave/employeeLeaveDetails.view',
			method : 'POST',
            params: params,
            scope: me,
            success : successHandler
       	 });
	    	
	},
	
	setHiddenDateFormatStartDate : function(field) {
		var o = {};
		o.field = field;
		o.displayField = 'leaveStartDateDisplay';
		o.hiddenField = 'leaveStartDate';		
		this.setHiddenDateFormat(o);
	},
	
	setHiddenDateFormatEndDate : function(field) {
		var o = {};
		o.field = field;
		o.displayField = 'leaveEndDateDisplay';
		o.hiddenField = 'leaveEndDate';		
		this.setHiddenDateFormat(o);
	},
	
	setHiddenDateFormat : function(config) {
		//console.log('in change of date field',config.field)
		var leaveRequest = config.field.up('leaveRequestForm');
		var displayField = leaveRequest.down('datepickerfield[name="'+config.displayField+'"]');
		var hiddenField = leaveRequest.down('hiddenfield[name="'+ config.hiddenField +'"]');
		hiddenField.setValue(Date.parse(displayField.getValue()));
	},
	
	submitLeaveRequest : function(button) {
		console.log('in submit ');
		var leaveRequest = button.up('leaveRequestForm');
		var startDateField = leaveRequest.down('textfield[name="leaveStartDate"]');
		var formValues = leaveRequest.getValues();	
		var params = {};
		
		var superboxDataViews = {};
		superboxDataViews['requestorName'] = leaveRequest.requestorDataView;
		superboxDataViews['approverName'] = leaveRequest.approverDataView;
			
		for ( var superboxDataView in superboxDataViews) {
			if(superboxDataViews.hasOwnProperty(superboxDataView)) {
				//console.log('superboxDataView',superboxDataView);
				var superboxValues = sobisleave.config.Functions.getSuperboxValues({
					superboxDataView : superboxDataViews[superboxDataView]
				});						
												
				if(superboxValues.length > 0) {					
					params[superboxDataView] = superboxValues;
				} else {
					params[superboxDataView] = '';
				}
			}
		};
		
		//console.log('leaveRequest',formValues);		
		//console.log('leaveStartDate',Ext.Date.format(startDateField.getValue(), 'U'));
		//formValues['leaveStartDate'] = Ext.Date.format(startDateField.getValue(), 'U');
		
		leaveRequest.submit({
			url : 'http://localhost:8080/sobis_leave/newLeaveRequest.view',
			method : 'POST'	,
			params : params
		});		
	}
	
})
 
 
 
 