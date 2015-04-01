 Ext.define("sobisleave.view.ux.SelectField", {
 	/* NOTE - fix for PIRSJAVA-4318 and PIRSJAVA-4490
 	 *  	 * We dont have a select event for Select field of ST. This is required for me to identify if the user
 	 * has made a manual selection of recipient code or auto population of recipient code on type of 1st recipient.
 	 * Tried using onChange event, but it triggers for both manual and setvalue() method and therefore notuseful
 	 * the 'itemselected' event is therefore ideal 	 * 
 	 */
    extend: 'Ext.field.Select',
    xtype : 'sobisselectfield',
    
    onListSelect: function (item, record)
    {
        var me = this;
        var oldVal = me.getValue();
        me.callParent(arguments);
        me.fireEvent('itemselected', me, me.getValue(), oldVal);
    },
    onPickerChange: function (item, record)
    {
        var me = this;
        var oldVal = me.getValue();
        me.callParent(arguments);
        me.fireEvent('itemselected', me, me.getValue(), oldVal);
    }
});