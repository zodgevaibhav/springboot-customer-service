package org.openvz.customer.controllers.adapters;

import java.lang.reflect.Type;

import org.openvz.customer.utilities.PojoToJson;
import org.openvz.customer.utilities.PojoToXml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import com.fasterxml.jackson.core.JsonProcessingException;

@ControllerAdvice
public class RequestBodyAdviceAdapterImpl extends RequestBodyAdviceAdapter{

	Logger logger = LoggerFactory.getLogger(RequestBodyAdviceAdapterImpl.class);
	
	@Override
	public boolean supports(MethodParameter arg0, Type arg1, Class<? extends HttpMessageConverter<?>> arg2) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {

		try {
			if(inputMessage.getHeaders().getContentType().toString().contains("xml"))
				logger.info(PojoToXml.toString(body));
			else if(inputMessage.getHeaders().getContentType().toString().contains("json"))
				logger.info(PojoToJson.toString(body));
			else
				logger.error("!!!!!!!!!! Unexpected content type detected "+inputMessage.getHeaders().getContentType().toString());
		} catch (JsonProcessingException e) {
			logger.error("!!!!!!!!!! Unable to print requst message "+e.getLocalizedMessage());
		}
		
		return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
	}

}
