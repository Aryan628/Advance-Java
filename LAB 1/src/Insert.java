import java.sql.*;
import java.util.Scanner;
public class Insert 
{
	public static void main(String args[]) throws SQLException, ClassNotFoundException
	{
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.print("Enter The Details of the Employee\nID = ");
		String id = sc.next();
		System.out.print("First Name = ");
		String fname = sc.next();
		System.out.print("Last Name = ");
		String lname = sc.next();
		System.out.print("Age = ");
		String age = sc.next();
		System.out.print("DOB (YYYY-MM-DD) = ");
		String date = sc.next();
		

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BCA","root","Aryan@04");
				
		String query = "Insert into Employee values (? , ? , ? , ? ,?)";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, id);
		pst.setString(2, fname);
		pst.setString(3, lname);
		pst.setString(4, age);
		pst.setString(5, date);
		
		int affected_rows = pst.executeUpdate();
		
		if (affected_rows > 0)
		{
			System.out.println("Data Inserted");
		}
		sc.close();
		con.close();
	}
}
