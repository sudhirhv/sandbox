/*
    This file is generated and updated by Sencha Cmd. You can edit this file as
    needed for your application, but these edits will have to be merged by
    Sencha Cmd when it performs code generation tasks such as generating new
    models, controllers or views and when running "sencha app upgrade".

    Ideally changes to this file would be limited and most work would be done
    in other places (such as Controllers). If Sencha Cmd cannot merge your
    changes and its generated code, it will produce a "merge conflict" that you
    will need to resolve manually.
*/

// DO NOT DELETE - this directive is required for Sencha Cmd packages to work.
//@require @packageOverrides

//<debug>
Ext.Loader.setPath({
    'Ext':      'touch/src',
    'Ext.ux':   'touch/src/ux'
});
//</debug>

Ext.application({
    name: 'sobisleave',

    requires: [
        'Ext.MessageBox',
        'sobisleave.config.Constants',
        'sobisleave.config.Functions'
    ],

    views: [
        
    ],

    models: 		[
    	'Employee',
    	'Holiday',
    	'LeaveRequest',
    	'Superbox',
    	'TypesOfLeave',
    	'LeaveDurationType'
    ],
    
    stores:			[
    	'Employee',
    	'Holiday',
    	'LeaveRequest',
    	'Superbox',
    	'TypesOfLeave',
    	'LeaveDurationType'
    ],
    
    controllers:		[
    	'employee.Employee',
    	'leaverequest.LeaveRequest',
    	'common.Superbox'
    ],
    
    icon: {
        '57': 'resources/icons/Icon.png',
        '72': 'resources/icons/Icon~ipad.png',
        '114': 'resources/icons/Icon@2x.png',
        '144': 'resources/icons/Icon~ipad@2x.png'
    },

    isIconPrecomposed: true,

    startupImage: {
        '320x460': 'resources/startup/320x460.jpg',
        '640x920': 'resources/startup/640x920.png',
        '768x1004': 'resources/startup/768x1004.png',
        '748x1024': 'resources/startup/748x1024.png',
        '1536x2008': 'resources/startup/1536x2008.png',
        '1496x2048': 'resources/startup/1496x2048.png'
    },

    viewport: {
		layout: {
			type: 'card'
		}
	},

    
    launch: function() {
        // Destroy the #appLoadingIndicator element
        Ext.fly('appLoadingIndicator').destroy();
        
		var applicationViewPort = Ext.create('sobisleave.view.viewport.ApplicationViewPort');
		applicationViewPort.add(Ext.create('sobisleave.view.viewport.ApplicationContainer'));
		
		sobisleave.superbox = Ext.create('sobisleave.view.common.Superbox');					
		applicationViewPort.add(sobisleave.superbox);

		sobisleave.store.typesOfLeaveStore = Ext.create("sobisleave.store.TypesOfLeave");
		sobisleave.store.leaveDurationStore = Ext.create("sobisleave.store.LeaveDurationType");
		
		console.log('sobisleave.store.typesOfLeaveStore',sobisleave.store.typesOfLeaveStore);
		console.log(sobisleave.store.leaveDurationStore)
		
		
        Ext.Viewport.add(applicationViewPort);
    }  
});
