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
		var store = parkingRequestsDataView.getStore();
		var proxy = store.getProxy();
		proxy.setExtraParams({
			'date': new Date().getTime()
		})
		parkingRequestsDataView.getStore().load()
		me.renderView(parkingRequestsDataView)		
	},
	
	renderView : function(parkingRequestsDataView) {
		var me = this;
		me.tpl = Ext.create('Ext.XTemplate',
					'<div style="font-size:.8em;background-color:white;border:1px solid lightgray;">'+
						'{[this.getParkingRequestEntry(values)]}' +				
					'</div>'	
					, {
					getParkingRequestEntry : function(o) {
						//console.log('rec',o);
						var employeeName = o.employeeName && o.employeeName!=null ? o.employeeName : '--';
						var style = o.employeeName && o.employeeName!=null ? 'font-size:.8em;background-color:#EBC2B9;width:100%;text-align:center;padding:20px;box-shadow:0 0 15px 5px rgba(0,0,0,0.5)' 
						: 'font-size:.8em;background-color:#CCE8C3;width:100%;text-align:center;padding:20px;box-shadow:0 0 15px 5px rgba(0,0,0,0.5)';
						var result = '<div style = "'+style +'">'+employeeName+'</div>';		
						return result;
					},					
					getContactImage : function(rec) {
														
					}
		});
		parkingRequestsDataView.setItemTpl(me.tpl);		
	},
	
	itemtap : function(list, index, target, rec, e) {		
		var params = {};
		var store = list.getStore();
		var me = this;
		var url;
		var boolContinue = false;
		
		if(rec.get('employeeName')==null && (store.find('fk_employee', carparking.config.employeeId) < 0)) {
			boolContinue = true;
			params['employee'] = carparking.config.employeeId,//'2c9089a85318ad4a015318ae187f0000',
			params['parkingSlot'] = rec.get('ps_id'),//2c9089a85318bc5d015318bf4a060005',
			params['parkingDate'] = Ext.util.Format.date(new Date(), 'd-m-Y H:i:s');
			url = carparking.config.constants.CONTROLLER.ADD_PARKING_REQUEST
		}		
		if(rec.get('employeeName')!=null && rec.get('fk_employee')==carparking.config.employeeId) {
			boolContinue = true;
			params['pr_id'] = rec.get('pr_id');
			url = carparking.config.constants.CONTROLLER.DELETE_PARKING_REQUEST
		}
		
		if (boolContinue) {
			Ext.Ajax.request({
				url : carparking.config.constants.BASEURL + url,
				timeout : carparking.config.constants.TIMEOUT,
				params : params,
				success : function(response) {
					var result = Ext.decode(response.responseText);
					if (result.success) {
						var proxy = list.getStore().getProxy();
						proxy.setExtraParams({
									'date' : new Date().getTime()
								})
						list.getStore().load();
					}
				},
				failure : function(response) {
					console.log('Failure in ApplicationController call. Could not verify current users access.');
				}
			})
		} else {
			console.log('no access to act or you have already chosen the slot')
		}
	}		
})