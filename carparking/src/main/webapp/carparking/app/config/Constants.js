if (typeof carparking == 'undefined') var carparking = {};
carparking = carparking || {};
carparking.config = carparking.config || {};

carparking.config.constants = {
	BASEURL:					'../',
	IS_NATIVE_APP:				'',	
	JSON_READER: {
		TOTAL_PROPERTY:			'totalCount',
		ROOT:					'rows',
		ID_PROPERTY:			'id'
	}
}