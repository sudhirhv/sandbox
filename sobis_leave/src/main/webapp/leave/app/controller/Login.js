Ext.define('sobisleave.controller.application.Login', {
	extend:				'Ext.app.Controller',

	config: {
		control: {
			'loginForm' : {				
				login : 'login'				
			}
		}
	},
	
	init : function() {
		var me = this;
		console.log('in init of a login controller')
		return
		/*Ext.Ajax.request({
			url : sobisleave.config.constants.Controller.APPLICATION,
			timeout : sobisleave.config.constants.TIMEOUT,
			scope : me,
			success : me.checkSessionSuccessHandler,			
			failure : me.showLogin,
			params : {
				keepAlive : true
			}
		});		*/
	},
	
	initialize : function(loginForm) {},
	
	login : function(loginForm) {	
		var me = this;				
		var values = loginForm.getValues();			
		if(loginForm.username.getValue()!='' && loginForm.password.getValue()!=''){
			Ext.Ajax.request({
				url: '../j_spring_security_check',
	            method: 'post',
	            params: loginForm.getValues(),
	            scope : me,
	            success: me.loginSuccessHandler,	            
	            failure : function(){			
					Ext.Msg.alert('Error', sobisleave.unprotected.Labels.Login.CONNECTION_ERROR, Ext.emptyFn);
				}
	       	 })
		} else {
			Ext.Msg.alert('Error', sobisleave.unprotected.Labels.Login.USERNAME_PWD_MISSING, Ext.emptyFn);  
		}			
	},
	
	loginSuccessHandler : function(response) {
		var me = this;
		var result = response.responseText ? Ext.decode(response.responseText) : response;
		console.log('result',result);
    	switch (result.success) {
			case true:
			
				var applicationViewPort = Ext.create('sobisleave.view.viewport.ApplicationViewPort');
				applicationViewPort.add(Ext.create('sobisleave.view.viewport.ApplicationContainer'));
				
				sobisleave.superbox = Ext.create('sobisleave.view.common.Superbox');					
				applicationViewPort.add(sobisleave.superbox);
		
				sobisleave.store.typesOfLeaveStore = Ext.create("sobisleave.store.TypesOfLeave");
				sobisleave.store.leaveDurationStore = Ext.create("sobisleave.store.LeaveDurationType");
				
				//console.log('sobisleave.store.typesOfLeaveStore',sobisleave.store.typesOfLeaveStore);
				//console.log(sobisleave.store.leaveDurationStore)	
				
		        Ext.Viewport.add(applicationViewPort);
								
				break;
			case false:				
        }
	},
	

	initApplication : function() {}	
});