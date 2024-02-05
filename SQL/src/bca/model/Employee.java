package bca.model;

import java.sql.*;

public class Employee 
{
	public Employee() throws ClassNotFoundException, SQLException
	{
		String query = "Create Table if not exists Employee ("+
						"ID varchar(2) Primary key,"+
						"First_Name varchar(255) Not Null,"+
						"Last_Name varchar(255)  Not Null," +
						"Age varchar(2) Not Null,"+
						"DOB date) Not Null";
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BCA","root","Aryan@04");
						
		Statement st = con.createStatement();
						
		st.executeUpdate(query);
	}


	public void Select() throws ClassNotFoundException, SQLException
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
	public void Delete(String id) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BCA","root","Aryan@04");
		
		
		String query = "Delete from Employee where id = ?";
		PreparedStatement pst =  con.prepareStatement(query);
		pst.setString(1, id);
		int affected_rows = pst.executeUpdate();
		
		if (affected_rows > 0)
		{
			System.out.println("Data Deleted");
		}
		
		con.close();
	}
	public void Insert(String id , String fname , String lname , String age , String date) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
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
		con.close();
	}
	public void Update(String id , String fname , String lname , String age , String Date) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BCA","root","Aryan@04");
				
		String query = "Update Employee set First_Name = ? , Last_Name = ? , Age = ? , Dob = ? where ID = ?";
		PreparedStatement pst = con.prepareStatement(query);
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
		con.close();
	}
	public void UpdateName(String id , String fname , String lname ) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BCA","root","Aryan@04");
				
		String query = "Update Employee set First_Name = ? , Last_Name = ? where ID = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, fname);
		pst.setString(2, lname);
		pst.setString(3, id);

		int affected_rows = pst.executeUpdate();
		if (affected_rows > 0)
		{
			System.out.println("Data Updated");
		}
		con.close();
	}
	public void UpdateAge(String  id , String age , String date) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BCA","root","Aryan@04");
				
		String query = "Update Employee set Age = ? , DOB = ? where ID = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, age);
		pst.setString(2, date);
		pst.setString(3,id);

		int affected_rows = pst.executeUpdate();
		if (affected_rows > 0)
		{
			System.out.println("Data Updated");
		}
		con.close();
	}
	public void Select_Specific(String roll) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BCA","root","Aryan@04");
		String query = "select * from Employee where id = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, roll);
		
		ResultSet rs = pst.executeQuery();
		System.out.println("Roll\tFirst Name\tLast Name\tAge\t\tDOB");
		while (rs.next())
		{
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t\t"+rs.getDate(5));
		}
		
		con.close();
	}
}
