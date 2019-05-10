/**
 * Models a queue which adds new elements to the rear
 * and removes them from the front using a linked list
 * @author  Hunter Damron                                
 * @param <E> element data type
 * //Queue.java
 * //Honor Code: I did not lie, cheat, or steal
 */
import java.util.*;

public class Queue<E> {
	private LinkedList<E> list;	// instance variable

	/** instantiates a queue with no elements  */
	public Queue (){			
		list = new LinkedList<E>();
	}
	
	/** places element at the end of the queue */
	public void enqueue(E element) {
		list.add(element);
	}
	
	/** if the queue is not empty, removes and returns the first element
      Otherwise throws a no such element exception */

	public E dequeue(){
		if(list.size() == 0)
			throw new NoSuchElementException();
		else
			return list.removeFirst();
	}
	
	/** if the queue has no elements, returns true. Otherwise returns false */
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	/** debug method returns a string containing all values stored in the queue */
	public String toString(){
		return list.toString();
	}

}