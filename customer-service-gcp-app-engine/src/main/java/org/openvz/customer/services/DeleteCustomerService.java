package org.openvz.customer.services;

import org.openvz.customer.dao.CustomerRepository;
import org.openvz.customer.dto.request.DeleteCustomer;
import org.openvz.customer.dto.response.DeleteCustomerResponse;
import org.openvz.customer.dto.response.UpdateCustomerResponse;
import org.openvz.customer.entities.Customer;
import org.openvz.customer.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private DeleteCustomerResponse deleteCustomerResponse;
	
	public DeleteCustomerResponse deleteCustomer(String customerId)
	{
		
	try
	{
		Customer customer = customerRepo.findBycustomerId(customerId); 
		
		if(null==customer)
			throw new CustomerNotFoundException();
	
		 customerRepo.delete(customer);
		
		deleteCustomerResponse.setCustomerId(customer.getCustomerId())
							.setResponseCode("0000")
							.setResponseMessage("PASS:Customer Deleted");
	}catch(Exception e)
	{
		if (e instanceof CustomerNotFoundException) {
			deleteCustomerResponse.setResponseCode("0911");
		deleteCustomerResponse.setResponseMessage("FAIL : Customer not found");
			
		}else {
		e.printStackTrace();
		deleteCustomerResponse.setResponseCode("0911");
		deleteCustomerResponse.setResponseMessage("FAIL : System Error");
		}
	}
		return deleteCustomerResponse;
	}
	
	
}
