public class PartTimeEmployee implements Employee{

	// Create fields for object
	private String name;
	private String role;
	private double rate;
	private double hours;
	private double salary;
	
	// Constructor for part time employee
	public PartTimeEmployee(String inputName, double inputRate, double inputHours, String inputRole) {
		this.name = inputName;
		this.role = inputRole;
		this.rate = inputRate;
		this.hours = inputHours;
		setSalary();
		
	}

	// getters and setters
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double getRate() {
		return rate;
	}

	@Override
	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public double getHours() {
		return hours;
	}

	@Override
	public void setHours(double hours) {
		this.hours = hours;
	}

	@Override
	public String getRole() {
		return role;
	}

	@Override
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public double getSalary() {
		return salary;
	}
	
	@Override
	public void setSalary() {
		
		//set salary to be rate * hours
		salary = rate * hours;		
	}
	
	@Override
	public String toString() {
		return "NAME: " + name + "\nROLE: " + role + "\nRATE: $" + rate + "\nHOURS: " + hours + "\nSALARY: $" + salary;
		
	}

}
