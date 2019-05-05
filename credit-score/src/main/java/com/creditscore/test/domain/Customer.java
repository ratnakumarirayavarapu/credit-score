package com.creditscore.test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@IdClass(CompositeKey.class)
public class Customer {

	@Id
	@NotNull
    String firstName;
	@Id
	@NotNull
    String lastName;
	@NotNull
	@Min(value = 1)
    int age;
    @Id
    @NotNull
    String dob;
    @NotNull
    @Min(value = 1, message = "")
    long annualIncome;
    int score;
      
    
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
	public long getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(long annualIncome) {
		this.annualIncome = annualIncome;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}    
	
}
