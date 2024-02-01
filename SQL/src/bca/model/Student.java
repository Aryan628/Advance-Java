package bca.model;

import java.sql.*;

public class Student 
{
	public void Select() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BCA","root","Aryan@04");
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from Student");
		System.out.println("Roll\t\tName\t\t\tDOB");
		while (rs.next())
		{
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t\t"+rs.getDate(3));
		}
		
		con.close();
	}
	public void Delete(String roll) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BCA","root","Aryan@04");
		
		
		String query = "Delete from Student where Roll = ?";
		PreparedStatement pst =  con.prepareStatement(query);
		pst.setString(1, roll);
		int affected_rows = pst.executeUpdate();
		
		System.out.println("Affected Rows :" + affected_rows);
		
		con.close();
	}
	public void Insert(String roll , String name , String date) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BCA","root","Aryan@04");
				
		String query = "Insert into Student values (? , ? ,?)";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, roll);
		pst.setString(2, name);
		pst.setString(3, date);
		
		int affected_rows = pst.executeUpdate();
		
		System.out.println("Affected Rows :" + affected_rows);
		
		con.close();
	}
	public void Update(String roll , String name , String date) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BCA","root","Aryan@04");
				
		String query = "Update Student set SName = ? , DOB = ? where Roll = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, name);
		pst.setString(2, date);
		pst.setString(3, roll);
		
		int affected_rows = pst.executeUpdate();
		
		System.out.println("Affected Rows :" + affected_rows);
		
		con.close();
	}
	public void Select_Specific(String roll) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BCA","root","Aryan@04");
		String query = "select * from Student where Roll = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, roll);
		
		ResultSet rs = pst.executeQuery();
		System.out.println("Roll\t\tName\t\t\tDOB");
		while (rs.next())
		{
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t\t"+rs.getDate(3));
		}
		
		con.close();
	}
}
