Ext.define("carparking.view.attendance.AttendanceForm", {
	extend : 'Ext.form.Panel',
	xtype : 'attendanceForm',
	
	config : {			
		url : carparking.config.constants.BASEURL+carparking.config.constants.CONTROLLER.ADD_ATTENDANCE,
		flex : 1,
		hidden : true,
		layout : {	
			type : 'vbox'    			
		},	
		scrollable : true,			
		method : 'POST'
	},
	initialize : function() {
		this.callParent(arguments);
		var self = this;
		
		//datepickerfield 
		this.fromDate = Ext.create('Ext.field.DatePicker', {
		    label: 'From date',
		    value: new Date(),
		    name : 'fromDate',
		    dateFormat : 'd-m-Y'
		});
		
		this.toDate = Ext.create('Ext.field.DatePicker', {
			name : 'toDate',
		    label: 'To date',
		    value: new Date(),
		    dateFormat : 'd-m-Y'
		});
		
		this.employee = {
   			xtype : 'hiddenfield',
   			name : 'employee',
   			value : carparking.config.employeeId
   		};
   		
   				
   		this.saveButtonContainer = {
   			xtype : 'container',
   			padding : '15px',
   			layout : {
				type : 'hbox'				
			},
   			items : [{
	   			xtype : 'button',   			
	   			action : 'saveAttendance',
	   			text : 'Save',
	   			flex : 1
   			}]
   		};
   		
   		this.add([self.fromDate, self.toDate, self.employee, self.saveButtonContainer])   				
	}
})