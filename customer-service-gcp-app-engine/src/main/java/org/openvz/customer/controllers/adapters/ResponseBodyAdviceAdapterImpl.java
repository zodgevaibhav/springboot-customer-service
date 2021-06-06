package org.openvz.customer.controllers.adapters;

import org.openvz.customer.utilities.PojoToJson;
import org.openvz.customer.utilities.PojoToXml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.fasterxml.jackson.core.JsonProcessingException;

@ControllerAdvice
public class ResponseBodyAdviceAdapterImpl implements ResponseBodyAdvice<Object>{

	Logger logger = LoggerFactory.getLogger(RequestBodyAdviceAdapterImpl.class);

	
	@Override
	public Object beforeBodyWrite(Object arg0, MethodParameter arg1, MediaType arg2,
			Class<? extends HttpMessageConverter<?>> arg3, ServerHttpRequest arg4, ServerHttpResponse arg5) {

		try {
			if(arg2.toString().contains("xml"))
				logger.info(PojoToXml.toString(arg0));
			else if(arg2.toString().contains("json"))
				logger.info(PojoToJson.toString(arg0));
			else
				logger.error("!!!!!!!!!! Unexpected content type detected "+arg5.getHeaders().getContentType().toString());
		} catch (JsonProcessingException e) {
			logger.error("!!!!!!!!!! Unable to print response message "+e.getLocalizedMessage());
		}
		
		return arg0;
	}

	@Override
	public boolean supports(MethodParameter arg0, Class<? extends HttpMessageConverter<?>> arg1) {

		
		return true;
	}}
