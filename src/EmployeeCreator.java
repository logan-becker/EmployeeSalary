import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeCreator {

	static List<String> getCSVStrings(String fileName) {

		// creates collection of strings to hold values to create Employee objects
		List<String> stringVals = new ArrayList<>();

		// declare scanner
		Scanner s = null;

		try {
			// scanner to parse file
			s = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Iterate through lines in file
		while (s.hasNextLine()) {
			
			// get value of line
			String val = s.nextLine();

			// adds string value of the line to the array list
			stringVals.add(val);
		}

		// close scanner
		s.close();

		// returns array list filled with Strings
		return stringVals;

	}

	static List<Employee> createEmployees(List<String> linesFromFile) {

		// Creates a collection to be comprised of Employee objects
		List<Employee> employees = new ArrayList<>();

		// Iterate over the strings gotten from the file input by the user
		for (String line : linesFromFile) {
			
			//Creates an array out of the split string and populates the indices with string values
			String[] str = line.split("\\|");
						
			// Add new part time employee
			if (str[3].equals("FULL TIME")) {

				Employee temp = new FullTimeEmployee(str[0], Double.parseDouble(str[1]), Double.parseDouble(str[2]), str[3]);
				employees.add(temp);
			} 
			
			// Add new part time employee
			else if (str[3].equals("PART TIME")) {
				Employee temp = new PartTimeEmployee(str[0], Double.parseDouble(str[1]), Double.parseDouble(str[2]), str[3]);
				employees.add(temp);
			} 
			
			// Add new contract employee
			else {
				Employee temp = new ContractEmployee(str[0], Double.parseDouble(str[1]), Double.parseDouble(str[2]), str[3]);
				employees.add(temp);
			}
		}

		// Returns list of Employee objects
		return employees;
	}

}
