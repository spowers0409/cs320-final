package TaskService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskService {
	// Create new list to hold unique IDs and info
	private final List<Task> taskList = new ArrayList<>();
	// Create a unique ID that is no longer than 10 characters
	private String uniqueID() {
		return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}
	
	
	// Throw exception is no task ID available
	private Task searchForTask(String ID) throws Exception {
		int index = 0;
		while(index < taskList.size()) {
			if(ID.equals(taskList.get(index).getTaskID())) {
				return taskList.get(index);
			}
			index++;
		}
		throw new Exception("No task available.");
	}
	
	
	// Create new task ID
	public void newTask() {
		Task task = new Task(uniqueID());
		taskList.add(task);
	}
	// Create new task Name
	public void newTask(String taskName) {
		Task task = new Task(uniqueID(), taskName);
		taskList.add(task);
	}
	// Create new task Description
	public void newTask(String taskName, String taskDescription) {
		Task task = new Task(uniqueID(), taskName, taskDescription);
		taskList.add(task);
	}
	
	
	// Update the task name from ID
	public void updateTaskName(String ID, String taskName) throws Exception {
		searchForTask(ID).validName(taskName);
	}
	// Update the task description from ID
	public void updateTaskDescription(String ID, String taskName, String taskDescription) throws Exception {
		searchForTask(ID).validTaskDescription(taskDescription);
	}
	
	
	// Delete a task VIA the task ID
	public void deleteTask(String ID) throws Exception {
		taskList.remove(searchForTask(ID));
	}
	
	
	// Return task List
	public List<Task> getTaskList() { return taskList; }

}
