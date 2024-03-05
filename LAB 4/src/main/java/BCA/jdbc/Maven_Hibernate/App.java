package BCA.jdbc.Maven_Hibernate;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
        Configuration config = new Configuration();
        config.configure();
        
        SessionFactory factory = config.buildSessionFactory();
        
        Scanner sc = new Scanner(System.in);
        while (true)
        {
        	menu(factory,sc);
        }
        
        
    }
    
    public static void menu(SessionFactory factory, Scanner sc)
	{
    	Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
		Employee s = new Employee();
		System.out.println("Enter Your Choice :\n1 -> View All\n2 -> View Specific\n3 -> Insert\n4 -> Delete\n5 -> Update\n6 -> Exit");
		int ch = sc.nextInt();
		switch (ch) 
		{
			case 1: 
			{
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
				break;
			}
			case 2: 
			{
				System.out.println("Enter The ID whose Details to be seen");
				String id = sc.next();
				s = session.get(Employee.class, id);
				System.out.println("Details are : ");
				System.out.println("Name : "+s.getFirst_Name()+" "+s.getLast_Name());
				System.out.println("Age : "+s.getAge());
				System.out.println("Date Of Birth : "+s.getDOB());
				break;
			}
			case 3:
			{
				System.out.print("Enter The Details of the Employee\nID = ");
				String id = sc.next();
				s.setID(id);
				System.out.print("First Name = ");
				String fname = sc.next();
				s.setFirst_Name(fname);
				System.out.print("Last Name = ");
				String lname = sc.next();
				s.setLast_Name(lname);
				System.out.print("Age = ");
				String age = sc.next();
				s.setAge(age);
				System.out.print("DOB (YYYY-MM-DD) = ");
				String date = sc.next();
				s.setDOB(date);
				session.save(s);
				System.out.println("Data Inserted");
				tx.commit();
		        session.close();
				break;
			}
			case 4:
			{
				System.out.println("Enter The Id whose Details needs to be Deleted");
				String id = sc.next();
				s.setID(id);
				session.delete(s);
				System.out.println("Data Deleted");
				tx.commit();
		        session.close();
				break;
			}
			case 5:
			{
				System.out.println("Enter The ID of the Employee Whose Data needs to be Updated");
				String id = sc.next();
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
		        session.close();
				break;
			}
			case 6:
			{
				System.out.println("System Exited");
				tx.commit();
		        session.close();
				System.exit(0);
			}
			default:
				System.out.println("Please Enter a Valid Option");
		}
	}
}
