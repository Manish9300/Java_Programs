import java.lang.*;
import java.io.*;
class Employee {
	int Emp_code;
	String Emp_name;
	String Address;
	int Ph_no;
	double basic_pay;
	double da = 0.1;
	double hra = 0.2;
	Employee(int emp_code, String name, String address, int ph_no, double basic_pay) {
		this.Emp_code = emp_code;
		this.Emp_name = name;
		this.Address = address;
		this.Ph_no = ph_no;
		this.basic_pay = basic_pay;
	}
	double calculateSalary() {
		return (basic_pay + (da * basic_pay) + (hra * basic_pay));
	}
}
class Teaching extends Employee {
	String subject_specialization;
	String designation;
	Teaching(int emp_code, String name, String address, int ph_no, double basic_pay, String subject_specialization, String desig) {
		super(emp_code, name, address, ph_no, basic_pay);
		this.subject_specialization = subject_specialization;
		this.designation = designation;
	}
}
class Faculty extends Teaching {
	String Research_Area;
	Faculty(int emp_code, String name, String address, int ph_no, double basic_pay, String subject_specialization, String desig, String res_area) {
		super(emp_code, name, address, ph_no, basic_pay, subject_specialization, desig);
		this.Research_Area = res_area;
	}
}
class Technical extends Teaching {
	String Tech_Expert_Area;
	Technical(int emp_code, String name, String address, int ph_no, double basic_pay, String subject_specialization, String desig, String tech) {
		super(emp_code, name, address, ph_no, basic_pay, subject_specialization, desig);
		this.Tech_Expert_Area = tech;
	}
}
class Office extends Employee {
	String position;
	Office(int emp_code, String name, String address, int ph_no, double basic_pay, String pos) {
		super(emp_code, name, address, ph_no, basic_pay);
		this.position = pos;
	}
}
class Administrative extends Office {
	Administrative(int emp_code, String name, String address, int ph_no, double basic_pay, String pos) {
		super(emp_code, name, address, ph_no, basic_pay, pos);
	}
}
class Accounts extends Office {
	Accounts(int emp_code, String name, String address, int ph_no, double basic_pay, String pos) {
		super(emp_code, name, address, ph_no, basic_pay, pos);
	}
}
class Assignment5 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("1. Faculty\n2. Technical\n3. Administrative\n4. Accounts\nEnter choice: ");
		int choice = Integer.parseInt(br.readLine());
		System.out.print("Employee Code: ");
		int emp_code = Integer.parseInt(br.readLine());
		System.out.print("Employee Name: ");
		String name = br.readLine();
		System.out.print("Employee Address: ");
		String address = br.readLine();
		System.out.print("Phone number: ");
		int ph_no = Integer.parseInt(br.readLine());
		System.out.print("Enter basic pay: ");
		double basic_pay = Double.parseDouble(br.readLine());
		Employee emp = new Employee(emp_code, name, address, ph_no, basic_pay);
		switch(choice) {
			//Faculty
			case 1:
			System.out.print("**Faculty**\nEnter Designation: ");
			String desig1 = br.readLine();
			System.out.print("Enter Subject Specialization: ");
			String ss1 = br.readLine();
			System.out.print("Enter Research Area: ");
			String res_area = br.readLine();
			Faculty fac = new Faculty(emp_code, name, address, ph_no, basic_pay, ss1, desig1, res_area);
			System.out.println("Employee Name: "+fac.Emp_name+"\nEmployee Code: "+fac.Emp_code+"\nSalary: "+fac.calculateSalary());
			break;
			//Technical
			case 2:
			System.out.print("**Technical**\nEnter Designation: ");
			String desig2 = br.readLine();
			System.out.print("Enter Subject Specialization: ");
			String ss2 = br.readLine();
			System.out.print("Enter Tech Expert Area: ");
			String tech = br.readLine();
			Technical t = new Technical(emp_code, name, address, ph_no, basic_pay, ss2, desig2, tech);
			System.out.println("Employee Name: "+t.Emp_name+"\nEmployee Code: "+t.Emp_code+"\nSalary: "+t.calculateSalary());
			break;
			//Administrative
			case 3:
			System.out.print("**Administrative**\nEnter Position: ");
			String pos1 = br.readLine();
			Administrative admin = new Administrative(emp_code, name, address, ph_no, basic_pay, pos1);
			System.out.println("Employee Name: "+admin.Emp_name+"\nEmployee Code: "+admin.Emp_code+"\nSalary: "+admin.calculateSalary());
			break;
			//Accounts
			case 4:
			System.out.print("**Accounts**\nEnter Position: ");
			String pos2 = br.readLine();
			Accounts acc = new Accounts(emp_code, name, address, ph_no, basic_pay, pos2);
			System.out.println("Employee Name: "+acc.Emp_name+"\nEmployee Code: "+acc.Emp_code+"\nSalary: "+acc.calculateSalary());
			break;
		
			default:
			System.out.println("INVALID CHOICE\n");
		}
	}
}

/*
===================================================================================================================================

OUTPUT:

c:\MANISH PAUL CSE 3B\29 AUG 24>javac Assignment5.java

c:\MANISH PAUL CSE 3B\29 AUG 24>java Assignment5
1. Faculty
2. Technical
3. Administrative
4. Accounts
Enter choice: 2
Employee Code: 1234
Employee Name: Manish Paul
Employee Address: Baruipur
Phone number: 1234567890
Enter basic pay: 10000
**Technical**
Enter Designation: Teacher
Enter Subject Specialization: Machine Learning
Enter Tech Expert Area: Neural Networks
Employee Name: Manish Paul
Employee Code: 1234
Salary: 13000.0

*/
























