Ext.define('sobisleave.controller.employee.Employee', {
	extend : 'Ext.app.Controller',
	requires : ['sobisleave.view.employee.list.Employees'],
	
	config : {
		control : {
			'employeesList' : {
				itemtap : 'itemtap',
				initialize : 'initialize'
			}		
		}
	},
	
	initialize : function(employeesList) {
		console.log('in init of employees')
		employeesList.getStore().loadPage(1);
	}
	
})