Ext.define('carparking.controller.Attendance', {
	extend : 'Ext.app.Controller',
	requires : [],
	config : {		
		
		control : {
			'attendanceList' : {	
				initialize : 'initialize'
			}, 
			'attendanceForm button[action=saveAttendance]' : {
				tap : 'saveAttendance'
			}
		}
			
	},
	initialize : function(attendanceList) {	
		var me = this;		
		var store = attendanceList.getStore();
		var proxy = store.getProxy();
		proxy.setExtraParams({
			'date': new Date().getTime()
		})
		store.load()
		me.renderView(attendanceList)		
	},
	
	renderView : function(attendanceList) {
		var me = this;
		me.tpl = Ext.create('Ext.XTemplate',
					//'<div style="font-size:.8em;background-color:white;border:1px solid lightgray;">'+
						'{[this.getAttendanceListEntry(values)]}' 		
					//'</div>'	
					, {
					getAttendanceListEntry : function(o) {
//						console.log('rec',o);
						var employee = o.employee ? o.employee : null;		
						var name = employee && employee.employeeName ? employee.employeeName : '';						
						var result = '<div>'+name+'</div>';		
						return result;
					}
		});
		attendanceList.setItemTpl(me.tpl);		
	},
	
	saveAttendance : function(button) {
		var form = button.up('attendanceForm');
		if(form){
			var params = {};
			params['fromDate'] = form.fromDate.getFormattedValue();
			params['toDate'] = form.toDate.getFormattedValue();
			params['employeeId'] = carparking.config.employeeId;
			
			Ext.Ajax.request({
				url : carparking.config.constants.BASEURL+carparking.config.constants.CONTROLLER.ADD_ATTENDANCE,
				timeout : carparking.config.constants.TIMEOUT,
				params : params,
				success : function(response) {		
					var result = Ext.decode(response.responseText);		
					if(result.success) {
						var attendanceContainer = form.up('attendance');
						if(attendanceContainer) {
							var list = attendanceContainer.down('attendanceList');
							form.hide();
							list.show();
							list.getStore().load();							
						}
					}
				},				
				failure : function(response) {						
					console.log('Failure in ApplicationController call. Could not verify current users access.');			
				}
			})	
		}
	}
}) 