import java.sql.*;

public class Select 
{
	public static void main(String args[]) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BCA","root","Aryan@04");
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from Employee");
		System.out.println("Roll\tFirst Name\tLast Name\tAge\t\tDOB");
		while (rs.next())
		{
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t\t"+rs.getDate(5));
		}
		
		con.close();
	}
}
