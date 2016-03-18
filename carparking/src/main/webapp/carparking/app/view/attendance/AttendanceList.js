Ext.define('carparking.view.attendance.AttendanceList', {
	extend : 'Ext.dataview.List',	
	xtype : 'attendanceList',
	config : {
		scrollable : null,		
		store : 'Attendance',
		itemTpl : '',
		flex : 1
	}
});