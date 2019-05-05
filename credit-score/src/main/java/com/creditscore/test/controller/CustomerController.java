package com.creditscore.test.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
     * URL: http://hostname:port/credit-score/getCustomers
     * URL: http://localhost:8080/credit-score/getCustomers
     * HTTP method: GET
     * 
     */	
	@RequestMapping(value="/getCustomers", method = RequestMethod.GET)
	public ResponseEntity<?> getCustomers() {
		Iterable<Customer> customerList = customerService.getCustomers();
		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}

    	

    /**
     * 
     * this method maps the following URL & http method
     * URL: http://hostname:port/appName/addCustomer
     * URL: http://localhost:8080/credit-score/addCustomer
     * HTTP method: POST
     * 
     */		
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public ResponseEntity<?> addCustomer(@Valid @RequestBody Customer customer, BindingResult result) {

		if (!result.hasErrors()) {
			int score = customerService.addCustomer(customer);
			return new ResponseEntity<>("Your credit score is " + score, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("please enter all mandatory fields firstName, lastName, age, dob, annualIncome",
					HttpStatus.PRECONDITION_FAILED);

		}
	}

	/**
     * 
     * this method maps the following URL & http method
     * URL: http://hostname:port/appName/addCustomer
     * URL: http://localhost:8080/credit-score/addCustomer
     * HTTP method: PUT
     * 
     */	
    @RequestMapping(value = "/customers", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCustomer(@Valid @RequestBody Customer customer, BindingResult result) {
    	if (!result.hasErrors()) {
			int score = customerService.addCustomer(customer);
			return new ResponseEntity<>("Your credit score is " + score, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("all fields are mandatory. please enter all the fields and submit",
					HttpStatus.PRECONDITION_FAILED);

		}
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
