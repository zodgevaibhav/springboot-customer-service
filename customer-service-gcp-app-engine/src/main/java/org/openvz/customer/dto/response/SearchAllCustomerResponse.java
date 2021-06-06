package org.openvz.customer.dto.response;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchAllCustomerResponse {

@Autowired
private List<SearchCustomerResponse> Customers;

public List<SearchCustomerResponse> getCustomers() {
	return Customers;
}

public void setCustomers(List<SearchCustomerResponse> customers) {
	Customers = customers;
}


}
