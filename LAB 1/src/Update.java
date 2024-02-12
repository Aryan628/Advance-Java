import java.sql.*;
import java.util.Scanner;

public class Update 
{
	public static void main(String args[]) throws SQLException ,ClassNotFoundException
	{
		Scanner sc = new Scanner(System.in);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BCA","root","Aryan@04");
				
		System.out.println("Enter The ID of the Employee Whose Data needs to be Updated");
		String id = sc.next();
		
		String query = "select * from Employee where id = ?";
		PreparedStatement pst1 = con.prepareStatement(query);
		pst1.setString(1, id);
		ResultSet rs = pst1.executeQuery();
		if (rs.next())
		{
			System.out.print("Enter First Name : ");
			String fname = sc.next();
			System.out.print("Enter Last Name : ");
			String lname = sc.next();
			System.out.print("Enter Age : ");
			String age = sc.next();
			System.out.print("Date Of Birth (YYYY-MM-DD) : ");
			String Date = sc.next();
			String querty = "Update Employee set First_Name = ? , Last_Name = ? , Age = ? , Dob = ? where ID = ?";
			PreparedStatement pst = con.prepareStatement(querty);
			pst.setString(1, fname);
			pst.setString(2, lname);
			pst.setString(3, age);
			pst.setString(4, Date);
			pst.setString(5, id);
			
			int affected_rows = pst.executeUpdate();
			
			if (affected_rows > 0)
			{
				System.out.println("Data Updated");
			}
		}
		else
		{
			System.out.println("No Data with this ID");
		}
		sc.close();
		con.close();
	}
}
