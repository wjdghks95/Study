package ch16;

public class EmployeeTest {

	public static void main(String[] args) {

		Employee employeeLee = new Employee();
		employeeLee.setEmployName("이순신");
		
		System.out.println(Employee.getSerialNum());
		
		Employee employeeKim = new Employee();
		employeeKim.setEmployName("김유신");
		
		System.out.println(employeeLee.getEmployName() + "님의 사번은" + employeeLee.getEmployeeId());
		System.out.println(employeeKim.getEmployName() + "님의 사번은" + employeeKim.getEmployeeId());
	}

}
