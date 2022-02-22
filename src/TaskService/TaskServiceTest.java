package TaskService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
	
	private String ID;
	private String taskName;
	private String taskDescription;
	private String longTaskName;
	private String longTaskDescription;
	
	
	// Set the initial information for the tests
	@BeforeEach
	void infoBin() {
		ID = "0000000001";
		taskName = "Samuel Powers";
		taskDescription = "Task description";
		longTaskName = "This name is far too long to be less than 20 characters";
		longTaskDescription = "This description is far too long to be less than 50 characters";
	}
	
	
	// Tests for task name length, null, update and make sure it is valid
	@Test
	void taskNameTest() {
		TaskService service = new TaskService();
	    service.newTask(taskName);
	    Assertions.assertNotNull(service.getTaskList().get(0).getTaskName());
	    Assertions.assertEquals(taskName, service.getTaskList().get(0).getTaskName());
	  }
	@Test
	void longTaskNameTest() {
	    TaskService service = new TaskService();
	    Assertions.assertThrows(IllegalArgumentException.class,
	    		() -> service.newTask(longTaskName));
	  }
	@Test
	  void nullTaskNamelTest() {
	    TaskService service = new TaskService();
	    assertThrows(IllegalArgumentException.class,
	    		() -> service.newTask(null));
	  } 
	@Test
	  void updateTaskNameTest() throws Exception {
	    TaskService service = new TaskService();
	    service.newTask();
	    service.updateTaskName(service.getTaskList().get(0).getTaskID(), taskName);
	    assertEquals(taskName, service.getTaskList().get(0).getTaskName());
	  }
	@Test
	  void updateInvalidNameTest() throws Exception {
	    TaskService service = new TaskService();
	    service.newTask();
	    assertThrows(Exception.class,
	    		() -> service.updateTaskName(ID, taskName));
	  }
	
	
	// Tests for task description length, null, update and make sure it is valid
	  @Test
	  void taskDescriptionTest() {
	    TaskService service = new TaskService();
	    service.newTask(taskName, taskDescription);
	    Assertions.assertNotNull(service.getTaskList().get(0).getTaskDescription());
	    Assertions.assertEquals(taskDescription,
	                            service.getTaskList().get(0).getTaskDescription());
	  }
	  @Test
	  void longTaskDescriptionTest() {
	    TaskService service = new TaskService();
	    assertThrows(IllegalArgumentException.class,
	                 () -> service.newTask(taskName, longTaskDescription));
	  }
	  @Test
	  void nullTaskDescriptionTest() {
	    TaskService service = new TaskService();
	    assertThrows(IllegalArgumentException.class,
	                 () -> service.newTask(taskName, null));
	  }
	  @Test
	  void updateTaskDescriptionTest() throws Exception {
	    TaskService service = new TaskService();
	    service.newTask();
	    service.updateTaskDescription(service.getTaskList().get(0).getTaskID(), taskName, taskDescription);
	    assertEquals(taskDescription, service.getTaskList().get(0).getTaskDescription());
	  }
	  @Test
	  void updateInvalidDescriptionTest() throws Exception {
	    TaskService service = new TaskService();
	    service.newTask();
	    assertThrows(Exception.class,
	                 () -> service.updateTaskDescription(ID, taskName, taskDescription));
	  }
	  
	  
	  @Test
	  // Test for valid ID 
	  void taskIDTest() {
		  TaskService service = new TaskService();
		  service.newTask();
		  Assertions.assertNotNull(service.getTaskList().get(0).getTaskID());
		  Assertions.assertNotEquals("INITIAL", service.getTaskList().get(0).getTaskID());
	  }
	  
	  
	  // Test to verify tasks can be deleted
	  @Test
	  void deleteTaskTest() throws Exception {
	    TaskService service = new TaskService();
	    service.newTask();
	    assertEquals(1, service.getTaskList().size());
	    service.deleteTask(service.getTaskList().get(0).getTaskID());
	    assertEquals(0, service.getTaskList().size());
	  }	  
	  

	  @RepeatedTest(4)
	  void repeatTaskListTests() {
	    TaskService service = new TaskService();
	    service.newTask();
	    service.newTask();
	    service.newTask();
	    assertEquals(3, service.getTaskList().size());
	    assertNotEquals(service.getTaskList().get(0).getTaskID(),
	                    service.getTaskList().get(1).getTaskID());
	    assertNotEquals(service.getTaskList().get(0).getTaskID(),
	                    service.getTaskList().get(2).getTaskID());
	    assertNotEquals(service.getTaskList().get(1).getTaskID(),
	                    service.getTaskList().get(2).getTaskID());
	  }
	}
