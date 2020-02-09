package org.openvz.customer.services;

import org.openvz.customer.dao.CustomerRepository;
import org.openvz.customer.dto.request.AddCustomer;
import org.openvz.customer.dto.request.UpdateCustomer;
import org.openvz.customer.dto.response.AddCustomerResponse;
import org.openvz.customer.dto.response.UpdateCustomerResponse;
import org.openvz.customer.entities.Customer;
import org.openvz.customer.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private UpdateCustomerResponse updateCustomerResponse;
	
	public UpdateCustomerResponse updateCustomer(UpdateCustomer updateCustomerRequest)
	{
		
	try
	{
		Customer customer = customerRepo.findBycustomerId(updateCustomerRequest.getCustomerId()); 
		
		if(null==customer)
			throw new CustomerNotFoundException();
	
		
		customer.setCustomerId(updateCustomerRequest.getCustomerId())
				.setFirstName(updateCustomerRequest.getFirstName())
				.setLastName(updateCustomerRequest.getLastName())
				.setGender(updateCustomerRequest.getGender())
				.setMiddleName(updateCustomerRequest.getMiddleName())
				.setOccupation(updateCustomerRequest.getOccupation())
				.setSsn(updateCustomerRequest.getSsn())
				.setStatus(updateCustomerRequest.getStatus());
		
		 customer = customerRepo.save(customer);
		
		updateCustomerResponse.setCustomerCode(customer.getCustomerCode())
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
		if (e instanceof CustomerNotFoundException) {
			updateCustomerResponse.setResponseCode("0911");
			updateCustomerResponse.setResponseMessage("FAIL : Customer not found");
			
		}else {
		e.printStackTrace();
		updateCustomerResponse.setResponseCode("0911");
		updateCustomerResponse.setResponseMessage("FAIL : System Error");
		}
	}
		return updateCustomerResponse;
	}
	
	
}
