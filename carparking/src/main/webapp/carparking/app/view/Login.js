Ext.define("carparking.view.Login", {
	extend : 'Ext.form.Panel',
	xtype : 'login',
	
	config : {	
		fullscreen : true,
		id : 'loginFormPanel',		
		layout : {	
			type : 'vbox',
			align : 'center',
			pack : 'center'
		},	
		scrollable : true,			
		method : 'POST'
	},
	
	initialize : function(){
		
		this.callParent(arguments);
		var self = this;
		
		this.baseUrl = '../';		
		carparking.unprotected.Cookies.init();		
		var lastUsername = carparking.unprotected.Cookies.get('username');	
		var lastPassword = carparking.unprotected.Cookies.get('password');
		
		this.username = new Ext.field.Text({
			id : 'usernameField',
			name : 'username',
			label : 'Username',
			required : true,			
			labelWidth: '40%',
			clearIcon : true,
			autoCapitalize : false,
			autoComplete : false,
			autoCorrect : false,						
			minWidth: '300px',
			value : lastUsername && lastUsername!='' ? lastUsername : ''		
		});
		
		this.password = new Ext.field.Password({
			id : 'passwordField',
			name : 'password',
			label : 'Password',
			required : true,
			labelWidth: '40%',
			clearIcon : true,
			autoCapitalize : false,
			autoComplete : false,
			autoCorrect : false,			
			minWidth: '300px',
			value : lastPassword && lastPassword!='' ? lastPassword : '',		
			listeners : {
				keyup : function(field, e) {
					if(e.event.keyCode == 13) {
						 //self.up('formpanel').submit();
						 self.submitHandler();
					} 						
				}				
			}
		});
		
		this.msg = new Ext.Label({
			html : '',
			style : 'font-style: italic;font-size: .8em;color: red;margin: 5px;text-align:center',
			hidden : true
		})
				
		this.fieldsContainer = new Ext.form.FieldSet({		
			items : [self.username, self.password, self.msg],			
			margin : '0 0 5 0'
		});
		
		this.image = new Ext.Img({			
			cls: 'sobisLogo',
			width : '100%'	        
		});
		
		this.imageContainer = new Ext.Container({
			width: 300,
		    height: 100,
		    layout: 'fit',
			items : [self.image]
		});
			
		this.submitButton = new Ext.Button({
			ui : 'confirm',
			maxWidth: '90%',			
			minWidth: 300,
			text : 'Log in',
			handler: function(btn) {
				 self.submitHandler();		
            }
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
			title : 'Log in',
			height : 50
		});		
		
		
		this.submitHandler = function(response){
			var frm = Ext.getCmp('loginFormPanel');
			var values = frm.getValues();			
			if(self.username.getValue()!='' && self.password.getValue()!=''){
				Ext.Ajax.request({
					url: self.baseUrl + 'carparking/j_spring_security_check',
		            method: 'POST',
		            params: frm.getValues(),
		            scope: this,
		            success: function(response){
		            	if(response) {
		            		var result = Ext.decode(response.responseText);	
			            	if(result && result.success) {			            		
				            	carparking.unprotected.Cookies.set('username', self.username.getValue());		
				            	carparking.unprotected.Cookies.set('password', self.password.getValue());
				            	window.location = "carparking/index.html"		            		
			            	} else {
			            		self.msg.setHtml('Invalid username or password');
			            		self.msg.show();		            		  
			            	}
		            	} else {
		            		self.msg.setHtml('Invalid username or password');
		            		self.msg.show();		            		  
		            	}		            	
		            },
		            failure : function(){
		            	self.msg.setHtml('Application not available');
	            		self.msg.show();		            	  
		            }
		       	 })
			} else {
				self.msg.setHtml('Enter Username and password to login');
        		self.msg.show();			
			}			
		};
		
		this.addEventListener([self.titlebar, self.imageContainer, self.fieldsContainer, self.toolbar])		
	}
})