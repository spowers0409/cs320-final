package AppointmentService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AppointmentService {
	final private List<Appointment> appointmentList = new ArrayList<>();
	
	// Creates random unique appointment ID that is no longer than 10 characters
	private String uniqueID() {
		return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}
	
	public void newAppointment() {
		Appointment appointment = new Appointment(uniqueID());
		appointmentList.add(appointment);
	}
	
	public void newAppointment(Date date) {
		Appointment appointment = new Appointment(uniqueID(), date);
		appointmentList.add(appointment);
	}
	
	public void newAppointment(Date date, String description) {
		Appointment appointment = new Appointment(uniqueID(), date, description);
		appointmentList.add(appointment);
	}
	
	public void deleteAppointment(String ID) throws Exception {
		appointmentList.remove(searchAppointment(ID));
	}
	
	
	public List<Appointment> getAppointmentList() { return appointmentList; }
	// Search for ID and verify that it is a valid appointment ID
	private Appointment searchAppointment(String ID) throws Exception {
		int index = 0;
		while(index < appointmentList.size()) {
			if(ID.equals(appointmentList.get(index).getAppointmentID() )) {
				return appointmentList.get(index);
			}
			index++;
		}
		throw new Exception("Not a valid appointment");
	}
}
