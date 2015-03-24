Ext.define('sobisleave.view.employee.Employee', {
	
	extend: 'Ext.Panel',	
	xtype: 'employeeCardPanel',		
	requires: [	'sobisleave.view.employee.list.Employees'],
	
	config: {
		title : 'Employees',
		iconCls: '',		
		layout: {
			type: 'card'
		}
	},

	initialize : function() {
		var me = this;
		this.callParent(arguments);		
		this.employeesList = Ext.create('sobisleave.view.employee.list.Employees');		
		//me.employeesList.getStore().loadPage(1);
		this.add([me.employeesList])
	}	
});