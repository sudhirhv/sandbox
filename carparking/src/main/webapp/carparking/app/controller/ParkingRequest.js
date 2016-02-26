Ext.define('carparking.controller.ParkingRequest', {
	extend : 'Ext.app.Controller',
	requires : [],
	config : {		
		
		control : {
			'parkingRequestsDataView' : {	
				initialize : 'initialize',				
				itemtap : 'itemtap'
			}
		}
			
	},
	initialize : function(parkingRequestsDataView) {	
		var me = this;
		
		
		me.tpl = Ext.create('Ext.XTemplate',
					'<div style="font-size:.8em;background-color:white;border:1px solid lightgray;">'+
						'{[this.getParkingRequestEntry(values)]}' +				
					'</div>'	
					, {
					getParkingRequestEntry : function(o) {
						//console.log('rec',o);
						var rows = o['rows'];
						var employeeObj = o['employee'];
						//console.log(employeeObj);
						var result = '<div style = "width:100%;text-align:center;padding:20px;box-shadow:0 0 15px 5px rgba(0,0,0,0.5)">'+employeeObj.employeeName+'</div>';		
						return result;
					},					
					getContactImage : function(rec) {
														
					},
					getHeader : function(rec) {
						
					},
					getBodyRow : function(rec) {
					
					}
		});
		parkingRequestsDataView.setItemTpl(me.tpl);		
				
	},
	
	itemtap : function(activityList, index, target, rec, e) {		
		console.log('item tapped')
	}
})