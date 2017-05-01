package com.jennifernguyen.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Applicant 
{
	private String firstName;
	private String lastName;
	private int age;
	private String applicantState;
	
	public Applicant(String firstName, String lastName, int age, String applicantState) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.applicantState = applicantState;
	}
	
    public boolean hasValidName() {
    	Pattern regex = Pattern.compile("^[A-Z]{1}[a-z]");
    	Matcher matchFirstName = regex.matcher(firstName);
    	Matcher matchLastName = regex.matcher(lastName);
    	
    	return matchFirstName.find() && matchLastName.find();
    }
    
    public boolean hasValidAge() {
    	return age >= 0;
    }
    
	public int getAge() {
		return age;
	}

	public String getApplicantState() {
		return applicantState;
	}
}
