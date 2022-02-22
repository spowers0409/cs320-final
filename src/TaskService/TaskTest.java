package TaskService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskTest {
	
	private String ID;							// Less than or equal to 10 characters
	private String taskName;					// Less than or equal to 20 characters
	private String taskDescription;				// Less than or equal to 50 characters
	private String longID;						// Longer than 10 characters
	private String longTaskName;				// Longer than 20 characters
	private String longTaskDescription;			// Longer than 50 characters
	
	@BeforeEach
	void infoBin() {
		ID = "0000000001";
		taskName = "Samuel Powers";
		taskDescription = "This is a description";
		longID = "000000000000000001";
		longTaskName = "Samuel Jordan Powers is a long name";
		longTaskDescription = "This is a decription that is far too long to be used in this type of field because we only needed this to be less than or equal to 50 characters long";
	}
	
	// taskID tests for validity, length and null
	@Test
	void taskIDTest() {
		Task task = new Task(ID);
		Assertions.assertEquals(ID,  task.getTaskID());;		
	}	
	@Test
	void longIDTest() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Task(longID));
	}
	@Test
	void nullTaskIDTest() {
	    Assertions.assertThrows(IllegalArgumentException.class,
	            () -> new Task(null));
	}
	
	
	
	// taskName tests
	@Test
	void taskNameTest() {
		Task task = new Task(ID, taskName);
		Assertions.assertEquals(taskName, task.getTaskName());
	}
	@Test
	void setTaskName() {
		Task task = new Task();
		task.validName(taskName);
		Assertions.assertEquals(taskName, task.getTaskName());
	}
	@Test
	void longTaskNameTest() {
		Task task = new Task();
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> task.validName(longTaskName));
	}
	@Test
	  void nullTaskNameTest() {
	    Task task = new Task();
	    Assertions.assertThrows(IllegalArgumentException.class,
	            () -> task.validName(null));
	  }
	
	
	
	// taskDescription tests
	@Test
	void taskDescriptionTest() {
		Task task = new Task(ID, taskName, taskDescription);
		Assertions.assertEquals(taskDescription, task.getTaskDescription());
	}
	@Test
	void setTaskDescriptionTest() {
		Task task = new Task();
		task.validTaskDescription(taskDescription);
		Assertions.assertEquals(taskDescription, task.getTaskDescription());
	}
	@Test
	void longTaskDescriptionTest() {
		Task task = new Task();
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> task.validTaskDescription(longTaskDescription));
	}
	@Test
	void nullTaskDescriptionTest() {
	    Task task = new Task();
	    Assertions.assertThrows(IllegalArgumentException.class,
	            () -> task.validTaskDescription(null));
	  }

}
