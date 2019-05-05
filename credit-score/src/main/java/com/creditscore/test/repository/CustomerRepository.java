package com.creditscore.test.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.creditscore.test.domain.Customer;


@Repository
@Transactional
public class CustomerRepository {
	@PersistenceContext
	EntityManager eManager;
	
	public int getCustomerDetails(Customer customer) {
		String SQL = "select c.score from Customer c where c.firstName = '" 
				+ customer.getFirstName() + "' and c.lastName='" + customer.getLastName() 
				+ "' and c.age="+ customer.getAge() 
				+"and c.dob ='" + customer.getDob() 
				+ "' and c.annualIncome=" + customer.getAnnualIncome();
		Query query = eManager.createQuery(SQL);
		List<Integer> result = query.getResultList();
		if(result.size()==0) return 0;
		return result.get(0);
	}
	
	public void addCustomerDetails(Customer customer) {
		eManager.merge(customer);
	}
	
	public List<Customer> getCustomers() {
		Query query = eManager.createQuery("Select c from Customer c");
	    List<Customer> list = query.getResultList();

		return list;
	}
}
