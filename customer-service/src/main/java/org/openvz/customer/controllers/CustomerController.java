package org.openvz.customer.controllers;

import org.openvz.customer.dto.request.AddCustomer;
import org.openvz.customer.dto.request.UpdateCustomer;
import org.openvz.customer.dto.response.AddCustomerResponse;
import org.openvz.customer.dto.response.DeleteCustomerResponse;
import org.openvz.customer.dto.response.SearchAllCustomerResponse;
import org.openvz.customer.dto.response.SearchCustomerResponse;
import org.openvz.customer.dto.response.UpdateCustomerResponse;
import org.openvz.customer.services.AddCustomerService;
import org.openvz.customer.services.DeleteCustomerService;
import org.openvz.customer.services.SearchCustomerService;
import org.openvz.customer.services.UpdateCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	AddCustomerService addCustomerService;
	
	@Autowired
	UpdateCustomerService updateCustomerService;
	
	@Autowired
	DeleteCustomerService deleteCustomerService;
	
	@Autowired
	SearchCustomerService searchCustomerService;
	
	@PostMapping(path="/AddCustomer", consumes= {"application/json","application/xml"}, produces= {"application/json","application/xml"})
	public AddCustomerResponse addCustomer(@RequestBody AddCustomer addCustomerRequest) throws JsonProcessingException
	{	
		return addCustomerService.addCustomer(addCustomerRequest);
	}
	@PostMapping(path="/UpdateCustomer", consumes= {"application/json","application/xml"}, produces= {"application/json","application/xml"})
	public UpdateCustomerResponse updateCustomer(@RequestBody UpdateCustomer updateCustomerRequest)
	{
		return updateCustomerService.updateCustomer(updateCustomerRequest);
	}
	
	@DeleteMapping(path="/DeleteCustomer/{customerId}", produces= {"application/json","application/xml"})
	public DeleteCustomerResponse deleteCustomer(@PathVariable String customerId)
	{
		return deleteCustomerService.deleteCustomer(customerId);
	}

	@GetMapping(path="/SearchCustomer/{customerId}", produces= {"application/json","application/xml"})
	public SearchCustomerResponse searchCustomer(@PathVariable String customerId)
	{
		return searchCustomerService.searchCustomer(customerId);
	}
	
	@GetMapping(path="/SearchAllCustomer", produces= {"application/json","application/xml"})
	public SearchAllCustomerResponse searchCustomer()
	{
		return searchCustomerService.searchCustomer();
	}
}
