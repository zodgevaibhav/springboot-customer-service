package org.openvz.customer.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "customer_code", nullable = false, updatable = false, insertable = false)
	private Integer customerCode;

	@Column(name = "customer_id", nullable = false, length = 50)
	private String customerId;

	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;

	@Column(name = "last_name", nullable = true, length = 50)
	private String lastName;

	@Column(name = "middle_name", nullable = true, length = 50)
	private String middleName;

	@Column(name = "ssn")
	private Integer ssn;

	@Column(name = "gender", nullable = true, length = 10)
	private String gender;

	@Column(name = "occupation", nullable = true, length = 50)
	private String occupation;

	@Column(name = "status", nullable = false, length = 10)
	private String status;

	public static Customer getCustomerInstance() {
		return new Customer();
	}

	public Integer getCustomerCode() {
		return customerCode;
	}

	public Customer setCustomerCode(Integer customerCode) {
		this.customerCode = customerCode;
		return this;
	}

	public String getCustomerId() {
		return customerId;
	}

	public Customer setCustomerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public Customer setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public Customer setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getMiddleName() {
		return middleName;
	}

	public Customer setMiddleName(String middleName) {
		this.middleName = middleName;
		return this;
	}

	public Integer getSsn() {
		return ssn;
	}

	public Customer setSsn(Integer ssn) {
		this.ssn = ssn;
		return this;
	}

	public String getGender() {
		return gender;
	}

	public Customer setGender(String gender) {
		this.gender = gender;
		return this;
	}

	public String getOccupation() {
		return occupation;
	}

	public Customer setOccupation(String occupation) {
		this.occupation = occupation;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public Customer setStatus(String status) {
		this.status = status;
		return this;
	}

}
