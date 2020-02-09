package org.openvz.customer.dto.response;

import org.springframework.stereotype.Component;

@Component
public class SearchCustomerResponse {

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

	public static SearchCustomerResponse getAddCustomerInstance() {
		return new SearchCustomerResponse();
	}

	public String getResponseCode() {
		return responseCode;
	}

	public SearchCustomerResponse setResponseCode(String responseCode) {
		this.responseCode = responseCode;
		return this;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public SearchCustomerResponse setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
		return this;
	}

	
	public Integer getCustomerCode() {
		return customerCode;
	}

	public SearchCustomerResponse setCustomerCode(Integer customerCode) {
		this.customerCode = customerCode;
		return this;
	}

	public String getCustomerId() {
		return customerId;
	}

	public SearchCustomerResponse setCustomerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public SearchCustomerResponse setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public SearchCustomerResponse setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getMiddleName() {
		return middleName;
	}

	public SearchCustomerResponse setMiddleName(String middleName) {
		this.middleName = middleName;
		return this;
	}

	public Integer getSsn() {
		return ssn;
	}

	public SearchCustomerResponse setSsn(Integer ssn) {
		this.ssn = ssn;
		return this;
	}

	public String getGender() {
		return gender;
	}

	public SearchCustomerResponse setGender(String gender) {
		this.gender = gender;
		return this;
	}

	public String getOccupation() {
		return occupation;
	}

	public SearchCustomerResponse setOccupation(String occupation) {
		this.occupation = occupation;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public SearchCustomerResponse setStatus(String status) {
		this.status = status;
		return this;
	}

}
