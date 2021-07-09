import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculateEmployeeSalaries {

	// Method for calculating total employee salaries
	static double calculateAllSalaries(List<Employee> employees) {

		double total = 0;

		// Iterate over list of employees and add up total salaries
		for (Employee emp : employees) {
			
			// Add to total each iteration
			total += emp.getSalary();
		}

		// Return new total salary
		return total;
	}

	// Method for grouping the collective salaries of different employee roles in a map
	static Map<String, Double> calculateSalariesByRole(List<Employee> employees) {
		
		double count = 0;
		
		// Create a map of strings as keys and doubles as values
		Map<String, Double> groupedSalaries = new HashMap<>();
		
		// Add the roles to the map with 0 as the value to count up
		groupedSalaries.put("FULL TIME: ", (double) 0);
		groupedSalaries.put("PART TIME: ", (double) 0);
		groupedSalaries.put("CONTRACT: ", (double) 0);

		// Iterate over list of employees 
		for (Employee emp : employees) {
			
			// If the employees is full time replace the old key value pair in the map with the same key but a new new count added to the previous count
			if (emp.getRole().equals("FULL TIME")) {
				count = groupedSalaries.get("FULL TIME: ");
				groupedSalaries.replace("FULL TIME: ", count, count + emp.getSalary());
				
			// If the employees is part time replace the old key value pair in the map with the same key but a new new count added to the previous count
			} else if (emp.getRole().equals("PART TIME")) {
				count = groupedSalaries.get("PART TIME: ");
				groupedSalaries.replace("PART TIME: ", count, count + emp.getSalary());
				
			// Employee is on contract, replace the old key value pair in the map with the same key but a new new count added to the previous count
			} else {
				count = groupedSalaries.get("CONTRACT: ");
				groupedSalaries.replace("CONTRACT: ", count, count + emp.getSalary());

			}
		}
		
		//returns map of grouped salary totals
		return groupedSalaries;

	}
}
