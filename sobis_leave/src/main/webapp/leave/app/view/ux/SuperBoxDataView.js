Ext.define('sobisleave.view.ux.SuperBoxSearch', {
	extend: 'Ext.dataview.component.DataItem',
   	requires: ['Ext.field.Text'],
    xtype: 'superBoxSearch',    
    config: {    	
      	searchField: {      		
      	   clearIcon: true,          
           margin : '3 3 3 3',
           autoCorrect : false,
           autoCapitalize : false,
           autoComplete : false
        },       
		width : '',
        dataMap: {
            getSearchField: {
                setEmployeeName : 'employeeName',
                setWidth : 'width',
                setClearIcon : 'clearIcon',
                setStyle : 'style',
                setReadOnly : 'readOnly',
                setCls : 'cls',                
                setDeleted : 'deleted',
                setDirty : 'dirty'
            }
        }
   },
   initialize : function(){	   
	  var me = this;
	  me.callParent();	 
	  //me.element.on('keypress', 'onKeyPress', me);   
   },   
   
   applySearchField: function(config) {
      return Ext.factory(config, Ext.field.Text, this.getSearchField());
   },
   
   updateSearchField: function(newf, oldf) {  
   	  var me = this;
      if (oldf) this.remove(oldf);  
     //I had earlier used keyup, it works in chrome, safari and mobile safari, but not on native iOS app. so am using keypress
      if (newf) {
       	newf.on('clearicontap', this.onClearIconTap, this);       	
       	var textf = newf.getComponent().input;       	
       	textf.dom.onkeypress = function (e) { me.onKeyUp(newf,e) };     	        	             	
       	this.add(newf);        	  	
      }
   },
   
   onClearIconTap : function(field, e) {
		var record = this.getRecord(); 	   
		var dataview = field.up('dataview');
		var store = dataview.getStore();
		if (record) {
			/**
			 * * Note - when the user clicks the back button, we need to
			 * find out if the form is dirty, so if we remove the
			 * record, it is not possible. so we soft delete the record.
			 * Now we soft delete records only that are committed or in
			 * other words when we open a document from backend, the
			 * superbox values already set, but when we remove an
			 * existing recipient, we need to set the form is dirty. We
			 * could have ideally used the "record.dirty = true", but
			 * since we create records in dataview of superbox on every
			 * load, all records are new.
			 *  - PIRSJAVA-4314.
			 */
			if (record.get('dirty') == false) {
				record.set('deleted', 'yes');
				record.set('dirty', true)
				field.hide();
			} else {
				store.remove(record);
			}
		} 
   },
    
   onKeyUp : function(field, e) {	  
	
		if(field.getValue().length > 1) { 				
 			var superboxListPanel = sobisleave.superbox; //pirsmobile.view.projectcontainer.Superbox; //Ext.ComponentQuery.query('#superboxPanel');
 			superboxListPanel.setField(field);
 			var superboxList = superboxListPanel.down('list');	         			
     		var store = superboxList.getStore();     		
     		    				             		
     		store.loadPage(1);	     
     		store.sort('employeeName', 'ASC')
     		superboxListPanel.showBy(field, 'tc-bc?');
		} 
 	}
   
});

Ext.define('sobisleave.view.ux.SuperBoxDataView', {
	extend: 'Ext.dataview.DataView',
    requires: ['sobisleave.view.ux.SuperBoxSearch'],
    xtype: 'superBoxDataView',  
    config : {
    	dataViewLabel : '',
    	parentForm : null,
    	defaultType   : 'superBoxSearch',
		useComponents : true,
	    scrollable : null,
	    inline        : {
	        wrap : true
	    },
	    store: {	        
	    	fields: ['id', 'employeeName', 'width', 'clearIcon', 'readOnly', 'style','cls', 'deleted', 'dirty']
	    }
	},
	initialize : function(){
		var self = this;
		this.callParent(arguments);
		
		this.label = {
			docked:			'top',
			xtype:			'label',				
			style :			'height:auto;font-size:11px;padding: 0.4em;background-color: #f7f7f7',
			width:			'100%',
			html:			self.config.dataViewLabel	
		};
		
		this.add([self.label])
		
	}
});