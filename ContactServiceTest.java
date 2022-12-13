package test;

import org.junit.Test;

import org.junit.jupiter.api.Assertions;

import contactservice.Contact;
import contactservice.ContactService;

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

import junit.framework.TestCase;

public class ContactServiceTest extends TestCase {

	// Runs various test to make sure the add contact, update contact address, first
	// name, last name,
	// and number are properly updated, and finally the removal is correct.

	@Test
	public void testContactService() {
		// create contact service to add to the hash map list of contacts.
		ContactService contactService = new ContactService();
		// create contact to test for the appropriate functions described in the
		// requirements.
		Contact contact = new Contact("test", "test", "test", "testing123", "test");
		// various functions that are the set up before the test is run during assertion
		// statements.
		contactService.addContact(contact); // add contact to database.
		contactService.updateContactAddress(contact.getContactID(), "test1"); // update contact address.
		contactService.updateContactFirstName(contact.getContactID(), "test1"); // update first name.
		contactService.updateContactLastName(contact.getContactID(), "test1"); // update last name.
		contactService.updateContactNumber(contact.getContactID(), "2222222222"); // update contact number.
		// asserted that these statements are true based on the algorithm within the
		// executed code.
		// passing test means that the system is properly functioning with add. remove,
		// and updating
		// features.
		assertTrue(contact.getContactAddress().equalsIgnoreCase("test1"));
		assertTrue(contact.getLastName().equalsIgnoreCase("test1"));
		assertTrue(contact.getFirstName().equalsIgnoreCase("test1"));
		assertTrue(contact.getContactNumber().equalsIgnoreCase("2222222222"));
		assertTrue(contactService.getContactList().containsKey(contact.getContactID()));

		// test to see if the contact is deleted from the database
		contactService.deleteContact(contact.getContactID()); // delete contact from database.

		// run test to see if the contact is deleted from the hash map structure
		assertTrue(!(contactService.getContactList().containsKey(contact.getContactID())));

	}

