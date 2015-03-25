Ext.define('sobisleave.view.leaverequest.form.LeaveRequestForm', {
	
	extend: 'sobisleave.view.ux.FormPanel',	
	xtype: 'leaveRequestForm',
	
	config : {
		isDisabledFields : false
	},
	
	initialize : function() {
		var me = this;
		me.callParent(arguments);
		
		this.defaults = {
			labelAlign : 'top',
			labelWrap : true,
			clearIcon : false,
			disabled : false,
			disabledCls : null,
			component : {
				disabledCls : null
			}
			//readOnly : false		
		};
		
		this.requestorDataView = Ext.create('sobisleave.view.ux.SuperBoxDataView', {
			parentForm : this,
			dataViewLabel : 'Requestor Name'
	    });
	    
	    this.approverDataView = Ext.create('sobisleave.view.ux.SuperBoxDataView', {
			parentForm : this,
			dataViewLabel : 'Approver Name'
	    });
		
		this.requestorName = {
			xtype : 'textfield',
			name : 'requestorName',
			label : 'Requestor Name'
		};
		
		this.approverName = {
			xtype : 'textfield',
			name : 'approverName',
			label : 'Approver Name'
		};
		
		this.availableLeaveBalance = {
			xtype : 'numberfield',
			name : 'availableLeaveBalance',
			label : 'Leave Balance'
		};
		
		this.leaveStartDate = {
			xtype : 'datepickerfield',
			name : 'leaveStartDate',
			label : 'Leave Start date',
			value : new Date()
		};
		
		this.leaveEndDate = {
			xtype : 'datepickerfield',
			name : 'leaveEndDate',
			label : 'Leave End date',
			value : new Date()
		};
		
		this.leaveDuration = {
			xtype : 'numberfield',
			name : 'leaveDuration',
			label : 'Duration'
		};
		
		this.leaveDurationType = {
			xtype : 'textfield',
			name : 'leaveDurationType',
			label : 'Leave Type'
		};
		
		this.leaveType = {
			xtype: 'selectfield',
            label: 'Leave type',
            options: [
                {text: 'Casual',  value: 'Casual'},
                {text: 'Maternity', value: 'Maternity'}                
            ]
		};
		
		this.remarks = {
			xtype : 'textareafield',
			label : 'Reason for Leave',
			name : 'remarks'
		};
					
		this.fieldset = Ext.create('Ext.form.FieldSet', {
			defaults : me.defaults,
			items : [
			   //me.requestorName,
			   //me.approverName,
			   me.requestorDataView,
			   me.approverDataView,
			   me.leaveStartDate,
			   me.leaveEndDate,
			   me.leaveDuration,
			   me.availableLeaveBalance,
			   me.leaveDurationType,
			   me.leaveType,
			   me.remarks
			]			
		});
		
		this.add([me.fieldset])
		
	}
	
})
 