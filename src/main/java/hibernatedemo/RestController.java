package hibernatedemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import hibernateassignment.DAO;
import hibernateassignment.Employee;
import hibernateassignment.Role;
import hibernateassignment.Task;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@RequestMapping(value = "/api-test", method = RequestMethod.GET)
	public String getAllCarsApi() {
		// Person p1 = new Person();
		// p1.setName("Saman With Hats");
		// p1.setAge(30);
		//
		// Hat h1 = new Hat();
		// h1.setColor("Black");
		// h1.setSize("Small");
		//
		// Hat h2 = new Hat();
		// h2.setColor("White");
		// h2.setSize("Large");
		//
		// p1.addHat(h1);
		// p1.addHat(h2);
		//
		// createPerson(p1);
		// listPerson();

		return null;
	}

	@RequestMapping(value = "/api-test-create-role", method = RequestMethod.GET)
	public String apiTestCreateRole() {
		Role r1 = new Role("UI engineer");
		DAO.createRole(r1);
		
	

		return null;
	}

	@RequestMapping(value = "/api-test-create-employee", method = RequestMethod.GET)
	public String apiTestCreateEmployee() {
		Employee emp = new Employee();
		emp.setName("Prageeth");
		emp.setRole(DAO.getRoleById(1));
		
		
		Set<Task> taskset = new HashSet<Task>();
		
		
		
		Task t1 = new Task(); 
		t1.setDescription("QA");
		
		Task t2 = new Task(); 
		t2.setDescription("Optimization");
		
		taskset.add(t1);
		taskset.add(t2);
		
		emp.setTasks(taskset);
		
		DAO.createEmployee(emp);

		return null;
	}

	@RequestMapping(value = "/api-test-create-task", method = RequestMethod.GET)
	public String apiTestCreateTask() {
		Task t1 = new Task();
		t1.setDescription("create app");
		DAO.createTask(t1);
		return null;
	}

	@RequestMapping(value = "/api-test-list-employees", method = RequestMethod.GET)
	public String apiTestListEmployees() {
		DAO.listEmployees();
		
//		Employee emp2 = new Employee();
//		emp2.setName("Pathum");
//		emp2.setRole(DAO.getRoleById(1));
//		emp2.addTask(DAO.getTaskById(1));
//		DAO.createEmployee(emp2);
//		
//		DAO.getEmployeeById(1);
		return null;
	}
	
	
	@RequestMapping(value = "/api-test-list-tasks", method = RequestMethod.GET)
	public String apiTestListTask() {
		DAO.listTasks();
		
//		Employee emp2 = new Employee();
//		emp2.setName("Pathum");
//		emp2.setRole(DAO.getRoleById(1));
//		emp2.addTask(DAO.getTaskById(1));
//		DAO.createEmployee(emp2);
//		
//		DAO.getEmployeeById(1);
		return null;
	}

	@RequestMapping(value = "/api-get-add-title", method = RequestMethod.POST, produces = "application/json")
	public String getAddByTitle(HttpServletRequest request) {

		return null;
	}

	// private static void listPerson() {
	// Transaction tx = null;
	// Session session = SessionFactoryUtil.getCurrentSession();
	//
	// try {
	// tx = session.beginTransaction();
	// List persons = session.createQuery(
	// "select p from Person as p").list();
	// System.out.println("*** Content of the Person Table ***");
	// System.out.println("*** Start ***");
	//
	// for (Iterator iter = persons.iterator(); iter.hasNext();) {
	// Person element = (Person) iter.next();
	// System.out.println(element);
	// }
	// System.out.println("*** End ***");
	// tx.commit();
	// }
	// catch (RuntimeException e) {
	// if (tx != null ) {
	//
	// try {
	// // Second try catch as the rollback could fail as well
	// tx.rollback();
	// }
	// catch (HibernateException e1) {
	// System.out.println("Error rolling back transaction");
	// }
	// throw e;
	// }
	// }
	// }
	//
	// private static void createPerson(Person person) {
	// Transaction tx = null;
	// Session session = SessionFactoryUtil.getCurrentSession();
	//
	// try {
	// tx = session.beginTransaction();
	// session.save(person);
	// tx.commit();
	// }
	// catch (RuntimeException e) {
	// if (tx != null ) {
	// try {
	// // Second try catch as the rollback could fail as well
	// tx.rollback();
	// }
	// catch (HibernateException e1) {
	// System.out.println("Error rolling back transaction");
	// }
	// // throw again the first exception
	// throw e;
	// }
	// }
	// }

	

}
