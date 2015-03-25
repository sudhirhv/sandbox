Ext.define("sobisleave.view.viewport.ApplicationContainer", {
	
	extend : 'Ext.tab.Panel',
	xtype : 'applicationContainer',
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
		me.leaveRequestCardPanel = Ext.create('sobisleave.view.leaverequest.LeaveRequest');
		
		me.add([
			me.employeesCardPanel,
			me.leaveRequestCardPanel
		])
		
	}
})