/**
 * Tests search method by searching arrays of varying length
 * @author HDamron1
 * //SeracherTester.java
 * //Honor Code: I did not lie, cheat, or steal
 */

public class SearcherTester {
	public static void main(String[] args) {
		Searcher search;
		StopWatch timer = new StopWatch();
		long time;
		int target, index;
		int[] array = ArrayUtil.randomSortedArray(250000000);
		System.out.println("Array Length\tTime for Linear Search (ms)\tTime for Binary Search (ns)");
		
		for(int length = 10000000; length <= array.length; length += 10000000) {
			search = new Searcher(subArray(array, length));
			target = search.getAValue();
			timer.reset();
			timer.start();
			index = search.linearSearch(target);
			timer.stop(); 
			time = timer.getElapsedTime();
			System.out.print(length + "\t\t" + time);
			timer.reset();
			timer.start();
			index = search.binarySearch(target);
			timer.stop(); 
			time = timer.getElapsedTimeNanos();
			System.out.println("\t\t\t\t" + time);
		}
		System.out.println();
		search = new Searcher(subArray(array, 100));
		target = 404;
		try {
		timer.reset();
		timer.start();
		index = search.linearSearch(target);
		timer.stop(); 
		time = timer.getElapsedTime();
		} catch (Searcher.ItemNotFoundException e) {
			System.out.println("Array of length 100 - " + e.getMessage());
		}
		try {
		timer.reset();
		timer.start();
		index = search.binarySearch(target);
		timer.stop(); 
		time = timer.getElapsedTimeNanos();
		} catch (Searcher.ItemNotFoundException e) {
			System.out.println("Array of length 100 - " + e.getMessage());
		}
	}
	
	public static int[] subArray(int[] array, int length) { 
		if(length >= array.length)
			return array;
		else {
			int[] newArray = new int[length];
			for(int index = 0; index < length; index++) {
				newArray[index] = array[index];
			}
			return newArray;
		}
	}
}
