import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Select_Specific 
{
	public static void main(String[] args) throws SQLException , ClassNotFoundException
	{
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Enter The ID of the Employee");
		String roll = sc.next();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BCA","root","Aryan@04");
		String query = "select * from Employee where id = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, roll);
		
		ResultSet rs = pst.executeQuery();
		if (rs.next())
		{
			System.out.println("Roll\tFirst Name\tLast Name\tAge\t\tDOB");
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t\t"+rs.getDate(5));
		}
		else
		{
			System.out.println("No Data with this ID");
		}
		sc.close();
		con.close();
	}
}
