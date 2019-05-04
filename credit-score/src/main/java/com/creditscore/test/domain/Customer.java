package com.creditscore.test.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Customer {

	
    String firstName;
    String lastName;
    int age;
    @Id
    String dob;
    int annualIncome;
    int score;
    
    /*  public Customer(String firstName, String lastName, int age, String dob, int annualIncome) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dob = dob;
		this.annualIncome = annualIncome;
		
	}*/
    
    
   /* public Customer(int id, String firstName, String lastName, int age, String dob, int annualIncome, int score) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dob = dob;
		this.annualIncome = annualIncome;
		this.score = score;
	}*/
    
    
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(int annualIncome) {
		this.annualIncome = annualIncome;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
    
	
}
