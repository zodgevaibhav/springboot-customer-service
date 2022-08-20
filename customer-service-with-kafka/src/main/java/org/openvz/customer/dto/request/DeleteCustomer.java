package org.openvz.customer.dto.request;

import org.springframework.stereotype.Component;

@Component
public class DeleteCustomer {

	private String customerId;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}
