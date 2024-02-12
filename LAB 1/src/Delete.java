import java.sql.*;
import java.util.*;

public class Delete 
{
	public static void main(String args[]) throws SQLException, ClassNotFoundException
	{
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BCA","root","Aryan@04");
		
		System.out.println("Enter The ID to be deleted");
		String r = sc.next();
		
		String query = "Delete from Employee where id = ?";
		PreparedStatement pst =  con.prepareStatement(query);
		pst.setString(1, r);
		int affected_rows = pst.executeUpdate();
		
		if (affected_rows > 0)
		{
			System.out.println("Data Deleted");
		}
		else
		{
			System.out.println("No Data To Be Deleted");
		}
		sc.close();
		con.close();
	}
}
