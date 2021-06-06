package org.openvz.customer.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class PojoToXml{
	
	public static String toString(Object object) throws JsonProcessingException
	{
		XmlMapper xmlMapper = new XmlMapper();

		String xmlValue = xmlMapper.writeValueAsString(object);
		
		return xmlValue;
	}

}
