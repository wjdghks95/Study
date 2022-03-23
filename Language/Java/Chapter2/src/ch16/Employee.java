package ch16;

public class Employee {
	
	private static int serialNum = 1000;

	private int employeeId;
	private String employName;
	private String department;
	
	public Employee() {
		
		serialNum++;
		employeeId = serialNum;
	}
	
	public static int getSerialNum() {
		
		return serialNum;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployName() {
		return employName;
	}
	public void setEmployName(String employName) {
		this.employName = employName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
