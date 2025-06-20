package Assignment2;

public class student{
	private String name, major;
	private double GPA;
	
	public student() {
		name = "";
		major = "";
		GPA = 0.00;
	}
	
	public student(String inputName, String inputMajor) {
		name = inputName;
		major = inputMajor;
		GPA = 0.00;
	}
	
	public student(String inputName, String inputMajor, double inputGPA) {
		name = inputName;
		major = inputMajor;
		GPA = inputGPA;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String input) {
		name = input;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String input) {
		major = input;
	}
	
	public double getGPA() {
		return GPA;
	}
	
	public void setGPA(double input) {
		GPA = input;
	}
	
	public String toString() {
		return "Name: " + name + " Major: " + major + " GPA: " + GPA;
	}
	
	public boolean equals(student input) {
		if (name.equalsIgnoreCase(input.name) && major.equalsIgnoreCase(input.major)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}