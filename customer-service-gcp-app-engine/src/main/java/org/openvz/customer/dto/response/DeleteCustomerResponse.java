package org.openvz.customer.dto.response;

import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerResponse {

	private String responseCode;
	private String responseMessage; 
	private String customerId;


	public String getResponseCode() {
		return responseCode;
	}

	public DeleteCustomerResponse setResponseCode(String responseCode) {
		this.responseCode = responseCode;
		return this;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public DeleteCustomerResponse setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
		return this;
	}

	
	public String getCustomerId() {
		return customerId;
	}

	public DeleteCustomerResponse setCustomerId(String customerId) {
		this.customerId = customerId;
		return this;
	}
}
