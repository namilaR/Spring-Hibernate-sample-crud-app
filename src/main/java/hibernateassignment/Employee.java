package hibernateassignment;

import java.util.Set;

import hibernatedemo.Hat;

public class Employee {
	private int employeeId;
	private String name;
	private Role role;
	private Set<Task> tasks;
	
	public Employee(){
		
	}
	
	public Employee(String name, Role role, Set tasks) {
		super();
		this.name = name;
		this.role = role;
		this.tasks = tasks;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Set getTasks() {
		return tasks;
	}
	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	
    public void addTask(Task task) {
    	System.out.println(task.getDescription());
        this.tasks.add(task);
    }

    public void removeTask(Task task) {
        this.tasks.remove(task);
    }
    

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", role=" + role + ", tasks=" + tasks.toString() + "]";
	}
	
	
	
}
