package org.openvz.customer.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class PojoToJson {
	
	public static String toString(Object object) throws JsonProcessingException
	{
		ObjectMapper jsonMapper = new ObjectMapper();
		jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
		String jsonStringValue = jsonMapper.writeValueAsString(object);
		return jsonStringValue;		
	}

}
