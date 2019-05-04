package com.creditscore.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.creditscore.test.domain.Customer;
import com.creditscore.test.service.CustomerService;


@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

    /**
     * 
     * this method maps the following URL & http method
     * URL: http://hostname:port/credit-score/customers
     * HTTP method: GET
     * 
     */	
	@RequestMapping(value="/customers", method = RequestMethod.GET)
	public ResponseEntity<?> getCustomers() {
		Iterable<Customer> customerList = customerService.getCustomers();
		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}

    	

    /**
     * 
     * this method maps the following URL & http method
     * URL: http://hostname:port/appName/customers
     * HTTP method: POST
     * 
     */		
	@RequestMapping(value="/customers", method = RequestMethod.POST)
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		System.out.println("coming in post");
		int result = customerService.addCustomer(customer);
		return new ResponseEntity<>("Your credit score is "+result, HttpStatus.CREATED);
	}
	
    /**
     * 
     * this method maps the following URL & http method
     * URL: http://hostname:port/appName/customers
     * HTTP method: PUT
     * 
     */	
    @RequestMapping(value = "/customers", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
    	System.out.println("coming in put");
    	int result = customerService.addCustomer(customer);
    	return new ResponseEntity<>("Your credit score is "+result, HttpStatus.OK);
    }

    /**
     * 
     * this method maps the following URL & http method
     * URL: http://hostname:port/appName
     * HTTP method: GET
     * 
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> home() {
    	return new ResponseEntity<>("Credit Score API", HttpStatus.OK);
    }
  
}
