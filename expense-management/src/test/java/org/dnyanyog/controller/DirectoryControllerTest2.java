package org.dnyanyog.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import javax.xml.xpath.XPathExpressionException;

import org.dnyanyog.dto.request.SignUpRequest;
import org.dnyanyog.dto.response.SignUpResponse;
import org.dnyanyog.dto.response.UserData;
import org.dnyanyog.repository.UserRepository;
import org.dnyanyog.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class DirectoryControllerTest2{
	
	@Autowired
	MockMvc mockMvc;
	
	@InjectMocks
	private DirectoryController directoryController;
	
	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserService userService;
	
	@Before
	public void beforeMethod()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void verifyUserSignupOperationReturnExpectedObject() throws XPathExpressionException, Exception {

		SignUpResponse signUpResponse = new SignUpResponse();

		signUpResponse.setStatus("success");
		signUpResponse.setMessage("User account created successfully");
		UserData data = new UserData();
		data.setEmail("sagarEmail1@example.com");
		data.setCountry("US");
		data.setCurrency("IN");
		data.setFullName("John Doe");
		data.setLanguage("MAR");
		data.setMobile("RamMobile340");
		data.setUserId(1);
		signUpResponse.setData(data);
		
		ResponseEntity<SignUpResponse> res = new ResponseEntity<SignUpResponse>(signUpResponse, HttpStatus.CREATED);

		Mockito.when(userService.saveData(Mockito.any())).thenCallRealMethod();
		Mockito.when(userRepository.findByMobileNo(Mockito.any())).thenReturn(null);
		Mockito.when(userRepository.findByEmail(Mockito.any())).thenReturn(null);
		

		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/signup")
				.content("<user>\n" + "  <fullName>John Doe</fullName>\n" + "  <email>sagarEmail1@example.com</email>\n"
						+ "  <mobile>RamMobile340</mobile>\n" + "  <password>myPassword</password>\n"
						+ "  <currency>IN</currency>\n" + "  <language>MAR</language>\n" + "  <country>US</country>\n"
						+ "</user>\n" + "")
				.contentType(MediaType.APPLICATION_XML_VALUE).accept(MediaType.APPLICATION_XML_VALUE);

		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isCreated())
				.andExpect(xpath("//SignUpResponse/status").string("success"))
				.andExpect(xpath("//SignUpResponse/message").string("User account created successfully"))
				.andExpect(xpath("//SignUpResponse/data/fullName").string("John Doe"))
				.andExpect(xpath("//SignUpResponse/data/email").string("sagarEmail1@example.com"))
				.andExpect(xpath("//SignUpResponse/data/mobile").string("RamMobile340"))
				.andExpect(xpath("//SignUpResponse/data/currency").string("IN"))
				.andExpect(xpath("//SignUpResponse/data/language").string("MAR"))
				.andExpect(xpath("//SignUpResponse/data/country").string("US"))
				.andExpect(xpath("//SignUpResponse/data/userId").string("1")).andReturn();
	//	Mockito.verify(userService).saveData(Mockito.any());

	}

}
