package p16_4;
/**
 * Models a student with a name and grade
 * @author Hunter Damron
 * //Student.java
 * //Honor Code: I did not lie, cheat, or steal
 */
public class Student {
	private String name;
	private double grade;
	private boolean hasGrade;
	
	/**
	 * Constructs student with name and grade
	 * @param name Name of student
	 * @param grade Student's grade
	 */
	public Student(String name, double grade) {
		this.name = name;
		this.grade = grade;
		this.hasGrade = true;
	}
	
	/**
	 * Constructs student with name only
	 * @param name Name of student
	 */
	public Student(String name) {
		this.name = name;
		grade = 0;
		this.hasGrade = false;
	}
	
	/**
	 * Gets the name of the student
	 * @return Returns name of student
	 */
	public String name() {
		return name;
	}
	
	/**
	 * Gets the student's grade
	 * @return Returns student's grade
	 */
	public double grade() {
		if(hasGrade)
			return grade;
		else return 0.0;
	}
	
	/**
	 * Gets the grade's letter equivalent (i.e. B+)
	 * @return Returns letter grade
	 */
	public String letterGrade() {
		if(!hasGrade) 
			return "";
		if(grade >= 100) return "A+";
		if(grade >= 94) return "A";
		if(grade >= 90) return "A-";
		if(grade >= 87) return "B+";
		if(grade >= 83) return "B";
		if(grade >= 80) return "B-";
		if(grade >= 77) return "C+";
		if(grade >= 73) return "C";
		if(grade >= 70) return "C-";
		if(grade >= 67) return "D+";
		if(grade >= 63) return "D";
		if(grade >= 60) return "D-";
		if(grade <= 0) return "F-";
		else return "F";
	}
	
	/**
	 * Tests if student has a grade in the books
	 * @return Returns true if student has a grade
	 */
	public boolean hasGrade() {
		return hasGrade;
	}
	
	/**
	 * Sets the student's grade
	 * @param grade Student's grade
	 */
	public void setGrade(double grade) {
		this.grade = grade;
		hasGrade = true;
	}
	
	/**
	 * Overrides Object toString to give name, grade, 
	 * 		and letter grade
	 * @return Returns string representation
	 */
	public String toString() {
		if(hasGrade)
			return name + "\t" + grade + " " + letterGrade();
		else 
			return name;
	}
}
