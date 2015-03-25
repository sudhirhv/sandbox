Ext.define('sobisleave.view.employee.form.EmployeeForm', {
	
	extend: 'sobisleave.view.ux.FormPanel',	
	xtype: 'employeeForm',
	
	config : {
		isDisabledFields : true
	},
	
	initialize : function() {
		var me = this;
		me.callParent(arguments);
		
		this.defaults = {
			labelAlign : 'top',
			labelWrap : true,
			clearIcon : false,
			disabled : true,
			disabledCls : null,
			component : {
				disabledCls : null
			},
			readOnly : true		
		};
		
		this.employeeName = {
			xtype : 'textfield',
			name : 'employeeName',
			label : 'Employee Name'
		};
		
		this.employeeId = {
			xtype : 'textfield',
			name : 'employeeId',
			label : 'Employee ID'
		}
		
		this.email = {
			xtype : 'textfield',
			name : 'email',
			label : 'E-Mail'
		}
		
		this.manager = {
			xtype : 'textfield',
			name : 'managerId',
			label : 'Manager'
		}
		
		this.fieldset = Ext.create('Ext.form.FieldSet', {
			defaults : me.defaults,
			items : [
			   me.employeeName.
			   me.employeeId,
			   me.email,
			   me.manager
			]			
		});
		
		this.add([me.fieldset])
		
	}
	
})
 