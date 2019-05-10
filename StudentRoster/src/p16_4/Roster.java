package p16_4;
/**
 * Roster for keeping students and grades
 * @author Hunter Damron
 * //Roster.java
 * //Honor Code: I did not lie, cheat, or steal
 */
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

public class Roster {
	private TreeMap<String, Student> stuMap;
	private String className;

	/**
	 * Constructs Roster with class name
	 * @param className Name of class
	 */
	public Roster(String className) {
		stuMap = new TreeMap<String, Student>();
		this.className = className;
	}

	/**
	 * Constructs Roster without class name
	 */
	public Roster() {
		stuMap = new TreeMap<String, Student>();
		className = "(Unnamed List)";
	}

	/**
	 * Adds student to the roster
	 * @param name Name of student
	 * @param grade Student grade
	 */
	public void add(String name, double grade) {
		stuMap.put(name, new Student(name, grade));
	}

	/**
	 * Adds student to list without grade
	 * @param name Name of student
	 */
	public void add(String name) {
		stuMap.put(name, new Student(name));
	}

	/**
	 * Changes student's grade
	 * @param name Name of student
	 * @param grade New grade of student
	 */
	public void changeGrade(String name, double grade) {
		if(stuMap.containsKey(name)) {
			stuMap.get(name).setGrade(grade);
		}
	}

	/**
	 * Removes student from roster
	 * @param name Name of student
	 */
	public void remove(String name) {
		stuMap.remove(name);
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
		for(Student student : stuMap.values()) {
			roster += "\n" + student;
		}
		return roster;
	}

	/**
	 * Gets the roster as a 2D String array
	 * @return Returns the roster as an array
	 */
	public String[][] getRoster() {
		Collection<Student> stuList = stuMap.values();
		String[][] array = new String[stuList.size()][3];
		Iterator<Student> iter = stuList.iterator();
		for(int i = 0; i < array.length; i++) {
			Student stu = iter.next();
			array[i][0] = stu.name();
			if(stu.hasGrade())
				array[i][1] = "" + stu.grade();
			else
				array[i][1] = "";
			array[i][2] = stu.letterGrade();
		}
		return array;
	}
}