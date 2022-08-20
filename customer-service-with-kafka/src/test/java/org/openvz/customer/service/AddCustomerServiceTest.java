package org.openvz.customer.service;

import static org.testng.Assert.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.openvz.customer.dao.CustomerRepository;
import org.openvz.customer.dto.request.AddCustomer;
import org.openvz.customer.dto.response.AddCustomerResponse;
import org.openvz.customer.entities.Customer;
import org.openvz.customer.services.AddCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCustomerServiceTest {

	@InjectMocks
	@Autowired
	AddCustomerService addCustomerService;
	
	@Mock
	CustomerRepository customerRepo;

	/*@Mock
	private AddCustomerResponse addCustomerResponse;
*/
	
	@BeforeMethod
	public void beforeMethod()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void verifyCustomerSaveOperationReturnExpectedObject()
	{
	
		Customer customer =new Customer();
		
		customer.setCustomerCode(123).setCustomerId("VVZ001").setFirstName("Vaibhav").setGender("Male").setLastName("Zodge").setSsn(123);
		
		Mockito.when(customerRepo.save(Mockito.any())).thenReturn(customer);

		AddCustomer addCustomer = new AddCustomer();
		
		addCustomer.setCustomerId("VVZ001").setFirstName("Vaibhav").setGender("Male").setLastName("Zodge").setSsn(123);
		
		AddCustomerResponse response = addCustomerService.addCustomer(addCustomer);
		Assert.assertNotNull(response);
		Assert.assertEquals(response.getCustomerId(), customer.getCustomerId());
		Assert.assertEquals(response.getFirstName(), customer.getFirstName());
		Assert.assertEquals(response.getGender(), customer.getGender());
		Assert.assertEquals(response.getLastName(), customer.getLastName());
		Assert.assertEquals(response.getMiddleName(), customer.getMiddleName());
		Assert.assertEquals(response.getResponseCode(), "0000");
	}
	@Autowired
	@Test
	public void verifyCustomerSaveOperationReturnErrorMessageOnException(AddCustomer addCustomer)
	{
	
		Customer customer =new Customer();
		
		customer.setCustomerCode(123).setCustomerId("VVZ001").setFirstName("Vaibhav").setGender("Male").setLastName("Zodge").setSsn(123);
		
		Mockito.when(customerRepo.save(Mockito.any())).thenThrow(new NullPointerException());

	//	AddCustomer addCustomer = new AddCustomer();
		
		addCustomer.setCustomerId("VVZ001").setFirstName("Vaibhav").setGender("Male").setLastName("Zodge").setSsn(123);
		
		AddCustomerResponse response = addCustomerService.addCustomer(addCustomer);
		Assert.assertNotNull(response);
		Assert.assertEquals(response.getResponseCode(), "0911");
		Assert.assertEquals(response.getResponseMessage(), "FAIL : System Error");
	}
	
}
