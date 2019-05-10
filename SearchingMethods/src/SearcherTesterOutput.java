/**
 * Tests search method by searching arrays of varying length
 * @author HDamron1
 * //SeracherTester.java
 * //Honor Code: I did not lie, cheat, or steal
 */

public class SearcherTesterOutput {
	public static void main(String[] args) {
		Searcher search;
		StopWatch timer = new StopWatch();
		long time;
		int target, index;
		int[] array = ArrayUtil.randomSortedArray(250000000);
		System.out.println("\"Array Length\",\"Time for Linear Search (ms)\",\"Time for Binary Search (ns)\"");
		
		for(int length = 10000000; length <= array.length; length += 10000000) {
			search = new Searcher(subArray(array, length));
			target = search.getAValue();
			timer.reset();
			timer.start();
			index = search.linearSearch(target);
			timer.stop(); 
			time = timer.getElapsedTime();
			System.out.print("\"" + length + "\",\"" + time);
			timer.reset();
			timer.start();
			index = search.binarySearch(target);
			timer.stop(); 
			time = timer.getElapsedTimeNanos();
			System.out.println("\",\"" + time + "\"");
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
