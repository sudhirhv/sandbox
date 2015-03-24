Ext.define('sobisleave.view.ux.GeneralView', {	
	
	extend : 'Ext.List',	
	requires : ['Ext.plugin.ListPaging'],	
	xtype : 'generalView',
	
	config : {				
		flex : 1,	
		cls : 'generalList',
		lastActiveCard : null,
		isLeaf : null,
		disableSelection : true,
		deferEmptyText : false,		
		title: '',		
		onItemDisclosure: true,
		disclosed: null,
		emptyText : '<div class="icon-inbox"></div>' + sobisleave.Labels.Common.NO_RECORDS,
		isListPagingReqd : true,
		isPullRefreshReqd : true,
		isTitleBarReqd : true,
		isSearchBarReqd : true,
		isBackButtonReqd : true	
	},
	
	initialize : function() {
		 var self = this;
		 this.callParent();
		 
		 this.backButton = Ext.create('Ext.Button', {
			width : '2em',
			iconCls : 'icon-chevron-left',			
			action : 'backToPreviousCard',
			hidden : self.getIsBackButtonReqd() ? false : true
		 });
		 
		 this.titlebar = Ext.create('Ext.TitleBar', {		 	
			docked : 'top',			
			cls : 'thisCanBeDragged listToolbar iOSStatusBarFix',
			ui : 'light',			
			title : self.config.title,
			items : [this.backButton],
			hidden : self.getIsTitleBarReqd() ? false : true
		 });
		 
		 this.searchField = Ext.create('Ext.field.Search', {
		 	placeHolder : 'Search..',//sobisleave.Labels.Common.SEARCH.text,
		    flex : 1         
		 });
		 
		 this.searchbar = Ext.create('Ext.TitleBar',{
		 	docked : 'top',
		 	cls : 'searchBar',
		 	layout: {
	      		type: 'vbox',       
	        	pack: 'center'
			},
		 	items : [this.searchField],
		 	hidden : self.getIsSearchBarReqd() ? false : true
		 });		
		 
		 this.arrPlugins = [];
		 
		 this.getIsListPagingReqd() ? this.arrPlugins.push({
			type : 'listpaging',
			autoPaging : true,
			noMoreRecordsText : sobisleave.Labels.Common.NO_MORE,
			loadMoreText : sobisleave.Labels.Common.LOAD_MORE
		 }) : '';
		 
		 this.getIsPullRefreshReqd() ? this.arrPlugins.push({			   
	        xclass: 'Ext.plugin.PullRefresh',
	        pullText: sobisleave.Labels.Common.PULL_REFRESH_TEXT,
	        releaseText: sobisleave.Labels.Common.RELEASE_REFRESH_TEXT
		 }) : '';
		 
		 this.setPlugins(self.arrPlugins);
		
		 this.add([
			this.titlebar,
		 	this.searchbar
		 ])		 
	}
})
