Ext.define('carparking.proxy.ParkingRequest', {
	extend: 'Ext.data.proxy.Ajax',
	
	alias: 'proxy.ParkingRequest',
	
	config: {
		//url: carparking.config.constants.BASEURL+'getAllParkingRequests.view',
		url : carparking.config.constants.BASEURL+carparking.config.constants.CONTROLLER.GET_PARKING_SLOTS_STATUS,
		type : 'ajax',
		reader: {
			type: 'json',
			totalProperty: 'totalCount',//carparking.config.constants.JSON_READER.TOTAL_PROPERTY,
			rootProperty: 'rows', //carparking.config.constants.JSON_READER.ROOT,
			successProperty: 'success',
			idProperty: 'id' //carparking.config.constants.JSON_READER.ID_PROPERTY
		},
		extraParams : {
			date : ''//1456425000000
		}
		
	}
});