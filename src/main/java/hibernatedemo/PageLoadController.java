package hibernatedemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.loader.custom.Return;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.google.gson.Gson;

import hibernateassignment.DAO;
import hibernateassignment.Employee;
import hibernateassignment.Role;
import hibernateassignment.Task;

@Controller
public class PageLoadController {
	private Employee empTemp = new Employee();
	private Role role = new Role();
	private Task task  = new Task();
	Gson gson = new Gson();
	@RequestMapping("/")
	public ModelAndView loadHomePage() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/emp-list-view")
	public ModelAndView loadEmpListView( ) {
		List<Employee> empList =  DAO.listEmployees();		
		ModelAndView model = new ModelAndView("employee-list-view");
		model.addObject("data", getDataList());
		return model;
		
		 
	}
	
	
	@RequestMapping(value ="/insert-employee", method = RequestMethod.POST)
	public ModelAndView addEmployee(HttpServletRequest request) {
		String[] arr = request.getParameterValues("multiselect[]");
		
		Employee emp = new Employee();
		emp.setName(request.getParameter("employeeName"));
		emp.setRole(DAO.getRoleById(Integer.parseInt(request.getParameter("role"))));
		
		Set<Task> taskset = new HashSet<Task>();
		
		for (String id : arr) {
			taskset.add(DAO.getTaskById(Integer.parseInt(id)));
		}
		
		emp.setTasks(taskset);
		DAO.createEmployee(emp);
		
		//System.out.println(Arrays.toString(arr));
		
		return new ModelAndView("redirect:/emp-list-view");

	}
	
	@RequestMapping(value = "/emp-edit-view/{id}", method = RequestMethod.GET)
	public ModelAndView loadEditPage(@PathVariable String id) {
		HashMap<String, Object> dataSet = new HashMap<String, Object>();
		empTemp = null;
		empTemp = DAO.getEmployeeById(Integer.parseInt(id));
		List<Role> rolesList =  DAO.listRoles();
		
		dataSet.put("employee", empTemp);
		dataSet.put("roles", rolesList);
		
		ModelAndView model = new ModelAndView("employee-edit-view");
		model.addObject("data", dataSet);
		return model;
		
		 

	}
	
	@RequestMapping(value ="/update-employee", method = RequestMethod.POST)
	public ModelAndView updateEmployee(HttpServletRequest request) {
		 
		empTemp.setName(request.getParameter("employeeName"));
		empTemp.setRole(DAO.getRoleById(Integer.parseInt(request.getParameter("role"))));
		DAO.updateEmployee(empTemp);
		empTemp = null;
		//System.out.println(Arrays.toString(arr));
		
		return new ModelAndView("redirect:/emp-list-view");

	}
	
	
	

	
	@RequestMapping(value ="/insert-role", method = RequestMethod.POST)
	public ModelAndView addRole(HttpServletRequest request) {
 
		Role r = new Role();
		r.setTitle(request.getParameter("roleName"));
		DAO.createRole(r);
		return new ModelAndView("redirect:/roles-list-view");

	}
	
	
	@RequestMapping("/roles-list-view")
	public ModelAndView loadRolesListView( ) {
		List<Role> rolesList =  DAO.listRoles();
//		for (Employee employee : empList) {
//			System.out.println(employee.getEmployeeId());
//			System.out.println(employee.getName());
//			System.out.println("TITLE : " + employee.getRole().getTitle());
//			
//			System.out.println(employee.getTasks().size());
//
//		}
		
		ModelAndView model = new ModelAndView("roles-list-view");
		model.addObject("roles", rolesList);
		return model;
		
		 
	}
	
	@RequestMapping(value = "/role-edit-view/{id}", method = RequestMethod.GET)
	public ModelAndView loadEditRolePage(@PathVariable String id) {
		HashMap<String, Object> dataSet = new HashMap<String, Object>();
		role = null;
		role = DAO.getRoleById(Integer.parseInt(id));		
		 
		dataSet.put("role", role);
		
		ModelAndView model = new ModelAndView("role-edit-view");
		model.addObject("data", dataSet);
		return model;		 

	}
	
	@RequestMapping(value ="/update-role", method = RequestMethod.POST)
	public ModelAndView updateRole(HttpServletRequest request) {
		 
		role.setTitle(request.getParameter("roleTitle"));		
		DAO.updateRole(role);
		role = null;
		//System.out.println(Arrays.toString(arr));
		
		return new ModelAndView("redirect:/roles-list-view");

	}
	
	@RequestMapping(value ="/insert-task", method = RequestMethod.POST)
	public ModelAndView addTask(HttpServletRequest request) {
 
		Task task = new Task();
		task.setDescription(request.getParameter("taskDescription"));
		task.setEmployee(DAO.getEmployeeById(Integer.parseInt(request.getParameter("employee"))));
		DAO.createTask(task);
		
		return new ModelAndView("redirect:/tasks-list-view");

	}
	
	@RequestMapping("/tasks-list-view")
	public ModelAndView loadTasksListView( ) {
		
		ModelAndView model = new ModelAndView("tasks-list-view");
		model.addObject("data", getDataList());
		return model;
		
		 
	}
	
	@RequestMapping(value = "/task-edit-view/{id}", method = RequestMethod.GET)
	public ModelAndView loadEditTaskPage(@PathVariable String id) {
		HashMap<String, Object> dataSet = new HashMap<String, Object>();
		task = null;
		task = DAO.getTaskById(Integer.parseInt(id));		
		
		List<Employee> empList =  DAO.listEmployees();
		dataSet.put("task", task);
		dataSet.put("employees", empList);
		
		ModelAndView model = new ModelAndView("task-edit-view");
		model.addObject("data", dataSet);
		return model;		 

	}
	
	@RequestMapping(value ="/update-task", method = RequestMethod.POST)
	public ModelAndView updateTask(HttpServletRequest request) {
		 
		task.setDescription(request.getParameter("taskDescription"));	
		task.setEmployee(DAO.getEmployeeById(Integer.parseInt(request.getParameter("employee"))));
		DAO.updateTask(task);
		task = null;
		//System.out.println(Arrays.toString(arr));
		
		return new ModelAndView("redirect:/tasks-list-view");

	}
	
	
	
	private Map<String, Object> getDataList(){
		HashMap<String, Object> dataSet = new HashMap<String, Object>();
		List<Employee> empList =  DAO.listEmployees();
		List<Role> rolesList =  DAO.listRoles();
		List<Task> taskList =  DAO.listTasks();
		
		dataSet.put("employees", empList);
		dataSet.put("roles", rolesList);
		dataSet.put("tasks", taskList);
		
		return dataSet;
	}


	
	
}
