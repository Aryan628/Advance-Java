package Package.HibernateWithoutConfig;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class Select 
{
	public static void main(String[] args) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
        
        Transaction tx = session.beginTransaction();
		List<Employee> employees = session.createQuery("FROM Employee", Employee.class).getResultList();
	    if(employees.isEmpty()) 
	    {
	        System.out.println("No employees found.");
	    } 
	    else 
	    {
	        System.out.println("ID\tName\t\t\tAge\tDate Of Birth");
	        for(Employee employee : employees) {
	            System.out.println(employee.getID() + "\t" + employee.getFirst_Name() + " " + employee.getLast_Name() + "\t\t" + employee.getAge() + "\t" + employee.getDOB());
	        }
	    }

        tx.commit();
        session.close();
	}
}
