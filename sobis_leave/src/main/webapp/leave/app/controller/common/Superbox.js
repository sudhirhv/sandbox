Ext.define('sobisleave.controller.common.Superbox', {
	extend : 'Ext.app.Controller',	
	config : {		
		control : {			
			'superboxList list' : {
				itemtap : 'itemtap'
			}
		}
	},

	itemtap : function(superboxList, index, target, record) {		
		var id = record.getId();
		var name = record.get('employeeName');
			superboxObj = {};		
		console.log('name',name)
		superboxObj['id'] = id;
		superboxObj['employeeName'] = name;		
							
		var panel = superboxList.up('panel');
		var dataItemField = panel.getField();
		
		var data = sobisleave.config.Functions.getSuperboxSearchField({
			superboxObj : superboxObj,
			isSearchField : false,
			dirty : true
		});		
		var dataview = dataItemField.up('dataview');
		var store = dataview.getStore();		
		
		var boolInsert = true;
		var rec = store.findRecord('id', id);
		rec && rec['deleted'] == '' ? boolInsert = false : '';
		console.log('data',data)
		boolInsert ? dataview.getStore().insert(dataview.getStore().getCount()-1, data) : '';
		
		dataItemField.setValue('');
		sobisleave.superbox.hide();
		
	}
});