package Package.HibernateWithoutConfig;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Update 
{
	public static void main(String[] args) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
        
        Transaction tx = session.beginTransaction();
        Scanner sc = new Scanner(System.in);
        Employee s = new Employee();
        System.out.println("Enter The ID of the Employee Whose Data needs to be Updated");
		int id = sc.nextInt();
		s = session.get(Employee.class, id);
		if (s != null)
		{
			System.out.println("Present Details");
			
			System.out.println("Details are : ");
			System.out.println("Name : "+s.getFirst_Name()+" "+s.Last_Name);
			System.out.println("Age : "+s.getAge());
			System.out.println("Date Of Birth : "+s.getDOB());
			System.out.println("Select What Data you need to change\n1 -> Name\n2 -> Age(Date As well)\n3 -> Multiple Data");
			int c = sc.nextInt();
			if(c==1)
			{
				System.out.print("Enter First Name : ");
				String fname = sc.next();
				s.setFirst_Name(fname);
				System.out.print("Enter Last Name : ");
				String lname = sc.next();
				s.setLast_Name(lname);
				session.update(s);
			}
			else if(c==2)
			{
				System.out.print("Enter Age : ");
				String ag = sc.next();
				s.setAge(ag);
				System.out.print("Date Of Birth (YYYY-MM-DD) : ");
				String dOB = sc.next();
				s.setDOB(dOB);
				session.update(s);
			}
			else if(c==3)
			{
				System.out.print("Enter First Name : ");
				String fname = sc.next();
				s.setFirst_Name(fname);
				System.out.print("Enter Last Name : ");
				String lname = sc.next();
				s.setLast_Name(lname);
				System.out.print("Enter Age : ");
				String ag = sc.next();
				s.setAge(ag);
				System.out.print("Date Of Birth (YYYY-MM-DD) : ");
				String dOB = sc.next();
				s.setDOB(dOB);
				session.update(s);
			}
		}
		else
		{
			System.out.println("Employee not found.");
		}
		tx.commit();
		sc.close();
        session.close();
	}
}
