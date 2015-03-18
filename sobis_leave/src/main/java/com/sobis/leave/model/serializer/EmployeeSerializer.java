package com.sobis.leave.model.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.sobis.leave.model.Employee;
	
public class EmployeeSerializer extends JsonSerializer<Employee> {
    @Override
    public void serialize(Employee employee, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {
        jgen.writeStartObject();        
        jgen.writeStringField("id", employee.getManager().getId()); // This will get output as manager.id (nested object)
        /*jgen.writeStringField("id", employee.getId());
        jgen.writeStringField("name", employee.getEmployeeName());
        jgen.writeStringField("email", employee.getEmail());
        jgen.writeObjectField("createdOn", employee.getCreatedOn());
        jgen.writeObjectField("modifiedOn", employee.getModifiedOn());*/
        jgen.writeEndObject();        
    }	
}
	

