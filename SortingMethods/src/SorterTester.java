
import java.util.Arrays;

public class SorterTester {
	public static void main(String[] args) {
		int[] array, sorted;
		long elapsedTime;
		Sorter selection, insertion, merge;
		StopWatch timer = new StopWatch();

		array = ArrayUtil.randomIntArray(42000, 100);
		selection = new SelectionSorter(Arrays.copyOf(array, array.length));
		insertion = new InsertionSorter(Arrays.copyOf(array, array.length));
		merge = new MergeSorter(Arrays.copyOf(array, array.length));

		timer.reset();
		timer.start();
		sorted = selection.sort();
		timer.stop();
		elapsedTime = timer.getElapsedTime();
		System.out.println("Selection sort in " + elapsedTime + " milliseconds");

		timer.reset();
		timer.start();
		sorted = insertion.sort();
		timer.stop();
		elapsedTime = timer.getElapsedTime();
		System.out.println("Insertion sort in " + elapsedTime + " milliseconds");

		timer.reset();
		timer.start();
		sorted = merge.sort();
		timer.stop();
		elapsedTime = timer.getElapsedTime();
		System.out.println("Merge sort in " + elapsedTime + " milliseconds");

		sorted = Arrays.copyOf(array, array.length);
		timer.reset();
		timer.start();
		Arrays.sort(sorted);
		timer.stop();
		elapsedTime = timer.getElapsedTime();
		System.out.println("Native Arrays.sort() in " + elapsedTime + " milliseconds");
		
		System.out.println("\nAlready in Ascending Order:");
		Arrays.sort(array);
		selection = new SelectionSorter(Arrays.copyOf(array, array.length));
		insertion = new InsertionSorter(Arrays.copyOf(array, array.length));
		merge = new MergeSorter(Arrays.copyOf(array, array.length));

		timer.reset();
		timer.start();
		sorted = selection.sort();
		timer.stop();
		elapsedTime = timer.getElapsedTime();
		System.out.println("Selection sort in " + elapsedTime + " milliseconds");

		timer.reset();
		timer.start();
		sorted = insertion.sort();
		timer.stop();
		elapsedTime = timer.getElapsedTime();
		System.out.println("Insertion sort in " + elapsedTime + " milliseconds");

		timer.reset();
		timer.start();
		sorted = merge.sort();
		timer.stop();
		elapsedTime = timer.getElapsedTime();
		System.out.println("Merge sort in " + elapsedTime + " milliseconds");

		sorted = Arrays.copyOf(array, array.length);
		timer.reset();
		timer.start();
		Arrays.sort(sorted);
		timer.stop();
		elapsedTime = timer.getElapsedTime();
		System.out.println("Native Arrays.sort() in " + elapsedTime + " milliseconds");
		
		System.out.println("\nAlready in descending order:");
		reverse(array);
		selection = new SelectionSorter(Arrays.copyOf(array, array.length));
		insertion = new InsertionSorter(Arrays.copyOf(array, array.length));
		merge = new MergeSorter(Arrays.copyOf(array, array.length));

		timer.reset();
		timer.start();
		sorted = selection.sort();
		timer.stop();
		elapsedTime = timer.getElapsedTime();
		System.out.println("Selection sort in " + elapsedTime + " milliseconds");

		timer.reset();
		timer.start();
		sorted = insertion.sort();
		timer.stop();
		elapsedTime = timer.getElapsedTime();
		System.out.println("Insertion sort in " + elapsedTime + " milliseconds");

		timer.reset();
		timer.start();
		sorted = merge.sort();
		timer.stop();
		elapsedTime = timer.getElapsedTime();
		System.out.println("Merge sort in " + elapsedTime + " milliseconds");

		sorted = Arrays.copyOf(array, array.length);
		timer.reset();
		timer.start();
		Arrays.sort(sorted);
		timer.stop();
		elapsedTime = timer.getElapsedTime();
		System.out.println("Native Arrays.sort() in " + elapsedTime + " milliseconds");
	}
	
	public static void reverse(int[] array) {
		int temp, last = array.length - 1;
		for(int i = 0; i <= array.length / 2; i++) {
			temp = array[last - i];
			array[last - i] = array[i];
			array[i] = temp;
		}
	}
}