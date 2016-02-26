package com.sobis.carparking.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
	
public class ParkingRequestSerializer extends JsonSerializer<ParkingRequest> {
    @Override
    public void serialize(ParkingRequest parkingRequest, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {
        jgen.writeStartObject();        
        jgen.writeStringField("employeeName", parkingRequest.getEmployee().getEmployeeName());       
        jgen.writeEndObject();        
    }	
}
	

