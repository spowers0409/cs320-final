package ContactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
	// Variables
  protected String contactId, firstNameTest, lastNameTest, phoneNumberTest,
      addressTest;
  	// Test Variables
  protected String longContactId, longFirstName, longLastName,
      longPhoneNumber, shortPhoneNumber, longAddress;

  @BeforeEach
  void infoBin() {
    contactId = "0000000001";								// No longer than 10 characters
    firstNameTest = "Sam";									// No longer than 10 characters
    lastNameTest = "Powers";								// No longer than 10 characters
    phoneNumberTest = "5553854470";							// Exactly 10 characters
    addressTest = "934 Crete Ct";							// No longer than 30 characters
    longContactId = "000000000000000011";					// Test for longer than 10 characters
    longFirstName = "Samuel Jordan Powers";					// Test for longer than 10 characters
    longLastName = "Powers Jordan Samuel";					// Test for longer than 10 characters
    longPhoneNumber = "5553854470111111";					// Test for longer than 10 characters
    shortPhoneNumber = "3854470";							// Test for shorter than 10 characters
    longAddress = "934 Crete Ct WArrenton Missouri";		// Test for longer than 30 characters
  }

  @Test
  // Sets initial information for testing
  // Initial blank service application
  void newContactTest() {
    ContactService service = new ContactService();
    service.newContact();
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(0).getContactId()),
        ()
            -> assertEquals("INITIAL",
                            service.getContactList().get(0).getFirstName()),
        ()
            -> assertEquals("INITIAL",
                            service.getContactList().get(0).getLastName()),
        ()
            -> assertEquals("5553854470",
                            service.getContactList().get(0).getPhoneNumber()),
        ()
            -> assertEquals("INITIAL",
                            service.getContactList().get(0).getAddress()));
    
    // Sets first name for testing within service application
    service.newContact(firstNameTest);
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(1).getContactId()),
        ()
            -> assertEquals(firstNameTest,
                            service.getContactList().get(1).getFirstName()),
        ()
            -> assertEquals("INITIAL",
                            service.getContactList().get(1).getLastName()),
        ()
            -> assertEquals("5553854470",
                            service.getContactList().get(1).getPhoneNumber()),
        ()
            -> assertEquals("INITIAL",
                            service.getContactList().get(1).getAddress()));
    
    // Sets last name for testing within service application
    service.newContact(firstNameTest, lastNameTest);
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(2).getContactId()),
        ()
            -> assertEquals(firstNameTest,
                            service.getContactList().get(2).getFirstName()),
        ()
            -> assertEquals(lastNameTest,
                            service.getContactList().get(2).getLastName()),
        ()
            -> assertEquals("5553854470",
                            service.getContactList().get(2).getPhoneNumber()),
        ()
            -> assertEquals("INITIAL",
                            service.getContactList().get(2).getAddress()));
    
    // Sets phone number for testing within service application
    service.newContact(firstNameTest, lastNameTest, phoneNumberTest);
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(3).getContactId()),
        ()
            -> assertEquals(firstNameTest,
                            service.getContactList().get(3).getFirstName()),
        ()
            -> assertEquals(lastNameTest,
                            service.getContactList().get(3).getLastName()),
        ()
            -> assertEquals(phoneNumberTest,
                            service.getContactList().get(3).getPhoneNumber()),
        ()
            -> assertEquals("INITIAL",
                            service.getContactList().get(3).getAddress()));
    
    // Sets address for testing within service application
    service.newContact(firstNameTest, lastNameTest, phoneNumberTest,
                       addressTest);
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(4).getContactId()),
        ()
            -> assertEquals(firstNameTest,
                            service.getContactList().get(4).getFirstName()),
        ()
            -> assertEquals(lastNameTest,
                            service.getContactList().get(4).getLastName()),
        ()
            -> assertEquals(phoneNumberTest,
                            service.getContactList().get(4).getPhoneNumber()),
        ()
            -> assertEquals(addressTest,
                            service.getContactList().get(4).getAddress()));
  }

  // Test to delete contacts
  @Test
  void deleteContactTest() {
    ContactService service = new ContactService();
    service.newContact();
    assertThrows(Exception.class, () -> service.deleteContact(contactId));
    assertAll(()
                  -> service.deleteContact(
                      service.getContactList().get(0).getContactId()));
  }

  // Test to update first name and verify the length is no longer than 10 or null
  @Test
  void updateFirstNameTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updateFirstName(service.getContactList().get(0).getContactId(),
                            firstNameTest);
    assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateFirstName(
                         service.getContactList().get(0).getContactId(),
                         longFirstName));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateFirstName(
                         service.getContactList().get(0).getContactId(), null));
    assertThrows(Exception.class,
                 () -> service.updateFirstName(contactId, firstNameTest));
  }

  // Test to update last name and verify the length is no longer than 10 or null
  @Test
  void updateLastNameTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updateLastName(service.getContactList().get(0).getContactId(),
                           lastNameTest);
    assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateLastName(
                         service.getContactList().get(0).getContactId(),
                         longLastName));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateLastName(
                         service.getContactList().get(0).getContactId(), null));
    assertThrows(Exception.class,
                 () -> service.updateLastName(contactId, lastNameTest));
  }

  // Test to update phone number and verify the length is exactly 10 and not null
  @Test
  void updatePhoneNumberTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updatePhoneNumber(service.getContactList().get(0).getContactId(),
                              phoneNumberTest);
    assertEquals(phoneNumberTest,
                 service.getContactList().get(0).getPhoneNumber());
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updatePhoneNumber(
                         service.getContactList().get(0).getContactId(),
                         longPhoneNumber));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updatePhoneNumber(
                         service.getContactList().get(0).getContactId(),
                         shortPhoneNumber));
    assertThrows(IllegalArgumentException.class,
    			()
    				-> service.updatePhoneNumber(
    					service.getContactList().get(0).getContactId(), 
    					contactId));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updatePhoneNumber(
                         service.getContactList().get(0).getContactId(), null));
    assertThrows(Exception.class,
                 () -> service.updatePhoneNumber(contactId, lastNameTest));
  }

  // Test to update address and verify the length is no longer than 30 or null
  @Test
  void updateAddressTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updateAddress(service.getContactList().get(0).getContactId(),
                          addressTest);
    assertEquals(addressTest, service.getContactList().get(0).getAddress());
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateAddress(
                         service.getContactList().get(0).getContactId(),
                         longAddress));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateAddress(
                         service.getContactList().get(0).getContactId(), null));
    assertThrows(Exception.class,
                 () -> service.updateAddress(contactId, addressTest));
  }
}
