package p16_5;
/**
 * Demos Roster class with UI
 * @author Hunter Damron
 * //RosterTester.java
 * //Honor Code: I did not lie, cheat, or steal
 */
import java.util.Scanner;

public class RosterTerminalUI {
	public static void main(String[] args) {
		Roster group = new Roster();
		Scanner input = new Scanner(System.in);
		final String HELP = "This program keeps a roster of students each with their final grade.\n"
				+ "Possible operations:\n"
				+ "  add <first-name_last-name> <grade> - adds a student to the list\n"
				+ "  class-name <class-name> - changes the name of the roster\n"
				+ "  get <student-id> gets the gets student print-out by id\n"
				+ "  help - displays this page\n"
				+ "  ls - alternative to print-roster\n"
				+ "  modify <student-name> <grade> - changes student's grade\n"
				+ "  print-roster - prints the contents of the roster\n"
				+ "  quit - terminates the program\n"
				+ "  remove <student-id> - removes student from the list\n", 
				WELCOME = "Welcome to RosterMaster.\nEnter student data to create a roster.\n"
						+ "Type \"help\" to see the help menu.\n> ";
		String[] choice;
		System.out.print(WELCOME);
		
		everything: for(;;) {
			choice = input.nextLine().split(" ");
			switch(choice[0]) {
			case "quit":
				break everything;
			case "help":
				System.out.println(HELP);
				break;
			case "add":
				if(choice.length <= 2) {
					System.err.println("Invalid parameter");
					break;
				}
				try {
					double grade = Double.parseDouble(choice[choice.length - 1]);
					String fName = "", lName = "";
					int i = 1;
					for(; i < choice.length - 1; i++) {
						if(choice[i].contains("_")) {
							int upto = choice[i].indexOf("_");
							fName += choice[i].substring(0, upto);
							lName += choice[i].substring(upto + 1);
							if(i < choice.length - 2)
								lName += " ";
							break;
						} else {
							fName += choice[i];
						}
						if(i < choice.length - 2)
							fName += " ";
					}
					for(; i < choice.length - 2; i++) {
						lName += choice[i];
						if(i < choice.length - 2)
							lName += " ";
					}
					group.add(lName, fName, grade);
				} catch(Exception e) {
					System.err.println("Invalid parameter");
				}
				break;
			case "get":
				if(choice.length <= 1) {
					System.err.println("Invalid parameter");
					break;
				}
				System.out.println(group.getString(Long.parseLong(choice[1])));
				break;
			case "remove":
				if(choice.length <= 1) {
					System.err.println("Invalid parameter");
					break;
				}
				group.remove(Long.parseLong(choice[1]));
				break;
			case "modify":
				if(choice.length <= 2) {
					System.err.println("Invalid parameter");
					break;
				}
				double grade = Double.parseDouble(choice[choice.length - 1]);
				group.changeGrade(Long.parseLong(choice[1]), grade);
				break;
			case "class-name":
				if(choice.length <= 1) {
					System.err.println("Invalid parameter");
					break;
				}
				String name = "";
				for(int i = 1; i < choice.length - 1; i++) {
					name += choice[i] + " ";
				}
				name += choice[choice.length - 1];
				group.setName(name);
				break;
			case "print-roster":
			case "ls":
				System.out.println(group);
				break;
			case "eat-beans":
				System.out.println("You have reached the easter egg. Have a nice day!");
				break;
			default:
				System.err.println("Invalid parameter");
			}
			System.out.print("> ");
		}
		input.close();
		System.out.print("Goodbye");
	}
}
