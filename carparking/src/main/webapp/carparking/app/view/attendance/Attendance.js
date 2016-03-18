Ext.define('carparking.view.attendance.Attendance', {
	extend : 'Ext.Panel',
	requires : 'Ext.TitleBar',
	xtype : 'attendance',
	config : {	
		
		layout : {
			type : 'vbox',
			align : 'stretch',
			pack : 'start'
		},
		scrollable : true	
	},
	
	initialize : function() {
		var self = this;
		this.callParent(arguments);
		
		this.addButton = Ext.create("Ext.Button", {
			ui : 'normal',
			iconCls : 'add',
			align : 'right',		
			handler : function() {
				self.form.show();
				self.backButton.show();
				self.attendanceList.hide();				
			}
		});
		
		this.backButton = Ext.create("Ext.Button", {
			ui : 'normal',
			iconCls : 'arrow_left',
			align : 'left',
			hidden : true,
			handler : function() {				
				self.form.hide();
				self.backButton.hide();
				self.attendanceList.show();
			}
		});
		
		this.titlebar = Ext.create('Ext.TitleBar', {
			docked : 'top',				
			title : 'Absent today',
			items : [self.backButton, self.addButton]
		});
		
		
		this.form = Ext.create('carparking.view.attendance.AttendanceForm');
		
		this.attendanceList = Ext.create('carparking.view.attendance.AttendanceList');
		
		this.add([self.titlebar, self.form, self.attendanceList])
		
	}
});