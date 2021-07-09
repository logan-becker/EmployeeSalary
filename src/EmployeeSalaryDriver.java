import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmployeeSalaryDriver {

	public static void main(String[] args) {
		
		// Condition for while loop
		boolean loop = true;
		
		// New Scanner
		Scanner s = new Scanner(System.in);
		
		// Ask the user for a file
		System.out.println("Please enter a file to be read: ");
		String fileName = s.nextLine();
		
		// Creates a collection of the string values, every index is a line from the .csv file input
		List<String> employeeInfo = EmployeeCreator.getCSVStrings(fileName);
		
		// Creates a collection of Employee objects out of the String values split by the comma
		List<Employee> employeeCollection = EmployeeCreator.createEmployees(employeeInfo);		
		
		// calls the method in the CalculateEmployeeSalaries class to calculate the total salaries of all employees
		double totalEmployeeSalaries = CalculateEmployeeSalaries.calculateAllSalaries(employeeCollection);
		
		// Loop to prompt user more than once
		while (loop == true) {
			// Prompt user with option to view all employees' total salary or salary by group
			System.out.println("Press enter 1 to view total salary or 2 to view salaries by group:");
			int option = s.nextInt();
			
			// Print total employee salary
			if (option == 1) {
				System.out.println("1. Total salary in dollars.");
				System.out.println(totalEmployeeSalaries);
				System.out.println();
			}
			
			
			// Print salary by group
			else if (option == 2) {
				System.out.println("2. Total salary in dollars grouped by role.");
				Map<String, Double> salariesbyRole = CalculateEmployeeSalaries.calculateSalariesByRole(employeeCollection);
				for (Map.Entry<String,Double> entry : salariesbyRole.entrySet())
		            System.out.println("Total salary " + entry.getKey() + entry.getValue());
				System.out.println();

			} 

			//end loop
			else {
				loop = false;
			}
		}
		
		// exit program
		s.close();
		System.out.println("Exiting program... Thanks!");
		System.exit(0);
		

	}

}
