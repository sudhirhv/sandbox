if (typeof sobisleave == 'undefined') var sobisleave = {};
sobisleave = sobisleave || {};
sobisleave.config = sobisleave.config || {};
sobisleave.application = sobisleave.application || {};
sobisleave.CurrentUser = sobisleave.CurrentUser || {};


sobisleave.config.constants = {
	BASEURL:					'../',
		
	ANIMATION:					(Ext.os.is.iPad || Ext.os.is.iPhone || Ext.os.is.iPod || Ext.os.is.iOS || Ext.os.is.MacOS ? 'slide' : 'slide'),
	ANIMATIONLOGIN:				(Ext.os.is.iPad || Ext.os.is.iPhone || Ext.os.is.iPod || Ext.os.is.iOS || Ext.os.is.MacOS ? 'fade' : 'fade'),
	AUTOCAPITALIZE:				false,
	AUTOCOMPLETE:				false,
	AUTOCORRECT:				false,
	CLEARICON:					true,
	CONTROLLER: {
		EMPLOYEE_CONTROLLER:				'http://localhost:8080/sobis_leave/allEmployees.view',
		LEAVE_REQUEST_CONTROLLER:			'LeaveRequestController'		
	},
	
	JSON_READER: {
		TOTAL_PROPERTY:			'totalCount',
		ROOT:					'rows',
		ID_PROPERTY:			'id'
	},
	KEEP_ALIVE:					60000,
	LABEL_WIDTH:				'30%',
	LANGUAGE:					'en',
	LISTPAGESIZE:				30,
	LISTPAGESIZE_SEARCH:		30,
	LISTPAGESIZE_UNLIMITED:		2000,
	
	FIELDS : {
		ID:									'id'
	}
};

Ext.define('sobisleave.config.Constants', {
	singleton : true,
	constructor : function(config) {
		this.initConfig(config);
		this.callParent([config]);
	}
});