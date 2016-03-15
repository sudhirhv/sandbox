Ext.define("carparking.view.InfoActionSheet", {
	
	extend : 'Ext.Sheet',
	singleton : 'true',	
	config : {
		cardSwitchAnimation:{type:'pop',duration:1000},
	    stretchX : true,	
	    hidden : true,
	    msgs : null
	},
	
	initialize : function() {
		var self = this;
		
		this.msgsTpl = new Ext.XTemplate(		    
		    '<tpl for="msgs">',
		        '<div style = "font-size:9pt;text-align:center;color:white;">{.}</div>',
		    '</tpl>',
		    {
		       compiled:true
		    }
		);
				
		this.msgsPanel = Ext.create('Ext.Panel', {
			 tpl : self.msgsTpl
		});				
				
		this.add([self.msgsPanel]);		
	},
	
	updateAndShowPanel : function() {		
		var self = this;
		var msgsData = {};		    		
		msgsData.msgs = self.getMsgs();	
		
		if(this.getMsgs()) {			
			self.msgsPanel.getTpl().overwrite(self.msgsPanel.element, msgsData);
			self.show();
			setTimeout(function () {
				self.hide();
            }, 3000 /* ms */);	
		}
		
	}
	
})