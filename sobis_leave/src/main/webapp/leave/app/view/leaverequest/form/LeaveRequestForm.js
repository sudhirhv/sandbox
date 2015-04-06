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
			name : 'leaveStartDateDisplay',
			label : 'Leave Start date',
			value : new Date(),			
			required : true,
		    dateFormat: 'd.m.Y',
		    listeners : {		    	
		    	change : function() {			 		
					me.fireEvent('onChangeOfStartDate',this);		
				}	
		    }		    	
		};
		
		this.leaveStartDateHidden = {
			xtype : 'hiddenfield',
			name : 'leaveStartDate'
		};
				
		this.leaveEndDate = {
			xtype : 'datepickerfield',
			name : 'leaveEndDateDisplay',
			label : 'Leave End date',
			value : new Date(),
			dateFormat: 'd.m.Y',			
			listeners : {
			 	change : function() {			 							
					me.fireEvent('onChangeOfEndDate',this);
				}		    	
		    }	
		};
		
		this.leaveEndDateHidden = {
			xtype : 'hiddenfield',
			name : 'leaveEndDate'
		};
		
		this.leaveDuration = {
			xtype : 'numberfield',
			name : 'leaveDuration',
			label : 'Duration'
		};
		
		this.leaveDurationType = {			
			name : 'leaveDurationType',
			label : 'Duration type',
			xtype: 'selectfield',
			store : sobisleave.store.leaveDurationStore,
			valueField : 'id',
			displayField : 'value'
		};
		
		this.leaveType = {
			xtype: 'selectfield',
            label: 'Type of Leave',
            name : 'typeOfLeave',
            store : sobisleave.store.typesOfLeaveStore,
            valueField : 'id',
			displayField : 'value'
		};
		
		this.remarks = {
			xtype : 'textareafield',
			label : 'Reason for Leave',
			name : 'remarks'
		};
		
		this.submitLeaveRequestButton = Ext.create('Ext.Button' ,{			 
  			 ui: 'action',
  			 align: 'right',
  			 text:	'Submit',
  			 iconCls : 'mail-plain',
  			 action : 'submitLeaveRequest'
		});
				
		this.titlebar.add([me.submitLeaveRequestButton]);
					
		this.fieldset = Ext.create('Ext.form.FieldSet', {
			defaults : me.defaults,
			items : [
			   //me.requestorName,
			   //me.approverName,
			   me.leaveStartDateHidden,
			   me.leaveEndDateHidden,
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
		
	}, 
	onChangeOfStartDate : function(field) {		
		this.fireEvent('setHiddenDateFormat',this);
	},
	onChangeOfEndDate : function(field) {		
		this.fireEvent('setHiddenDateFormat',this);
	}
})
 