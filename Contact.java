package contactservice;

/* 
 * Lawrence Arundel CS 320
 * SNHU
 * November 2022
 * The class will implement various components include verifications, authenticity, and integrity standards.
 * 
 * Sources:
 * SNHU, S. N. H. U. (2020, September 11). Junit tutorial. YouTube., 
 * from https://www.youtube.com/watch?v=KbXhK9HUng4&amp;ab_channel=SNHUMedia 
 * 
 * Requirements
 * The contact object shall have a required unique contact ID string that cannot be longer than 10 characters. 
 * The contact ID shall not be null and shall not be updatable.
 * 
 * The contact object shall have a required firstName String field that cannot be longer than 10 characters. 
 * The firstName field shall not be null.
 * 
 * The contact object shall have a required lastName String field that cannot be longer than 10 characters. 
 * The lastName field shall not be null.
 * 
 * The contact object shall have a required phone String field that must be exactly 10 digits. 
 * The phone field shall not be null.
 * 
 * The contact object shall have a required address field that must be no longer than 30 characters. 
 * The address field shall not be null.
 */

public class Contact {
	// declare variables that are utilized within the Contact Class.
	private final String contactID; // contactID is unique within the program because of the final clause.
	private String firstName;
	private String lastName;
	private String contactNumber;
	private String contactAddress;

	// variables to avoid utilizing magic numbers.
	int STATIC_TEN = 10;
	int STATIC_THIRTY = 30;

	// constructor for the Contact object.
	public Contact(String contactID, String firstName, String lastName, String contactNumber, String contactAddress) {

		// contactID variable cannot contain null/empty within the context of the
		// framework.
		if (contactID == null || contactID.isEmpty()) {
			throw new IllegalArgumentException("Null/Empty Entry. Must Input Characters That Do Not Exceed 10.");
		}
		// contactID variable cannot be greater than 10 in terms of the length of the
		// string variable.

		if (contactID.length() > STATIC_TEN) {
			throw new IllegalArgumentException("Invalid Length For Contact ID. Cannot Exceed 10 Characters.");
		}

		// creates the validated contactID after assessing the input from the unit test.
		this.contactID = contactID;

		// firstName variable cannot contain null/empty within the context of the
		// framework.
		if (firstName == null || firstName.isEmpty()) {
			throw new IllegalArgumentException("Null/Empty Entry. Must Input Characters That Do Not Exceed 10.");
		}

		// firstName variable cannot be greater than 10 in terms of the length of the
		// string variable.
		if (firstName.length() > STATIC_TEN) {
			throw new IllegalArgumentException("Invalid Length For First Name. Cannot Exceed 10 Characters.");
		}

		// creates the validated firstName after assessing the input from the unit test.
		this.firstName = firstName;

		// lastName variable cannot contain null/empty within the context of the
		// framework.
		if (lastName == null || lastName.isEmpty()) {
			throw new IllegalArgumentException("Null/Empty Entry. Must Input Characters That Do Not Exceed 10.");
		}

		// lastName variable cannot be greater than 10 in terms of the length of the
		// string variable.
		if (lastName.length() > STATIC_TEN) {
			throw new IllegalArgumentException("Invalid Length For Last Name. Cannot Exceed 10 Characters.");
		}

		// creates the validated lastName after assessing the input from the unit
		// test.
		this.lastName = lastName;

		// contactNumber variable cannot contain null/empty within the context of the
		// framework.
		if (contactNumber == null || contactNumber.isEmpty()) {
			throw new IllegalArgumentException("Null/Empty Entry. Must Input Characters That Do Not Exceed 10.");
		}

		// contactNumber variable that has to equal to exactly 10 to satisfy the
		// requirement.
		if (contactNumber.length() != STATIC_TEN) {
			throw new IllegalArgumentException("Invalid Length For Contact Number. Cannot Exceed 10 Characters.");
		}

		// creates the validated Contact Number after assessing the input from the unit
		// test.
		this.contactNumber = contactNumber;

		// contactAddress variable cannot contain null/empty within the context of the
		// framework.
		if (contactAddress == null || contactAddress.isEmpty()) {
			throw new IllegalArgumentException("Null/Empty Entry. Must Input Characters That Do Not Exceed 30.");
		}

		// contactAddress variable that has to equal to exactly 30 to satisfy the
		// requirement.
		if (contactAddress.length() > STATIC_THIRTY) {
			throw new IllegalArgumentException("Invalid Length For Contact Number. Cannot Exceed 30 Characters.");
		}

		// creates the validated Contact Address after assessing the input from the unit
		// test.
		this.contactAddress = contactAddress;
	}

	// set first name to parameter first name in contact object.
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// set last name to parameter last name in contact object.
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// set contact number to parameter contact number in contact object.
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	// set contact address to parameter contact address in contact object.
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	// returns the data stored in the contactID variable.
	public String getContactID() {
		return contactID;
	}

	// returns the data stored in the firstName variable.
	public String getFirstName() {
		return firstName;
	}

	// returns the data stored in the lastName variable.
	public String getLastName() {
		return lastName;
	}

	// returns the data stored in the contactNumber variable.
	public String getContactNumber() {
		return contactNumber;
	}

	// returns the data stored in the contactAddress variable.
	public String getContactAddress() {
		return contactAddress;
	}
}
