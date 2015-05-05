Ext.define("sobisleave.view.Login", {
	
	extend : 'Ext.form.Panel',	
	xtype : 'loginForm',
	
	config : {	 		
		fullscreen:true,
		id : 'loginFormPanel',		
		layout : {	
			type : 'vbox',
			align : 'center',
			pack : 'center'
		},						
		url : '../j_spring_security_check', // move to constants??
		//submitOnAction : true,    
		// in ST 2.3.1 - http://www.sencha.com/forum/showthread.php?270036 -  a bug was introduced, so until they give a fix, I will use the keyup event in the pwd field
		method : 'POST'		
	},	
	
	initialize : function() {
		this.callParent(arguments);
		var self = this;			
		
		this.username = new Ext.field.Text({
			id : 'usernameField',
			name : 'j_username',
			label : 'Username',
			required : true,			
			labelWidth: '40%',
			clearIcon : true,
			autoCapitalize : false,
			autoComplete : false,
			autoCorrect : false,
			value : '',	
			minWidth: '300px'
		});
		
		this.password = new Ext.field.Password({
			id : 'passwordField',
			name : 'j_password',
			label : 'Password',
			required : true,
			labelWidth: '40%',
			clearIcon : true,
			autoCapitalize : false,
			autoComplete : false,
			autoCorrect : false,			
			minWidth: '300px',
			listeners : {
				keyup : function(field, e) {
					if(e.event.keyCode == 13) {						
						self.onLoginButtonTap();
					} 						
				}				
			}
		});
				
		this.fieldsContainer = new Ext.form.FieldSet({		
			items : [self.username, self.password],			
			margin : '0 0 5 0'
		});
		
		this.submitButton = new Ext.Button({
			ui : 'confirm',
			maxWidth: '90%',			
			minWidth: 300,
			text : 'Submit',			
			handler : function() {
   				this.onLoginButtonTap();
   			},
   			scope : this	
		});
		
		this.toolbar = new Ext.Toolbar({
			 layout: {
                 pack: 'center'
             }, 
             ui: 'plain',
             items : [self.submitButton]
		});
		
		this.titlebar = new Ext.TitleBar({
			docked : 'top',			
			title : 'Login'
		});
		
		this.add([self.titlebar, self.fieldsContainer, self.toolbar]);
	},
	
	onLoginButtonTap : function() {   		
		this.fireEvent('login', this); 
   	}		
})