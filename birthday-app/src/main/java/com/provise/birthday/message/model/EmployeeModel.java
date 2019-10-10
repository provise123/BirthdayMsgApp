package com.provise.birthday.message.model;

import java.util.Date;

/**
 * @author swapnil.patil
 *	The Class EmployeeModel.
 */
public class EmployeeModel {


	public EmployeeModel() {
		super();
	}

	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The dob. */
	private Date DOB;
	
	/** The email address. */
	private String emailAddress;

	public EmployeeModel(String string, String string2, String string3, String string4) {
		
	}
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

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "EmployeeModel [firstName=" + firstName + ", lastName=" + lastName + ", DOB=" + DOB + ", emailAddress="
				+ emailAddress + "]";
	}
	
	
	
	
}
