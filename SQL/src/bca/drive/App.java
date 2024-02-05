package bca.drive;

import java.sql.*;
import java.util.Scanner;

import bca.model.Employee;

public class App
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			menu(sc);
		}
		
	}
	public static void menu(Scanner sc) throws ClassNotFoundException, SQLException
	{
		
		Employee s = new Employee();
		System.out.println("Enter Your Choice :\n1 -> View\n2 -> Insert\n3 -> Delete\n4 -> Update\n5 -> Exit");
		int ch = sc.nextInt();
		switch (ch) 
		{
			case 1: 
			{
				s.Select();
				break;
			}
			case 2:
			{
				System.out.print("Enter The Details of the Employee\nID = ");
				String roll = sc.next();
				System.out.print("First Name = ");
				String fname = sc.next();
				System.out.print("Last Name = ");
				String lname = sc.next();
				System.out.print("Age = ");
				String age = sc.next();
				System.out.print("DOB (YYYY-MM-DD) = ");
				String date = sc.next();
				s.Insert(roll, fname, lname , age, date);
				break;
			}
			case 3:
			{
				System.out.println("Enter The Id whose Details needs to be Deleted");
				String id = sc.next();
				s.Delete(id);
				break;
			}
			case 4:
			{
				System.out.println("Enter The ID of the Employee Whose Data needs to be Updated");
				String id = sc.next();
				System.out.println("Present Details");
				s.Select_Specific(id);
				System.out.println("Select What Data you need to change\n1 -> Name\n2 -> Age(Date As well)\n3 -> Multiple Data");
				int c = sc.nextInt();
				if(c==1)
				{
					System.out.print("Enter First Name : ");
					String fname = sc.next();
					System.out.print("Enter Last Name : ");
					String lname = sc.next();
					s.UpdateName(id, fname, lname);
				}
				else if(c==2)
				{
					System.out.print("Enter Age : ");
					String ag = sc.next();
					System.out.print("Date Of Birth (YYYY-MM-DD) : ");
					String dOB = sc.next();
					s.UpdateAge(id,ag,dOB);
				}
				else if(c==3)
				{
					System.out.print("Enter First Name : ");
					String fname = sc.next();
					System.out.print("Enter Last Name : ");
					String lname = sc.next();
					System.out.print("Enter Age : ");
					String ag = sc.next();
					System.out.print("Date Of Birth (YYYY-MM-DD) : ");
					String dOB = sc.next();
					s.Update(id, fname, lname, ag, dOB);
				}
				break;
			}
			case 5:
			{
				System.out.println("System Exited");
				System.exit(0);
			}
			default:
				System.out.println("Please Enter  a Valid Option");
		}
	}
}
