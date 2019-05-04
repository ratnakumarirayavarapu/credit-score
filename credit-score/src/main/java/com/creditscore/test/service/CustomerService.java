package com.creditscore.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creditscore.test.domain.Customer;
import com.creditscore.test.repository.CustomerRepository;



@Service
@Transactional
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getCustomers() {
		return customerRepository.getCustomers();
	}
	
	public int addCustomer(Customer customer) {
		int creditScore = customerRepository.getCustomerDetails(customer);
		if(creditScore==0) {
			creditScore = calculateCreditScore(customer);
			customer.setScore(creditScore);
			customerRepository.addCustomerDetails(customer);
		}
		System.out.println("credit score" + creditScore);
		return creditScore;
	}

	private int calculateCreditScore(Customer customer) {
		int value =  Math.floorDiv(customer.getAnnualIncome(), (Math.multiplyExact(customer.getAge(), 12)));
		return value+300;
	}
}
