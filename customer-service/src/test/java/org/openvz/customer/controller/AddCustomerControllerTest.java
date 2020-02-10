package org.openvz.customer.controller;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.openvz.customer.dto.response.AddCustomerResponse;
import org.openvz.customer.services.AddCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import javax.xml.xpath.XPathExpressionException;

@SpringBootTest
@AutoConfigureMockMvc
public class AddCustomerControllerTest extends AbstractTestNGSpringContextTests{

	@Autowired
	MockMvc mockMvc;
	
	@Mock
	AddCustomerService addCustomerService;
	
	@BeforeMethod
	public void beforeMethod()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void verifyCustomerSaveOperationReturnExpectedObject() throws XPathExpressionException, Exception
	{
	
		AddCustomerResponse addCustomerResponse =new AddCustomerResponse();
		
		addCustomerResponse.setCustomerCode(123).setCustomerId("VVZ001").setFirstName("Vaibhav").setGender("Male").setLastName("Zodge").setSsn(123);
		
		Mockito.when(addCustomerService.addCustomer(Mockito.any())).thenReturn(addCustomerResponse);


		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/customer/AddCustomer").content("<AddCustomer>\n" + 
				"    <customerId>VVZ001</customerId>\n" + 
				"    <firstName>Swara</firstName>\n" + 
				"    <lastName>Zodge</lastName>\n" + 
				"    <middleName>V</middleName>\n" + 
				"    <ssn>11223</ssn>\n" + 
				"    <gender>Male</gender>\n" + 
				"    <occupation>Job</occupation>\n" + 
				"    <status>ACTIVE</status>\n" + 
				"</AddCustomer>").contentType(MediaType.APPLICATION_XML_VALUE).accept(MediaType.APPLICATION_XML_VALUE);

		MvcResult result = mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(xpath("//responseCode").string("0000"))
				.andReturn();
	}
	
}
