package org.openvz.customer.service;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.openvz.customer.dao.CustomerRepository;
import org.openvz.customer.dto.request.AddCustomer;
import org.openvz.customer.dto.response.AddCustomerResponse;
import org.openvz.customer.entities.Customer;
import org.openvz.customer.services.AddCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class AddCustomerTest {

	@InjectMocks
	@Autowired
	AddCustomerService addCustomerService;
	
	@Mock
	CustomerRepository customerRepo;
	
	@Test
	public void verifyCustomerSaveOperationReturnExpectedObject()
	{
	
		Customer customer =new Customer();
		
		customer.setCustomerCode(123).setCustomerId("VVZ001").setFirstName("Vaibhav").setGender("Male").setLastName("Zodge");
		
		Mockito.when(customerRepo.save(Mockito.any())).thenReturn(customer);
		
		AddCustomer addCustomer = new AddCustomer();
		
		addCustomer.setCustomerId("VVZ");
		
		AddCustomerResponse addCustomerResponse = addCustomerService.addCustomer(addCustomer);
		System.out.println(addCustomerResponse);
	}
	
}
