package AppointmentService;

import java.util.Date;

public class Appointment {
	
	final private byte appointmentIDLength;
	final private byte appointmentDescriptionLength;
	final private String INITIALIZER;
	
	private String appointmentID;
	private Date appointmentDate;
	private String description;
	
	
	{
		// ID can not be longer than 10 and description longer than 50
		appointmentIDLength = 10;
		appointmentDescriptionLength = 50;
		INITIALIZER = "INITIAL";
	}
	
	
	// Initialize new appointment
	public Appointment() {
		Date today = new Date();
		appointmentID = INITIALIZER;
		appointmentDate = today;
		description = INITIALIZER;
	}	
	public Appointment(String ID) {
		Date today = new Date();
		updateAppointmentID(ID);
		appointmentDate = today;
		description = INITIALIZER;
	}	
	public Appointment(String ID, Date date) {
		updateAppointmentID(ID);
		updateDate(date);
		description = INITIALIZER;
	}	
	public Appointment(String ID, Date date, String description) {
		updateAppointmentID(ID);
		updateDate(date);
		updateDescription(description);
	}
	
	
	// Update appointment information with given ID
	public void updateAppointmentID(String ID) {
		if(ID == null) {
			throw new IllegalArgumentException("Appointment ID null!");
		}
		else if(ID.length() > appointmentIDLength) {
			throw new IllegalArgumentException("Appointment ID cannot be longer than " + appointmentIDLength + " characters!");
		}
		else {
			this.appointmentID = ID; // Sets the new valid ID as the ID
			}
		}	
	public String getAppointmentID() { return appointmentID; }
	
	// Update appointment, validate correct date and not in past 
	public void updateDate(Date date) {
		if(date == null) {
			throw new IllegalArgumentException("Appointment date null");
		}
		else if(date.before(new Date())) {
			throw new IllegalArgumentException("Error - date is in the past");
		}
		else {
			this.appointmentDate = date;
		}
	}	
	public Date getAppointmentDate() { return appointmentDate; }
	
	// Update appointment, validate the description and length
	public void updateDescription(String description) {
		if(description == null) {
			throw new IllegalArgumentException("Description is null");
		}
		else if(description.length() > appointmentDescriptionLength) {
			throw new IllegalArgumentException("Appointment description cannot be longer than " + appointmentDescriptionLength + " characters!");
		}
		else {
			this.description = description;
		}		
	}	
	public String getDescription() { return description; }
}
