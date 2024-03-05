package Package.HibernateWithoutConfig;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class Insert 
{
    public static void main( String[] args )
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Transaction tx = session.beginTransaction();
        Scanner sc = new Scanner(System.in);
        Employee s = new Employee();
        System.out.print("Enter The Details of the Employee\nFirst Name = ");
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
        
        session.save(s);
        sc.close();
        tx.commit();
        session.close();
        
    }
}
