package org.dnyanyog.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import javax.xml.xpath.XPathExpressionException;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testng.annotations.Test;

@SpringBootTest
@AutoConfigureMockMvc
public class DirectoryControllerTest extends AbstractTestNGSpringContextTests {

	@Autowired
	MockMvc mockMvc;
	
	@InjectMocks
	private DirectoryController directoryController;

	@Test(priority = 1)
	public void verifyUserSignupSuccessOperationReturnExpectedObject() throws XPathExpressionException, Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/signup")
				.content("<user>\n"
						+ "  <fullName>John Doe</fullName>\n"
						+ "  <email>johndoe@example.com</email>\n"
						+ "  <mobile>1234567890</mobile>\n"
						+ "  <password>myPassword</password>\n"
						+ "  <currency>IN</currency>\n"
						+ "  <language>MAR</language>\n"
						+ "  <country>US</country>\n"
						+ "</user>\n"
						+ "")
				.contentType(MediaType.APPLICATION_XML_VALUE).accept(MediaType.APPLICATION_XML_VALUE);

		mockMvc.perform(requestBuilder)
				.andExpect(status().isCreated())
				.andExpect(xpath("/SignUpResponse/status").string("success"))
				.andExpect(xpath("/SignUpResponse/message").string("User account created successfully"))
				.andExpect(xpath("/SignUpResponse/data/fullName").string("John Doe"))
				.andExpect(xpath("/SignUpResponse/data/email").string("johndoe@example.com"))
				.andExpect(xpath("/SignUpResponse/data/currency").string("IN"))
				.andExpect(xpath("/SignUpResponse/data/language").string("MAR"))
				.andExpect(xpath("/SignUpResponse/data/country").string("US"))
				.andExpect(xpath("/SignUpResponse/data/userId").string("1"))
				.andReturn();
	}
	
	@Test(priority = 2)
	public void verifyUserSignupFailForDuplicateEmail() throws XPathExpressionException, Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/signup")
				.content("<user>\n"
						+ "  <fullName>John Doe</fullName>\n"
						+ "  <email>johndoe@example.com</email>\n"
						+ "  <mobile>1234567870</mobile>\n"
						+ "  <password>myPassword</password>\n"
						+ "  <currency>IN</currency>\n"
						+ "  <language>MAR</language>\n"
						+ "  <country>US</country>\n"
						+ "</user>\n"
						+ "")
				.contentType(MediaType.APPLICATION_XML_VALUE).accept(MediaType.APPLICATION_XML_VALUE);

		mockMvc.perform(requestBuilder)
				.andExpect(status().isConflict())
				.andExpect(xpath("/SignUpResponse/status").string("error"))
				.andExpect(xpath("/SignUpResponse/message").string("Email or mobile number already registered"))
				.andReturn();
	}
	
	@Test(priority = 2)
	public void verifyUserSignupFailForDuplicateMobile() throws XPathExpressionException, Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/signup")
				.content("<user>\n"
						+ "  <fullName>John Doe</fullName>\n"
						+ "  <email>johndoe1@example.com</email>\n"
						+ "  <mobile>1234567890</mobile>\n"
						+ "  <password>myPassword</password>\n"
						+ "  <currency>IN</currency>\n"
						+ "  <language>MAR</language>\n"
						+ "  <country>US</country>\n"
						+ "</user>\n"
						+ "")
				.contentType(MediaType.APPLICATION_XML_VALUE).accept(MediaType.APPLICATION_XML_VALUE);

		mockMvc.perform(requestBuilder)
				.andExpect(status().isConflict())
				.andExpect(xpath("/SignUpResponse/status").string("error"))
				.andExpect(xpath("/SignUpResponse/message").string("Email or mobile number already registered"))
				.andReturn();
	}

}
