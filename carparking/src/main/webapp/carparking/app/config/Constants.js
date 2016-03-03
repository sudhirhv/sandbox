if (typeof carparking == 'undefined') var carparking = {};
carparking = carparking || {};
carparking.config = carparking.config || {};

carparking.config.Constants = {
	BASEURL:					'../',
	IS_NATIVE_APP:				'',	
	TIMEOUT:					10000,	
	JSON_READER: {
		TOTAL_PROPERTY:			'totalCount',
		ROOT:					'rows',
		ID_PROPERTY:			'id'
	}
}