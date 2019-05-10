package p16_5;
/**
 * Models a student with a name and grade
 * @author Hunter Damron
 * //Student.java
 * //Honor Code: I did not lie, cheat, or steal
 */
public class Student implements Comparable<Student> {
	private String lName, fName;
	private static long idFactory = 0;
	private long id;
	
	/**
	 * Constructs student with name and grade
	 * @param name Name of student
	 * @param grade Student's grade
	 */
	public Student(String lName, String fName) {
		this.lName = lName;
		this.fName = fName;
		idFactory += System.currentTimeMillis() % 7 + 1;
		id = idFactory;
	}
	
	/**
	 * Gets the name of the student
	 * @return Returns name of student
	 */
	public String name() {
		return lName + ", " + fName;
	}
	
	public static String letterGrade(double grade) {
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
	 * Sets the student's grade
	 * @param grade Student's grade
	 */
	
	public long id() {
		return id;
	}
	
	/**
	 * Overrides Object toString to give name, grade, 
	 * 		and letter grade
	 * @return Returns string representation
	 */
	public String toString() {
		return lName + ", " + fName + " (id: " + id + ")";
	}

	@Override
	public int compareTo(Student arg0) {
		String stu1 = this.lName + this.fName + this.id;
		String stu2 = arg0.lName + arg0.fName + arg0.id;
		return stu1.compareTo(stu2);
	}
}
