Ext.define('sobisleave.view.ux.FormPanel', {
	extend : 'Ext.form.Panel',
	xtype : 'generalFormPanel',
	
	config : {	
		docId : null,
		isBackButtonReqd : true, // PIRSJAVA-2804 - We dont show Back button when doclinks are opened.
		isBottomBarReqd : true,
		layout : {
			type : 'vbox',
			align : 'stretch',
			pack : 'start'
		},
		scrollable : true,
		title : '',
		backButtonText : '',
		backButtonAction : 'backAction',
		lastActiveCard : null		
	},
	
	initialize : function(){
		var self = this;
		this.callParent(arguments);		
		
		this.backButtonHandler = function() {		
			Ext.Viewport.animateActiveItem(self.getLastActiveCard(), {
				type : sobisleave.config.constants.ANIMATION,
				direction : 'right'
			})	
		};		
				
		this.backButton = Ext.create('Ext.Button', {
			width : '2em',
			iconCls : 'icon-chevron-left',
			action : self.getBackButtonAction(), 
			hidden : self.getIsBackButtonReqd() ? false : true
		});
		
		this.titlebar = Ext.create('Ext.TitleBar',{
			docked : 'top',				
			cls : 'thisCanBeDragged iOSStatusBarFix',
			ui : 'light',
			title : self.config.title, 
			items : [self.backButton]		
		});
		
		this.bottombar = Ext.create('Ext.TitleBar',{
			docked : 'bottom',				
			cls : 'thisCanBeDragged',
			ui : 'light'					
		}); 
		
		this.add([self.titlebar])
		self.getIsBottomBarReqd() ? this.add([self.bottombar]) : '';		
	}	
})