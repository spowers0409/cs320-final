package ContactService;

public class Contact {

	  private static final byte idLength = 10;	  
	  private static final byte firstNameLength = 10;
	  private static final byte lastNameLength = 10;
	  private static final int phoneNumberLength = 10;
	  private static final byte addressLength = 30;
	  
	  private static final String INITIALIZER = "INITIAL";
	  private static final String INITIALIZER_NUM = "5553854470";
	  
	  private String contactId;
	  private String firstName;
	  private String lastName;
	  private String phoneNumber;
	  private String address;

	  // Initializes contact information for ID, first name, last name, phone number and address
	  Contact() {
	    this.contactId = INITIALIZER;
	    this.firstName = INITIALIZER;
	    this.lastName = INITIALIZER;
	    this.phoneNumber = INITIALIZER_NUM;
	    this.address = INITIALIZER;
	  }

	  // Update contactId with contactId
	  Contact(String contactId) {
	    updateContactId(contactId);
	    this.firstName = INITIALIZER;
	    this.lastName = INITIALIZER;
	    this.phoneNumber = INITIALIZER_NUM;
	    this.address = INITIALIZER;
	  }

	  // update firstName with firstName
	  Contact(String contactId, String firstName) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    this.lastName = INITIALIZER;
	    this.phoneNumber = INITIALIZER_NUM;
	    this.address = INITIALIZER;
	  }

	  // Update lastName with lastName
	  Contact(String contactId, String firstName, String lastName) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    this.phoneNumber = INITIALIZER_NUM;
	    this.address = INITIALIZER;
	  }

	  // Update phoneNumber with phoneNumber
	  Contact(String contactId, String firstName, String lastName,
	          String phoneNumber) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    updatePhoneNumber(phoneNumber);
	    this.address = INITIALIZER;
	  }

	  // Update address with address
	  Contact(String contactId, String firstName, String lastName,
	          String phoneNumber, String address) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    updatePhoneNumber(phoneNumber);
	    updateAddress(address);
	  }

	  // Gets the information to be returned when called 
	  protected final String getContactId() { return contactId; }
	  protected final String getFirstName() { return firstName; }
	  protected final String getLastName() { return lastName; }
	  protected final String getPhoneNumber() { return phoneNumber; }
	  protected final String getAddress() { return address; }
	  
	  // When updating the ID, this checks for null and length of no more than 10
	  protected void updateContactId(String contactId) {
		    if (contactId == null) {
		      throw new IllegalArgumentException("Contact ID expected");
		    } else if (contactId.length() > idLength) {
		      throw new IllegalArgumentException("Contact ID cannot be longer than " + idLength + " characters");
		    } else {
		      this.contactId = contactId;
		    }
		  }

	  // When updating the first name, this checks for null and length of no more than 10
	  protected void updateFirstName(String firstName) {
		    if (firstName == null) {
		      throw new IllegalArgumentException("First name expected");
		    } else if (firstName.length() > firstNameLength) {
		      throw new IllegalArgumentException("First name cannot be longer than " + firstNameLength + " characters");
		    } else {
		      this.firstName = firstName;
		    }
		  }
	  
	  // When updating the last name, this checks for null and length of no more than 10
	  protected void updateLastName(String lastName) {
	    if (lastName == null) {
	      throw new IllegalArgumentException("Last name expected");
	    } else if (lastName.length() > lastNameLength) {
	      throw new IllegalArgumentException("Last name cannot be longer than " + lastNameLength + " characters");
	    } else {
	      this.lastName = lastName;
	    }
	  }

	  // When updating phone number, check for null, length of exactly 10, and that only numbers are used
	  protected void updatePhoneNumber(String phoneNumber) {
	    String regex = "[0-9]+";
	    if (phoneNumber == null) {
	      throw new IllegalArgumentException("Phone number expected.");
	    } else if (phoneNumber.length() != phoneNumberLength) {
	      throw new IllegalArgumentException(
	          "Phone number may only be " + phoneNumberLength + " characters long.");
	    } else if (!phoneNumber.matches(regex)) {
	      throw new IllegalArgumentException(
	          "Only use numbers please!");
	    } else {
	      this.phoneNumber = phoneNumber;
	    }
	  }

	  protected void updateAddress(String address) {
	    if (address == null) {
	      throw new IllegalArgumentException("Address expected");
	    } else if (address.length() > addressLength) {
	      throw new IllegalArgumentException("Address must not exceed " + addressLength + " characters long");
	    } else {
	      this.address = address;
	    }
	  }
	  
	  

	  
	}

