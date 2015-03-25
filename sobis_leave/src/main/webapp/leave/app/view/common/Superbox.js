Ext.define("sobisleave.view.common.Superbox", {
	
	extend: 'Ext.Panel',		
	xtype : 'superboxList',
	requires : ['Ext.dataview.List','sobisleave.store.Superbox'],
	config : {			
		field : null,
		height: '30%',        
        left: '5%',
        padding: 5,
        top: '0%',
        width: Ext.os.is.Android || Ext.os.is.iPhone ||  Ext.os.is.iPod || Ext.os.is.iPhone5  ? '90%' : '40%',
        hideOnMaskTap: true,
        modal: true,
        hidden : true,
        itemId : 'superboxPanel'
	},
	
	initialize : function () {
		
		var me = this;
		this.callParent(arguments);
		
		this.list = Ext.create('Ext.List', {
			xtype: 'list',
			store : 'Superbox',
			height : '100%',
			itemHeight : 35,
			itemTpl: '<div style="font-size:10px;">{employeeName}</div>'
		});
		
		this.add([me.list])
	}
}); 

