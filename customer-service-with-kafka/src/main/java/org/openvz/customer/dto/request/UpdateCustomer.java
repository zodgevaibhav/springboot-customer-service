package org.openvz.customer.dto.request;

import org.springframework.stereotype.Component;

@Component
public class UpdateCustomer {

	private String customerId;
	private String firstName;
	private String lastName;
	private String middleName;
	private Integer ssn;
	private String gender;
	private String occupation;
	private String status;

	public static UpdateCustomer getAddCustomerInstance() {
		return new UpdateCustomer();
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public UpdateCustomer setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public UpdateCustomer setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getMiddleName() {
		return middleName;
	}

	public UpdateCustomer setMiddleName(String middleName) {
		this.middleName = middleName;
		return this;
	}

	public int getSsn() {
		return ssn;
	}

	public UpdateCustomer setSsn(int ssn) {
		this.ssn = ssn;
		return this;
	}

	public String getGender() {
		return gender;
	}

	public UpdateCustomer setGender(String gender) {
		this.gender = gender;
		return this;
	}

	public String getOccupation() {
		return occupation;
	}

	public UpdateCustomer setOccupation(String occupation) {
		this.occupation = occupation;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public UpdateCustomer setStatus(String status) {
		this.status = status;
		return this;
	}

}
