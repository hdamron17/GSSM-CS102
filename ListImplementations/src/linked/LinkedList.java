package linked;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
//import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E>, Cloneable {
	private class Node {
		E element;
		Node prev, next;
		
		Node(E element, Node prev, Node next) {
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
		
		void setPrev(Node prevNode) {
			prev = prevNode;
		}
		
		void setNext(Node nextNode) {
			next = nextNode;
		}
		
		public String toString() {
			return "" + element;
		}
	}
	
	public class LinkedListIterator implements ListIterator<E> {
		private Node node, lastInstance;
		private int index;
		private boolean wasPrev = false;
		
		private LinkedListIterator() {
			node = first;
			index = 0;
		}
		
		private LinkedListIterator(int index) {
			node = getNode(index);
			index = indexOf(node);
		}
		
		@Override
		public boolean hasNext() {
			return node.next != first;
		}

		@Override
		public E next() {
			if(hasNext()) {
				lastInstance = node;
				node = node.next;
				index++;
				wasPrev = false;
				return node.prev.element;
			} else return null;
		}

		@Override
		public boolean hasPrevious() {
			return node.prev != last;
		}

		@Override
		public E previous() {
			if(hasPrevious()) {
				lastInstance = node;
				node = node.next;
				index--;
				wasPrev = true;
				return node.prev.element;
			} else return null;
		}

		@Override
		public int nextIndex() {
			if(hasNext())
				return index + 1;
			else return -1;
		}

		@Override
		public int previousIndex() {
			if(hasPrevious())
				return index - 1;
			else return -1;
		}

		@Override
		public void remove() {
			LinkedList.this.remove(lastInstance);
			if(wasPrev)
				index--;
		}

		@Override
		public void set(E e) {
			if(lastInstance != null) {
				lastInstance.element = e;
			}
		}

		@Override
		public void add(E e) {
			LinkedList.this.add(index, e);
			node = node.next;
			index++;
		}
		
	}
	
	private int size;
	private Node first, last;
	
	public LinkedList() {
		first = null;
		last = null;
		size = 0;
	}
	
	public LinkedList(E element) {
		first = new Node(element, null, null);
		first.setPrev(first);
		first.setNext(first);
	}
	
	@SafeVarargs
	public LinkedList(E... elements) {
		for(E instance : elements) {
			add(instance);
		}
	}
		
	public LinkedList(Collection<? extends E> c) {
		Iterator<? extends E> i = c.iterator();
		first = null;
		last = null;
		size = 0;
		while(i.hasNext()) {
			add(i.next());
			size++;
		}
	}
	
	private LinkedList(Node node, int length) {
		first = node;
		Node reference = first;
		for(int i = 0; i < length; i++) {
			reference = reference.next;
		}
		last = reference;
		size = length;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(Object o) {
		return getNode((E) o) != null;
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
		for(int i = 0; i < size; i++) {
			array[i] = (Object) get(i);
		}
		return array;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] a) {
		if(a.length < size) {
			a = (T[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
		}
		for(int i = 0; i < size; i++) {
			a[i] = (T) get(i);
		}
		return a;
	}
	
	@Override
	public boolean add(E e) {
		if(size == 0) {
			first = new Node(e, null, null);
			last = first;
			first.setNext(first);
			first.setPrev(first);
		} else {
			last.setNext(new Node(e, last, first));
			last = last.next;
			first.setPrev(last);
		}
		size++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		Node instance = getNode(indexOf(o));
		return removeNode(instance);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		Iterator<?> i = c.iterator();
		while(i.hasNext()) {
			if(!contains(i.next()))
				return false;
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		Iterator<? extends E> i = c.iterator();
		while(i.hasNext()) {
			add(i.next());
		}
		if(c.size() > 0)
			return true;
		else return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		if(index >= size || index < 0) 
			return false;
		Iterator<? extends E> i = c.iterator();
		while(i.hasNext()) {
			add(index, i.next());
			index++;
		}
		if(c.size() > 0)
			return true;
		else return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean removed = false;
		Iterator<?> i = c.iterator();
		while(i.hasNext()) {
			Object element = i.next();
			if(this.contains(element)) {
				remove(element);
				removed = true;
			}
		}
		return removed;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		boolean removed = false;
		ListIterator<E> i = listIterator();
		while(i.hasNext()) {
			if(!c.contains(i.next())) {
				i.remove();
				removed = true;
			}
		}
		return removed;
	}

	@Override
	public void clear() {
		first = null;
		last = null;
		size = 0;
	}

	@Override
	public E get(int index) {
		return getNode(index).element;
	}

	@Override
	public E set(int index, E element) {
		Node node = getNode(index);
		E original = node.element;
		node.element = element;
		return original;
	}

	@Override
	public void add(int index, E element) {
		Node original = getNode(index);
		Node instance = new Node(element, original.prev, original);
		instance.prev.setNext(instance);
		instance.next.setPrev(instance);
	}

	@Override
	public E remove(int index) {
		Node original = getNode(index);
		original.prev.setNext(original.next);
		original.next.setPrev(original.prev);
		return original.element;
	}

	@Override
	public int indexOf(Object o) {
		Node test = first;
		for(int i = 0; i < size; i++) {
			if(test.element.equals(o))
				return i;
			else {
				test = test.next;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		Node test = last;
		for(int i = size; i > 0; i--) {
			if(test.element.equals(o))
				return i;
			else {
				test = test.prev;
			}
		}
		return -1;
	}

	@Override
	public ListIterator<E> listIterator() {
		return new LinkedListIterator();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return new LinkedListIterator(index);
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		if(fromIndex < toIndex && toIndex < size)
			return new LinkedList<E>(getNode(fromIndex), toIndex - fromIndex);
		else if(fromIndex == toIndex)
			return new LinkedList<E>();
		else
			return null;
	}
	
	@Override
	public LinkedList<E> clone() {
		return new LinkedList<E>(this);
	}
	
	public String toString() {
		String message = "LinkedList[";
		Node output = first;
		for(int i = 0; i < size - 1; i++) {
			message += "" + output + ",";
			output = output.next;
		}
		message += "" + output + "]";
		return message;
	}
	
	private Node getNode(int index) {
		if(index < size) {
			Node test = first;
			for(; index != 0; index--) {
				test = test.next;
			}
			return test;
		}
		else return null;
	}
	
	private Node getNode(E element) {
		Node test = first;
		for(int i = 0; i < size; i++) {
			if(test.element.equals(element))
				return test;
			else {
				test = test.next;
			}
		}
		return null;
	}
	
	private boolean removeNode(Node instance) {
		if(instance != null) {
			if(size == 1) {
				first = null;
				last = null;
			}
			else if(instance == first)
				first = instance.next;
			else if(instance == last)
				last = instance.prev;
			instance.prev.setNext(instance.next);
			instance.next.setPrev(instance.prev);
			size--;
			return true;
		}
		else return false;
	}
	
	
	
	//TODO Remove Before Continuing
	/**** Testing recursiveGetNode because why not? 
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>(1,2,3,4,5,6,7);
		System.out.println(list.toString());
		System.out.println("Node at index 4 = " + list.getNode(4));
		System.out.println("Node at index 4 = " + list.recursiveGetNode(4));
	}
	
	private Node recursiveGetNode(int index) {
		if(index >= 0 && index < size())
			return innerGetNode(index, first);
		else
			throw new NoSuchElementException();
	}
	
	private Node innerGetNode(int index, Node node) {
		if(index == 0)
			return node;
		else
			return innerGetNode(index - 1, node.next);
	}
	****/
}
