package TaskService;

public class Task {
	
	private String taskID;
	private String taskName;
	private String taskDescription;
	
	// Set the initial value of the variables
	Task() {
		taskID = "INITIAL";
		taskName = "INITIAL";
		taskDescription = "INITIAL";
	}
	Task(String taskID) {
		validTaskID(taskID);
		taskName = "INITIAL";
		taskDescription = "INITIAL";
	}
	Task(String taskID, String taskName) {
		validTaskID(taskID);
		validName(taskID);
		taskDescription = "INITIAL";
	}
	Task(String taskID, String taskName, String taskDescription) {
		validTaskID(taskID);
		validName(taskID);
		validTaskDescription(taskDescription);
	}
	
	// Get and return the values for taskID, name and description
	public final String getTaskID() { return taskID; }
	public final String getTaskName() { return taskName; }
	public final String getTaskDescription() { return taskDescription; }
	
	// validates null and length for taskID
	public void validTaskID(String taskID) {
		if(taskID == null || taskID.length() > 10) {
			throw new IllegalArgumentException("Task ID Invalid. Please try again.");
		}
		else {
			this.taskID = taskID;
		}
	}
	// validates null and length for taskName
	public void validName(String taskName) {
		if(taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Invalid task name. Please try again.");
		}
		else {
			this.taskName = taskName;
		}
	}
	// validates nullity and length for taskDescription
	public void validTaskDescription(String taskDescription) {
		if(taskDescription == null || taskDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid task description");
		}
		else {
			this.taskDescription = taskDescription;
		}
	}
}
