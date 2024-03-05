package BCA.jdbc.Maven_Hibernate;

public class Employee 
{
	String ID;
	String First_Name;
	String Last_Name;
	String Age;
	String DOB;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public Employee(String iD, String first_Name, String last_Name, String age, String dOB) {
		super();
		ID = iD;
		First_Name = first_Name;
		Last_Name = last_Name;
		Age = age;
		DOB = dOB;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
