package p16_5;
/**
 * Roster for keeping students and grades
 * @author Hunter Damron
 * //Roster.java
 * //Honor Code: I did not lie, cheat, or steal
 */
import java.util.TreeMap;

public class Roster {
	private TreeMap<Long, Student> stuMap;
	private TreeMap<Student, String> gradeMap;
	private String className;

	/**
	 * Constructs Roster with class name
	 * @param className Name of class
	 */
	public Roster(String className) {
		stuMap = new TreeMap<Long, Student>();
		gradeMap = new TreeMap<Student, String>();
		this.className = className;
	}

	/**
	 * Constructs Roster without class name
	 */
	public Roster() {
		stuMap = new TreeMap<Long, Student>();
		gradeMap = new TreeMap<Student, String>();
		className = "(Unnamed List)";
	}
	
	public void add(String lName, String fName, double grade) {
		Student addition = new Student(lName, fName);
		stuMap.put(addition.id(), addition);
		gradeMap.put(addition, "" + grade 
				+ "% " + Student.letterGrade(grade));
	}
	
	public void changeGrade(long id, double grade) {
		if(stuMap.containsKey(id)) {
			gradeMap.put(stuMap.get(id), "" + grade
					+ "% " + Student.letterGrade(grade));
		}
	}

	/**
	 * Removes student from roster
	 * @param id ID of student
	 */
	public void remove(long id) {
		if(stuMap.containsKey(id)) {
			gradeMap.remove(stuMap.get(id));
			stuMap.remove(id);
		}
	}
	
	/**
	 * Gets student from roster
	 * @param id ID of student
	 */
	public Student get(long id) {
		if(stuMap.containsKey(id))
			return stuMap.get(id);
		else return null;
	}
	
	public String getString(long id) {
		if(stuMap.containsKey(id)) {
			Student stu = stuMap.get(id);
			return stu + " " + gradeMap.get(stu);
		} else return null;
	}

	/**
	 * Gets the name of the roster
	 * @return Returns name of roster
	 */
	public String name() {
		return className;
	}

	/**
	 * Sets the name of the roster
	 * @param name Name of roster
	 */
	public void setName(String name) {
		this.className = name;
	}

	/**
	 * Overrides Object toString and prints table with grades
	 */
	public String toString() {
		String roster = className;
		for(Student stu : gradeMap.keySet()) {
			roster += "\n" + stu + " " + gradeMap.get(stu);
		}
		return roster;
	}
}