package p16_4;
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
				+ "  add <student-name> [opt: grade] - adds a student to the list\n"
				+ "  class-name <class-name> - changes the name of the roster\n"
				+ "  help - displays this page\n"
				+ "  ls - alternative to print-roster\n"
				+ "  modify <student-name> <grade> - changes student's grade\n"
				+ "  print-roster - prints the contents of the roster\n"
				+ "  quit - terminates the program\n"
				+ "  remove <student-name> - removes student from the list\n", 
				WELCOME = "Welcome to RosterMaster.\nEnter student data to create a roster.\n"
						+ "Type \"help\" to see the help menu.\n> ";
		String[] choice;
		String name;
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
				if(choice.length <= 1) {
					System.out.println("Invalid parameter");
					break;
				}
				try {
					double grade = Double.parseDouble(choice[choice.length - 1]);
					name = "";
					for(int i = 1; i < choice.length - 2; i++) {
						name += choice[i] + " ";
					}
					name += choice[choice.length - 2];
					group.add(name, grade);
				} catch(Exception e) {
					name = "";
					for(int i = 1; i < choice.length - 1; i++) {
						name += choice[i] + " ";
					}
					name += choice[choice.length - 1];
					group.add(name);
				}
				break;
			case "remove":
				if(choice.length <= 1) {
					System.out.println("Invalid parameter");
					break;
				}
				name = "";
				for(int i = 1; i < choice.length - 1; i++) {
					name += choice[i] + " ";
				}
				name += choice[choice.length - 1];
				group.remove(name);
				break;
			case "modify":
				if(choice.length <= 1) {
					System.out.println("Invalid parameter");
					break;
				}
				try {
					double grade = Double.parseDouble(choice[choice.length - 1]);
					name = "";
					for(int i = 1; i < choice.length - 2; i++) {
						name += choice[i] + " ";
					}
					name += choice[choice.length - 2];
					group.changeGrade(name, grade);
				} catch(Exception e) {}
				break;
			case "class-name":
				if(choice.length <= 1) {
					System.out.println("Invalid parameter");
					break;
				}
				name = "";
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
				System.out.println("Invalid parameter");
			}
			System.out.print("> ");
		}
		input.close();
		System.out.print("Goodbye");
	}
}
