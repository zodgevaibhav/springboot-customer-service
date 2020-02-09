package org.openvz.customer.dto.response;

import org.springframework.stereotype.Component;

@Component
public class AddCustomerResponse {

	private String responseCode;
	private String responseMessage;
	private Integer customerCode; 
	private String customerId;
	private String firstName;
	private String lastName;
	private String middleName;
	private Integer ssn;
	private String gender;
	private String occupation;
	private String status;

	public static AddCustomerResponse getAddCustomerInstance() {
		return new AddCustomerResponse();
	}

	public String getResponseCode() {
		return responseCode;
	}

	public AddCustomerResponse setResponseCode(String responseCode) {
		this.responseCode = responseCode;
		return this;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public AddCustomerResponse setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
		return this;
	}

	
	public Integer getCustomerCode() {
		return customerCode;
	}

	public AddCustomerResponse setCustomerCode(Integer customerCode) {
		this.customerCode = customerCode;
		return this;
	}

	public String getCustomerId() {
		return customerId;
	}

	public AddCustomerResponse setCustomerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public AddCustomerResponse setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public AddCustomerResponse setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getMiddleName() {
		return middleName;
	}

	public AddCustomerResponse setMiddleName(String middleName) {
		this.middleName = middleName;
		return this;
	}

	public Integer getSsn() {
		return ssn;
	}

	public AddCustomerResponse setSsn(Integer ssn) {
		this.ssn = ssn;
		return this;
	}

	public String getGender() {
		return gender;
	}

	public AddCustomerResponse setGender(String gender) {
		this.gender = gender;
		return this;
	}

	public String getOccupation() {
		return occupation;
	}

	public AddCustomerResponse setOccupation(String occupation) {
		this.occupation = occupation;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public AddCustomerResponse setStatus(String status) {
		this.status = status;
		return this;
	}

}
