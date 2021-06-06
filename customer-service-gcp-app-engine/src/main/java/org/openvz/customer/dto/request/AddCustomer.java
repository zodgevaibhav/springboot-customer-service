package org.openvz.customer.dto.request;

import org.springframework.stereotype.Component;

@Component
public class AddCustomer {

	private String customerId;
	private String firstName;
	private String lastName;
	private String middleName;
	private Integer ssn;
	private String gender;
	private String occupation;
	private String status;

	public static AddCustomer getAddCustomerInstance() {
		return new AddCustomer();
	}

	public String getCustomerId() {
		return customerId;
	}

	public AddCustomer setCustomerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public AddCustomer setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public AddCustomer setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getMiddleName() {
		return middleName;
	}

	public AddCustomer setMiddleName(String middleName) {
		this.middleName = middleName;
		return this;
	}

	public int getSsn() {
		return ssn;
	}

	public AddCustomer setSsn(int ssn) {
		this.ssn = ssn;
		return this;
	}

	public String getGender() {
		return gender;
	}

	public AddCustomer setGender(String gender) {
		this.gender = gender;
		return this;
	}

	public String getOccupation() {
		return occupation;
	}

	public AddCustomer setOccupation(String occupation) {
		this.occupation = occupation;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public AddCustomer setStatus(String status) {
		this.status = status;
		return this;
	}

}
