package com.axcore.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axcore.portal.entity.Customer;
import com.axcore.portal.repository.CustomerRepository;

@Service
public class CustomerServiceImpl {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer getCustomerById(Long id) {
		return customerRepository.findById(id).orElse(null);
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public void deleteCustomerById(Long id) {
		customerRepository.deleteById(id);
	}

//	public void updateRemainingBalance(Long customerId, int bottleDelivered, double receivedAmount) {
//		Customer customer = customerRepository.findById(customerId).orElse(null);
//		if (customer != null) {
//			double remainingBalance = (bottleDelivered * customer.getBottleRate()) - receivedAmount;
//			customer.setBalanceAmount(remainingBalance);
//			customerRepository.save(customer);
//		}
//	}
}
