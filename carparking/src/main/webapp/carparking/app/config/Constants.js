if (typeof carparking == 'undefined') var carparking = {};
carparking = carparking || {};
carparking.config = carparking.config || {};

carparking.config.constants = {
	BASEURL:					'http://172.16.9.40:8080/carparking/',
	IS_NATIVE_APP:				'',	
	TIMEOUT:					10000,	
	JSON_READER: {
		TOTAL_PROPERTY:			'totalCount',
		ROOT:					'rows',
		ID_PROPERTY:			'id'
	},
	CONTROLLER : {
		APPLICATION_CONTROLLER : 'applicationController.do',
		ADD_EMPLOYEE : 'addEmployee.do',
		EMPLOYEE_BY_USERNAME : 'getEmployeeByUserName.do',
		ADD_PARKING_REQUEST : 'addParkingRequest.do',
		ADD_ATTENDANCE : 'addAttendance.do',
		GET_ATTENDANCE_DATE_WISE : 'getAttendanceDateWise.do',
		GET_PARKING_REQUESTS : 'getAllParkingRequests.do',
		GET_PARKING_REQUESTS_DATEWISE : 'getAllParkingRequestsPerDate.do',
		GET_PARKING_SLOTS_STATUS : 'getAllParkingSlotsWithStatus.do',
		DELETE_PARKING_REQUEST : 'deleteParkingRequest.do',
		ADD_PARKING_SLOT : 'addParkingSlot.do',
		ADD_USER : 'addUser.do',
		ADD_ROLE : 'addRole.do'
 	},
	FIELDS : {
		
	}
};

Ext.define('carparking.config.Constants', {
	singleton : true,
	constructor : function(config) {
		this.initConfig(config);
		this.callParent([config]);
	}
});