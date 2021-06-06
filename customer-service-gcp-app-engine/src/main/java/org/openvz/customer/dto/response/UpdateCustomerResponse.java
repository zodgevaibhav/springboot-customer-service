package org.openvz.customer.dto.response;

import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerResponse {

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

	public static UpdateCustomerResponse getAddCustomerInstance() {
		return new UpdateCustomerResponse();
	}

	public String getResponseCode() {
		return responseCode;
	}

	public UpdateCustomerResponse setResponseCode(String responseCode) {
		this.responseCode = responseCode;
		return this;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public UpdateCustomerResponse setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
		return this;
	}

	
	public Integer getCustomerCode() {
		return customerCode;
	}

	public UpdateCustomerResponse setCustomerCode(Integer customerCode) {
		this.customerCode = customerCode;
		return this;
	}

	public String getCustomerId() {
		return customerId;
	}

	public UpdateCustomerResponse setCustomerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public UpdateCustomerResponse setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public UpdateCustomerResponse setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getMiddleName() {
		return middleName;
	}

	public UpdateCustomerResponse setMiddleName(String middleName) {
		this.middleName = middleName;
		return this;
	}

	public Integer getSsn() {
		return ssn;
	}

	public UpdateCustomerResponse setSsn(Integer ssn) {
		this.ssn = ssn;
		return this;
	}

	public String getGender() {
		return gender;
	}

	public UpdateCustomerResponse setGender(String gender) {
		this.gender = gender;
		return this;
	}

	public String getOccupation() {
		return occupation;
	}

	public UpdateCustomerResponse setOccupation(String occupation) {
		this.occupation = occupation;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public UpdateCustomerResponse setStatus(String status) {
		this.status = status;
		return this;
	}

}
