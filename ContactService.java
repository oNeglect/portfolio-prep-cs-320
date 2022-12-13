package contactservice;

import java.util.HashMap;

/* 
 * Lawrence Arundel CS 320
 * SNHU
 * November 2022
 * The class will implement various components include verifications, authenticity, and integrity standards.
 * 
 * Requirements
 * The contact service shall be able to add contacts with a unique ID.
 * The contact service shall be able to delete contacts per contact ID.
 * The contact service shall be able to update contact fields per contact ID. 
 * 
 * The following fields are updatable:
 * firstName
 * lastName
 * Number
 * Address
 */

public class ContactService {
	// declare private variable of hash map where the contact id will be utilized as
	// the key
	// and the contact object itself will be the contents within that specified key.
	private HashMap<String, Contact> contactList = new HashMap<String, Contact>();
	private int STATIC_TEN = 10;
	private int STATIC_THIRTY = 30;

	// adds contact object to the hashmap of contacts within the database to satisfy
	// the client requirements.
	public void addContact(Contact contact) {
		// adds contact object into the hash map database if the object
		// does not already exist.
		if (contactList.containsKey(contact.getContactID())) {
			throw new IllegalArgumentException("Key Already Exists. Enter Valid Entry");
		}
		// adds contact object into the hash map after the hash map is searched for
		// existing contact id.
		contactList.put(contact.getContactID(), contact);
	}

	// deletes contact object in the hash map of contacts within the database to
	// satisfy
	// the client requirements.
	public void deleteContact(String contactID) {
		// delete contact object from the hash map database if the object does exist.
		// if the object does not exist, the algorithm will throw an exception.
		// otherwise, proceed with deletion.
		if (!(contactList.containsKey(contactID))) {
			throw new IllegalArgumentException("Key Does Not Exist. Invalid Operation.");
		}
		// delete contact object from the hash map once check for key has been processed
		// appropriately.
		contactList.remove(contactID);
	}

	public void updateContactFirstName(String contactID, String firstName) {
		// search for the required contact id that the user would like to update.
		// if the id is not found, throw an exception error and claim key does not
		// exist.
		// if the id is found, update the first name for that specified contact id
		// within database.
		if (!(contactList.containsKey(contactID))) {
			throw new IllegalArgumentException("Key Does Not Exist. Invalid Operation.");
		}

		// update the first name for the specified contact id with the parameter
		// firstName given the constraints that it must be at least 10 characters and
		// cannot be null.
		if (firstName == null || firstName.length() > STATIC_TEN) {
			throw new IllegalArgumentException("First Name Must Not Exceed 10 characters And Cannot Be Null Value.");
		}

		// update the first name for the specified contact id with the parameter
		// firstName.
		contactList.get(contactID).setFirstName(firstName);
	}

	public void updateContactLastName(String contactID, String lastName) {
		// search for the required contact id that the user would like to update.
		// if the id is not found, throw an exception error and claim key does not
		// exist.
		// if the id is found, update the last name for that specified contact id
		// within database.
		if (!(contactList.containsKey(contactID))) {
			throw new IllegalArgumentException("Key Does Not Exist. Invalid Operation.");
		}
		// update the last name for the specified contact id with the parameter
		// lastName given the constraints that it must be at least 10 characters and
		// cannot be null.
		if (lastName == null || lastName.length() > STATIC_TEN) {
			throw new IllegalArgumentException("Last Name Must Not Exceed 10 Characters And Cannot Be Null Value.");
		}

		// update the last name for the specified contact id after the proper checks
		// have been implemented.
		contactList.get(contactID).setLastName(lastName);
	}

	public void updateContactNumber(String contactID, String contactNumber) {
		// search for the required contact id that the user would like to update.
		// if the id is not found, throw an exception error and claim key does not
		// exist.
		// if the id is found, update the contact number for that specified contact id
		// within database.
		if (!(contactList.containsKey(contactID))) {
			throw new IllegalArgumentException("Key Does Not Exist. Invalid Operation.");
		}
		// update the contact Number for the specified contact id with the parameter
		// contactNumber given the constraints that it must be exactly 10 characters and
		// cannot be null.
		if (contactNumber == null || contactNumber.length() != STATIC_TEN) {
			throw new IllegalArgumentException("Contact Number Must Be 10 characters And Cannot Be Null Value.");
		}

		// update the contact number for the specified contact id after the proper
		// checks
		// have been implemented.
		contactList.get(contactID).setContactNumber(contactNumber);
	}

	public void updateContactAddress(String contactID, String contactAddress) {
		// search for the required contact id that the user would like to update.
		// if the id is not found, throw an exception error and claim key does not
		// exist.
		// if the id is found, update the contact address for that specified contact id
		// within database.
		if (!(contactList.containsKey(contactID))) {
			throw new IllegalArgumentException("Key Does Not Exist. Invalid Operation.");
		}
		// update the contact address for the specified contact id with the parameter
		// contactNumber given the constraints that it cannot exceed 30 characters and
		// cannot be null.
		if (contactAddress == null || contactAddress.length() > STATIC_THIRTY) {
			throw new IllegalArgumentException(
					"Contact Address Must Not Exceed 30 characters And Cannot Be Null Value.");
		}

		// update the contact address for the specified contact id after the proper
		// checks
		// have been implemented.
		contactList.get(contactID).setContactAddress(contactAddress);
	}

	// get method to obtain the database for searching or hash map structure return
	public HashMap<String, Contact> getContactList() {
		return contactList;
	}
}
