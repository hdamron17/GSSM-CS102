/**
 * Test several tricky methods using homegrown Queue
 * @author Hunter Damron
 * //QueueTester.java
 * //Honor Code: I did not lie, cheat, or steal
 */

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class QueueTester {
	public static void main(String[] args) {
		System.out.println("Executing testMethod1...");
		testMethod1();
		System.out.println("\nExecuting testMethod2...");
		testMethod2();
	}

	public static void testMethod1() {
		LinkedList<String> names = new LinkedList<String> ();
		Stack <String> starters = new Stack<String>();
		Queue<String> freeTime = new Queue<String> ();

		names.addLast("Hunter");
		names.addLast("Rae");
		names.addFirst("Ben");
		names.addFirst("Dennis");
		while(names.size() > 0)
			starters.push(names.removeFirst());
		while(!starters.isEmpty()){
			if (starters.pop().equalsIgnoreCase("Hunter"))
				freeTime.enqueue(starters.pop());
		}
		System.out.println("Who has free time? " + freeTime.dequeue());	
	}

	public static void testMethod2() {
		LinkedList<String> names = new LinkedList<String> ();
		ListIterator<String> iter = names.listIterator();
		iter.add("Isaiah");
		iter.add("Nikki");
		iter = names.listIterator();
		iter.add("David");
		iter.add("Grace");
		iter.next();
		iter.remove();
		iter = names.listIterator();
		while (iter.hasNext()) {
			System.out.print ("  "+ iter.next());
		}
		System.out.println();
	}
}
