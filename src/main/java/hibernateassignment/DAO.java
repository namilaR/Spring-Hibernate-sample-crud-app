package hibernateassignment;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernatedemo.SessionFactoryUtil;

public class DAO {
	
	/*
	 * 	ROLES  
	 */
	public static void createRole(Role role) {
		Transaction tx = null;
		Session session = SessionFactoryUtil.getCurrentSession();

		try {
			tx = session.beginTransaction();
			session.save(role);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				try {
					// Second try catch as the rollback could fail as well
					tx.rollback();
				} catch (HibernateException e1) {
					System.out.println("Error rolling back transaction");
				}
				// throw again the first exception
				throw e;
			}
		}
	}

	public static void updateRole(Role role) {
		Transaction tx = null;
		Session session = SessionFactoryUtil.getCurrentSession();

		try {
			tx = session.beginTransaction();
			session.update(role);
			;
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				try {
					// Second try catch as the rollback could fail as well
					tx.rollback();
				} catch (HibernateException e1) {
					System.out.println("Error rolling back transaction");
				}
				// throw again the first exception
				throw e;
			}
		}
	}

	public static List<Role> listRoles() {
		Transaction tx = null;
		List<Role> roleList = null;
		Session session = SessionFactoryUtil.getCurrentSession();

		try {
			tx = session.beginTransaction();
			roleList = session.createQuery("select r from Role as r").list();
			for (Role r : roleList) {
				//System.out.println(r.toString());

			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {

				try {
					// Second try catch as the rollback could fail as well
					tx.rollback();
				} catch (HibernateException e1) {
					System.out.println("Error rolling back transaction");
				}
				throw e;
			}
		}

		return roleList;
	}
	
	public static Role getRoleById(int id) {
		Transaction tx = null;
		Role role = null;
		List<Role> roleList = null;
		Session session = SessionFactoryUtil.getCurrentSession();

		try {
			tx = session.beginTransaction();
			Query q =   session.createQuery("select r from Role as r  where r.roleId = :id ");
			
			role = new Role();
			role.setRoleId(id);
			q.setInteger("id", id);	
			
			role = (Role) q.list().get(0);		
			 
			//System.out.println(role.toString());
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {

				try {
					// Second try catch as the rollback could fail as well
					tx.rollback();
				} catch (HibernateException e1) {
					System.out.println("Error rolling back transaction");
				}
				throw e;
			}
		}

		return role;
	}
	
	/*
	 *  EMPLOYEES 
	 */
	public static void createEmployee(Employee emp) {
		Transaction tx = null;
		Session session = SessionFactoryUtil.getCurrentSession();

		try {
			tx = session.beginTransaction();
			session.save(emp);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				try {
					// Second try catch as the rollback could fail as well
					tx.rollback();
				} catch (HibernateException e1) {
					System.out.println("Error rolling back transaction");
				}
				// throw again the first exception
				throw e;
			}
		}
	}

	public static void updateEmployee(Employee emp) {
		Transaction tx = null;
		Session session = SessionFactoryUtil.getCurrentSession();

		try {
			tx = session.beginTransaction();
			session.update(emp);
			;
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				try {
					// Second try catch as the rollback could fail as well
					tx.rollback();
				} catch (HibernateException e1) {
					System.out.println("Error rolling back transaction");
				}
				// throw again the first exception
				throw e;
			}
		}
	}

	public static List<Employee> listEmployees() {
		Transaction tx = null;
		List<Employee> emoloyeeList = null;
		Session session = SessionFactoryUtil.getCurrentSession();

		try {
			tx = session.beginTransaction();
			emoloyeeList = session.createQuery("select e from Employee as e").list();
			for (Employee e : emoloyeeList) {
				//System.out.println(e.toString());

			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {

				try {
					// Second try catch as the rollback could fail as well
					tx.rollback();
				} catch (HibernateException e1) {
					System.out.println("Error rolling back transaction");
				}
				throw e;
			}
		}

		return emoloyeeList;
	}
	
	public static Employee getEmployeeById(int id) {
		Transaction tx = null;
		Employee emp = null;		 
		Session session = SessionFactoryUtil.getCurrentSession();

		try {
			tx = session.beginTransaction();
			Query q =   session.createQuery("select e from Employee as e  where e.employeeId = :id ");
			
 
			q.setInteger("id", id);	
			
			emp = (Employee) q.list().get(0);		
			 
			//System.out.println(emp.toString());
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {

				try {
					// Second try catch as the rollback could fail as well
					tx.rollback();
				} catch (HibernateException e1) {
					System.out.println("Error rolling back transaction");
				}
				throw e;
			}
		}

		return emp;
	}
	

	/*
	 * TASKS
	 */
	public static void createTask(Task task) {
		Transaction tx = null;
		Session session = SessionFactoryUtil.getCurrentSession();

		try {
			tx = session.beginTransaction();
			session.save(task);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				try {
					// Second try catch as the rollback could fail as well
					tx.rollback();
				} catch (HibernateException e1) {
					System.out.println("Error rolling back transaction");
				}
				// throw again the first exception
				throw e;
			}
		}
	}

	public static void updateTask(Task task) {
		Transaction tx = null;
		Session session = SessionFactoryUtil.getCurrentSession();

		try {
			tx = session.beginTransaction();
			session.update(task);
			;
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				try {
					// Second try catch as the rollback could fail as well
					tx.rollback();
				} catch (HibernateException e1) {
					System.out.println("Error rolling back transaction");
				}
				// throw again the first exception
				throw e;
			}
		}
	}

	public static List<Task> listTasks() {
		Transaction tx = null;
		List<Task> taskList = null;
		Session session = SessionFactoryUtil.getCurrentSession();

		try {
			tx = session.beginTransaction();
			taskList = session.createQuery("select t from Task as t").list();
			for (Task e : taskList) {
				//System.out.println(e.toString());

			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {

				try {
					// Second try catch as the rollback could fail as well
					tx.rollback();
				} catch (HibernateException e1) {
					System.out.println("Error rolling back transaction");
				}
				throw e;
			}
		}

		return taskList;
	}
	
	public static Task getTaskById(int id) {
		Transaction tx = null;
		Task task = null;		 
		Session session = SessionFactoryUtil.getCurrentSession();

		try {
			tx = session.beginTransaction();
			Query q =   session.createQuery("select t from Task as t  where t.taskId = :id ");
			
 
			q.setInteger("id", id);	
			
			task = (Task) q.list().get(0);		
			 
			//System.out.println(task.toString());
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {

				try {
					// Second try catch as the rollback could fail as well
					tx.rollback();
				} catch (HibernateException e1) {
					System.out.println("Error rolling back transaction");
				}
				throw e;
			}
		}

		return task;
	}
}
