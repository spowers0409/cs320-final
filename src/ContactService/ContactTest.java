package ContactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {
	// Variables
  protected String contactId, firstNameTest, lastNameTest, phoneNumberTest,
      addressTest;
  	// Test variables
  protected String tooLongContactId, tooLongFirstName, tooLongLastName,
      tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;

  @BeforeEach
  void infoBin() {
    contactId = "0000000001";								// No longer than 10 characters
    firstNameTest = "Sam";									// No longer than 10 characters
    lastNameTest = "Powers";								// No longer than 10 characters
    phoneNumberTest = "5553854470";							// Exactly 10 characters
    addressTest = "934 Crete Ct";							// No longer than 30 characters
    tooLongContactId = "00000000000000000001";				// Test for longer than 10 characters
    tooLongFirstName = "Samuel Jordan Powers";				// Test for longer than 10 characters
    tooLongLastName = "Powers Jordan Samuel";				// Test for longer than 10 characters
    tooLongPhoneNumber = "55538544701";						// Test for longer than 10 characters
    tooShortPhoneNumber = "3854470";						// Test for shorter than 10 characters
    tooLongAddress = "934 Crete Ct Warrenton Missouri";		// Test for longer than 30 characters
  }

  // Sets initial information for testing and verify not null
  @Test
  void contactTest() {
    Contact contact = new Contact();
    assertAll("constructor",
              ()
                  -> assertNotNull(contact.getContactId()),
              ()
                  -> assertNotNull(contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              ()  -> assertNotNull(contact.getAddress()));
  }

  // Test for contactId
  @Test
  void contactIdConstructorTest() {
    Contact contact = new Contact(contactId);
    assertAll("constructor one",
              ()
                  -> assertEquals(contactId, contact.getContactId()),
              ()
                  -> assertNotNull(contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              ()  -> assertNotNull(contact.getAddress()));
  }

  // Test for contactId and first name
  @Test
  void contactIdAndFirstNameConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest);
    assertAll("constructor two",
              ()
                  -> assertEquals(contactId, contact.getContactId()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              ()  -> assertNotNull(contact.getAddress()));
  }

  // Test for contactId, first name and last name
  @Test
  void contactIdAndFullNameConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest);
    assertAll("constructor three",
              ()
                  -> assertEquals(contactId, contact.getContactId()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertEquals(lastNameTest, contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              ()  -> assertNotNull(contact.getAddress()));
  }

  // Test for contactId, first name, last name and phone number
  @Test
  void contactIdFullNamePhoneNumberConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
    assertAll("constructor four",
              ()
                  -> assertEquals(contactId, contact.getContactId()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertEquals(lastNameTest, contact.getLastName()),
              ()
                  -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              ()  -> assertNotNull(contact.getAddress()));
  }

  // Test for contactId, first name, last name, phone number and address
  @Test
  void allTheProperThingsConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest,
                                  phoneNumberTest, addressTest);
    assertAll("constructor all",
              ()
                  -> assertEquals(contactId, contact.getContactId()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertEquals(lastNameTest, contact.getLastName()),
              ()
                  -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              ()  -> assertEquals(addressTest, contact.getAddress()));
  }
  
  
  // Test for updating contactId
  @Test
  void updateContactIdTest() {
    Contact contact = new Contact();
    contact.updateContactId(contactId);
    assertAll("contact ID",
        ()
            -> assertEquals(contactId, contact.getContactId()),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateContactId(null)),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateContactId(tooLongContactId)));
  }

  // Test for updating first name
  @Test
  void updateFirstNameTest() {
    Contact contact = new Contact();
    contact.updateFirstName(firstNameTest);
    assertAll("first name",
        ()
            -> assertEquals(firstNameTest, contact.getFirstName()),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateFirstName(null)),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateFirstName(tooLongFirstName)));
  }

  // Test for updating last name
  @Test
  void updateLastNameTest() {
    Contact contact = new Contact();
    contact.updateLastName(lastNameTest);
    assertAll("last name",
        ()
            -> assertEquals(lastNameTest, contact.getLastName()),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateLastName(null)),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateLastName(tooLongFirstName)));
  }

  // Test for updating phone number
  @Test
  void updatePhoneNumberTest() {
    Contact contact = new Contact();
    contact.updatePhoneNumber(phoneNumberTest);
    assertAll("phone number",
              ()
                  -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                		  () -> contact.updatePhoneNumber(null)),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                		  () -> contact.updatePhoneNumber(tooLongPhoneNumber)),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                		  () -> contact.updatePhoneNumber(tooShortPhoneNumber)),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                		  () -> contact.updatePhoneNumber(contactId)));
  }

  // Test for updating address
  @Test
  void updateAddressTest() {
    Contact contact = new Contact();
    contact.updateAddress(addressTest);
    assertAll("address",
              ()
                  -> assertEquals(addressTest, contact.getAddress()),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updateAddress(null)),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updateAddress(tooLongAddress)));
  }
}

