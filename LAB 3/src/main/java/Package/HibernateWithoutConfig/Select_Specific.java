package Package.HibernateWithoutConfig;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Select_Specific 
{
	public static void main(String[] args) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
        
        Transaction tx = session.beginTransaction();
        Employee s = new Employee();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The ID whose Details to be seen");
		int id = sc.nextInt();
		s = session.get(Employee.class, id);
		System.out.println("Details are : ");
		System.out.println("Name : "+s.getFirst_Name()+" "+s.getLast_Name());
		System.out.println("Age : "+s.getAge());
		System.out.println("Date Of Birth : "+s.getDOB());

        session.save(s);
        sc.close();
        tx.commit();
        session.close();
	}
}
