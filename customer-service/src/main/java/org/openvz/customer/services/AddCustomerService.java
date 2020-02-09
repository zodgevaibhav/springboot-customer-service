package org.openvz.customer.services;

import org.openvz.customer.dao.CustomerRepository;
import org.openvz.customer.dto.request.AddCustomer;
import org.openvz.customer.dto.response.AddCustomerResponse;
import org.openvz.customer.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddCustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private AddCustomerResponse addCustomerResponse;
	
	public AddCustomerResponse addCustomer(AddCustomer addCustomerRequest)
	{
		
	try
	{
		Customer customer = new Customer(); 
		customer.setCustomerId(addCustomerRequest.getCustomerId())
				.setFirstName(addCustomerRequest.getFirstName())
				.setLastName(addCustomerRequest.getLastName())
				.setGender(addCustomerRequest.getGender())
				.setMiddleName(addCustomerRequest.getMiddleName())
				.setOccupation(addCustomerRequest.getOccupation())
				.setSsn(addCustomerRequest.getSsn())
				.setStatus("ACTIVE");
		
		 customer = customerRepo.save(customer);
		
		addCustomerResponse.setCustomerCode(customer.getCustomerCode())
							.setCustomerId(customer.getCustomerId())
							.setFirstName(customer.getFirstName())
							.setGender(customer.getGender())
							.setLastName(customer.getLastName())
							.setMiddleName(customer.getMiddleName())
							.setOccupation(customer.getOccupation())
							.setResponseCode("0000")
							.setResponseMessage("PASS")
							.setSsn(customer.getSsn())
							.setStatus(customer.getStatus());
	}catch(Exception e)
	{
		e.printStackTrace();
		addCustomerResponse.setResponseCode("0911");
		addCustomerResponse.setResponseMessage("FAIL : System Error");
	}
		return addCustomerResponse;
	}
	
	
}