	// test that checks client requirements that state the contact can be added to
	// the database based on
	// the contact id. if the contact id exists, the algorithm will throw an error
	// and handle appropriately.
	@Test
	public void testContactServiceAddContact() {

		// testing whether adding contact to database works. passing test means the
		// unique id already exists
		// within the database, and the algorithm effectively checks for this.

		// test will create two contact objects and attempt to add them into the
		// database.
		// both objects will have identical contact id. passing test means algorithm is
		// correctly implemented
		// by throwing appropriate exception.

		// constructor format in the assertion statement.
		// Contact(String contactID, String firstName, String lastName, String
		// contactNumber, String contactAddress).

		// create first object to add to database with all valid inputs.
		Contact contactOne = new Contact("test", "test", "test", "3333333333", "test");

		// create second object to add to database with all valid inputs.
		Contact contactTwo = new Contact("test", "test", "test", "3333333333", "test");

		// create contact service object to store contact/s previously created.
		ContactService contactDataBase = new ContactService();

		// add the first object into the database to set up the test.
		contactDataBase.addContact(contactOne);

		// add the second object into the database to perform test and check to see if
		// algorithm checks correctly for identical keys within the system.
		// test will pass meaning an exception was thrown because id exist already in
		// database.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactDataBase.addContact(contactTwo);
		});
	}

	// test that checks client requirements that state the contact can be added to
	// the database based on
	// the contact id. if the contact id exists, the algorithm will throw an error
	// and handle appropriately.
	@Test
	public void testContactServiceDeleteContact() {

		// testing whether deleting contact to database works. passing test means the
		// unique id does not exisit
		// within the database, and the algorithm effectively checks for this.

		// test will create one contact object, and attempt to delete the object based
		// on the
		// contact id via calling method with string variable (matching contact id).

		// constructor format in the assertion statement.
		// Contact(String contactID, String firstName, String lastName, String
		// contactNumber, String contactAddress).

		// create first object to add to database with all valid inputs.
		Contact contactOne = new Contact("test", "test", "test", "3333333333", "test");

		// create contact service object to store contact/s previously created.
		ContactService contactDataBase = new ContactService();

		// add the contact to the database to set up for the test deletion
		contactDataBase.addContact(contactOne);

		// attempt to delete the previously added contact from the database.
		// if the exception is thrown, the specified deletion does not exist, and then
		// algorithm
		// works as intended, meaning passing test.
		// attempting to delete contact with key "testingID".
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactDataBase.deleteContact("testingID");
		});
	}

	// test that checks client requirements that state the contact can be added to
	// the database based on
	// the contact id. if the contact id exists, the algorithm will throw an error
	// and handle appropriately.
	@Test
	public void testContactServiceUpdateContactFirstName() {

		// testing whether contact service can update the specified contact first name
		// within the database. the test will involve searching for the required contact
		// id
		// if the contact id is found, the contact first name will be promptly updated
		// within the database.
		// throw exception if the contact id attempting to be updated is not found.

		// constructor format in the assertion statement.
		// Contact(String contactID, String firstName, String lastName, String
		// contactNumber, String contactAddress).

		// create first object to add to database with all valid inputs.
		Contact contactOne = new Contact("test", "test", "test", "3333333333", "test");

		// create contact service object to store contact/s previously created.
		ContactService contactDataBase = new ContactService();

		// add the contact to the database to set up for the test update first name.
		contactDataBase.addContact(contactOne);

		// attempt to run test with invalid contact id, test should pass meaning the
		// algorithm is successfully
		// implemented to check for appropriate id.
		// with valid id, the code executes an update on the database with the passed
		// parameter for first name.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactDataBase.updateContactFirstName("wrongtest", "john");
		});
	}

	// test that checks client requirements that state the contact can be added to
	// the database based on
	// the contact id. if the contact id exists, the algorithm will throw an error
	// and handle appropriately.
	@Test
	public void testContactServiceUpdateContactFirstNameLength() {

		// testing whether contact service can update the specified contact first name
		// within the database. the test will involve searching for the required contact
		// id
		// if the contact id is found and length is correct, the contact first name will
		// be promptly updated
		// within the database.
		// throw exception if the contact id attempting to be updated is not found or
		// length is not correct (exceeds 10 characters).

		// constructor format in the assertion statement.
		// Contact(String contactID, String firstName, String lastName, String
		// contactNumber, String contactAddress).

		// create first object to add to database with all valid inputs.
		Contact contactOne = new Contact("test", "test", "test", "3333333333", "test");

		// create contact service object to store contact/s previously created.
		ContactService contactDataBase = new ContactService();

		// add the contact to the database to set up for the test update first name.
		contactDataBase.addContact(contactOne);

		// attempt to run test with invalid chracter length for first name, test should
		// pass meaning the
		// algorithm is successfully
		// implemented to check for appropriate character length.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactDataBase.updateContactFirstName("test", "addingtomanycharacters");
		});
	}

	// test that checks client requirements that state the contact can be added to
	// the database based on
	// the contact id. if the contact id exists and first name not equal to null,
	// the algorithm will throw an error
	// and handle appropriately.
	@Test
	public void testContactServiceUpdateContactFirstNameNull() {

		// testing whether contact service can update the specified contact first name
		// within the database. the test will involve searching for the required contact
		// id and check first name appropriate.
		// if the contact id is found and first name is not equal to null, the contact
		// first name will
		// be promptly updated
		// within the database.
		// throw exception if the contact id attempting to be updated is not found or
		// length is not correct (exceeds 10 characters).

		// constructor format in the assertion statement.
		// Contact(String contactID, String firstName, String lastName, String
		// contactNumber, String contactAddress).

		// create first object to add to database with all valid inputs.
		Contact contactOne = new Contact("test", "test", "test", "3333333333", "test");

		// create contact service object to store contact/s previously created.
		ContactService contactDataBase = new ContactService();

		// add the contact to the database to set up for the test update first name.
		contactDataBase.addContact(contactOne);

		// attempt to run test with null value for first name, test should
		// pass meaning the
		// algorithm is successfully
		// implemented to check for appropriate null value handling.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactDataBase.updateContactFirstName("test", null);
		});
	}

	// test that checks client requirements that state the contact can be added to
	// the database based on
	// the contact id. if the contact id exists, the algorithm will throw an error
	// and handle appropriately.
	@Test
	public void testContactServiceUpdateContactLastName() {

		// testing whether contact service can update the specified contact last name
		// within the database. the test will involve searching for the required contact
		// id
		// if the contact id is found, the contact last name will be promptly updated
		// within the database.
		// throw exception if the contact id attempting to be updated is not found.

		// constructor format in the assertion statement.
		// Contact(String contactID, String firstName, String lastName, String
		// contactNumber, String contactAddress).

		// create first object to add to database with all valid inputs.
		Contact contactOne = new Contact("test", "test", "test", "3333333333", "test");

		// create contact service object to store contact/s previously created.
		ContactService contactDataBase = new ContactService();

		// add the contact to the database to set up for the test update last name.
		contactDataBase.addContact(contactOne);

		// attempt to run test with invalid contact id, test should pass meaning the
		// algorithm is successfully
		// implemented to check for appropriate id.
		// with valid id, the code executes an update on the database with the passed
		// parameter for last name.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactDataBase.updateContactFirstName("wrongtest", "john");
		});
	}

	// test that checks client requirements that state the contact can be added to
	// the database based on
	// the contact id. if the contact id exists, the algorithm will throw an error
	// and handle appropriately.
	@Test
	public void testContactServiceUpdateContactLastNameLength() {

		// testing whether contact service can update the specified contact last name
		// within the database. the test will involve searching for the required contact
		// id
		// if the contact id is found and length is correct, the contact last name will
		// be promptly updated
		// within the database.
		// throw exception if the contact id attempting to be updated is not found or
		// last name
		// length is not correct (exceeds 10 characters).

		// constructor format in the assertion statement.
		// Contact(String contactID, String firstName, String lastName, String
		// contactNumber, String contactAddress).

		// create first object to add to database with all valid inputs.
		Contact contactOne = new Contact("test", "test", "test", "3333333333", "test");

		// create contact service object to store contact/s previously created.
		ContactService contactDataBase = new ContactService();

		// add the contact to the database to set up for the test update last name.
		contactDataBase.addContact(contactOne);

		// attempt to run test with invalid chracter length for last name, test should
		// pass meaning the
		// algorithm is successfully
		// implemented to check for appropriate character length.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactDataBase.updateContactLastName("test", "addingtomanycharacters");
		});
	}

	// test that checks client requirements that state the contact can be added to
	// the database based on
	// the contact id. if the contact id exists and last name not equal to null,
	// the algorithm will throw an error
	// and handle appropriately.
	@Test
	public void testContactServiceUpdateContactLastNameNull() {

		// testing whether contact service can update the specified contact last name
		// within the database. the test will involve searching for the required contact
		// id and check last name appropriate.
		// if the contact id is found and last name is not equal to null, the contact
		// last name will
		// be promptly updated
		// within the database.
		// throw exception if the contact id attempting to be updated is not found or
		// last name
		// is null.

		// constructor format in the assertion statement.
		// Contact(String contactID, String firstName, String lastName, String
		// contactNumber, String contactAddress).

		// create first object to add to database with all valid inputs.
		Contact contactOne = new Contact("test", "test", "test", "3333333333", "test");

		// create contact service object to store contact/s previously created.
		ContactService contactDataBase = new ContactService();

		// add the contact to the database to set up for the test update last name.
		contactDataBase.addContact(contactOne);

		// attempt to run test with null value for last name, test should
		// pass meaning the
		// algorithm is successfully
		// implemented to check for appropriate null value handling.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactDataBase.updateContactLastName("test", null);
		});
	}

	// test that checks client requirements that state the contact can be added to
	// the database based on
	// the contact id. if the contact id exists, the algorithm will throw an error
	// and handle appropriately.
	@Test
	public void testContactServiceUpdateContactNumber() {

		// testing whether contact service can update the specified contact number
		// within the database. the test will involve searching for the required contact
		// id
		// if the contact id is found, the contact number will be promptly updated
		// within the database.
		// throw exception if the contact id attempting to be updated is not found.

		// constructor format in the assertion statement.
		// Contact(String contactID, String firstName, String lastName, String
		// contactNumber, String contactAddress).

		// create first object to add to database with all valid inputs.
		Contact contactOne = new Contact("test", "test", "test", "3333333333", "test");

		// create contact service object to store contact/s previously created.
		ContactService contactDataBase = new ContactService();

		// add the contact to the database to set up for the test update contact number.
		contactDataBase.addContact(contactOne);

		// attempt to run test with invalid contact id, test should pass meaning the
		// algorithm is successfully
		// implemented to check for appropriate id.
		// with valid id, the code executes an update on the database with the passed
		// parameter for contact number.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactDataBase.updateContactNumber("wrongtest", "2555555555");
		});
	}

	// test that checks client requirements that state the contact can be added to
	// the database based on
	// the contact id. if the contact id exists, the algorithm will throw an error
	// and handle appropriately.
	@Test
	public void testContactServiceUpdateContactNumberLength() {

		// testing whether contact service can update the specified contact contact
		// number
		// within the database. the test will involve searching for the required contact
		// id
		// if the contact id is found and length is correct, the contact number will
		// be promptly updated
		// within the database.
		// throw exception if the contact id attempting to be updated is not found or
		// contact number
		// length is not correct (needs to be exactly 10 characters).

		// constructor format in the assertion statement.
		// Contact(String contactID, String firstName, String lastName, String
		// contactNumber, String contactAddress).

		// create first object to add to database with all valid inputs.
		Contact contactOne = new Contact("test", "test", "test", "3333333333", "test");

		// create contact service object to store contact/s previously created.
		ContactService contactDataBase = new ContactService();

		// add the contact to the database to set up for the test update contact number.
		contactDataBase.addContact(contactOne);

		// attempt to run test with invalid chracter length for contact number, test
		// should
		// pass meaning the
		// algorithm is successfully
		// implemented to check for appropriate character length.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactDataBase.updateContactNumber("test", "25888888887");
		});
	}

	// test that checks client requirements that state the contact can be added to
	// the database based on
	// the contact id. if the contact id exists and last name not equal to null,
	// the algorithm will throw an error
	// and handle appropriately.
	@Test
	public void testContactServiceUpdateContactNumberNull() {

		// testing whether contact service can update the specified contact contact
		// number
		// within the database. the test will involve searching for the required contact
		// id and check contact number appropriate.
		// if the contact id is found and contact number is not equal to null, the
		// contact
		// number will
		// be promptly updated
		// within the database.
		// throw exception if the contact id attempting to be updated is not found or
		// contact number
		// is null.

		// constructor format in the assertion statement.
		// Contact(String contactID, String firstName, String lastName, String
		// contactNumber, String contactAddress).

		// create first object to add to database with all valid inputs.
		Contact contactOne = new Contact("test", "test", "test", "3333333333", "test");

		// create contact service object to store contact/s previously created.
		ContactService contactDataBase = new ContactService();

		// add the contact to the database to set up for the test update contact number.
		contactDataBase.addContact(contactOne);

		// attempt to run test with null value for contact number, test should
		// pass meaning the
		// algorithm is successfully
		// implemented to check for appropriate null value handling.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactDataBase.updateContactNumber("test", null);
		});
	}

	// test that checks client requirements that state the contact can be added to
	// the database based on
	// the contact id. if the contact id exists, the algorithm will throw an error
	// and handle appropriately.
	@Test
	public void testContactServiceUpdateContactAddress() {

		// testing whether contact service can update the specified contact address
		// within the database. the test will involve searching for the required contact
		// id
		// if the contact id is found, the contact address will be promptly updated
		// within the database.
		// throw exception if the contact id attempting to be updated is not found.

		// constructor format in the assertion statement.
		// Contact(String contactID, String firstName, String lastName, String
		// contactNumber, String contactAddress).

		// create first object to add to database with all valid inputs.
		Contact contactOne = new Contact("test", "test", "test", "3333333333", "test");

		// create contact service object to store contact/s previously created.
		ContactService contactDataBase = new ContactService();

		// add the contact to the database to set up for the test update contact
		// address.
		contactDataBase.addContact(contactOne);

		// attempt to run test with invalid contact id, test should pass meaning the
		// algorithm is successfully
		// implemented to check for appropriate id.
		// with valid id, the code executes an update on the database with the passed
		// parameter for contact address.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactDataBase.updateContactAddress("wrongtest", "test");
		});
	}

	// test that checks client requirements that state the contact can be added to
	// the database based on
	// the contact id. if the contact id exists, the algorithm will throw an error
	// and handle appropriately.
	@Test
	public void testContactServiceUpdateContactAddressLength() {

		// testing whether contact service can update the specified contact contact
		// address
		// within the database. the test will involve searching for the required contact
		// id
		// if the contact id is found and length is correct, the contact address will
		// be promptly updated
		// within the database.
		// throw exception if the contact id attempting to be updated is not found or
		// contact address
		// length is not correct (cannot exceed 30 characters).

		// constructor format in the assertion statement.
		// Contact(String contactID, String firstName, String lastName, String
		// contactNumber, String contactAddress).

		// create first object to add to database with all valid inputs.
		Contact contactOne = new Contact("test", "test", "test", "3333333333", "test");

		// create contact service object to store contact/s previously created.
		ContactService contactDataBase = new ContactService();

		// add the contact to the database to set up for the test update contact
		// address.
		contactDataBase.addContact(contactOne);

		// attempt to run test with invalid chracter length for contact number, test
		// should
		// pass meaning the
		// algorithm is successfully
		// implemented to check for appropriate character length.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactDataBase.updateContactAddress("test", "testingtestingtestingtestingtesting");
		});
	}

	// test that checks client requirements that state the contact can be added to
	// the database based on
	// the contact id. if the contact id exists and last name not equal to null,
	// the algorithm will throw an error
	// and handle appropriately.
	@Test
	public void testContactServiceUpdateContactAddressNull() {

		// testing whether contact service can update the specified contact contact
		// number
		// within the database. the test will involve searching for the required contact
		// id and check contact number appropriate.
		// if the contact id is found and contact number is not equal to null, the
		// contact
		// number will
		// be promptly updated
		// within the database.
		// throw exception if the contact id attempting to be updated is not found or
		// contact number
		// is null.

		// constructor format in the assertion statement.
		// Contact(String contactID, String firstName, String lastName, String
		// contactNumber, String contactAddress).

		// create first object to add to database with all valid inputs.
		Contact contactOne = new Contact("test", "test", "test", "3333333333", "test");

		// create contact service object to store contact/s previously created.
		ContactService contactDataBase = new ContactService();

		// add the contact to the database to set up for the test update contact number.
		contactDataBase.addContact(contactOne);

		// attempt to run test with null value for contact number, test should
		// pass meaning the
		// algorithm is successfully
		// implemented to check for appropriate null value handling.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactDataBase.updateContactAddress("test", null);
		});
	}
}
