Ext.define('carparking.unprotected.Cookies', {
	//extend : 'Ext.app.Controller',
	singleton: true,
	
	init : function() {
		
		this.proxyId = 'carparking.cookies',
		this.localStorageModel = Ext.define('LocalStorageCookie', {
			extend : 'Ext.data.Model',				
		    requires : [ 'Ext.data.proxy.LocalStorage' ],				
		    config : {
		    	identifier: {
      				 type: 'uuid'
    			},
				fields : ['id', 'key', 'value'],
				proxy : {
					type : 'localstorage',
					id : this.proxyId
				}
			}
		});		
		this.store = new Ext.data.Store({
			model : "LocalStorageCookie"
		});
		this.store.load();
		
	},

	// Get function
	get : function(key) {		
		
		var indexOfRecord = this.store.find('key', key, 0, false, true,	true);		
		if (indexOfRecord == -1) {
			return null; 
		} else {
			var record = this.store.getAt(indexOfRecord);
			return record.get('value');
		}
	},

	// Set function
	set : function(key, value) {
		var indexOfRecord = this.store.find('key', key, 0, false, true,	true); // <-- Forcing exact matching
		if (indexOfRecord == -1) {
			var record = Ext.ModelMgr.create({
						key : key,
						value : value
					}, 'LocalStorageCookie');
		} else {
			var record = this.store.getAt(indexOfRecord);
			record.set('value', value);
			this.store.sync(); 
		}
		return record.save();
	},
	
	del : function(key) {
		var indexOfRecord = this.store.find('key', key, 0, false, true,
				true);
		if (indexOfRecord == -1) {
			return false;
		} else {
			var record = this.store.removeAt(indexOfRecord);
			this.store.sync();
			return true;
		}
	}

})
