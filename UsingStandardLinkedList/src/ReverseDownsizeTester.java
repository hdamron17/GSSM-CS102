/**
 * Downsize and Reverse methods applied to LinkedList of staff
 * @author Hunter Damron
 * //ReverseDownsizeTester.java
 * //Honor Code: I did not lie, cheat, or steal
 */

import java.util.LinkedList;
import javax.swing.JOptionPane;

public class ReverseDownsizeTester {
	public static void main(String[] args) {
		LinkedList<String> staff;
		staff = new LinkedList<String>();
		String name = JOptionPane.showInputDialog(
				"Enter person's name or quit to stop");
		while(!name.equalsIgnoreCase("quit")){
			staff.add(name);
			name = JOptionPane.showInputDialog("Enter "
					+ "person's name or quit to stop");
		}
		System.out.println(staff);
		downsize(staff);
		System.out.println(staff);
		reverse(staff);
		System.out.println(staff);
	}

	/**
	 * downsize
	 */
	public static void downsize(LinkedList<String> staff) {
		for(int i=1; i<staff.size();i++)staff.remove(i);
	}

	/**
	 * reverse
	 */
	public static void reverse(LinkedList<String> staff) {
		for(int i=0;i<staff.size();i++)staff.addFirst(staff.remove(i));
	}
}