package linked;
import java.util.ListIterator;

import linked.LinkedList;

public class LinkedListTester {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>(3, 6, 9, 2, 4);
		Integer i = new Integer(5);
		System.out.println(list + " size = " + list.size());
		System.out.println("Does it add? " + list.add(i));
		System.out.println(list);
		System.out.println("size = " + list.size());
		i = 2;
		System.out.println("Does it remove? " + list.remove(i));
		System.out.println(list);
		System.out.println("size = " + list.size());
		i = 9;
		System.out.println("Does it contain 9? " + list.contains(i));
		i = 10;
		System.out.println("Does it contain 10? " + list.contains(i));
		System.out.println("Will it give an iterator?");
		ListIterator<Integer> iterator = list.listIterator();
		//Extremely wrong Big O
		while(iterator.hasNext()) {
			System.out.println("Removed element " + iterator.next());
			iterator.remove();
		}
		System.out.println("List is now : " + list);
		
		//Starts getting screwy
		list = new LinkedList<Integer>(2,4,5,1,6);
		LinkedList<Integer> newList = list.clone();
		System.out.println("Creating newList = " + newList);
		newList.add(42);
		System.out.println("newList = " + newList + "\n\tversus list = " + list);
	}
}
