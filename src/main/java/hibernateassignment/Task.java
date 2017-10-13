package hibernateassignment;

public class Task {
	private int taskId;
	private String description;
	private Employee employee;
	
	public Task(){
		
	}
	
	public Task(String description, Employee employee) {
		super();
		this.description = description;
		this.employee = employee;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", description=" + description + ", employee=" + employee + "]";
	}
	
	
	
}
