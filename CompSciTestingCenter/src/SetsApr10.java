import java.util.HashSet;
import java.util.Set;

public class SetsApr10 {
	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(2);
		set1.add(4);
		set1.add(5);
		set1.add(6);
		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(3);
		set2.add(7);
		set2.add(2);
		set2.add(4);
		
		System.out.println("Set 1 = " + set1);
		System.out.println("Set 2 = " + set2);
		System.out.println("Union = " + union(set1, set2));
		System.out.println("Intersection = " + intersection(set1, set2));
		System.out.println("Union = " + union2(set1, set2));
		System.out.println("Intersection = " + intersection2(set1, set2));
	}
	
	public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) { 
		Set<Integer> union = new HashSet<Integer>();
		for(Integer element : set1)
			union.add(element);
		for(Integer element : set2)
			union.add(element);
		return union;
	}
	
	public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
		Set<Integer> intersection = new HashSet<Integer>();
		for(Integer element : set1)
			if(set2.contains(element))
				intersection.add(element);
		return intersection;
	}
	
	public static Set<Integer> union2(Set<Integer> set1, Set<Integer> set2) { 
		Set<Integer> union = new HashSet<Integer>();
		union.addAll(set1);
		union.addAll(set2);
		return union;
	}
	
	public static Set<Integer> intersection2(Set<Integer> set1, Set<Integer> set2) {
		Set<Integer> intersection = new HashSet<Integer>();
		intersection.addAll(set1);
		intersection.retainAll(set2);
		return intersection;
	}
}
