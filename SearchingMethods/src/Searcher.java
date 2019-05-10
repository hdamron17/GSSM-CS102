/**
 * Searches an array for a target value using either a linear or binary search
 * @author HDamron1
 * //Seracher.java
 * //Honor Code: I did not lie, cheat, or steal
 */

import java.util.Random;

public class Searcher {
	private int[] array;
	Sorter sort;
	Random gen;

	public class ItemNotFoundException extends RuntimeException {
		public ItemNotFoundException(String message) {
			super(message);
		}
	}

	/**
	 * Only accepts sorted arrays
	 * @param array
	 */
	public Searcher(int[] array) {
		int prev = array[0];
		boolean sorted = true;
		for(int val : array) {
			if(!(val <= prev)) {
				sorted = false;
				break;
			} else {
				val = prev;
			}
		}
		if(sorted)
			this.array = array;
		else {
			sort = new Sorter(array);
			this.array = sort.getSorted();
		}
		gen = new Random();
	}

	public int linearSearch(int target) throws ItemNotFoundException {
		for(int index = 0; index < array.length; index++) {
			if(array[index] == target)
				return index;
		}
		throw new ItemNotFoundException("Item " + target + " not found");
	}

	public int binarySearch(int target) throws ItemNotFoundException {
		int low = 0, high = array.length - 1;
		while(low <= high) {
			int mid = (high + low) / 2;
			int var = array[mid];
			if(var == target)
				return mid;
			else if(var > target)
				low = mid + 1;
			else
				high = mid - 1;
		}
		throw new ItemNotFoundException("Item " + target + " not found");
	}

	public int getAValue() {
		return array[gen.nextInt(array.length)];
	}

	public int get(int index) {
		return array[index];
	}

	public int[] getArray() {
		return array;
	}
}
