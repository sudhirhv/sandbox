Ext.define("sobisleave.view.viewport.ApplicationContainer", {
	
	extend : 'Ext.tab.Panel',
	requires : [
		
	],
	xtype : 'appContainer',
	config : {
		tabBarPosition : 'bottom',
		tabBar : {			
			cls : 'thisCanBeDragged'			
		}	
	},
	
	initialize : function(){
		var me = this;
		this.callParent(arguments);
		
		me.employeesCardPanel = Ext.create('sobisleave.view.employee.Employee');		
		me.add([
			me.employeesCardPanel
		])
		
	}
})