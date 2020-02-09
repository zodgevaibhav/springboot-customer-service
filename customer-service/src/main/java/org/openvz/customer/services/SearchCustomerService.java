package org.openvz.customer.services;

import java.util.List;

import org.openvz.customer.dao.CustomerRepository;
import org.openvz.customer.dto.response.SearchAllCustomerResponse;
import org.openvz.customer.dto.response.SearchCustomerResponse;
import org.openvz.customer.entities.Customer;
import org.openvz.customer.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchCustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private SearchCustomerResponse searchCustomerResponse;
	
	@Autowired
	private List<SearchCustomerResponse> searchCustomerResponseList;
	
	@Autowired
	private SearchAllCustomerResponse searchAllCustomerResponse;
	
	public SearchCustomerResponse searchCustomer(String customerId)
	{
		
	try
	{
		Customer customer = customerRepo.findBycustomerId(customerId); 
		
		if(null==customer)
			throw new CustomerNotFoundException();
		
		searchCustomerResponse.setCustomerCode(customer.getCustomerCode())
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
			searchCustomerResponse.setResponseCode("0911");
			searchCustomerResponse.setResponseMessage("FAIL : Customer not found");
			
		}else {
		e.printStackTrace();
		searchCustomerResponse.setResponseCode("0911");
		searchCustomerResponse.setResponseMessage("FAIL : System Error");
		}
	}
		return searchCustomerResponse;
	}
	
	
	public SearchAllCustomerResponse searchCustomer()
	{
		
	try
	{
		List<Customer> customerList = customerRepo.findAll(); 
		
		if(customerList.size()==0)
			throw new CustomerNotFoundException();
	for(Customer customer:customerList)	
		searchCustomerResponseList.add(new SearchCustomerResponse().setCustomerCode(customer.getCustomerCode())
							.setCustomerId(customer.getCustomerId())
							.setFirstName(customer.getFirstName())
							.setGender(customer.getGender())
							.setLastName(customer.getLastName())
							.setMiddleName(customer.getMiddleName())
							.setOccupation(customer.getOccupation())
							.setSsn(customer.getSsn())
							.setStatus(customer.getStatus()));
	
	searchAllCustomerResponse.setCustomers(searchCustomerResponseList);
	}catch(Exception e)
	{
		if (e instanceof CustomerNotFoundException) {
			searchCustomerResponseList.add(new SearchCustomerResponse().setResponseCode("0911").setResponseMessage("FAIL : Customer not found"));
			searchAllCustomerResponse.setCustomers(searchCustomerResponseList);
		}else {
		e.printStackTrace();
		searchCustomerResponseList.add(new SearchCustomerResponse().setResponseCode("0911").setResponseMessage("FAIL : System error"));
		searchAllCustomerResponse.setCustomers(searchCustomerResponseList);
		}
	}
		return searchAllCustomerResponse;
	}	
	
}
