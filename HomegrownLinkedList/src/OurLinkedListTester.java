public class OurLinkedListTester {
	public static void main(String[] args) {
		OurLinkedList list = new OurLinkedList();
		list.addLast(13);
		list.addLast(9);
		list.addLast(82);
		list.addLast(3);
		list.addLast(34);
		list.addLast(53);
		list.addLast(399);
		list.addLast(1);
		
		System.out.println("(Size = " + list.size() + ") " + list.toString());
		
		Object thing = list.get(2);
		System.out.println("Get index 2 : " + thing);
		
		System.out.println("Removing idem at index 2: " + list.remove(2));
		System.out.println("(Removed item at index 2) " + list);
		
		list.reverse();
		System.out.println("(Reversed; Size = " + list.size() + ") " + list);
	}
}
