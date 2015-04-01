package com.sobis.leave.web.editors;

import java.beans.PropertyEditorSupport;

import org.joda.time.DateTime;
import org.springframework.core.convert.converter.Converter;

import com.sobis.leave.model.Employee;


public class StringToJodaDateTimeConverter extends PropertyEditorSupport {

    // Converts a String to a Category (when submitting form)
    @Override
    public void setAsText(String text) {    	
    	System.out.println("text "+text);
    	setValue(new DateTime(Long.parseLong(text)));
    }

   
}

/*public class StringToJodaDateTimeConverter implements Converter<String, DateTime> {
	

	 @Override
	 public DateTime convert(String dateValue) {
		System.out.println("dateValue "+dateValue);
		return new DateTime(Long.parseLong(dateValue));
	 }



	public class CategoryToString implements Converter<Category, String> {

	    @Override
	    public String convert(Category source) {
	        return source.getName();
	    }

	}
}*/
