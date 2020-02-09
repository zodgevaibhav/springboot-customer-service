package org.openvz.customer.dao;

import org.openvz.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CustomerRepository extends JpaRepository<Customer,Long>{

	Customer findBycustomerId(String customerId);

}
