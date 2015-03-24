Ext.define("sobisleave.view.employee.list.Employees", {
	
	extend : 'sobisleave.view.ux.GeneralView',	
	xtype : 'employeesList',

	config : {		
		store : 'Employee',
		cls : 'employeesList',		
		title: 'All Employees',
		emptyText  : '<div class="icon-search"></div>'+'No results',
		itemTpl: Ext.create('Ext.XTemplate',
					'<div class="contact-list-entry">'+
						'{[this.getEmployeeEntry(values)]}' +				
					'</div>'	
					, {
					getEmployeeEntry : function(rec) {					
						var result = '<div class="contact_name">'+ rec['employeeName'] + '</div>';
						return result;
					}
		})
	}
});









